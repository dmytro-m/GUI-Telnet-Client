package com.github.dmtk;

public interface Modem {
        
    public String testCable(String port);
    
    public String showPorts();
    
    public String showMACAddressTable();
    
    public String reload();
    
}
