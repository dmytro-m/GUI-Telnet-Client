package com.github.dmtk;

import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class Terminal {
    
    private boolean interruptWaiting;
    private String cmd = "";

    public void sendCommand(String command) {

        cmd = command;
        cmd = cmd + "\n";
        interruptWaiting = true;

    }

    byte[] waitCommand() throws InterruptedException {

        while (!interruptWaiting) {
            Thread.sleep(20);
        }
        interruptWaiting = false;
        char[] chars = cmd.toCharArray();
        byte[] bytes = Charset.forName("ASCII").encode(CharBuffer.wrap(chars)).array();//encode chars to bytes
        cmd = "";
        return bytes;
    }
}
