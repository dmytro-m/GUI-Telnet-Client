package com.github.dmtk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

class Pipe extends Thread {

        BufferedReader is;
        GUIPrint os;

        /**
         * Construct a Pipe to read from is and write to os
         */
        Pipe(InputStream is, OutputStream os) {
            this.is = new BufferedReader(new InputStreamReader(is));
            this.os = new GUIPrint(os, GUI.getInstance());
        }

        /**
         * Do the reading and writing.
         */
        public void run() {
            String line;
            try {
                while ((line = is.readLine()) != null) {
                    os.print(line);
                    if(line.length()>2) os.print("\r\n");
                    os.flush();
                }
            } catch (IOException ex) {

                //os.print("нема");
                
                Logger.getLogger(Telnet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
