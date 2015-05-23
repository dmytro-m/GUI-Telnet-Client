package com.github.dmtk;

public class EdgeCoreSwitch implements Modem {

    private String model = "ES3528";//"ES4210"

    @Override
    public String showPorts() {
        return "show int brief\n";
    }

    @Override
    public String showMACAddressTable() {
        return "show mac-address-table";
    }

    @Override
    public String reload() {

        return "reload";
    }

    public String showMACAddressTable(String port) {
        return "show mac-address-table interface ethernet 1/" + port;
    }

    public String showMACAddressTableVlan(String vlan) {
        return "show mac-address-table vlan " + vlan;
    }

    public String showMACAddressTableMAC(String MAC) {
        return "show mac-address-table address " + MAC;
    }

    public String showInterfaceStatus(String port) {
        return "show interfaces status ethernet 1/" + port;
    }

    public String testConfig(String port) {
        String command = "configure\n"
                + "interface ethernet 1/" + port + "\n"
                + "no ip dhcp snooping trust\n"
                + "no ip arp inspection trust\n"
                + "no ip arp inspection trust\n"
                + "switchport mode hybrid\n"
                + "switchport acceptable-frame-types all\n"
                + "switchport native vlan 2\n"
                + "switchport allowed vlan remove 1,10\n"
                + "mvr type receiver\n"
                + "mvr immediate\n"
                + "switchport multicast packet-rate 64\n"
                + "ip igmp max-groups 2\n"
                + "ip igmp max-groups action replace\n"
                + "ip igmp query-drop\n"
                + "spanning-tree bpdu-guard\n"
                + "spanning-tree bpdu-guard auto-recovery\n"
                + "spanning-tree loopback-detection trap\n"
                + "end";
        return command;
    }

    public String exampleConfig(String port) {

        String command = "configure\n"
                + "interface ethernet 1/" + port + "\n"
                + "media-type copper-forced\n"
                + "port security max-mac-count 2\n"
                + "ip source-guard sip-mac\n"
                + "no ip dhcp snooping trust\n"
                + "no ip arp inspection trust\n"
                + "spanning-tree bpdu-guard\n"
                + "spanning-tree bpdu-guard auto-recovery\n"
                + "spanning-tree loopback-detection trap\n"
                + "switchport mode hybrid\n"
                + "switchport acceptable-frame-types all\n"
                + "switchport native vlan 2\n"
                + "ip igmp filter 1\n"
                + "ip igmp max-groups 2\n"
                + "ip igmp max-groups action replace\n"
                + "mvr type receiver\n"
                + "mvr immediate\n"
                + "ip igmp query-drop\n"
                + "switchport multicast packet-rate 64\n"
                + "end";
        return command;
    }

    public String showCableTestResult() {
        return "show cable-diagnostics tdr interface";
    }

    public String showCableTestResult(String port) {
        String command = null;
        if (model.equals("ES4210")) {
            command = "show cable-diagnostics interface ethernet 1/" + port;
        } else {
            command = "show cable-diagnostics tdr interface ethernet 1/" + port;
        }
        return command;
    }

    @Override
    public String testCable(String port) {
        String command = null;
        if (model.equals("ES4210")) {
            command = "test cable-diagnostics interface ethernet 1/" + port;
        } else {
            command = "test cable-diagnostics tdr interface ethernet 1/" + port;
        }
        return command;
    }

    public String testCable(String firstPort, String lastPort) {
        return "test cable-diagnostics tdr interface ethernet 1/" + firstPort + "-" + lastPort;
    }

    public String saveConfig() {
        return "copy running-config startup-config";
    }

    public String showSystem() {
        return "show system";
    }

    public String showArpLog() {
        return "show ip arp inspection log";
    }

    public String showArpConfig() {
        return "show ip arp inspection configuration";
    }

    public String showArpStat() {
        return "show ip arp inspection statistics";
    }

    public String showArpVlan(String vlan) {
        return "show ip arp inspection vlan" + vlan;
    }

    public String showSourceGuardBindingDhcpSnooping() {
        return "show ip source-guard binding dhcp-snooping";
    }

    public String showSourceGuardBindingStatic() {
        return "show ip source-guard binding static";
    }

    public void changeModel(String model) {
        this.model = model;
    }

    public String showMvr() {
        return "show mvr";
    }

    public String addVlanToSwitch(String vlan, String name) {
        String command = "configure\n"
                + "vlan database\nvlan " + vlan + " name " + name + " media ethernet state active\n"
                + "end";
        return command;
    }

