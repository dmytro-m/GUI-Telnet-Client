package com.github.dmtk;

public static abstract class MyUserInfo
        implements UserInfo, UIKeyboardInteractive {

    public String getPassword() {
        return null;
    }

    public boolean promptYesNo(String str) {
        return false;
    }

    public String getPassphrase() {
        return null;
    }

    public boolean promptPassphrase(String message) {
        return false;
    }

    public boolean promptPassword(String message) {
        return false;
    }

    public void showMessage(String message) {
    }

    public String[] promptKeyboardInteractive(String destination,
            String name,
            String instruction,
            String[] prompt,
            boolean[] echo) {
        return null;
    }
}
