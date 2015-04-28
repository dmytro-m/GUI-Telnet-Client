/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.dmtk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class Pinger {
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
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        try {
            while ((s = stdInput.readLine()) != null) {

                String newString = new String(s.getBytes("windows-1251"), "cp866");//change encoding
                System.out.println(newString);
                //out.setText(out.getText()+ "\n" + newString);

            }
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        // read any errors from the attempted command
        try {
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
                //out.setText(out.getText() + "/n");
            }
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
