package com.github.dmtk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class Pinger {
    
    private final static Logger log = Logger.getLogger(Pinger.class);
    
    static synchronized void pingClient(PrintStream stream, String ip) {

        List<String> commands = new ArrayList<String>();
        commands.add("ping");
        commands.add(ip);
        String s = null;
        ProcessBuilder pb = new ProcessBuilder(commands);
        Process process = null;
        try {
            process = pb.start();
        } catch (IOException ex) {
           log.error(ex);
        }
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        try {
            while ((s = stdInput.readLine()) != null) {

                String newString = new String(s.getBytes("windows-1251"), "cp866");//change encoding
                stream.println(newString);
            }
        } catch (IOException ex) {
           log.error(ex);
        }
        // read any errors from the attempted command
        try {
            while ((s = stdError.readLine()) != null) {
                stream.println(s);                
            }
        } catch (IOException ex) {
           log.error(ex);
        }
    }
}
