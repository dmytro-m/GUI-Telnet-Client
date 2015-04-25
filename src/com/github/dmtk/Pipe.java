package com.github.dmtk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

class Pipe extends Thread {

        BufferedReader is;
        BufferedWriter os;

        Pipe(InputStream is, OutputStream os) {
            this.is = new BufferedReader(new InputStreamReader(is));
            this.os = new BufferedWriter(new OutputStreamWriter(os));
        }

        public void run() {
            String line;
            try {
                while ((line = is.readLine()) != null) {
                    os.write(line);
                    if(line.length()>2) os.write("\r\n");
                    os.flush();
                }
            } catch (IOException ex) {

                      
                Logger.getLogger(Telnet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
