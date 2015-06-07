package com.github.dmtk;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTextArea;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class BillingParser {

    private final static Logger log = Logger.getLogger(BillingParser.class);
    static String userID;
    static String userTitle;
    static String abon_num;
    static JTextArea out;
    static WebElement element;
    static String billingURL = XMLConfigReader.read("billingURL");
    static String loginPage = XMLConfigReader.read("loginPage");
    static String dataClientPage = XMLConfigReader.read("dataClientPage");
    static String switchInformationPage = XMLConfigReader.read("switchInformationPage");
    static String computerInformationPage = XMLConfigReader.read("computerInformationPage");
    static String requestSymbol = XMLConfigReader.read("requestSymbol");
    static String cssSelectorAcceptButtonName = XMLConfigReader.read("cssSelectorAcceptButtonName");
    static String loginGETRequestVariable = XMLConfigReader.read("loginGETRequestVariable");
    static String htmlTableClassName = XMLConfigReader.read("htmlTableClassName");
    static String hostIdGETRequestVariable = XMLConfigReader.read("hostIdGETRequestVariable");
    static String modeGETRequestVariable = XMLConfigReader.read("modeGETRequestVariable");
    static String htmlNavigator = XMLConfigReader.read("htmlNavigator");
    static String idGETRequestVariable = XMLConfigReader.read("idGETRequestVariable");
    static String htmlElementAttribute = XMLConfigReader.read("htmlElementAttribute");
    static String htmlInputPortClassName = XMLConfigReader.read("htmlInputPortClassName");
    static String htmlInputVlanClassName = XMLConfigReader.read("htmlInputVlanClassName");
    static String htmlInputIpClassName = XMLConfigReader.read("htmlInputVlanClassName");
    static String htmlInputMacClassName= XMLConfigReader.read("htmlInputMacClassName");
    static String htmlInputLastNameName= XMLConfigReader.read("htmlInputLastNameName");
    static String htmlInputFirstNameName= XMLConfigReader.read("htmlInputFirstNameName");
    static String htmlInputPatronymicName= XMLConfigReader.read("htmlInputPatronymicName");
    static String htmlSelectViewClassName= XMLConfigReader.read("htmlSelectViewClassName");
    static String htmlInputPlaceClassName= XMLConfigReader.read("htmlInputPlaceClassName");
    static String htmlInputContractName= XMLConfigReader.read("htmlInputContractName");
    static String htmlInputLoginName= XMLConfigReader.read("htmlInputLoginName");
    static String hostFilterGETRequest= XMLConfigReader.read("hostFilterGETRequest");
    static String hostFilterGETRequestOption = XMLConfigReader.read("hostFilterGETRequestOption");
    static String idFilterGETRequestOption = XMLConfigReader.read("idFilterGETRequestOption");
    static String idFilterGETRequestOption2 = XMLConfigReader.read("idFilterGETRequestOption2");
    static String hostFilterGETRequestAnchor = XMLConfigReader.read("hostFilterGETRequestAnchor");
    static String idFilterGETRequestAnchor = XMLConfigReader.read("idFilterGETRequestAnchor");
    static String idFilterGETRequestAnchor2 = XMLConfigReader.read("idFilterGETRequestAnchor2");
    static String idFilterGETRequest = XMLConfigReader.read("idFilterGETRequest");
    static String hostFilterGETRequestOption2 = XMLConfigReader.read("hostFilterGETRequestOption2");
    static String htmlInputAutentificationLoginName = XMLConfigReader.read("htmlInputAutentificationLoginName");
    static String htmlInputPasswordName = XMLConfigReader.read("htmlInputPasswordName");
    static String idTag=XMLConfigReader.read("idTag");
    
    static String eq ="&";
    
    private static HtmlUnitDriver authorize() {

        System.out.print(billingURL);
        GUI.getInstance().getjLabel2().setText(GUI.getInstance().getjLabel2().getText() + "Autorization");

        HtmlUnitDriver driver = new HtmlUnitDriver();
        driver.setJavascriptEnabled(true);
        driver.get(billingURL);
        for (int i = 0; i < 6; i++) {
            try {
                Thread.sleep(800);
                GUI.getInstance().getjLabel2().setText(GUI.getInstance().getjLabel2().getText() + ".");
            } catch (InterruptedException ex) {
               log.error(ex);
            }
        }
        try {
            driver.findElement(By.name(htmlInputAutentificationLoginName)).clear();
            driver.findElement(By.name(htmlInputAutentificationLoginName)).sendKeys(GUI.getInstance().getjTextField9().getText());
            driver.findElement(By.name(htmlInputPasswordName)).clear();
            driver.findElement(By.name(htmlInputPasswordName)).sendKeys(new String(GUI.getInstance().getjPasswordField1().getPassword()));
            element = driver.findElement(By.cssSelector(cssSelectorAcceptButtonName));
            element.click();
        } catch (Exception ex) {
           log.error(ex);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
           log.error(ex);
        }
        GUI.getInstance().getjLabel2().setText(GUI.getInstance().getjLabel2().getText() + "Done ");
        return driver;
    }

    public static void parseInfo(final String num) {

        userID = "";
        userTitle = "";
        abon_num = "";
        Thread myThready;

        myThready = new Thread(new Runnable() {
            @Override
            public void run() {
                GUI.getInstance().getjLabel2().setText("Getting data.");
                abon_num = num;
                String modemIP = null;
                HtmlUnitDriver driver = authorize();
                driver.get(billingURL + dataClientPage + requestSymbol + loginGETRequestVariable+"%3D"  + abon_num);
                System.out.println(driver.getCurrentUrl());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                   log.error(ex);
                }
                try {
                    element = driver.findElement(By.className(htmlTableClassName));
                } catch (org.openqa.selenium.NoSuchElementException ex) {
                    GUI.getInstance().getjLabel2().setText("wrong login or password");
                }

                try {
                    String sub = element.getAttribute(htmlNavigator);
                    userID = sub.substring(sub.indexOf(idGETRequestVariable) + 7, sub.indexOf(idFilterGETRequestAnchor));
                    String sub2 = element.getAttribute("title");
                    userTitle = sub2.substring(sub2.indexOf("(") + 1, sub2.indexOf(")"));
                    driver.get(billingURL + dataClientPage + requestSymbol + idGETRequestVariable + userID + eq+idFilterGETRequest+eq+idFilterGETRequestOption+idFilterGETRequestAnchor2);
                    System.out.println(driver.getCurrentUrl());
                } catch (org.openqa.selenium.StaleElementReferenceException ex) {
                    GUI.getInstance().getjLabel2().setText("wrong id");
                }
                try {
                    driver.get(billingURL + computerInformationPage + requestSymbol + hostFilterGETRequest+eq+hostFilterGETRequestOption+"%3D" + userTitle + hostFilterGETRequestAnchor);

                    //parse switch info
                    List<WebElement> links = driver.findElements(By.tagName("a"));
                    Iterator<WebElement> itrt = links.iterator();
                    while (itrt.hasNext()) {
                        element = itrt.next();
                        String str = element.getAttribute("href");
                        if (str != null) {
                            if (str.contains(billingURL + switchInformationPage + requestSymbol + idTag) && (element.getText().contains("10."))) {
                                modemIP = element.getText();
                                GUI.getInstance().getjTextField5().setText(modemIP);
                                GUI.getInstance().getjTextField5().setBackground(Color.GREEN);

                            }
                        }
                    }

                    //parse hosts info
                    List<WebElement> comp = driver.findElements(By.className(htmlTableClassName));
                    Iterator<WebElement> itr = comp.iterator();
                    List<Host> hosts = new ArrayList<Host>();
                    List<String> hostIDs = new ArrayList<String>();
                    System.out.println(driver.getCurrentUrl());
                    while (itr.hasNext()) {

                        element = itr.next();
                        System.out.println(element.getText());
                        String sub = element.getAttribute(htmlNavigator);
                        String hostID = sub.substring(sub.indexOf(hostIdGETRequestVariable) + 7, sub.indexOf(hostFilterGETRequestAnchor));
                        hostIDs.add(hostID);
                        System.out.println(hostID);

                    }
                    for (int i = 0; i < hostIDs.size(); i++) {

                        driver.get(billingURL + computerInformationPage + requestSymbol + hostFilterGETRequest + userTitle + eq+hostIdGETRequestVariable + hostIDs.get(i) + eq+hostFilterGETRequestOption2+hostFilterGETRequestAnchor);
                        System.out.println(driver.getCurrentUrl());
                        Host host = new Host();
                        host.setId(hostIDs.get(i));
                        element = driver.findElement(By.name(htmlInputMacClassName));
                        host.setMac(element.getAttribute(htmlElementAttribute).replace(':', '-'));
                        element = driver.findElement(By.name(htmlInputIpClassName));
                        host.setIp(element.getAttribute(htmlElementAttribute));
                        element = driver.findElement(By.name(htmlInputPortClassName));
                        host.setPort(element.getAttribute(htmlElementAttribute));
                        element = driver.findElement(By.name(htmlInputVlanClassName));
                        host.setVlan(element.getAttribute(htmlElementAttribute));
                        hosts.add(host);

                    }
                    GUI.getInstance().initialiseHosts(hosts);

                    //parse user name info
                    driver.get(billingURL + dataClientPage + requestSymbol + idGETRequestVariable + userID + eq+idFilterGETRequestOption2+idFilterGETRequestAnchor);
                    element = driver.findElement(By.name(htmlInputLastNameName));
                    GUI.getInstance().getjLabel2().setText(element.getAttribute(htmlElementAttribute));
                    element = driver.findElement(By.name(htmlInputFirstNameName));
                    GUI.getInstance().getjLabel2().setText(GUI.getInstance().getjLabel2().getText() + " " + element.getAttribute(htmlElementAttribute));
                    element = driver.findElement(By.name(htmlInputPatronymicName));
                    GUI.getInstance().getjLabel2().setText(GUI.getInstance().getjLabel2().getText() + " " + element.getAttribute(htmlElementAttribute));
                    element = driver.findElement(By.className(htmlSelectViewClassName));
                    GUI.getInstance().getjLabel2().setText(GUI.getInstance().getjLabel2().getText() + " " + element.getText());
                    element = driver.findElement(By.name(htmlInputPlaceClassName));
                    GUI.getInstance().getjLabel2().setText(GUI.getInstance().getjLabel2().getText() + " " + element.getAttribute(htmlElementAttribute));
                    element = driver.findElement(By.name(htmlInputContractName));
                    GUI.getInstance().getjLabel2().setText(GUI.getInstance().getjLabel2().getText() + " " + element.getAttribute(htmlElementAttribute));
                    element = driver.findElement(By.name(htmlInputLoginName));
                    GUI.getInstance().getjLabel2().setText(GUI.getInstance().getjLabel2().getText() + " " + element.getAttribute(htmlElementAttribute));
                    driver.quit();

                } catch (org.openqa.selenium.NoSuchElementException ex) {
                    GUI.getInstance().getjLabel2().setText("parsing error");
                }

            }
        });
        myThready.start();

    }

}
