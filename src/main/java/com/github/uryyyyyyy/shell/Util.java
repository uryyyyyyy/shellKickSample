package com.github.uryyyyyyy.shell;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;


public class Util {

    static int doShell(String[] command){
        try {
            Runtime r = Runtime.getRuntime();
            Process process = r.exec(command);
            process.waitFor();

            System.out.println("stdout-----------------");
            BufferedReader in2 = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line2;
            while ((line2 = in2.readLine()) != null) {
                System.out.println(line2);
            }
            System.out.println("-----------------------");
            System.out.println("stderr-----------------");
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("-----------------------");
            return process.exitValue();
        } catch (IOException | InterruptedException e) {
            System.out.println("shell execute error: " + Arrays.toString(command));
            throw new RuntimeException(e);
        }
    }

    static void pipe(InputStream input, OutputStream output) throws IOException {
        int DEFAULT_BUFFER_SIZE = 1024 * 4;
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        int size;
        while (-1 != (size = input.read(buffer))) {
            output.write(buffer, 0, size);
        }
        input.close();
        output.close();
    }

    static File jarResourceToTempFile(File resourceFile, String tempDir){
        try {
            File tempFile = File.createTempFile("prefix", ".sh", new File(tempDir));
            OutputStream out = new FileOutputStream(tempFile);

            InputStream in = new FileInputStream(resourceFile);
            Util.pipe(in, out);

            return tempFile;
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
