//Authors: Kunga Kngochetsang, Oliver Waller
//Date: 12/12/21
//Description: mainMenu class UI that provides access to submenus when they are
//              selected by the user. Inherits helper methods for menu design
//              and user input from menu class.


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class mainMenu extends menu{

    private void printMainMenu(){
        System.out.println("\n1. Water Source, Treatment & Regulations");
        System.out.println("2. Businesses");
        System.out.println("3. Statistics and Data Analysis");
        System.out.println("4. Updates");
        System.out.println("5. Quit");
    }
    //run main menu until exit condition is met, pass connection to submenus
    public void runMainMenu(Connection conn)throws SQLException, IOException {
        while (!exit) {
            header();
            printMainMenu();
            int choice = getInput(1, 5); //1 to 5 is range of main menu options
            switch (choice) {
                case 1:
                    System.out.println("this feature coming soon...");
                    WSTR menu = new WSTR();
                    menu.runWSTRMenu(conn);
                    break;
                case 2:
                    System.out.println("this feature coming soon...");
                    break;
                case 3:
                    System.out.println("in progress...print statistics");
                    //create new statistics object
                    statistics stat = new statistics();
                    //prints all statistics for scenario 3
                    stat.printAllStats(conn);
                    break;
                case 4:
                    System.out.println("in progress...Pass to update menu");
                    //new update menu object
                    updateMenu up = new updateMenu();
                    //run that update menu
                    up.runUpdateMenu(conn);
                    break;
                case 5:
                    exit = true; //user chose to exit
                    System.out.println("exiting program...");
                    break;
                default:
                    System.out.println(" Not a valid option ");
            }
        }
    }
}
