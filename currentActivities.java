//Author(s): Oliver Waller
//Date: 12/12/21
//Description: Incomplete Scenario 2 item. Current activities reports -
//              to be completed by Vincenzo and Michael

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class currentActivities extends menu{

    public void runCurrentActivitiesMenu(Connection conn)throws SQLException, IOException {
        connectionHandler ch = new connectionHandler();
        conn = ch.establish(conn, false);
        boolean done = false;
        while (!done) {
            printMenu();
            int choice = getInput(1,3);
            switch (choice) {
                case 1:
                    System.out.println("treatment facilities summary report");
                    facilitiesReport(conn);
                    break;
                case 2:
                    System.out.println("water source summary report");
                    waterSourceSummary(conn);
                    break;
                case 3:
                    done = true;
                    System.out.println("returning to Main Menu...");
                    conn.close();
                    break;
                default:
                    System.out.println(" Not a valid option ");
            }
        }
    }

    public void facilitiesReport(Connection conn) throws SQLException {
        System.out.println("facilities report in progress...");
        /*
        Statement stmt = conn.createStatement();
        String query = "";
        ResultSet rset;
        rset = stmt.executeQuery(query);
        while (rset.next()){

        }
        rset.close();
        stmt.close();

         */
    }
    public void waterSourceSummary(Connection conn) throws SQLException {
        System.out.println("water source summary in progres...");
        /*
        Statement stmt = conn.createStatement();
        String query = "";
        ResultSet rset;
        rset = stmt.executeQuery(query);
        while (rset.next()){
        }
        rset.close();
        stmt.close();

         */
    }

    private void printMenu(){
        header();
        System.out.println("\t\t\t _____________________");
        System.out.println("\t\t\t| Current Activities  |");
        System.out.println("\t\t\t|_____________________|\n");
        System.out.println("Option 1: Treatment Facilities Summary Report");
        System.out.println("Option 2: Water Source Summary Report"); //this is what we will work on
        System.out.println("Option 3: Return to previous menu");
    }
}