    public String showVlanId(String vlan) {
        return "show vlan id " + vlan;
    }

    public String changePortSpeed(String speed, String port) {
        String command = null;
        if ("1000 Mbit/s".equals(speed)) {
            command = "configure\ninterface ethernet 1/" + port + "\nspeed-duplex 1000full\nend";

        } else if ("100 Mbit/s - Full".equals(speed)) {
            command = "configure\ninterface ethernet 1/" + port + "\nspeed-duplex 100full\nend";

        } else if ("100 Mbit/s - Half".equals(speed)) {
            command = "configure\ninterface ethernet 1/" + port + "\nspeed-duplex 100half\nend";

        } else if ("10 Mbit/s - Full".equals(speed)) {
            command = "configure\ninterface ethernet 1/" + port + "\nspeed-duplex 10full\nend";

        } else if ("10 Mbit/s - Half".equals(speed)) {
            command = "configure\ninterface ethernet 1/" + port + "\nspeed-duplex 10half\nend";

        }
        return command;
    }

    public String showTCAM() {
        return "show access-list tcam";
    }

    public String showVlan() {
        return "show vlan";
    }

    public String showCPU() {
        return "show process cpu";
    }

    public String changePolicy(String port, String policy) {
        String command = null;
        if ("DEFAULT_POLICY".equals(policy)) {
            command = "configure\ninterface ethernet 1/" + port + "\nservice-policy input DEFAULT_POLICY\nend";

        } else if ("DENY_ALL".equals(policy)) {
            command = "configure\ninterface ethernet 1/" + port + "\nservice-policy input DENY_ALL\nend";

        } else if ("DENY_MSNET".equals(policy)) {
            command = "configure\ninterface ethernet 1/" + port + "\nservice-policy input DENY_MSNET\nend";

        }
        return command;
    }

    public String showAccessList() {
        return "show access-list";
    }

    public String showIGMPFilter(String port) {
        return "show ip igmp filter interface ethernet 1/" + port;
    }

    public String changePortState(String port, boolean enabled) {
        String command = null;

        if (enabled) {
            command = "configure\ninterface ethernet 1/" + port + "\nno shutdown\nend";

        } else if (!enabled) {
            command = "configure\ninterface ethernet 1/" + port + "\nshutdown\nend";

        }

        return command;
    }

    public String capabilities1000Full(String port, boolean enable) {
        String command = null;

        if (enable) {
            command = "configure\ninterface ethernet 1/" + port + "\n capabilities 1000full\nend";
        } else if (!enable) {
            command = "configure\ninterface ethernet 1/" + port + "\nno capabilities 1000full\nend";
        }
        return command;
    }

    public String changeMediaType(String port, String type) {

        String command = null;
        if ("copper-forced".equals(type)) {
            command = "configure\ninterface ethernet 1/" + port + "\nmedia-type copper-forced\nend";

        } else if ("sfp-forced".equals(type)) {
            command = "configure\ninterface ethernet 1/" + port + "\nmedia-type sfp-forced\nend";

        } else if ("sfp-preferred-auto".equals(type)) {
            command = "configure\ninterface ethernet 1/" + port + "\nmedia-type sfp-preferred-auto\nend";

        } else if ("sfp-forced 100fx".equals(type)) {
            command = "configure\ninterface ethernet 1/" + port + "\nmedia-type sfp-forced 100fx\nend";

        }
        return command;
    }

    public String changeNegotiation(String port, boolean enable) {

        String command = null;

        if (enable) {
            command = "configure\ninterface ethernet 1/" + port + "\n negotiation\nend";
        } else if (!enable) {
            command = "configure\ninterface ethernet 1/" + port + "\nno negotiation\nend";
        }
        return command;
    }

    public String changePortSecurity(String port, boolean enable) {

        String command = null;

        if (enable) {
            command = "configure\ninterface ethernet 1/" + port + "\nport security\nend";
        } else if (!enable) {
            command = "configure\ninterface ethernet 1/" + port + "\nno port security\nend";
        }
        return command;
    }

    public String changeIPSourceGuardSipMac(String port, boolean enable) {

        String command = null;

        if (enable) {
            command = "configure\ninterface ethernet 1/" + port + "\nip source-guard sip-mac\nend";
        } else if (!enable) {
            command = "configure\ninterface ethernet 1/" + port + "\nno ip source-guard\nend";
        }
        return command;
    }

