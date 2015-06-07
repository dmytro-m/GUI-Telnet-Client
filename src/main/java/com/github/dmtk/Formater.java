package com.github.dmtk;

public class Formater {
    
    //convert MAC string from XX-XX-XX-XX-XX-XX to XXXX.XXXX.XXXX 
    public static String convert(String str) {
        String out = "";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-') {
                count++;
                if (count % 2 == 0) {
                    
                    out += ".";
                }
            } else {
                out += str.charAt(i);
            }

        }
        return out;
    }
    public static String replace(String str) {
                
        return str.replace(':', '-');
    }
}
