package org.example.kebab.utiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conectar {
    private static Connection connection;

    public static Connection conectar() throws ClassNotFoundException, SQLException, IOException {
        if (connection == null || connection.isClosed()) {
            Properties configuration = new Properties();
            configuration.load(new FileInputStream(new File("src/main/resources/configuration/database.properties")));

            String host = configuration.getProperty("host");
            String port = configuration.getProperty("port");
            String name = configuration.getProperty("name");
            String username = configuration.getProperty("username");
            String password = configuration.getProperty("password");

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + name + "?serverTimezone=UTC",
                    username, password);
        }
        return connection;
    }
    /*public static Connection conectar(){
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/Kebab?serverTimezone=UTC";
            String user = "root";
            String password = "toor";
            connection = DriverManager.getConnection(url,user,password);
        }catch (SQLException e){
            System.out.println("error " + e.getMessage());
        }
        return connection;
    }*/
}