    public String changeArpInspection(String port, boolean enable) {

        String command = null;

        if (enable) {
            command = "configure\ninterface ethernet 1/" + port + "\nno ip arp inspection trust\nend";
        } else if (!enable) {
            command = "configure\ninterface ethernet 1/" + port + "\nip arp inspection trust\nend";
        }
        return command;
    }

    public String showCurrentPortConfig(String port) {
        return "show running-config interface ethernet 1/" + port;
    }

    public String showPortCounters(String port) {
        return "show interfaces counters ethernet 1/" + port;
    }

    public String clearPortCounters(String port) {
        return "clear counters ethernet 1/" + port;
    }

    public String showDHCPSnoping() {
        return "show ip dhcp snooping";
    }

    public String enableStpBpdu(String port, boolean enable) {
        String command = null;
        if (enable) {
            command = "configure\ninterface ethernet 1/" + port + "\nspanning-tree bpdu-guard\nend";

        } else if (!enable) {
            command = "configure\ninterface ethernet 1/" + port + "\nno spanning-tree bpdu-guard\nend";

        }
        return command;

    }

    public String enableStpBpduAutoRecovery(String port, boolean enable) {
        String command = null;
        if (enable) {
            command = "configure\ninterface ethernet 1/" + port + "\nspanning-tree bpdu-guard auto-recovery\nend";

        } else if (!enable) {
            command = "configure\ninterface ethernet 1/" + port + "\nno spanning-tree bpdu-guard auto-recovery\nend";

        }
        return command;

    }

    public String addVlanToPort(String port, String vlan, boolean tagged) {

        String command = null;
        if (tagged) {
            command = "configure\ninterface ethernet 1/" + port + "\n switchport allowed vlan add " + vlan + " tagged\nend";

        } else if (!tagged) {
            command = "configure\ninterface ethernet 1/" + port + "\n switchport allowed vlan add " + vlan + " untagged\nend";
        }
        return command;

    }

    public String showPolicy(String port) {
        return "show policy-map interface 1/" + port + " input";
    }

    public String removeVlanFromPort(String port, String vlan) {
        return "configure\n"
                + "interface ethernet 1/" + port + "\n"
                + "switchport allowed vlan remove " + vlan + "\n"
                + "end";
    }

    public String configureDHCPSnoppingVlan(String vlan, boolean enabled) {

        String command = null;
        if (enabled) {
            command = "configure\nip dhcp snooping vlan " + vlan + "\nend";

        } else if (!enabled) {
            command = "configure\nno ip dhcp snooping vlan " + vlan + "\nend";
        }
        return command;
    }

    public String configurePortsIpSourceGuard(int port1, int port2, boolean enable) {

        String command = null;
        if (enable) {
            command = "configure\ninterface ethernet 1/" + port1 + "-" + port2 + "\nip source-guard sip-mac\nend";

        } else if (!enable) {
            command = "configure\ninterface ethernet 1/" + port1 + "-" + port2 + "\nno ip source-guard\nend";
        }
        return command;
    }

    public String configurePortsSecurity(int port1, int port2, boolean enable) {

        String command = null;
        if (enable) {
            command = "configure\ninterface ethernet 1/" + port1 + "-" + port2 + "\nip source-guard sip-mac\nend";

        } else if (!enable) {
            command = "configure\ninterface ethernet 1/" + port1 + "-" + port2 + "\nno ip source-guard\nend";
        }
        return command;
    }

    public String configureVlanArpInspection(int vlan, boolean enable) {

        String command = null;
        if (enable) {
            command = "configure\nip arp inspection vlan " + vlan + "\nend";

        } else if (!enable) {
            command = "configure\nno ip arp inspection vlan " + vlan + "\nend";

        }
        return command;
    }

    public String showStpPort(String port) {

        return "show spanning-tree ethernet 1/" + port;
    }

    public String configureMacAddressTable(String mac, int port, int vlan, boolean add) {

        String command = null;
        if (add) {
            command = "configure\n" + "mac-address-table static " + mac + " interface ethernet 1/" + port + " vlan " + vlan + " \nend";

        } else if (!add) {
            command = "configure\n" + "no mac-address-table static " + mac + " vlan " + vlan + "\nend";
        }
        return command;
    }

    public String configureIpSourceGuardBindingTable(String mac, int vlan, String ip, int port, boolean enable) {
        String command = null;
        if (enable) {
            command = "config\nip source-guard binding " + mac + " vlan " + vlan + " " + ip + " interface ethernet 1/" + port + "\nend";

        } else if (!enable) {
            command = "config\nno ip source-guard binding " + mac + " vlan " + vlan + "\nend";

        }
        return command;
    }

}
