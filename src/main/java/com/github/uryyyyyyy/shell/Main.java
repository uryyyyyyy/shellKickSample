package com.github.uryyyyyyy.shell;

import java.io.File;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
        String[] cmd = {"ls", "./"};
        Util.doShell(cmd);
        new Main().process();
    }

    public void process(){
        InputStream is = Main.class.getClassLoader().getResourceAsStream("shell1.sh");
        File tempFile = Util.jarResourceToTempFile(is, System.getProperty("java.io.tmpdir"));
        String[] cmd = {"sh", System.getProperty("java.io.tmpdir") + "/" + tempFile.getName()};
        int b = Util.doShell(cmd);
        System.out.println(b);
    }

}