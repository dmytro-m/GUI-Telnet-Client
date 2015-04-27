package com.github.dmtk;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class DBConnect {

    private Statement st;
    private ResultSet rs;

    DBConnect() {
        String primarydbserverIP = XMLConfigReader.read("primarydbserverIP");
        
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Properties connInfo = new Properties();
            connInfo.put("user", XMLConfigReader.read("dbUserName"));
            connInfo.put("password", XMLConfigReader.read("dbPassword"));
            connInfo.put("useUnicode", "true");
            connInfo.put("charSet", "utf-8");
            connInfo.put("characterEncoding", "utf-8");
            Connection conn = DriverManager.getConnection("jdbc:mysql://" + primarydbserverIP + ":" + XMLConfigReader.read("primarydbserverPort") + "/" + XMLConfigReader.read("dbName"), connInfo);
            st = conn.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Err" + ex);
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Properties connInfo = new Properties();
                connInfo.put("user", XMLConfigReader.read("dbUserName"));
                connInfo.put("password", XMLConfigReader.read("dbPassword"));
                connInfo.put("useUnicode", "true");
                connInfo.put("charSet", "utf-8");
                connInfo.put("characterEncoding", "utf-8");
                Connection conn = DriverManager.getConnection("jdbc:mysql://" + XMLConfigReader.read("secondarydbserverIP") + ":" + XMLConfigReader.read("secondarydbserverPort") + "/" + XMLConfigReader.read("dbName"), connInfo);
                st = conn.createStatement();
            } catch (ClassNotFoundException | SQLException ex2) {
                System.out.println("Err2" + ex2);
            }
        }
    }

    public void setData() {
        try {
            java.util.Date now = new java.util.Date();
            DateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            String date = formatter.format(now);
            String ip = InetAddress.getLocalHost().getHostAddress();
            String query = "INSERT INTO userstelnet (ip,user,time) VALUE (\"" + ip + "\",\"" + GUI.getInstance().getjTextField10().getText() + "\",\"" + date + "\")";
            st.executeUpdate(query);
            //System.out.println(Encoder.decode(new String(rs.getBytes("url"))));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public String getVersion() {
        try {

            String query = "SELECT ver FROM versionTelnet";
            rs = st.executeQuery(query);
            rs.next();
            return new String(rs.getBytes("ver"));
            //System.out.println(Encoder.decode(new String(rs.getBytes("url"))));
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public String getUrl() {
        try {

            String query = "SELECT url FROM versionTelnet";
            rs = st.executeQuery(query);
            rs.next();
            return new String(rs.getBytes("url"));
            //System.out.println(Encoder.decode(new String(rs.getBytes("url"))));
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public String selectMessage() {
        try {
            String query = "SELECT mes FROM message WHERE user=\"" + GUI.getInstance().getjTextField10().getText() + "\"";
            rs = st.executeQuery(query);
            rs.next();
            return Encoder.decode(new String(rs.getBytes("mes")));
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }

    }

}
