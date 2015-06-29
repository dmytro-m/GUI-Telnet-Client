package com.github.dmtk;
import org.apache.log4j.Logger;

public class Vlan {

    private int vlanId;
    private final int defaultVlan = 2;
    private final static Logger log = Logger.getLogger(Vlan.class);

    public Vlan(String vlan) {

        try {
            intialize(Integer.parseInt(vlan));
        } catch (NumberFormatException ex) {
            log.error("Wrong VLAN number format" + vlan);
        }

    }
    
    public int getId(){
        return vlanId;
    }

    public Vlan(int vlan) {
        intialize(vlan);
    }

    private void intialize(int vlan) {
        if (validate(vlan)) {
            this.vlanId = vlan;
        } else {
            this.vlanId = defaultVlan;
            log.error("Wrong VLAN number" + vlan);
        }
    }

    private boolean validate(int vlan) {
        return vlan > 0 && vlan < 4094;//VLANs range 
    }
}
