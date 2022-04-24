//Author(s): Oliver Waller
//Date: 12/12/21
//Description: Incomplete Scenario 2 item. Water Treatment Regulation Reports
//              - to be completed by Vincenzo and Michael

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class waterTreatmentRegulations extends menu{

    public void runMenu(Connection conn)throws SQLException, IOException {
        connectionHandler ch = new connectionHandler();
        conn = ch.establish(conn, false);
        boolean done = false;
        while (!done) {
            printMenu();
            String choice = readEntry("Enter treatment number to generate report or Q to quit: ");
            if (choice.equals('Q')){
                done = true;
                break;
            } else {
                done = regList(conn, choice); //pass entry to regList
            }

        }
    }

    //return boolean value saying whether it was successful or not
    public boolean regList(Connection conn, String choice) throws SQLException {
        System.out.println("regulation list in progress...");
        /*
        try {
            Statement stmt = conn.createStatement();
            String query = "";
            ResultSet rset;
            rset = stmt.executeQuery(query);
            while (rset.next()){

            }
            rset.close();
            stmt.close();
            return true;
        } catch (SQLException ex){
            System.out.println("invalid treatment number...try again");
            return false;
        }
         */
        return true;
    }

    private void printMenu() {
        header();
        System.out.println("\n\t\t\t ___________________________");
        System.out.println("\t\t\t| Water Treatment Regulations|");
        System.out.println("\t\t\t|____________________________|\n");
        System.out.println("Enter Treatment Regulation or Q to Quit: ");

    }
}
