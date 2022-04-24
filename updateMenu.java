//Authors: Kunga Kngochetsang, Oliver Waller
//Date: 12/12/21
//Description: updateMenu class UI that provides access to submenus when they
//              are selected by the user. Inherits helper methods for menu
//              design and user input from menu class.

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class updateMenu extends menu {
    //runs menu while exit condition is not met
    public void runUpdateMenu(Connection conn)throws SQLException, IOException{
            //pass connection to connection handler and prompt for credentials
            connectionHandler ch = new connectionHandler();
            conn = ch.establish(conn, true); //authentication required
            boolean done = false;
            while (!done) {
                printUpdatesMenu();
                int choice = getInput(1, 5); //5 options for update menu
                switch (choice) {
                    case 1:
                        System.out.println("this feature coming soon...");
                        break;
                    case 2:
                        System.out.println("in progress..pass to delete menu");
                        //create deletemenu object and pass connection to run
                        deleteMenu del = new deleteMenu();
                        del.runDeleteMenu(conn);
                        break;
                    case 3:
                        System.out.println("this feature coming soon...");
                        break;
                    case 4:
                        done = true;
                        System.out.println("returning to Main Menu...");
                        conn.close(); //ensure connection is closed
                        break;
                    case 5:
                        done = true; //escape update menu
                        exit = true; //exit program in mainMenu
                        System.out.println("exiting program...");
                        break;
                    default:
                        System.out.println(" Not a valid option ");
                }
            }
    }

    private void printUpdatesMenu(){
        header();
        System.out.println("\n\t\t\t _____________________");
        System.out.println("\t\t\t|      UPDATES        |");
        System.out.println("\t\t\t|_____________________|\n");
        System.out.println("Option 1: Insert New information");
        System.out.println("Option 2: Delete Some Information"); //this is what we will work on
        System.out.println("Option 3: Update Current Information");
        System.out.println("Option 4: Return to main Menu");
        System.out.println("Option 5: Quit");

    }
}
