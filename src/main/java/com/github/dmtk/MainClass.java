package com.github.dmtk;

import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.apache.log4j.Logger;

public class MainClass {

    private static GUI gui;
    private final static Logger log = Logger.getLogger(MainClass.class);
    public static void main(String[] argv) throws IOException, UnsupportedLookAndFeelException, Exception {
        
        log.info("Start");
        try {
            for (UIManager.LookAndFeelInfo info : UIManager
                    .getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            log.error(ex);
        }
        gui = GUI.getInstance();
        gui.setVisible(true);
    }
    
    public static void launchBrowser(String url) {
        String os = System.getProperty("os.name").toLowerCase();
        Runtime rt = Runtime.getRuntime();
        try {
            if (os.indexOf("win") >= 0) {
                rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else if (os.indexOf("mac") >= 0) {
                rt.exec("open " + url);
            } else if ((os.indexOf("nix") >= 0) || (os.indexOf("nux") >= 0)) {
                String[] browsers = {"epiphany", "firefox", "mozilla",
                    "konqueror", "netscape", "opera", "links", "lynx",
                    "chromium"};

                StringBuffer cmd = new StringBuffer();
                for (int i = 0; i < browsers.length; i++) {
                    cmd.append(i == 0 ? "" : " || ").append(browsers[i])
                            .append(" \"").append(url).append("\" ");
                }
                rt.exec(new String[]{"sh", "-c", cmd.toString()});
            }
        } catch (IOException e) {
            log.error(e);
        }
    }

}
