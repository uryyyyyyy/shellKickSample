package com.github.uryyyyyyy.shell;

import java.io.File;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MainTest {

    @Test
    public void testDoExec() throws Exception {
        File shellFile = new File(getClass().getClassLoader().getResource("shell1.sh").getFile());
        File tempFile = Util.jarResourceToTempFile(shellFile, System.getProperty("java.io.tmpdir"));
        String[] cmd = {"sh", System.getProperty("java.io.tmpdir") + "/" + tempFile.getName()};
        int b = Util.doShell(cmd);
        assertThat(b, is(0));
    }

    @Test
    public void testDoExec2() throws Exception {
        File shellFile = new File(getClass().getClassLoader().getResource("shell2.sh").getFile());
        File tempFile = Util.jarResourceToTempFile(shellFile, System.getProperty("java.io.tmpdir"));
        String[] cmd = {"sh", System.getProperty("java.io.tmpdir") + "/" + tempFile.getName()};
        int b = Util.doShell(cmd);
        assertThat(b, is(1));
    }

    @Test
    public void testDoExec3() throws Exception {
        File shellFile = new File(getClass().getClassLoader().getResource("shell3.sh").getFile());
        File tempFile = Util.jarResourceToTempFile(shellFile, System.getProperty("java.io.tmpdir"));
        String[] cmd = {"sh", System.getProperty("java.io.tmpdir") + "/" + tempFile.getName()};
        int b = Util.doShell(cmd);
        assertThat(b, is(0));
    }

    @Test
    public void testDoShell() throws Exception {

    }
}