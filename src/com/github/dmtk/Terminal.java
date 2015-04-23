package com.github.dmtk;

import java.io.OutputStream;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class Terminal {

    OutputStream streamOut;

    private String cmd = "";
    private boolean interruptWaiting = false;

    public void sendCommand(String command) {

        
        cmd = command;
        cmd = cmd + "\n";
        interruptWaiting = true;

    }

    byte[] waitCommand() {

        while (!interruptWaiting) {
            try {
                Thread.sleep(20);
            } catch (Exception ex) {
            }
        }
        interruptWaiting = false;
        char[] chars = cmd.toCharArray();
        byte[] bytes = Charset.forName("ASCII").encode(CharBuffer.wrap(chars)).array();//encode chars to bytes
        cmd = "";
        return bytes;
    }
}
