//Author(s): Oliver Waller
//Date: 12/12/21
//Description: WSTR (Water Source Treatment and Regulation) class UI that
//              provides access to submenus when they are selected by the
//              user. Inherits helper methods for menu design and user
//              input from menu class.

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class WSTR extends menu {

    public void runWSTRMenu(Connection conn)throws SQLException, IOException {
        connectionHandler ch = new connectionHandler();
        conn = ch.establish(conn, false);
        boolean done = false;
        while (!done) {
            printMenu();
            int choice = getInput(1,4);
            switch (choice) {
                case 1:
                    System.out.println("current activities chosen");
                    currentActivities curr = new currentActivities();
                    curr.runCurrentActivitiesMenu(conn);
                    break;
                case 2:
                    System.out.println("Water treatment regulations");
                    waterTreatmentRegulations wtr = new waterTreatmentRegulations();
                    wtr.runMenu(conn);
                    break;
                case 3:
                    System.out.println("this feature coming soon...");
                    break;
                case 4:
                    done = true;
                    System.out.println("returning to Main Menu...");
                    conn.close();
                    break;
                default:
                    System.out.println(" Not a valid option ");
            }
        }
    }

    private void printMenu(){
        header();
        System.out.println("\t\t\t ________________________________________");
        System.out.println("\t\t\t| Water Source, Treatment & Regulations  |");
        System.out.println("\t\t\t|________________________________________|\n");
        System.out.println("Option 1: Current Activities");
        System.out.println("Option 2: Water Treatment Regulations"); //this is what we will work on
        System.out.println("Option 3: Compliance with the regulations");
        System.out.println("Option 4: Quit");
    }

}
