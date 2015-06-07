package com.github.dmtk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.log4j.Logger;

public class Authentication implements Serializable {

    private String loginTerminal;
    private String passwdTerminal;
    private String loginBilling;
    private String passwdBilling;
    private final static Logger log = Logger.getLogger(Authentication.class);
    private byte[] key=new byte[]{35, 56, 20, 40, 25, 97, 47, 28};//key for DES encryption
    
    Authentication(GUI gui) throws IOException, ClassNotFoundException {

        FileInputStream fis;
        try {
            fis = new FileInputStream("temp.out");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Authentication ted = (Authentication) ois.readObject();
            StringCrypter crypter = new StringCrypter(key);
            this.loginBilling = crypter.decrypt(ted.loginBilling);
            this.loginTerminal = crypter.decrypt(ted.loginTerminal);
            this.passwdBilling = crypter.decrypt(ted.passwdBilling);
            this.passwdTerminal = crypter.decrypt(ted.passwdTerminal);
            gui.getjTextField9().setText(this.loginBilling);
            gui.getjTextField10().setText(this.loginTerminal);
            gui.getjPasswordField1().setText(this.passwdBilling);
            gui.getjPasswordField2().setText(this.passwdTerminal);
            new File("temp.out").delete();
        } catch (FileNotFoundException ex) {
           
            this.loginBilling = gui.getjTextField9().getText();
            this.loginTerminal = gui.getjTextField10().getText();
            this.passwdBilling = new String(gui.getjPasswordField1().getPassword());
            this.passwdTerminal = new String(gui.getjPasswordField2().getPassword());
            log.error(ex);
        }

    }

    public void serialize() throws FileNotFoundException, IOException {
        
        String tempLoginBilling=this.loginBilling;
        String tempLoginTelnet=this.loginTerminal;
        String tempPasswdBilling=this.passwdBilling;
        String tempPasswdTelnet=this.passwdTerminal;
        StringCrypter crypter = new StringCrypter(key);
        this.loginBilling = crypter.encrypt(GUI.getInstance().getjTextField9().getText());
        this.loginTerminal = crypter.encrypt(GUI.getInstance().getjTextField10().getText());
        this.passwdBilling = crypter.encrypt(new String(GUI.getInstance().getjPasswordField1().getPassword()));
        this.passwdTerminal = crypter.encrypt(new String(GUI.getInstance().getjPasswordField2().getPassword()));
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
        this.loginBilling=tempLoginBilling;
        this.loginTerminal=tempLoginTelnet;
        this.passwdBilling=tempPasswdBilling;
        this.passwdTerminal=tempPasswdTelnet;
    }

    public void repair() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Authentication ted = (Authentication) ois.readObject();
        StringCrypter crypter = new StringCrypter(key);
        this.loginBilling = crypter.decrypt(ted.loginBilling);
        this.loginTerminal = crypter.decrypt(ted.loginTerminal);
        this.passwdBilling = crypter.decrypt(ted.passwdBilling);
        this.passwdTerminal = crypter.decrypt(ted.passwdTerminal);
        ois.close();        
        new File("temp.out").delete();
    }

    public String getLoginTerminal() {
        return loginTerminal;
    }

    public void setLoginTerminal(String loginTerminal) {
        this.loginTerminal = loginTerminal;
    }

    public String getPasswdTerminal() {
        return passwdTerminal;
    }

    public void setPasswdTerminal(String passwdTerminal) {
        this.passwdTerminal = passwdTerminal;
    }

    public String getLoginBilling() {
        return loginBilling;
    }

    public void setLoginBilling(String loginBilling) {
        this.loginBilling = loginBilling;
    }

    public String getPasswdBilling() {
        return passwdBilling;
    }

    public void setPasswdBilling(String passwdBilling) {
        this.passwdBilling = passwdBilling;
    }

}
