//Authors: Oliver Waller
//Date: 12/12/21
//Description: connectionHandles class that handles connections.
//              Methods for opening, authenticating, and closing connections
//              are provided.

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

//If authentication is required (updates), it will prompt for a
//password
public class connectionHandler {
    public Connection establish(Connection myCon, boolean auth){
        try {
            //Step 1: Load the JDBC driver(You have to have the connector Jar file in your project Class path)
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Connect to the database
            String url = "jdbc:mysql://localhost:3306/WTF?serverTimezone=UTC&useSSL=TRUE";
            String user, pass;
            //auto authenticate if authorization not required - this is for the statistics
            if (auth){
                user = readEntry("userid : ");
                pass = readEntry("password: ");
            } else {
                user = "student";
                pass = "password";
            }
            myCon = DriverManager.getConnection(url, user, pass);
            if (myCon != null){
                System.out.println("Connected to database...");
                DatabaseMetaData dm = myCon.getMetaData(); //DatabaseMetaData type
                System.out.println("Driver name: " + dm.getDriverName()); //other methods for dm!
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load the driver");
        } catch (SQLException ex) {
            System.out.println("invalid credentials...Quit to main menu");
            //System.out.println(ex);
        }
        return myCon;
    }
    //read auth credentials from user when required
    private String readEntry(String prompt) {
        try {
            StringBuffer buffer = new StringBuffer();
            System.out.print(prompt);
            System.out.flush();
            int c = System.in.read();
            while(c != '\n' && c != -1) {
                buffer.append((char)c);
                c = System.in.read();
            }
            return buffer.toString().trim();
        } catch (IOException e) {
            return "";
        }
    }

    //closes connection to server
    public void closeCon(Connection myCon){
        if (myCon != null) {
            try {
                myCon.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
