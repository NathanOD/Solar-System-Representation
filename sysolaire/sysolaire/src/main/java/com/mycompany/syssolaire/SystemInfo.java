package com.mycompany.syssolaire;
/**
 * Systeme info
 * @author Thoma
 */
public class SystemInfo {
    /**
     * Version
     * @return 
     */
    public static String javaVersion() {
        return System.getProperty("java.version");
    }
    /**
     * Version
     * @return 
     */
    public static String javafxVersion() {
        return System.getProperty("javafx.version");
    }

}