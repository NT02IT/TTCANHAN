/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agond
 */
public class ConnectDB {
    public static Connection conn = null;
    private static String server;
    private static String database;
    private static String username;
    private static String password;
    private static int port;
    
    public ConnectDB() throws ClassNotFoundException, SQLException{
        try {
            readConfig();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String strConnect = "jdbc:sqlserver://"+server+":1433;databaseName="+database+";user="+username+";password="+password+";encrypt=true;trustServerCertificate=true";
            conn = DriverManager.getConnection(strConnect);
             System.out.println("Ket noi DB thanh cong");
        } catch (IOException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Ket noi DB that bai");
        }
    }
    
    private static void readConfig() throws IOException {
        String filename = "src\\Connection\\ServerInfo.txt"; //đường dẫn đến file txt
        Properties properties = new Properties();
        properties.load(new FileReader(filename));
        server = properties.getProperty("server");
        database = properties.getProperty("database");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        port = Integer.parseInt(properties.getProperty("port"));
    }
}
