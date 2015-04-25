package com.github.dmtk;

import com.jcraft.jsch.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintStream;
import javax.swing.*;

public class Ssh extends Terminal {

    private static Ssh ssh = new Ssh();
    private static boolean end_loop = false;
    private Ssh() {

    }

    public static Ssh getInstance() {
        return ssh;
    }

    public void start(String ip, int port, PrintStream output) {
        
        try {
            JSch jsch = new JSch();

            //jsch.setKnownHosts("/home/foo/.ssh/known_hosts");
            String host = null;

            host = JOptionPane.showInputDialog("Enter username@hostname",
                    System.getProperty("user.name")
                     + "@" + ip);

            String user = host.substring(0, host.indexOf('@'));
            host = host.substring(host.indexOf('@') + 1);

            Session session = jsch.getSession(user, host, port);

            String passwd = JOptionPane.showInputDialog("Enter password");
            session.setPassword(passwd);

            UserInfo ui = new MyUserInfo() {
                public void showMessage(String message) {
                    JOptionPane.showMessageDialog(null, message);
                }

                public boolean promptYesNo(String message) {
                    Object[] options = {"yes", "no"};
                    int foo = JOptionPane.showOptionDialog(null,
                            message,
                            "Warning",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.WARNING_MESSAGE,
                            null, options, options[0]);
                    return foo == 0;
                }

                // If password is not given before the invocation of Session#connect(),
                // implement also following methods,
                //   * UserInfo#getPassword(),
                //   * UserInfo#promptPassword(String message) and
                //   * UIKeyboardInteractive#promptKeyboardInteractive()
            };

            session.setUserInfo(ui);

            // It must not be recommended, but if you want to skip host-key check,
            // invoke following,
            // session.setConfig("StrictHostKeyChecking", "no");
            //session.connect();
            session.connect(30000);   // making a connection with timeout.

            Channel channel = session.openChannel("shell");
            channel.setInputStream(System.in);
            channel.setOutputStream(output);
            streamOut = channel.getOutputStream();
            //new Pipe(channel.getInputStream(), streamOut).start();
            //new Pipe(in, channel.getOutputStream()).start();

// Enable agent-forwarding.
            //((ChannelShell)channel).setAgentForwarding(true);

            /*
             // a hack for MS-DOS prompt on Windows.
             channel.setInputStream(new FilterInputStream(System.in){
             public int read(byte[] b, int off, int len)throws IOException{
             return in.read(b, off, (len>1024?1024:len));
             }
             });
             */
            /*
             // Choose the pty-type "vt102".
             ((ChannelShell)channel).setPtyType("vt102");
             */
            /*
             // Set environment variable "LANG" as "ja_JP.eucJP".
             ((ChannelShell)channel).setEnv("LANG", "ja_JP.eucJP");
             */
            //channel.connect();
            channel.connect(3 * 1000);

            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!end_loop) {
                        int ret_read = 0;
                        do {
                            buff = Ssh.getInstance().waitCommand();
                            in = new ByteArrayInputStream(buff);
                            try {
                                ret_read = in.read(buff);
                                System.out.print(ret_read + " " + new String(buff, 0, ret_read) + "\n");

                                try {
                                    streamOut.write(buff, 0, ret_read);
                                    streamOut.flush();
                                } catch (IOException e) {
                                    end_loop = true;
                                }

                            } catch (IOException e) {
                                System.err.println("Exception while reading keyboard:" + e.getMessage());
                                end_loop = true;
                            }
                        } while ((ret_read > 0) && (end_loop == false));
                    }
                }

            });
            thread1.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static abstract class MyUserInfo
            implements UserInfo, UIKeyboardInteractive {

        public String getPassword() {
            return null;
        }

        public boolean promptYesNo(String str) {
            return false;
        }

        public String getPassphrase() {
            return null;
        }

        public boolean promptPassphrase(String message) {
            return false;
        }

        public boolean promptPassword(String message) {
            return false;
        }

        public void showMessage(String message) {
        }

        public String[] promptKeyboardInteractive(String destination,
                String name,
                String instruction,
                String[] prompt,
                boolean[] echo) {
            return null;
        }
    }

}
