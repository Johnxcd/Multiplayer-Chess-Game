package com.tco.database;

public class Credential {
    // set in .bashrc or equivalent
    final static String USER = System.getenv("DB_USERNAME");
    final static String PASSWORD = System.getenv("DB_PASSWORD");
    
    // connection information when using port forwarding from localhost - ## is your team number
    final static String URL_DEFAULT = "jdbc:mariadb://faure.cs.colostate.edu/cs414_team5";
    final static String URL_OFF_CAMPUS = "jdbc:mariadb://127.0.0.1:56247/cs414_team5";

    static String url() {
        String useTunnel = System.getenv("CS414_USE_DATABASE_TUNNEL");
        if(useTunnel != null && useTunnel.equals("true")) {
            return URL_OFF_CAMPUS;
        }
        else {
            return URL_DEFAULT;
        }
    }
}