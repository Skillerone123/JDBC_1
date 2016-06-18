package org.study.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Skiller on 17.06.2016.
 */
public class ConnectionManager {
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/hrapp?autoReconnect=true&useSSL=false";
            return DriverManager.getConnection(url, "root", "skiller123465465");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
