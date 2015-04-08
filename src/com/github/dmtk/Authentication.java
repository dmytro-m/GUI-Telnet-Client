package com.github.dmtk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Authentication implements Serializable {

    private String loginTelnet;
    private String passwdTelnet;
    private String loginBilling;
    private String passwdBilling;
    private byte[] key=new byte[]{35, 56, 20, 40, 25, 97, 47, 28};//key for DES encryption
    Authentication(GUI gui) throws IOException, ClassNotFoundException {

        FileInputStream fis;
        try {
            fis = new FileInputStream("temp.out");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Authentication ted = (Authentication) ois.readObject();
            StringCrypter crypter = new StringCrypter(key);
            this.loginBilling = crypter.decrypt(ted.loginBilling);
            this.loginTelnet = crypter.decrypt(ted.loginTelnet);
            this.passwdBilling = crypter.decrypt(ted.passwdBilling);
            this.passwdTelnet = crypter.decrypt(ted.passwdTelnet);
            gui.getjTextField9().setText(this.loginBilling);
            gui.getjTextField10().setText(this.loginTelnet);
            gui.getjPasswordField1().setText(this.passwdBilling);
            gui.getjPasswordField2().setText(this.passwdTelnet);
            new File("temp.out").delete();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
            this.loginBilling = gui.getjTextField9().getText();
            this.loginTelnet = gui.getjTextField10().getText();
            this.passwdBilling = new String(gui.getjPasswordField1().getPassword());
            this.passwdTelnet = new String(gui.getjPasswordField2().getPassword());
        }

    }

    public void serialize() throws FileNotFoundException, IOException {
        
        String tempLoginBilling=this.loginBilling;
        String tempLoginTelnet=this.loginTelnet;
        String tempPasswdBilling=this.passwdBilling;
        String tempPasswdTelnet=this.passwdTelnet;
        StringCrypter crypter = new StringCrypter(key);
        this.loginBilling = crypter.encrypt(MainClass.gui.getjTextField9().getText());
        this.loginTelnet = crypter.encrypt(MainClass.gui.getjTextField10().getText());
        this.passwdBilling = crypter.encrypt(new String(MainClass.gui.getjPasswordField1().getPassword()));
        this.passwdTelnet = crypter.encrypt(new String(MainClass.gui.getjPasswordField2().getPassword()));
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
        this.loginBilling=tempLoginBilling;
        this.loginTelnet=tempLoginTelnet;
        this.passwdBilling=tempPasswdBilling;
        this.passwdTelnet=tempPasswdTelnet;
    }

    public void repair() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Authentication ted = (Authentication) ois.readObject();
        StringCrypter crypter = new StringCrypter(key);
        this.loginBilling = crypter.decrypt(ted.loginBilling);
        this.loginTelnet = crypter.decrypt(ted.loginTelnet);
        this.passwdBilling = crypter.decrypt(ted.passwdBilling);
        this.passwdTelnet = crypter.decrypt(ted.passwdTelnet);
        ois.close();        
        new File("temp.out").delete();
    }

    /**
     * @return the loginTelnet
     */
    public String getLoginTelnet() {
        return loginTelnet;
    }

    /**
     * @param loginTelnet the loginTelnet to set
     */
    public void setLoginTelnet(String loginTelnet) {
        this.loginTelnet = loginTelnet;
    }

    /**
     * @return the passwdTelnet
     */
    public String getPasswdTelnet() {
        return passwdTelnet;
    }

    /**
     * @param passwdTelnet the passwdTelnet to set
     */
    public void setPasswdTelnet(String passwdTelnet) {
        this.passwdTelnet = passwdTelnet;
    }

    /**
     * @return the loginBilling
     */
    public String getLoginBilling() {
        return loginBilling;
    }

    /**
     * @param loginBilling the loginBilling to set
     */
    public void setLoginBilling(String loginBilling) {
        this.loginBilling = loginBilling;
    }

    /**
     * @return the passwdBilling
     */
    public String getPasswdBilling() {
        return passwdBilling;
    }

    /**
     * @param passwdBilling the passwdBilling to set
     */
    public void setPasswdBilling(String passwdBilling) {
        this.passwdBilling = passwdBilling;
    }

}
