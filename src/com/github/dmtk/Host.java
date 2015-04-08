package com.github.dmtk;

import java.util.Objects;

public class Host {

    private String id;
    private String mac;
    private String ip;
    private String port;
    private String vlan;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the mac
     */
    public String getMac() {
        return mac;
    }

    /**
     * @param mac the mac to set
     */
    public void setMac(String mac) {
        this.mac = mac;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * @return the vlan
     */
    public String getVlan() {
        return vlan;
    }

    /**
     * @param vlan the vlan to set
     */
    public void setVlan(String vlan) {
        this.vlan = vlan;
    }

    @Override
    public String toString() {
        return id+" "
                + mac+" "
                + ip+" "
                + port+" "
                + vlan;
    }
    @Override
    public boolean equals(Object object){
        if(object==null) return false;
        else if(this==object) return true;
        else if(object!=null){
            Host host=(Host) object;
            if(!this.id.equals(host.getId())) return false;
            if(!this.ip.equals(host.getIp())) return false;
            if(!this.mac.equals(host.getMac())) return false;
            if(!this.port.equals(host.getPort())) return false;
            if(!this.vlan.equals(host.getVlan())) return false;
            return true;
        }
        else return false;
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.mac);
        hash = 67 * hash + Objects.hashCode(this.ip);
        hash = 67 * hash + Objects.hashCode(this.port);
        hash = 67 * hash + Objects.hashCode(this.vlan);
        return hash;
    }

}
