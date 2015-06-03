package com.github.dmtk;

import java.util.Objects;

public class Host {

    private String id;
    private String mac;
    private String ip;
    private String port;
    private String vlan;

        public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getVlan() {
        return vlan;
    }

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
