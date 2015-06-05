package com.github.dmtk;

public class DLinkSwitch implements Modem {

    @Override
    public String testCable(String port) {
        return "cable_diag ports " + port;
    }

    @Override
    public String showPorts() {
        return "show ports description";
    }

    @Override
    public String showMACAddressTable() {
        return "show fdb";
    }

    public String showMACAddressTable(String port) {
        return "show fdb" + port;
    }

    public String showMACAddressTableMAC(String mac) {
        return "show fdb mac " + mac;
    }

    public String showMACAddressTableVlan(int vlan) {
        return "show fdb vlanid " + vlan;
    }

    @Override
    public String reload() {
        return "reload";
    }

    public String showTrafficSegmentation() {

        return "sh traffic_segmentation";
    }

    public String changePortState(String port, boolean enabled) {
        String command = null;
        if (enabled) {
            command = "config ports " + port + " state enable";

        } else if (!enabled) {
            command = "config ports " + port + " state disable";

        }
        return command;
    }

    public String changeSpeed(String port, String speed) {

        String command = null;
        if ("Auto".equals(speed)) {
            command = "config ports " + port + " speed auto";

        } else if ("1000 Mbit/s".equals(speed)) {
            command = "config ports " + port + " speed 1000_full";
        } else if ("100 Mbit/s - Full".equals(speed)) {
            command = "config ports " + port + " speed 100_full";

        } else if ("100 Mbit/s - Half".equals(speed)) {
            command = "config ports " + port + " speed 100_half";

        } else if ("10 Mbit/s - Full".equals(speed)) {
            command = "config ports " + port + " speed 10_full";
        } else if ("10 Mbit/s - Half".equals(speed)) {
            command = "config ports " + port + " speed 10_half";

        }
        return command;
    }

    public String configAddressBindingZeroIP(String port, boolean enable) {
        String command = null;
        if (enable) {
            command = "config address_binding ip_mac ports" + port + " state enable allow_zeroip enable";

        } else if (!enable) {

            command = "config address_binding ip_mac ports " + port + " state disable allow_zeroip disable";
        }
        return command;

    }

    public String showErrorsOnPort(String port) {
        return "show error ports " + port;
    }

    public String showPacketsOnPort(String port) {
        return "show packet ports " + port;
    }

    public String showAddressBindingTable() {
        return "show address_binding ip_mac all";
    }

    public String showBandwidthControl() {
        return "show bandwidth_control";
    }

    public String configurePortSecurityMaxLearningAddr2(String port) {
        return "config port_security ports " + port + " admin_state disable max_learning_addr 2 lock_address_mode DeleteOnTimeout";
    }

    public String configurePortRxRateNoLimit(int port1, int port2) {
        return "config bandwidth_control " + port1 + " " + port2 + " rx_rate no_limit";
    }

    public String configurePortTxRateNoLimit(int port1, int port2) {
        return "config bandwidth_control " + port1 + " " + port2 + " tx_rate no_limit";
    }

    public String addAddressBindingPort(String ip, String mac, int port) {
        return "create address_binding ip_mac ipaddress " + ip + " mac_address " + mac + " ports " + port;
    }

    public String removeAddressBindingPort(String ip, String mac) {
        return "delete address_binding ip_mac ipaddress " + ip + " mac_address " + mac;
    }

    public String showAddressBindingBlocked() {
        return "show address_binding blocked all";
    }

    public String addVlanToSwitch(String vlanId, int vlan) {
        
        return "create vlan " + vlanId + " tag " + vlan;
    }

    public String removeVlanFromSwitch(String vlanId) {
        return "delete vlan vlanid " + vlanId;
    }

    public String addVlanToPort(int port, String vlanId, boolean tagged) {
        String command = null;
        if (tagged) {
            command = "config vlan " + vlanId + " add tagged " + port;

        } else if (!tagged) {
            command = "config vlan " + vlanId + " add untagged " + port;

        }
        return command;
    }

    public String removeVlanFromPort(int port, String vlanId) {
        return "config vlan" + vlanId + " delete " + port;
    }

    public String showDhcpRelay() {
        return "show dhcp_relay";
    }

}
