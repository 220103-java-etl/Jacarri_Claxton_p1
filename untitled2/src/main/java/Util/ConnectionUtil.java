package Util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// This ConnectionUtil class will define the methods needed to create a connection to our DB
public class ConnectionUtil {

    private static ConnectionUtil cu = null;
    private static Properties dbProps;

    // private constructor - so we can control the creation of any instances of this class
    // Singleton Design Pattern (Creational Design Pattern) - to make sure we only have one instance
    private ConnectionUtil() {
        // initialize properties object to hold our database credentials
        dbProps = new Properties();


        // Stream the credentials from our connection properties file to this Properties Object
        InputStream props = ConnectionUtil.class.getClassLoader().getResourceAsStream("connection.properties");

        try {
            dbProps.load(props);
        }catch (IOException e) {
            e.printStackTrace();
        }


    }

    // public getter to return us an instance of this ConnectionUtil class
    public static synchronized ConnectionUtil getConnectionUtil() {
        // first we want to check if an instance already exist
        if (cu == null) {
            // the call the private constructor (if null -> create one)
            cu = new ConnectionUtil();
        }
        // otherwise, just return the existing instance (else return the one that exists)
        return cu;
    }
    public Connection getConnection() {

        Connection conn = null;

        // Get the credentials needed to access the database from the Properties Object we created above ( which gets from the connection properties)
        String url = dbProps.getProperty("url");
        String username = dbProps.getProperty("username");
        String password = dbProps.getProperty("password");

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;

    }

}
