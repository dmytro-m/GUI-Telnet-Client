package com.github.dmtk;
import org.apache.log4j.Logger;

public class Port{

    private int port;
    private final int defaultPort = 2;
    private final static Logger log = Logger.getLogger(Port.class);

    public Port(String port) {

        try {
            intialize(Integer.parseInt(port));
        } catch (NumberFormatException ex) {
            log.error("Wrong port number format" + port);
        }

    }
    
    public int getNum(){
        return port;
    }

    public Port(int port) {
        intialize(port);
    }

    private void intialize(int port) {
        if (validate(port)) {
            this.port = port;
        } else {
            this.port = defaultPort;
            log.error("Wrong port number" + port);
        }
    }

    private boolean validate(int vlan) {
        return vlan > 0 && vlan < 52;//Ports range 
    }
}
