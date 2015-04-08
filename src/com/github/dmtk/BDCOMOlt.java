package com.github.dmtk;

public class BDCOMOlt implements Modem {

    @Override
    public String testCable(String port) {
        return "";
    }

    @Override
    public String showPorts() {
        return "show int brief";
    }

    @Override
    public String showMACAddressTable() {
        return "show mac address-table ";
    }

    public String showMACAddressTable(int eponPort, int olt) {
        return "show mac address-table interface epON 0/" + eponPort + ":" + olt;
    }

    public String showMACAddressTableMAC(String mac) {
        return "show mac address-table " + mac;
    }

    public String showMACAddressTableVlan(int vlan) {
        return "show fdb vlanid " + vlan;
    }

    @Override
    public String reload() {
        return "reload";
    }

    public String showDhcpRelaySnooping() {
        return "show ip dhcp-relay snooping binding all";
    }

    public String showVlan() {
        return "show vlan";
    }

    public String showOpticalTxRxDiagnosis() {
        return "show epon optical-transceiver-diagnosis";
    }

    public String showOpticalTxRxDiagnosis(int eponPort, int olt) {
        return "show epon interface epON 0/" + eponPort + ":" + olt + " onu ctc optical-transceiver-diagnosis ";
    }

    public String showEponVlan(int eponPort, int olt) {
        return "show epon interface epon 0/" + eponPort + ":" + olt + " onu ctc vlan";
    }

    public String showEponSnmp(int eponPort, int olt) {
        return "show epon interface epon 0/" + eponPort + ":" + olt + " onu ctc snmp-info";
    }

    public String rebootOnu(int eponPort, int olt) {
        return "epon reboot onu interface epon 0/" + eponPort + ":" + olt;
    }

    public String showEponDba(int eponPort, int olt) {
        return "show epon interface epon 0/" + eponPort + ":" + olt + " onu ctc dba";
    }

    public String showEponInfo(int eponPort, int olt) {
        return "show epon interface epon 0/" + eponPort + ":" + olt + " onu ctc basic-info";
    }
}
