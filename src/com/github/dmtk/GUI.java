package com.github.dmtk;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultCaret;

public class GUI extends javax.swing.JFrame {

    private volatile static GUI uniqueGui;
    
    private static Telnet telnet = null;
    private static Telnet telnet2 = null;
    private static Ssh ssh = new Ssh();
    private Authentication au;
    public String hostID;
    private List<Host> hosts = new ArrayList();
    private static Terminal telnetActive = null;
    private boolean repeatClean = true;
    private EdgeCoreSwitch ecs = new EdgeCoreSwitch();
    private DLinkSwitch dls = new DLinkSwitch();
    private BDCOMOlt bdt = new BDCOMOlt();
    private String ctrlC = "\003";

    private GUI() {

        initComponents();
        DefaultCaret caret = (DefaultCaret) CLITextArea1.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        DefaultCaret caret2 = (DefaultCaret) CLITextArea2.getCaret();
        caret2.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        try {
            au = new Authentication(this);
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    public static GUI getInstance() {
        if (uniqueGui == null) {
            synchronized (GUI.class) {
                if (uniqueGui == null) {
                    uniqueGui = new GUI();
                }
            }
        }
        return uniqueGui;
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idTextField = new javax.swing.JTextField();
        ipTextField = new javax.swing.JTextField();
        portTextField = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        macTextField = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        vlanTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton23 = new javax.swing.JButton();
        CtrlCButton = new javax.swing.JButton();
        commandTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        PortStatePanel = new javax.swing.JPanel();
        showSystemButton = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jComboBox4 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox5 = new javax.swing.JComboBox();
        jButton58 = new javax.swing.JButton();
        jButton79 = new javax.swing.JButton();
        jButton80 = new javax.swing.JButton();
        jCheckBox19 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jButton35 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton65 = new javax.swing.JButton();
        jButton63 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton64 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jButton26 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jTextField13 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jButton28 = new javax.swing.JButton();
        jTextField11 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jButton43 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jTextField14 = new javax.swing.JTextField();
        jCheckBox14 = new javax.swing.JCheckBox();
        jButton37 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jButton67 = new javax.swing.JButton();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton22 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButton3 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton68 = new javax.swing.JButton();
        jButton69 = new javax.swing.JButton();
        jButton70 = new javax.swing.JButton();
        jButton71 = new javax.swing.JButton();
        jButton72 = new javax.swing.JButton();
        jTextField18 = new javax.swing.JTextField();
        jButton73 = new javax.swing.JButton();
        jButton74 = new javax.swing.JButton();
        jCheckBox18 = new javax.swing.JCheckBox();
        jButton75 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButton46 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jButton53 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jButton59 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jButton62 = new javax.swing.JButton();
        jButton78 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        CLITerminal1 = new javax.swing.JPanel();
        switchIPTextField = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        connectButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CLITextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        switchIPTextField2 = new javax.swing.JTextField();
        connectButton2 = new javax.swing.JButton();
        loginButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        CLITextArea2 = new javax.swing.JTextArea();
        jTextField20 = new javax.swing.JTextField();
        jButton25 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        CLITextArea3 = new javax.swing.JTextArea();
        switchIPTextField3 = new javax.swing.JTextField();
        tcpPortTextField3 = new javax.swing.JTextField();
        connectButton3 = new javax.swing.JButton();
        loginButton3 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Telnet client for Edge-Core & D-link");
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        idTextField.setText("client_id");
        idTextField.setToolTipText("Введіть №договору і натисніть \"Enter\" для підтвердження");
        idTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextFieldActionPerformed(evt);
            }
        });
        idTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idTextFieldKeyPressed(evt);
            }
        });

        ipTextField.setToolTipText("type client IP here...");
        ipTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipTextFieldActionPerformed(evt);
            }
        });

        portTextField.setToolTipText("№ port");
        portTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portTextFieldActionPerformed(evt);
            }
        });

        jButton4.setText("clear CLI");
        MyButtonUI.setupButtonUI(jButton4);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        macTextField.setText("00-00-00-00-00-00");
        macTextField.setToolTipText("type MAC here...");
        macTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                macTextFieldActionPerformed(evt);
            }
        });

        jButton12.setText("OK");
        MyButtonUI.setupButtonUI(jButton12);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("ping");
        MyButtonUI.setupButtonUI(jButton13);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Client IP");

        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        vlanTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vlanTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("vlan");
        jLabel3.setToolTipText("virtual local area network");

        jButton23.setText("Space");
        MyButtonUI.setupButtonUI(jButton23);
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        CtrlCButton.setText("Ctrl+C");
        MyButtonUI.setupButtonUI(CtrlCButton);
        CtrlCButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CtrlCButtonActionPerformed(evt);
            }
        });

        commandTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                commandTabbedPane1StateChanged(evt);
            }
        });

        showSystemButton.setText("show system");
        MyButtonUI.setupButtonUI(showSystemButton);
        showSystemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showSystemButtonActionPerformed(evt);
            }
        });

        jButton30.setText("cable test");
        MyButtonUI.setupButtonUI(jButton30);
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton31.setText("show running config");
        MyButtonUI.setupButtonUI(jButton31);
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton32.setText("show counters");
        MyButtonUI.setupButtonUI(jButton32);
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton33.setText("clear counters");
        MyButtonUI.setupButtonUI(jButton33);
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jButton18.setText("show int brief ");
        MyButtonUI.setupButtonUI(jButton18);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Port on/off");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox6.setSelected(true);
        jCheckBox6.setText("Port Security");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jCheckBox10.setSelected(true);
        jCheckBox10.setText("static mac address table");
        jCheckBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox10ActionPerformed(evt);
            }
        });

        jCheckBox8.setSelected(true);
        jCheckBox8.setText("SIP-MAC");
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });

        jCheckBox7.setSelected(true);
        jCheckBox7.setText("ip source guard");
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        jCheckBox9.setSelected(true);
        jCheckBox9.setText("arp inspection");
        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ES3528", "ES4210" }));
        jComboBox4.setToolTipText("Swith model");
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jComboBox2.setBackground(new java.awt.Color(240, 240, 240));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "->Mbit/s", "1000 Mbit/s", "100 Mbit/s - Full", "100 Mbit/s - Half", "10 Mbit/s - Full", "10 Mbit/s - Half" }));
        jComboBox2.setToolTipText("Конфігурація швидкості на порту");
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "->media-type", "copper-forced", "sfp-forced", "sfp-preferred-auto", "sfp-forced 100fx" }));
        jComboBox3.setToolTipText("");
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DEFAULT_POLICY", "DENY_ALL", "DENY_MSNET" }));
        jComboBox5.setToolTipText("Поставить нужную политику на определенный порт ");
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jButton58.setText("sh access-list tcam");
        MyButtonUI.setupButtonUI(jButton58);
        jButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton58ActionPerformed(evt);
            }
        });

        jButton79.setText("sh vlan");
        MyButtonUI.setupButtonUI(jButton79);
        jButton79.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton79ActionPerformed(evt);
            }
        });

        jButton80.setText("sh process cpu");
        MyButtonUI.setupButtonUI(jButton80);
        jButton80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton80ActionPerformed(evt);
            }
        });

        jCheckBox19.setSelected(true);
        jCheckBox19.setText("capabilities 1000full");
        jCheckBox19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox19ActionPerformed(evt);
            }
        });

        jCheckBox4.setSelected(true);
        jCheckBox4.setText("autonegotiation");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jButton35.setText("show interfaces status ethernet");
        MyButtonUI.setupButtonUI(jButton35);
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jButton17.setText("show mac-address-table int eth");
        MyButtonUI.setupButtonUI(jButton17);
        jButton17.setToolTipText("show mac-address-table interface ethernet");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton42.setText(" show policy-map interface");
        MyButtonUI.setupButtonUI(jButton42);
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jButton34.setText(" sh ip source-guard binding static");
        MyButtonUI.setupButtonUI(jButton34);
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jButton50.setText("show ip arp inspection statistics");
        MyButtonUI.setupButtonUI(jButton50);
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });

        jButton45.setText("sh ip arp inspection configuration");
        MyButtonUI.setupButtonUI(jButton45);
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });

        jButton36.setText(" show mac-address-table address");
        MyButtonUI.setupButtonUI(jButton36);
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jButton40.setText("show mac-address-tab vlan");
        MyButtonUI.setupButtonUI(jButton40);
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        jButton65.setText("show access-list");
        jButton65.setToolTipText("Посмотреть  текущие группы политик/блокировок");
        MyButtonUI.setupButtonUI(jButton65);
        jButton65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton65ActionPerformed(evt);
            }
        });

        jButton63.setText(" sh ip src-grd b dhcp-snooping");
        MyButtonUI.setupButtonUI(jButton63);
        jButton63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton63ActionPerformed(evt);
            }
        });

        jButton39.setText(" show ip dhcp snooping");
        MyButtonUI.setupButtonUI(jButton39);
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        jButton64.setText(" show ip arp inspection log");
        MyButtonUI.setupButtonUI(jButton64);
        jButton64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton64ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PortStatePanelLayout = new javax.swing.GroupLayout(PortStatePanel);
        PortStatePanel.setLayout(PortStatePanelLayout);
        PortStatePanelLayout.setHorizontalGroup(
            PortStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PortStatePanelLayout.createSequentialGroup()
                .addGroup(PortStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PortStatePanelLayout.createSequentialGroup()
                        .addGroup(PortStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(showSystemButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PortStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PortStatePanelLayout.createSequentialGroup()
                                .addComponent(jCheckBox10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton80))
                            .addGroup(PortStatePanelLayout.createSequentialGroup()
                                .addComponent(jCheckBox8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PortStatePanelLayout.createSequentialGroup()
                                .addGroup(PortStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox9)
                                    .addComponent(jCheckBox7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PortStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox19, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jCheckBox4, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(PortStatePanelLayout.createSequentialGroup()
                                .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(PortStatePanelLayout.createSequentialGroup()
                                .addComponent(jCheckBox6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton79, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PortStatePanelLayout.createSequentialGroup()
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PortStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(PortStatePanelLayout.createSequentialGroup()
                        .addGroup(PortStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton50, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButton42, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PortStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton65, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton63, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        PortStatePanelLayout.setVerticalGroup(
            PortStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PortStatePanelLayout.createSequentialGroup()
                .addGroup(PortStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(PortStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PortStatePanelLayout.createSequentialGroup()
                        .addComponent(showSystemButton)
                        .addGap(0, 0, 0)
                        .addComponent(jButton30)
                        .addGap(0, 0, 0)
                        .addComponent(jButton31)
                        .addGap(0, 0, 0)
                        .addComponent(jButton32)
                        .addGap(0, 0, 0)
                        .addComponent(jButton33)
                        .addGap(0, 0, 0)
                        .addComponent(jButton18))
                    .addGroup(PortStatePanelLayout.createSequentialGroup()
                        .addGroup(PortStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox3)
                            .addComponent(jButton58))
                        .addGap(0, 0, 0)
                        .addGroup(PortStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox6)
                            .addComponent(jButton79))
                        .addGap(0, 0, 0)
                        .addGroup(PortStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox10)
                            .addComponent(jButton80))
                        .addGap(0, 0, 0)
                        .addGroup(PortStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox8)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PortStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PortStatePanelLayout.createSequentialGroup()
                                .addComponent(jCheckBox7)
                                .addGap(0, 0, 0)
                                .addComponent(jCheckBox9))
                            .addGroup(PortStatePanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox4)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PortStatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PortStatePanelLayout.createSequentialGroup()
                        .addComponent(jButton35)
                        .addGap(0, 0, 0)
                        .addComponent(jButton17)
                        .addGap(0, 0, 0)
                        .addComponent(jButton42)
                        .addGap(0, 0, 0)
                        .addComponent(jButton34)
                        .addGap(0, 0, 0)
                        .addComponent(jButton50)
                        .addGap(0, 0, 0)
                        .addComponent(jButton45))
                    .addGroup(PortStatePanelLayout.createSequentialGroup()
                        .addComponent(jButton36)
                        .addGap(0, 0, 0)
                        .addComponent(jButton40)
                        .addGap(0, 0, 0)
                        .addComponent(jButton65)
                        .addGap(0, 0, 0)
                        .addComponent(jButton63)
                        .addGap(0, 0, 0)
                        .addComponent(jButton39)
                        .addGap(0, 0, 0)
                        .addComponent(jButton64)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Port state", PortStatePanel);

        jButton26.setText("Testing port configuration ");
        MyButtonUI.setupButtonUI(jButton26);
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton44.setText("copy running-config startup-config");
        MyButtonUI.setupButtonUI(jButton44);
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        jButton27.setText("Exampe port configuration");
        MyButtonUI.setupButtonUI(jButton27);
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton29.setText("test cable-diag tdr int eth 1/x-y");
        MyButtonUI.setupButtonUI(jButton29);
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton47.setText("show cable-diagnostics tdr int");
        MyButtonUI.setupButtonUI(jButton47);
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        jButton49.setText(" show mvr ");
        MyButtonUI.setupButtonUI(jButton49);
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });

        jButton41.setText("igmp filter");
        MyButtonUI.setupButtonUI(jButton41);
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        jLabel8.setText("ports xx-yy");

        jCheckBox13.setSelected(true);
        jCheckBox13.setText("Port Security");
        jCheckBox13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox13ActionPerformed(evt);
            }
        });

        jCheckBox12.setSelected(true);
        jCheckBox12.setText("SIP-MAC");
        jCheckBox12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox12ActionPerformed(evt);
            }
        });

        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });

        jButton28.setText("add vlan on switch");
        MyButtonUI.setupButtonUI(jButton28);
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jTextField11.setText("vlan_№");
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });

        jTextField15.setText("vlan_name");

        jButton43.setText("add vlan on port");
        MyButtonUI.setupButtonUI(jButton43);
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        jButton38.setText("remove vlans");
        MyButtonUI.setupButtonUI(jButton38);
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jTextField14.setText("vlan_to_rm");

        jCheckBox14.setText("vlan[un]tagged ");
        jCheckBox14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox14ActionPerformed(evt);
            }
        });

        jButton37.setText("show vlan id");
        MyButtonUI.setupButtonUI(jButton37);
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        jButton48.setText("show ip arp inspection vlan");
        MyButtonUI.setupButtonUI(jButton48);
        jButton48.setToolTipText("Посмотреть DAI статус на определенном VLANe ");
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });

        jCheckBox11.setSelected(true);
        jCheckBox11.setText("dhcp snooping");
        jCheckBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox11ActionPerformed(evt);
            }
        });

        jCheckBox15.setSelected(true);
        jCheckBox15.setText("DAI");
        jCheckBox15.setToolTipText("Влючить/отключить DAI статус на определенном VLANe");
        jCheckBox15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox15ActionPerformed(evt);
            }
        });

        jButton67.setText("sh spanning-tree eth");
        MyButtonUI.setupButtonUI(jButton67);
        jButton67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton67ActionPerformed(evt);
            }
        });

        jCheckBox16.setSelected(true);
        jCheckBox16.setText("STP BPDU Guard ");
        jCheckBox16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox16ActionPerformed(evt);
            }
        });

        jCheckBox17.setSelected(true);
        jCheckBox17.setText("STP BPDU Guard Auto recovery");
        jCheckBox17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton44, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox14)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton43, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton28, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField11)
                                    .addComponent(jTextField15)
                                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(19, 19, 19)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox12)
                            .addComponent(jCheckBox13)))
                    .addComponent(jButton47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox16)
                            .addComponent(jCheckBox17))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton67, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jCheckBox11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckBox15))
                            .addComponent(jButton48, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton26)
                        .addGap(0, 0, 0)
                        .addComponent(jButton44))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jButton49))
                        .addComponent(jButton41)))
                .addGap(0, 0, 0)
                .addComponent(jButton27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox13)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton47))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton28)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton43)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton38)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jCheckBox14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox11)
                            .addComponent(jCheckBox15))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton67)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox16)
                .addContainerGap())
        );

        jTabbedPane3.addTab("VLAN & Port configuration", jPanel9);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );

        commandTabbedPane1.addTab("Edge-Core", jPanel2);

        jButton9.setText("show bandwidth_control");
        MyButtonUI.setupButtonUI(jButton9);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton5.setText("Address binding table");
        MyButtonUI.setupButtonUI(jButton5);
        jButton5.setToolTipText("Показати таблицю");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton8.setText("show ports description");
        MyButtonUI.setupButtonUI(jButton8);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton10.setText("show address_binding blocked all");
        MyButtonUI.setupButtonUI(jButton10);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        MyButtonUI.setupButtonUI(jButton7);
        jButton7.setText("delete address_binding ip_mac");
        jButton7.setToolTipText("Видалити статичний запис з таблиці");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton6.setText("create address_binding ip_mac");
        MyButtonUI.setupButtonUI(jButton6);
        jButton6.setToolTipText("Додати статичний запис у таблицю");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton20.setText("config bandwidth_control 1-xx tx_rate no_limit");
        MyButtonUI.setupButtonUI(jButton20);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton19.setText("config bandwidth_control 1-xx rx_rate no_limit");
        MyButtonUI.setupButtonUI(jButton19);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jTextField8.setText("26");
        jTextField8.setToolTipText("Кількість портів на комутаторі");

        jLabel4.setText("max №");
        jLabel4.setToolTipText("Кількість портів на комутаторі");

        jButton22.setText("address_mode DeleteOnTimeout");
        MyButtonUI.setupButtonUI(jButton22);
        jButton22.setToolTipText("config port_security ports № admin_state disable max_learning_addr 2 lock_address_mode DeleteOnTimeout");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton2.setText("show fdb port");
        MyButtonUI.setupButtonUI(jButton2);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton16.setText("show packet ports");
        MyButtonUI.setupButtonUI(jButton16);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton11.setText("show error ports");
        MyButtonUI.setupButtonUI(jButton11);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton15.setText("show fdb");
        MyButtonUI.setupButtonUI(jButton15);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("address_binding ip_mac");
        jCheckBox2.setToolTipText("config address_binding ip_mac ports state enable allow_zeroip enable");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(180, 221, 255));
        MyButtonUI.setupButtonUI(jButton3);
        jButton3.setText("cable test");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton21.setText("reboot");
        MyButtonUI.setupButtonUI(jButton21);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Auto", "1000 Mbit/s", "100 Mbit/s - Full", "100 Mbit/s - Half", "10 Mbit/s - Full", "10 Mbit/s - Half" }));
        jComboBox1.setToolTipText("port speed");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Port on/off");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jButton68.setText("sh dhcp-relay");
        MyButtonUI.setupButtonUI(jButton68);
        jButton68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton68ActionPerformed(evt);
            }
        });

        jButton69.setText("show fdb mac address");
        MyButtonUI.setupButtonUI(jButton69);
        jButton69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton69ActionPerformed(evt);
            }
        });

        jButton70.setText("show fdb vlanid");
        MyButtonUI.setupButtonUI(jButton70);
        jButton70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton70ActionPerformed(evt);
            }
        });

        MyButtonUI.setupButtonUI(jButton71);
        jButton71.setText("create vlan(on switch)");
        jButton71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton71ActionPerformed(evt);
            }
        });

        jButton72.setText("delete vlan (from switch)");
        MyButtonUI.setupButtonUI(jButton72);
        jButton72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton72ActionPerformed(evt);
            }
        });

        jTextField18.setText("№vlan");

        jButton73.setText("add vlan on port");
        MyButtonUI.setupButtonUI(jButton73);
        jButton73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton73ActionPerformed(evt);
            }
        });

        jButton74.setText("delete vlan from port");
        MyButtonUI.setupButtonUI(jButton74);
        jButton74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton74ActionPerformed(evt);
            }
        });

        jCheckBox18.setText("[un]tagged");

        jButton75.setText("sh traffic_segmentation");
        MyButtonUI.setupButtonUI(jButton75);
        jButton75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton75ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton21))
                    .addComponent(jLabel4))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jButton73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton71, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton72, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox18, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton10)
                            .addComponent(jButton11))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton7)
                            .addComponent(jButton15))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton9))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton22)))
                    .addComponent(jButton2))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16)
                    .addComponent(jButton69))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox2)
                    .addComponent(jButton70))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton68)
                    .addComponent(jButton75))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton71)
                            .addComponent(jCheckBox18))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton72)
                            .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton73)
                        .addGap(0, 0, 0)
                        .addComponent(jButton74)))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19)
                    .addComponent(jLabel4))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton20)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21)))
        );

        commandTabbedPane1.addTab("D-Link", jPanel1);

        jButton46.setText("show epon optical-transceiver-diagnosis");
        MyButtonUI.setupButtonUI(jButton46);
        jButton46.setToolTipText("посмотреть уровень помех для всех ONU");
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });

        jButton51.setText("show int brief");
        MyButtonUI.setupButtonUI(jButton51);
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });

        jButton52.setText("show epon interface epon optical-diag");
        MyButtonUI.setupButtonUI(jButton52);
        jButton52.setToolTipText("посмотреть уровень помех для конкретной Onu");
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });

        jLabel9.setText("номер Epon порта");

        jLabel10.setText("номер ONU");

        jButton53.setText("show vlan");
        MyButtonUI.setupButtonUI(jButton53);
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });

        jButton54.setText("show mac address-table interface epON ");
        MyButtonUI.setupButtonUI(jButton54);
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });

        jButton55.setText("show ip dhcp-relay snooping binding all");
        MyButtonUI.setupButtonUI(jButton55);
        jButton55.setToolTipText("Посмотреть привязки mac к ip");
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton55ActionPerformed(evt);
            }
        });

        jButton56.setText("show interface epON basic-info");
        MyButtonUI.setupButtonUI(jButton56);
        jButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton56ActionPerformed(evt);
            }
        });

        jButton57.setText("show interface epON dba");
        MyButtonUI.setupButtonUI(jButton57);
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton57ActionPerformed(evt);
            }
        });

        jButton59.setText("reboot onu  int epON");
        MyButtonUI.setupButtonUI(jButton59);
        jButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton59ActionPerformed(evt);
            }
        });

        jButton60.setText("show  interface epON snmp-info");
        MyButtonUI.setupButtonUI(jButton60);
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton60ActionPerformed(evt);
            }
        });

        jButton62.setText("show int epON vlan");
        MyButtonUI.setupButtonUI(jButton62);
        jButton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton62ActionPerformed(evt);
            }
        });

        jButton78.setText("show mac address-table mac");
        MyButtonUI.setupButtonUI(jButton78);
        jButton78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton78ActionPerformed(evt);
            }
        });

        jTextField2.setText("0000.0000.0000");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton56, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton55, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton60, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35))
                            .addComponent(jButton46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton57)
                            .addComponent(jButton51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton54, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(jButton52, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(0, 0, 0)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jButton52)
                .addGap(0, 0, 0)
                .addComponent(jButton54)
                .addGap(1, 1, 1)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton51)
                        .addGap(0, 0, 0)
                        .addComponent(jButton57)
                        .addGap(0, 0, 0)
                        .addComponent(jButton53)
                        .addGap(0, 0, 0)
                        .addComponent(jButton62)
                        .addGap(0, 0, 0)
                        .addComponent(jButton59))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton78)
                        .addGap(0, 0, 0)
                        .addComponent(jButton56)
                        .addGap(0, 0, 0)
                        .addComponent(jButton46)
                        .addGap(0, 0, 0)
                        .addComponent(jButton60)
                        .addGap(0, 0, 0)
                        .addComponent(jButton55)))
                .addContainerGap(107, Short.MAX_VALUE))
        );

        commandTabbedPane1.addTab("BDCOM", jPanel7);

        jPasswordField1.setText("password");

        jPasswordField2.setText("password");

        jTextField9.setText("login");
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jTextField10.setText("login");
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        jLabel6.setText("Billing");

        jLabel7.setText("Terminal");

        jCheckBox5.setText("Save login and passwd");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel6)
                        .addGap(107, 107, 107)
                        .addComponent(jLabel7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox5)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField9)
                                    .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPasswordField2, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(jTextField10))))))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox5)
                .addContainerGap(251, Short.MAX_VALUE))
        );

        commandTabbedPane1.addTab("Authentication", jPanel4);

        jLabel5.setText("Port");
        jLabel5.setToolTipText("port on the commutator ");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1" }));
        jComboBox6.setBorder(null);
        jComboBox6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });

        jTabbedPane2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane2StateChanged(evt);
            }
        });

        switchIPTextField.setText("...switch IP");
        switchIPTextField.setToolTipText("IP комутатора");
        switchIPTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchIPTextFieldActionPerformed(evt);
            }
        });
        switchIPTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                switchIPTextFieldKeyTyped(evt);
            }
        });

        jTextField6.setText("23");
        jTextField6.setToolTipText("Port for telnet connection");

        connectButton.setText("Connect");
        MyButtonUI.setupButtonUI(connectButton);
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        loginButton.setText("login");
        MyButtonUI.setupButtonUI(loginButton);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        CLITextArea1.setBackground(new java.awt.Color(0, 0, 0));
        CLITextArea1.setColumns(20);
        CLITextArea1.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        CLITextArea1.setForeground(new java.awt.Color(255, 255, 255));
        CLITextArea1.setLineWrap(true);
        CLITextArea1.setRows(5);
        CLITextArea1.setAutoscrolls(false);
        CLITextArea1.setCaretColor(new java.awt.Color(255, 255, 255));
        CLITextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        CLITextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CLITextArea1MouseClicked(evt);
            }
        });
        CLITextArea1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                CLITextArea1PropertyChange(evt);
            }
        });
        CLITextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CLITextArea1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(CLITextArea1);

        jButton1.setText("ping switch");
        MyButtonUI.setupButtonUI(jButton1);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CLITerminal1Layout = new javax.swing.GroupLayout(CLITerminal1);
        CLITerminal1.setLayout(CLITerminal1Layout);
        CLITerminal1Layout.setHorizontalGroup(
            CLITerminal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CLITerminal1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(switchIPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 363, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        CLITerminal1Layout.setVerticalGroup(
            CLITerminal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CLITerminal1Layout.createSequentialGroup()
                .addGroup(CLITerminal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(switchIPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connectButton)
                    .addComponent(loginButton)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Telnet #1", CLITerminal1);

        switchIPTextField2.setText("...switch IP");
        switchIPTextField2.setToolTipText("IP комутатора");
        switchIPTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchIPTextField2ActionPerformed(evt);
            }
        });
        switchIPTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                switchIPTextField2KeyTyped(evt);
            }
        });

        connectButton2.setText("Connect");
        MyButtonUI.setupButtonUI(connectButton2);
        connectButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButton2ActionPerformed(evt);
            }
        });

        loginButton2.setText("login");
        MyButtonUI.setupButtonUI(loginButton2);
        loginButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButton2ActionPerformed(evt);
            }
        });

        CLITextArea2.setBackground(new java.awt.Color(0, 0, 0));
        CLITextArea2.setColumns(20);
        CLITextArea2.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        CLITextArea2.setForeground(new java.awt.Color(255, 255, 255));
        CLITextArea2.setLineWrap(true);
        CLITextArea2.setRows(5);
        CLITextArea2.setAutoscrolls(false);
        CLITextArea2.setCaretColor(new java.awt.Color(255, 255, 255));
        CLITextArea2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        CLITextArea2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CLITextArea2MouseClicked(evt);
            }
        });
        CLITextArea2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CLITextArea2KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(CLITextArea2);

        jTextField20.setText("23");
        jTextField20.setToolTipText("Port for telnet connection");

        jButton25.setText("ping switch");
        MyButtonUI.setupButtonUI(jButton25);
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(switchIPTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(connectButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 363, Short.MAX_VALUE)
                .addComponent(jButton25)
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(switchIPTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connectButton2)
                    .addComponent(loginButton2)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Telnet #2", jPanel6);

        CLITextArea3.setBackground(new java.awt.Color(0, 0, 0));
        CLITextArea3.setColumns(20);
        CLITextArea3.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        CLITextArea3.setForeground(new java.awt.Color(255, 255, 255));
        CLITextArea3.setLineWrap(true);
        CLITextArea3.setRows(5);
        CLITextArea3.setAutoscrolls(false);
        CLITextArea3.setCaretColor(new java.awt.Color(255, 255, 255));
        CLITextArea3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        CLITextArea3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CLITextArea3MouseClicked(evt);
            }
        });
        CLITextArea3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CLITextArea3KeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(CLITextArea3);

        switchIPTextField3.setText("...type IP");
        switchIPTextField3.setToolTipText("IP комутатора");
        switchIPTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchIPTextField3ActionPerformed(evt);
            }
        });
        switchIPTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                switchIPTextField3KeyTyped(evt);
            }
        });

        tcpPortTextField3.setText("22");
        tcpPortTextField3.setToolTipText("Port for telnet connection");

        MyButtonUI.setupButtonUI(connectButton3);
        connectButton3.setText("Connect");
        MyButtonUI.setupButtonUI(connectButton2);
        connectButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButton3ActionPerformed(evt);
            }
        });

        MyButtonUI.setupButtonUI(loginButton3);
        loginButton3.setText("login");
        MyButtonUI.setupButtonUI(loginButton2);
        loginButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButton3ActionPerformed(evt);
            }
        });

        jButton61.setText("ping switch");
        MyButtonUI.setupButtonUI(jButton25);
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton61ActionPerformed(evt);
            }
        });

        jTextField1.setText("...switch ip");
        jTextField1.setPreferredSize(new java.awt.Dimension(61, 20));

        MyButtonUI.setupButtonUI(jButton14);
        jButton14.setText("logout");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(switchIPTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tcpPortTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(connectButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                .addComponent(jButton61)
                .addContainerGap())
            .addComponent(jScrollPane3)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(switchIPTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connectButton3)
                    .addComponent(loginButton3)
                    .addComponent(tcpPortTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton61)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("SSH", jPanel3);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("MAC");
        jLabel12.setToolTipText("A media access control address (MAC address)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ipTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                            .addComponent(macTextField))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(vlanTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                    .addComponent(portTextField)))
                            .addComponent(commandTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addGap(0, 0, 0)
                                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(CtrlCButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton12))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(vlanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(macTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton23)
                            .addComponent(CtrlCButton)
                            .addComponent(jButton13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(commandTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane2))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextFieldActionPerformed

        BillingParser.parseInfo(idTextField.getText());

    }//GEN-LAST:event_idTextFieldActionPerformed

    private void portTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portTextFieldActionPerformed

    }//GEN-LAST:event_portTextFieldActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed

        if (telnet != null) {
            try {
                telnet.disconnect();
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        telnet = new Telnet(switchIPTextField.getText(), Integer.parseInt(jTextField6.getText()), CLITextArea1);
        telnetActive = telnet;
        Thread myThready = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    telnet.execute();
                } catch (IOException ex) {
                    CLITextArea1.setText(CLITextArea1.getText() + "Connection \n");

                } catch (Exception ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        myThready.start();

    }//GEN-LAST:event_connectButtonActionPerformed

    private void ipTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipTextFieldActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (jTabbedPane2.getTitleAt(jTabbedPane2.getSelectedIndex()).equals("Telnet #1")) {
            CLITextArea1.setText("");
        } else if (jTabbedPane2.getTitleAt(jTabbedPane2.getSelectedIndex()).equals("Telnet #2")) {
            CLITextArea2.setText("");
        } else if (jTabbedPane2.getTitleAt(jTabbedPane2.getSelectedIndex()).equals("SSH")) {
            CLITextArea3.setText("");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void macTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_macTextFieldActionPerformed
        getjTextField4().setText(Formater.replace(macTextField.getText()));
    }//GEN-LAST:event_macTextFieldActionPerformed

    private void CLITextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CLITextArea1KeyPressed
//get command from typed text in to TextArea
        String command;
        if (evt.getKeyChar() == '\n') {

            CLITextArea1.setCaretPosition(CLITextArea1.getText().length());
            if (CLITextArea1.getText().indexOf('#') > (-1) && (CLITextArea1.getText().indexOf('>') < CLITextArea1.getText().indexOf('#'))) {
                command = CLITextArea1.getText().substring(CLITextArea1.getText().lastIndexOf("#") + 1, CLITextArea1.getText().length());
                telnetActive.sendCommand(command);
            } else if (CLITextArea1.getText().indexOf('>') > (-1) && (CLITextArea1.getText().indexOf('>') > CLITextArea1.getText().indexOf('#'))) {
                command = CLITextArea1.getText().substring(CLITextArea1.getText().lastIndexOf(">") + 1, CLITextArea1.getText().length());
                telnetActive.sendCommand(command);
            }
        } else if (Character.isLetterOrDigit(evt.getKeyChar())) {
            CLITextArea1.setCaretPosition(CLITextArea1.getText().length());
        }
    }//GEN-LAST:event_CLITextArea1KeyPressed

    private void switchIPTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchIPTextFieldActionPerformed


    }//GEN-LAST:event_switchIPTextFieldActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed

        BillingParser.parseInfo(idTextField.getText());
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        Thread myThready = new Thread(new Runnable() {
            @Override
            public void run() {
                PingWindow p = new PingWindow();
                p.setVisible(true);
                PrintStream printStream = new PrintStream(new TextAreaOutputStream(p.getjTextArea1()));
                System.setOut(printStream);
                Telnet.pingClient(printStream, ipTextField.getText());
            }

        });
        myThready.start();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        String command = " ";
        telnetActive.sendCommand(command);
        try {
            Thread.sleep(250);
        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (jTabbedPane2.getTitleAt(jTabbedPane2.getSelectedIndex()).equals("Telnet #1")) {
            CLITextArea1.setText(filteroutput(CLITextArea1.getText()));
        } else if (jTabbedPane2.getTitleAt(jTabbedPane2.getSelectedIndex()).equals("Telnet #2")) {
            CLITextArea2.setText(filteroutput(CLITextArea2.getText()));
        }

    }//GEN-LAST:event_jButton23ActionPerformed

    private void CtrlCButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CtrlCButtonActionPerformed

        String command = ctrlC;
        telnetActive.sendCommand(command);


    }//GEN-LAST:event_CtrlCButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed

        String command = getjTextField10().getText();
        telnetActive.sendCommand(command);
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        command = new String(getjPasswordField2().getPassword());
        telnetActive.sendCommand(command);
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        command = ctrlC;
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_loginButtonActionPerformed

    private void CLITextArea1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CLITextArea1MouseClicked

        if (evt.getButton() == 3) {
            String result = "";
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable contents = clipboard.getContents(null);
            boolean hasTransferableText
                    = (contents != null)
                    && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
            if (hasTransferableText) {
                try {
                    result = (String) contents.getTransferData(DataFlavor.stringFlavor);
                } catch (UnsupportedFlavorException | IOException ex) {
                    System.out.println(ex);
                    ex.printStackTrace();
                }
            }
            if (result != null) {
                telnetActive.sendCommand(result);
                CLITextArea1.setText(CLITextArea1.getText() + result + "\n");
            }

        }


    }//GEN-LAST:event_CLITextArea1MouseClicked

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

        String command = ecs.changePortState(portTextField.getText(), jCheckBox1.isSelected());
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        String command = dls.changeSpeed(portTextField.getText(), jComboBox1.getSelectedItem().toString());
        telnetActive.sendCommand(command);
        CLITextArea1.setText(CLITextArea1.getText() + command + "\n");

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed

        Object[] options = {"Так",
            "Ні"};

        int n = JOptionPane.showOptionDialog(this,
                "Перезавантажити комутатор?",
                "Воу воу палехче!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, //do not use a custom Icon
                options, //the titles of buttons
                options[0]); //default button title
        if (n == 0) {
            String command = dls.reload();
            telnetActive.sendCommand(command);

        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String command = dls.testCable(portTextField.getText());
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed

        String command = dls.configAddressBindingZeroIP(portTextField.getText(), jCheckBox2.isSelected());
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed

        String command = dls.showMACAddressTable();
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        String command = dls.showErrorsOnPort(portTextField.getText());
        telnetActive.sendCommand(command);
        command = ctrlC;
        try {
            Thread.sleep(150);
        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        String command = dls.showPacketsOnPort(portTextField.getText());
        telnetActive.sendCommand(command);
        command = ctrlC;//Ctrl+C for interrupt
        try {
            Thread.sleep(150);
        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String command = dls.showMACAddressTable(portTextField.getText());
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        String command = dls.configurePortSecurityMaxLearningAddr2(portTextField.getText());
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        String command = dls.configurePortRxRateNoLimit(1, Integer.parseInt(jTextField8.getText()));
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        String command = dls.configurePortTxRateNoLimit(1, Integer.parseInt(jTextField8.getText()));
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String command = dls.addAddressBindingPort(ipTextField.getText(), macTextField.getText(), Integer.parseInt(portTextField.getText()));
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String command = dls.removeAddressBindingPort(ipTextField.getText(), macTextField.getText());
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        String command = dls.showAddressBindingBlocked();
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        String command = dls.showPorts();
        telnetActive.sendCommand(command);
        try {
            Thread.sleep(150);
        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        command = " ";//Space for rolling output
        telnetActive.sendCommand(command);
        try {
            Thread.sleep(150);
        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        telnetActive.sendCommand(command);
        try {
            Thread.sleep(150);
        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        telnetActive.sendCommand(command);
        command = ctrlC;
        try {
            Thread.sleep(150);
        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String command = dls.showAddressBindingTable();
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String command = dls.showBandwidthControl();
        telnetActive.sendCommand(command);
        try {
            Thread.sleep(150);
        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        command = " ";
        telnetActive.sendCommand(command);
        try {
            Thread.sleep(150);
        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        command = " ";
        telnetActive.sendCommand(command);
        try {
            Thread.sleep(150);
        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        command = ctrlC;//Ctrl+C
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        if (jCheckBox5.isSelected()) {
            try {
                au.serialize();
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (!jCheckBox5.isSelected()) {
            try {
                au.repair();

            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed

        String command = ecs.removeVlanFromPort(portTextField.getText(), jTextField14.getText());
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton38ActionPerformed

    private void jCheckBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox11ActionPerformed

        String command = ecs.configureDHCPSnoppingVlan(jTextField11.getText(), jCheckBox11.isSelected());
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jCheckBox11ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jCheckBox12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox12ActionPerformed

        String command = ecs.configurePortsIpSourceGuard(Integer.parseInt(jTextField12.getText()), Integer.parseInt(jTextField13.getText()), jCheckBox12.isSelected());
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jCheckBox12ActionPerformed

    private void jCheckBox13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox13ActionPerformed

        String command = ecs.configurePortsSecurity(Integer.parseInt(jTextField12.getText()), Integer.parseInt(jTextField13.getText()), jCheckBox13.isSelected());
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jCheckBox13ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        String command = ecs.showVlanId(jTextField11.getText());
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        String command = ecs.addVlanToSwitch(jTextField11.getText(), jTextField15.getText());
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton28ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jCheckBox14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox14ActionPerformed

    }//GEN-LAST:event_jCheckBox14ActionPerformed

    private void jCheckBox15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox15ActionPerformed

        String command = ecs.configureVlanArpInspection(Integer.parseInt(jTextField11.getText()), jCheckBox15.isSelected());
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jCheckBox15ActionPerformed

    private void jButton67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton67ActionPerformed

        String command = ecs.showStpPort(portTextField.getText());
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton67ActionPerformed

    private void jCheckBox16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox16ActionPerformed

        String command = ecs.enableStpBpdu(portTextField.getText(), jCheckBox16.isSelected());
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jCheckBox16ActionPerformed

    private void jCheckBox17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox17ActionPerformed

        String command = ecs.enableStpBpduAutoRecovery(portTextField.getText(), jCheckBox17.isSelected());
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jCheckBox17ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed

        String command = ecs.addVlanToPort(portTextField.getText(), jTextField11.getText(), jCheckBox14.isSelected());
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton69ActionPerformed
        String command = dls.showMACAddressTableMAC(macTextField.getText());
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton69ActionPerformed

    private void jButton70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton70ActionPerformed
        String command = dls.showMACAddressTableVlan(Integer.parseInt(vlanTextField.getText()));
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton70ActionPerformed

    private void jButton73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton73ActionPerformed

        String command = dls.addVlanToPort(Integer.parseInt(portTextField.getText()), Integer.parseInt(jTextField18.getText()), jCheckBox18.isSelected());
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton73ActionPerformed

    private void jButton71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton71ActionPerformed
        String command = dls.addVlanToSwitch(Integer.parseInt(jTextField18.getText()));
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton71ActionPerformed

    private void jButton72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton72ActionPerformed
        String command = dls.removeVlanFromSwitch(Integer.parseInt(jTextField18.getText()));
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton72ActionPerformed

    private void jButton68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton68ActionPerformed
        String command = dls.showDhcpRelay();
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton68ActionPerformed

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        changeHost();
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jButton74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton74ActionPerformed
        String command = dls.removeVlanFromPort(Integer.parseInt(portTextField.getText()), Integer.parseInt(jTextField18.getText()));
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton74ActionPerformed

    private void jButton62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton62ActionPerformed
        String command = bdt.showEponVlan(Integer.parseInt(jTextField16.getText()), Integer.parseInt(jTextField17.getText()));

        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton62ActionPerformed

    private void jButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton60ActionPerformed
        String command = bdt.showEponSnmp(Integer.parseInt(jTextField16.getText()), Integer.parseInt(jTextField17.getText()));

        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton60ActionPerformed

    private void jButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton59ActionPerformed

        String command = bdt.rebootOnu(Integer.parseInt(jTextField16.getText()), Integer.parseInt(jTextField17.getText()));
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton59ActionPerformed

    private void jButton57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton57ActionPerformed
        String command = bdt.showEponDba(Integer.parseInt(jTextField16.getText()), Integer.parseInt(jTextField17.getText()));
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton57ActionPerformed

    private void jButton56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton56ActionPerformed
        String command = bdt.showEponInfo(Integer.parseInt(jTextField16.getText()), Integer.parseInt(jTextField17.getText()));
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton56ActionPerformed

    private void jButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton55ActionPerformed

        String command = bdt.showDhcpRelaySnooping();
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton55ActionPerformed

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed
        String command = bdt.showMACAddressTable(Integer.parseInt(jTextField16.getText()), Integer.parseInt(jTextField17.getText()));
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton54ActionPerformed

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        String command = bdt.showVlan();
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton53ActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        String command = bdt.showOpticalTxRxDiagnosis(Integer.parseInt(jTextField16.getText()), Integer.parseInt(jTextField17.getText()));
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton52ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        String command = bdt.showPorts();
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton51ActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        String command = bdt.showOpticalTxRxDiagnosis();
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jButton46ActionPerformed

    private void idTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idTextFieldKeyPressed
        if (!"".equals(jLabel2.getText())) {//erase data from fields 
            jLabel2.setText("");
            ipTextField.setText("");
            macTextField.setText("");
            portTextField.setText("");
            vlanTextField.setText("");
        }
        if (idTextField.getText().contains(" ") || idTextField.getText().contains("\t")) {

            idTextField.setText(idTextField.getText().replace(" ", ""));
            idTextField.setText(idTextField.getText().replace("\t", ""));
        }
    }//GEN-LAST:event_idTextFieldKeyPressed

    private void switchIPTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_switchIPTextFieldKeyTyped

    }//GEN-LAST:event_switchIPTextFieldKeyTyped

    private void switchIPTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchIPTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_switchIPTextField2ActionPerformed

    private void switchIPTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_switchIPTextField2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_switchIPTextField2KeyTyped

    private void connectButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButton2ActionPerformed
        if (telnet2 != null) {
            try {
                telnet2.disconnect();
                telnet2 = null;

            } catch (IOException ex) {
                Logger.getLogger(GUI.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (telnet2 == null) {
            telnet2 = new Telnet(switchIPTextField2.getText(), Integer.parseInt(jTextField20.getText()), CLITextArea2);
        }
        telnetActive = telnet2;
        Thread myThready = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    telnet2.execute();

                } catch (IOException ex) {
                    CLITextArea2.setText(CLITextArea2.getText() + "Connection error!\n");

                } catch (Exception ex) {
                    Logger.getLogger(GUI.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        myThready.start();
    }//GEN-LAST:event_connectButton2ActionPerformed

    private void loginButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButton2ActionPerformed
        String command = getjTextField10().getText();
        telnetActive.sendCommand(command);
        try {
            Thread.sleep(50);

        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        command = new String(getjPasswordField2().getPassword());
        telnetActive.sendCommand(command);
        try {
            Thread.sleep(50);

        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        command = ctrlC;//Ctrl+C
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_loginButton2ActionPerformed

    private void CLITextArea2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CLITextArea2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CLITextArea2MouseClicked

    private void CLITextArea2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CLITextArea2KeyPressed
        String command;
        if (evt.getKeyChar() == '\n') {
            if (CLITextArea2.getText().indexOf('#') > (-1) && (CLITextArea2.getText().indexOf('>') < CLITextArea2.getText().indexOf('#'))) {
                command = CLITextArea2.getText().substring(CLITextArea2.getText().lastIndexOf("#") + 1, CLITextArea2.getText().length());
                telnetActive.sendCommand(command);
            } else if (CLITextArea2.getText().indexOf('>') > (-1) && (CLITextArea2.getText().indexOf('>') > CLITextArea2.getText().indexOf('#'))) {
                command = CLITextArea2.getText().substring(CLITextArea2.getText().lastIndexOf(">") + 1, CLITextArea2.getText().length());
                telnetActive.sendCommand(command);
            }
        } else if (Character.isLetterOrDigit(evt.getKeyChar())) {
            CLITextArea2.setCaretPosition(CLITextArea2.getText().length());
        }
    }//GEN-LAST:event_CLITextArea2KeyPressed

    private void jTabbedPane2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane2StateChanged
        if (jTabbedPane2.getTitleAt(jTabbedPane2.getSelectedIndex()).equals("Telnet #1")) {
            telnetActive = telnet;
        } else if (jTabbedPane2.getTitleAt(jTabbedPane2.getSelectedIndex()).equals("Telnet #2")) {
            telnetActive = telnet2;
        } else if (jTabbedPane2.getTitleAt(jTabbedPane2.getSelectedIndex()).equals("SSH")) {
            telnetActive = ssh;
        }

    }//GEN-LAST:event_jTabbedPane2StateChanged

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        String command = ecs.showArpVlan(jTextField11.getText());
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed

        String command = ecs.showMvr();
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        String command = getjTextField3().getText();
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        String command = ecs.changePolicy(portTextField.getText(), jComboBox5.getSelectedItem().toString());
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jButton65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton65ActionPerformed
        String command = ecs.showAccessList();
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton65ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        String command = ecs.showArpStat();
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        ecs.changeModel(jComboBox4.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void showSystemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showSystemButtonActionPerformed
        String command = ecs.showSystem();
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_showSystemButtonActionPerformed

    private void jButton64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton64ActionPerformed
        String command = ecs.showArpLog();
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton64ActionPerformed

    private void jButton63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton63ActionPerformed
        String command = ecs.showSourceGuardBindingDhcpSnooping();
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton63ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed

        String command = ecs.showArpConfig();
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        String command = ecs.showPolicy(portTextField.getText());
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        String command = ecs.showMACAddressTableVlan(vlanTextField.getText());
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        String command = ecs.showDHCPSnoping();
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        String command = ecs.showMACAddressTableMAC(macTextField.getText());
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        String command = ecs.showInterfaceStatus(portTextField.getText());
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed

        String command = ecs.showSourceGuardBindingStatic();
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        String command = ecs.clearPortCounters(portTextField.getText());
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed

        String command = ecs.showPortCounters(portTextField.getText());
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        String command = ecs.showCurrentPortConfig(portTextField.getText());
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jCheckBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox10ActionPerformed

        String command = ecs.configureMacAddressTable(portTextField.getText(), Integer.parseInt(portTextField.getText()), Integer.parseInt(vlanTextField.getText()), repeatClean);
        telnetActive.sendCommand(command);

    }//GEN-LAST:event_jCheckBox10ActionPerformed

    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed

        String command = ecs.changeArpInspection(portTextField.getText(), jCheckBox9.isSelected());
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed

        String command = ecs.changeIPSourceGuardSipMac(portTextField.getText(), jCheckBox8.isSelected());
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed

        String command = ecs.configureIpSourceGuardBindingTable(macTextField.getText(), Integer.parseInt(vlanTextField.getText()), ipTextField.getText(), Integer.parseInt(portTextField.getText()), jCheckBox7.isSelected());
        telnetActive.sendCommand(command);


    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed

        String command = ecs.changePortSecurity(portTextField.getText(), jCheckBox6.isSelected());
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        Thread myThread;

        myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                cableTest();
            }
        });
        myThread.start();
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed

        String command = ecs.changeMediaType(portTextField.getText(), jComboBox3.getSelectedItem().toString());
        telnetActive.sendCommand(command);


    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed

        String command = ecs.changeNegotiation(portTextField.getText(), jCheckBox4.isSelected());
        telnetActive.sendCommand(command);
        try {
            Thread.sleep(100);

        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed

        String command = ecs.changePortState(portTextField.getText(), jCheckBox3.isSelected());
        telnetActive.sendCommand(command);

        try {
            Thread.sleep(100);

        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        String command = ecs.showMACAddressTable(portTextField.getText());
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        String command = ecs.showPorts();
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

        String command = ecs.changePortSpeed(jComboBox2.getSelectedItem().toString(), portTextField.getText());
        telnetActive.sendCommand(command);


    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Thread myThready = new Thread(new Runnable() {
            @Override
            public void run() {
                PingWindow p = new PingWindow();
                p.setVisible(true);
                PrintStream printStream = new PrintStream(new TextAreaOutputStream(p.getjTextArea1()));
                System.setOut(printStream);
                Telnet.pingClient(printStream, switchIPTextField.getText());
            }

        });
        myThready.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        Thread myThready = new Thread(new Runnable() {
            @Override
            public void run() {
                PingWindow p = new PingWindow();
                p.setVisible(true);
                PrintStream printStream = new PrintStream(new TextAreaOutputStream(p.getjTextArea1()));
                System.setOut(printStream);
                Telnet.pingClient(printStream, switchIPTextField2.getText());

            }

        });
        myThready.start();
    }//GEN-LAST:event_jButton25ActionPerformed

    private void vlanTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vlanTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vlanTextFieldActionPerformed

    private void CLITextArea1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_CLITextArea1PropertyChange

    }//GEN-LAST:event_CLITextArea1PropertyChange

    private void jCheckBox19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox19ActionPerformed

        String command = ecs.capabilities1000Full(portTextField.getText(), jCheckBox19.isSelected());
        telnetActive.sendCommand(command);


    }//GEN-LAST:event_jCheckBox19ActionPerformed

    private void jButton78ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton78ActionPerformed
        String command = bdt.showMACAddressTableMAC(jTextField2.getText());
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton78ActionPerformed

    private void commandTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_commandTabbedPane1StateChanged
        if (commandTabbedPane1.getTitleAt(commandTabbedPane1.getSelectedIndex()).equals("BDCOM")) {

            String str = macTextField.getText();
            jTextField2.setText(Formater.convert(str));
        }
    }//GEN-LAST:event_commandTabbedPane1StateChanged

    private void jButton58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton58ActionPerformed
        String command = ecs.showTCAM();
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton58ActionPerformed

    private void jButton79ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton79ActionPerformed
        String command = ecs.showVlan();
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton79ActionPerformed

    private void jButton80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton80ActionPerformed
        String command = ecs.showCPU();
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton80ActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void jButton75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton75ActionPerformed

        String command = dls.showTrafficSegmentation();
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton75ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        String command = ecs.showCableTestResult();
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        String command = ecs.testCable(jTextField12.getText(), jTextField13.getText());
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        String command = ecs.testConfig(portTextField.getText());
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        String command = ecs.saveConfig();
        telnetActive.sendCommand(command);
        try {
            Thread.sleep(20);//delay for sending command

        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        command = ctrlC;//Ctrl+C
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed

        String command = ecs.exampleConfig(portTextField.getText());
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton26ActionPerformed

    private void CLITextArea3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CLITextArea3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CLITextArea3MouseClicked

    private void CLITextArea3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CLITextArea3KeyPressed
        //get command from typed text in to TextArea
        String command;
        if (evt.getKeyChar() == '\n') {

            CLITextArea3.setCaretPosition(CLITextArea3.getText().length());
            if (CLITextArea3.getText().indexOf('#') > (-1) && (CLITextArea3.getText().indexOf('>') < CLITextArea3.getText().indexOf('#'))) {
                command = CLITextArea3.getText().substring(CLITextArea3.getText().lastIndexOf("#") + 1, CLITextArea3.getText().length());
                telnetActive.sendCommand(command);
            } else if (CLITextArea3.getText().indexOf('>') > (-1) && (CLITextArea3.getText().indexOf('>') > CLITextArea3.getText().indexOf('#'))) {
                command = CLITextArea3.getText().substring(CLITextArea3.getText().lastIndexOf(">") + 1, CLITextArea3.getText().length());
                telnetActive.sendCommand(command);
            } else if (CLITextArea3.getText().indexOf('$') > (-1) && (CLITextArea3.getText().indexOf('$') > CLITextArea3.getText().indexOf('#'))) {
                command = CLITextArea3.getText().substring(CLITextArea3.getText().lastIndexOf("$") + 1, CLITextArea3.getText().length());
                telnetActive.sendCommand(command);
            }
        } else if (Character.isLetterOrDigit(evt.getKeyChar())) {
            CLITextArea3.setCaretPosition(CLITextArea3.getText().length());
        }
    }//GEN-LAST:event_CLITextArea3KeyPressed

    private void switchIPTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchIPTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_switchIPTextField3ActionPerformed

    private void switchIPTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_switchIPTextField3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_switchIPTextField3KeyTyped

    private void connectButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButton3ActionPerformed
        final PrintStream outputSsh = new PrintStream(new TextAreaOutputStream(CLITextArea3));

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String host = JOptionPane.showInputDialog("Enter username@hostname",
                        getjTextField10().getText()
                        + "@" + switchIPTextField3.getText());
                String user = host.substring(0, host.indexOf('@'));
                host = host.substring(host.indexOf('@') + 1);
                ssh.start(host, Integer.parseInt(tcpPortTextField3.getText()), outputSsh, user, new String(getjPasswordField2().getPassword()));
                telnetActive = ssh;

            }
        });
        thread.start();
    }//GEN-LAST:event_connectButton3ActionPerformed

    private void loginButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButton3ActionPerformed

        telnetActive.sendCommand("telnet " + jTextField1.getText());
        try {
            Thread.sleep(50);

        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        String command = getjTextField10().getText();
        telnetActive.sendCommand(command);
        try {
            Thread.sleep(50);

        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        command = new String(getjPasswordField2().getPassword());
        telnetActive.sendCommand(command);
        try {
            Thread.sleep(50);

        } catch (InterruptedException ex) {
            Logger.getLogger(GUI.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        command = ctrlC;//Ctrl+C
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_loginButton3ActionPerformed

    private void jButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton61ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton61ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        String command = "exit";
        telnetActive.sendCommand(command);
    }//GEN-LAST:event_jButton14ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CLITerminal1;
    private javax.swing.JTextArea CLITextArea1;
    private javax.swing.JTextArea CLITextArea2;
    private javax.swing.JTextArea CLITextArea3;
    private javax.swing.JButton CtrlCButton;
    private javax.swing.JPanel PortStatePanel;
    private javax.swing.JTabbedPane commandTabbedPane1;
    private javax.swing.JButton connectButton;
    private javax.swing.JButton connectButton2;
    private javax.swing.JButton connectButton3;
    private javax.swing.JTextField idTextField;
    private javax.swing.JTextField ipTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JButton jButton67;
    private javax.swing.JButton jButton68;
    private javax.swing.JButton jButton69;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton70;
    private javax.swing.JButton jButton71;
    private javax.swing.JButton jButton72;
    private javax.swing.JButton jButton73;
    private javax.swing.JButton jButton74;
    private javax.swing.JButton jButton75;
    private javax.swing.JButton jButton78;
    private javax.swing.JButton jButton79;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton80;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JButton loginButton;
    private javax.swing.JButton loginButton2;
    private javax.swing.JButton loginButton3;
    private javax.swing.JTextField macTextField;
    private javax.swing.JTextField portTextField;
    private javax.swing.JButton showSystemButton;
    private javax.swing.JTextField switchIPTextField;
    private javax.swing.JTextField switchIPTextField2;
    private javax.swing.JTextField switchIPTextField3;
    private javax.swing.JTextField tcpPortTextField3;
    private javax.swing.JTextField vlanTextField;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the jPasswordField1
     */
    public javax.swing.JPasswordField getjPasswordField1() {
        return jPasswordField1;
    }

    /**
     * @param jPasswordField1 the jPasswordField1 to set
     */
    public void setjPasswordField1(javax.swing.JPasswordField jPasswordField1) {
        this.jPasswordField1 = jPasswordField1;
    }

    /**
     * @return the jPasswordField2
     */
    public javax.swing.JPasswordField getjPasswordField2() {
        return jPasswordField2;
    }

    /**
     * @param jPasswordField2 the jPasswordField2 to set
     */
    public void setjPasswordField2(javax.swing.JPasswordField jPasswordField2) {
        this.jPasswordField2 = jPasswordField2;
    }

    /**
     * @return the jTextField9
     */
    public javax.swing.JTextField getjTextField9() {
        return jTextField9;
    }

    /**
     * @param jTextField9 the jTextField9 to set
     */
    public void setjTextField9(javax.swing.JTextField jTextField9) {
        this.jTextField9 = jTextField9;
    }

    /**
     * @return the jTextField10
     */
    public javax.swing.JTextField getjTextField10() {
        return jTextField10;
    }

    /**
     * @param jTextField10 the jTextField10 to set
     */
    public void setjTextField10(javax.swing.JTextField jTextField10) {
        this.jTextField10 = jTextField10;
    }

    /**
     * @return the jLabel1
     */
    public javax.swing.JLabel getjLabel1() {
        return jLabel1;
    }

    /**
     * @return the jLabel2
     */
    public javax.swing.JLabel getjLabel2() {
        return jLabel2;
    }

    /**
     * @return the jLabel3
     */
    public javax.swing.JLabel getjLabel3() {
        return jLabel3;
    }

    /**
     * @return the jLabel4
     */
    public javax.swing.JLabel getjLabel4() {
        return jLabel4;
    }

    /**
     * @return the jLabel5
     */
    public javax.swing.JLabel getjLabel5() {
        return jLabel5;
    }

    /**
     * @return the jLabel6
     */
    public javax.swing.JLabel getjLabel6() {
        return jLabel6;
    }

    /**
     * @return the jLabel7
     */
    public javax.swing.JLabel getjLabel7() {
        return jLabel7;
    }

    /**
     * @return the jTextField7
     */
    public javax.swing.JTextField getjTextField7() {
        return vlanTextField;
    }

    /**
     * @return the jTextField8
     */
    public javax.swing.JTextField getjTextField8() {
        return jTextField8;
    }

    /**
     * @return the jButton1
     */
    public javax.swing.JButton getjButton1() {
        return connectButton;
    }

    /**
     * @return the jTextArea1
     */
    public javax.swing.JTextArea getjTextArea1() {
        return CLITextArea1;
    }

    public javax.swing.JTextArea getCLITextArea3() {
        return CLITextArea3;
    }

    /**
     * @return the jTextField1
     */
    public javax.swing.JTextField getjTextField1() {
        return idTextField;
    }

    /**
     * @return the jTextField2
     */
    public javax.swing.JTextField getjTextField2() {
        return ipTextField;
    }

    /**
     * @return the jTextField3
     */
    public javax.swing.JTextField getjTextField3() {
        return portTextField;
    }

    /**
     * @return the jTextField4
     */
    public javax.swing.JTextField getjTextField4() {
        return macTextField;
    }

    /**
     * @return the jTextField5
     */
    public javax.swing.JTextField getjTextField5() {
        return switchIPTextField;
    }

    /**
     * @return the jTextField6
     */
    public javax.swing.JTextField getjTextField6() {
        return jTextField6;
    }

    /**
     * @return the jTextField14
     */
    public javax.swing.JTextField getjTextField14() {
        return jTextField14;
    }

    /**
     * @return the jTextField11
     */
    public javax.swing.JTextField getjTextField11() {
        return jTextField11;
    }

    /**
     * @return the jTextField12
     */
    public javax.swing.JTextField getjTextField12() {
        return jTextField12;
    }

    /**
     * @return the jTextField13
     */
    public javax.swing.JTextField getjTextField13() {
        return jTextField13;
    }

    public String filteroutput(String s) {

        //erase textoutput from undefined symbols
        String checkString = "--- [Space] Next page, [Enter] Next line, [A] All, Others to exit ---";
        if (s.contains(checkString)) {

            for (int i = s.indexOf(checkString) + checkString.length() + 1; i < s.length(); i++) {

                if ('-' == s.charAt(i) || Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
                    return s.replace(s.substring(s.indexOf(checkString), i), "");

                }
            }

        }
        return s;
    }

    public void cableTest() {
        String command;
        javax.swing.JTextArea out = null;
        command = ecs.testCable(portTextField.getText());
        telnetActive.sendCommand(command);

        /*time for testing cable is 5*1 seconds, main purpose of this code is to print result of
         cable test into the same terminal from which command had been invoked     
         */
        if (jTabbedPane2.getTitleAt(jTabbedPane2.getSelectedIndex()).equals("Telnet #1")) {
            out = CLITextArea1;
        } else if (jTabbedPane2.getTitleAt(jTabbedPane2.getSelectedIndex()).equals("Telnet #2")) {
            out = CLITextArea2;
        } else if (jTabbedPane2.getTitleAt(jTabbedPane2.getSelectedIndex()).equals("SSH")) {
            out = CLITextArea3;
        }
        out.setText(out.getText() + command + "\n");
        for (int i = 4; i >= 0; i--) {
            out.setText(out.getText() + "wait " + (i + 1) + " seconds" + "\n");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(GUI.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            if (out.getText().contains("wait")) {
                out.setText(out.getText().substring(0, out.getText().lastIndexOf("wait")));
            }
        }
        command = ecs.showCableTestResult(portTextField.getText());
        telnetActive.sendCommand(command);

    }

    public void initialiseHosts(List<Host> parsedHosts) {
        hosts = new ArrayList();
        List<String> box = new ArrayList();
        for (int i = 0; i < parsedHosts.size(); i++) {
            hosts.add(parsedHosts.get(i));
            box.add(String.valueOf(i + 1));
        }
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(box.toArray()));
        changeHost();
    }

    public void changeHost() {
        Host host;
        int i = Integer.parseInt(String.valueOf(jComboBox6.getSelectedItem()));
        System.out.println(Integer.parseInt(String.valueOf(jComboBox6.getSelectedItem())) + " " + i);
        host = hosts.get(i - 1);
        System.out.println(host);
        hostID = host.getId();
        macTextField.setText(host.getMac());
        ipTextField.setText(host.getIp());
        portTextField.setText(host.getPort());
        vlanTextField.setText(host.getVlan());
    }

    String parseCommand(javax.swing.JTextArea textArea){
        
        return "";
    }
    
    
    //serverIPTextField.setBackground(new Color(99, 177, 68));
    
}
