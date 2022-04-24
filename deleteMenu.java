//Author(s): Oliver Waller
//Date: 12/12/21
//Description: deleteMenu class UI that provides access to methods to delete
//              selected facility, water source, business, or regulation

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class deleteMenu extends menu {
    //runs the delete menu using connection from previous menu
    public void runDeleteMenu(Connection conn) throws SQLException, IOException {
        boolean deleteExit = false; //will return to previous menu if true
        while (!deleteExit){
            printDeleteMenu();
            int choice = getInput(1, 5); //only five options
            switch (choice) {
                //each case, except previous menu passes connection to deletion
                //method
                case 1:
                    deleteWaterTreatmentFacility(conn) ;
                    break;
                case 2:
                    deleteWaterSource(conn);
                    break;
                case 3:
                    deleteBusiness(conn);
                    break;
                case 4:
                    deleteRegulation(conn);
                    break;
                case 5:
                    deleteExit = true; //return to previous menu
                    System.out.println("returning to update menu...");
                    break;
                default:
                    System.out.println(" Not a valid option ");
            }
        }
    }

    //each of the following methods handle the deletion of one kind of object
    // in DB
    private void deleteWaterTreatmentFacility(Connection conn) throws SQLException, IOException {
        boolean done = false;
        while (!done){
            //display options
            Statement stmt = conn.createStatement();
            String query = "select FacilityName from WaterTreatmentFacility;";
            ResultSet rset;
            rset = stmt.executeQuery(query);
            System.out.println("\t\t\t\tFACILITIES");
            System.out.println("--------------------------------------------" +
                                "------\n");
            System.out.println("Which of the following facilities would you " +
                                "like to delete?");
            //create index to track number of options for user to select from
            int index = 1;
            //create arrayList of facilities to display
            ArrayList<String> s = new ArrayList<String>();
            while (rset.next()){
                String Fname = rset.getString(1);
                s.add(Fname); //add facility to arrayList
                System.out.println(index + ": " + Fname);
                index++;
            }
            System.out.println(index + ": Exit deletion");
            rset.close();
            //only prompt for deletion choice if there are options to delete
            int choice = -1;
            if (index > 1){ //1 index necessary to exit if no facilities
                choice = getInput(1,index); //range of options
                if (choice == index){
                    done = true;
                } else {
                    System.out.println("Deleting option: " + choice);
                    Statement stmt2 = conn.createStatement();
                    System.out.println(s.get(choice-1));
                    //add string from arraylist associated with numeric choice
                    String query2 = "DELETE from WaterTreatmentFacility " +
                                    "where FacilityName = \""
                                    + s.get(choice-1) + "\"";
                    stmt2.executeUpdate(query2);
                    done = true;
                }
            } else {
                System.out.println("There are no Facilities to delete...");
                done = true; //exit if there is nothing to delete
            }
        }
    }

    //The remaining methods use the same indexing logic, statement creation,
    // and execution
    private void deleteWaterSource(Connection conn) throws SQLException {
        boolean done = false;
        while (!done){
            //display options
            Statement stmt = conn.createStatement();
            String query = "select IDNo, Location from WaterSource;";
            ResultSet rset;
            rset = stmt.executeQuery(query);
            System.out.println("\t\t\t\tWater Sources");
            System.out.println("--------------------------------------------------\n");
            System.out.println("Which of the following Water Sources would you like to delete?");
            int index = 1;
            //array list to store names
            ArrayList<Integer> s = new ArrayList<Integer>();
            while (rset.next()){
                int id = rset.getInt(1);
                String loc = rset.getString(2);
                System.out.println(index + ": " + "IDNo: " + id + ", Location: " + loc);
                s.add(id);
                index++;
            }
            System.out.println(index + ": Exit deletion");
            rset.close();
            //only prompt for deletion choice if there are options to delete
            int choice = -1;
            if (index > 1){
                choice = getInput(1,index);
                if (choice == index){
                    done = true;
                } else {
                    System.out.println("Deleting option: " + choice);
                    Statement stmt2 = conn.createStatement();
                    System.out.println(s.get(choice-1));
                    String query2 = "DELETE from WaterSource where IDNo = " + s.get(choice-1);
                    stmt2.executeUpdate(query2);
                    done = true;
                }
            } else {
                System.out.println("There are no WaterSources to delete...");
                done = true;
            }
        }
    }
    private void deleteBusiness(Connection conn) throws SQLException {
        boolean done = false;
        while (!done){
            //display options
            Statement stmt = conn.createStatement();
            String query = "select IDNo, BusinessName from Business;";
            ResultSet rset;
            rset = stmt.executeQuery(query);
            System.out.println("\t\t\t\tBusiness");
            System.out.println("--------------------------------------------------\n");
            System.out.println("Which of the following Business would you like to delete?");
            int index = 1;
            //array list to store names
            ArrayList<Integer> s = new ArrayList<Integer>();
            while (rset.next()){
                int id = rset.getInt(1);
                String name = rset.getString(2);
                System.out.println(index + ": " + "IDNo: " + id + ", BusinessName: " + name);
                s.add(id);
                index++;
            }
            System.out.println(index + ": Exit deletion");
            rset.close();
            //only prompt for deletion choice if there are options to delete
            int choice = -1;
            if (index > 1){
                choice = getInput(1,index);
                if (choice == index){
                    done = true;
                } else {
                    System.out.println("Deleting option: " + choice);
                    Statement stmt2 = conn.createStatement();
                    System.out.println(s.get(choice-1));
                    String query2 = "DELETE from Business where IDNo = " + s.get(choice-1);
                    stmt2.executeUpdate(query2);
                    done = true;
                }
            } else {
                System.out.println("There are no Businesses to delete...");
                done = true;
            }
        }

    }
    private void deleteRegulation(Connection conn) throws SQLException {
        boolean done = false;
        while (!done){
            //display options
            Statement stmt = conn.createStatement();
            String query = "select IDNo, RName from Regulation;";
            ResultSet rset;
            rset = stmt.executeQuery(query);
            System.out.println("\t\t\t\tRegulations");
            System.out.println("--------------------------------------------------\n");
            System.out.println("Which of the following Regulations would you like to delete?");
            int index = 1;
            //array list to store names
            ArrayList<Integer> s = new ArrayList<Integer>();
            while (rset.next()){
                int id = rset.getInt(1);
                String name = rset.getString(2);
                System.out.println(index + ": " + "IDNo: " + id + ", Regulation Name: " + name);
                s.add(id);
                index++;
            }
            System.out.println(index + ": Exit deletion");
            rset.close();
            //only prompt for deletion choice if there are options to delete
            int choice = -1;
            if (index > 1){
                choice = getInput(1,index);
                if (choice == index){
                    done = true;
                } else {
                    System.out.println("Deleting option: " + choice);
                    Statement stmt2 = conn.createStatement();
                    System.out.println(s.get(choice-1));
                    String query2 = "DELETE from Regulation where IDNo = " + s.get(choice-1);
                    stmt2.executeUpdate(query2);
                    done = true;
                }
            } else {
                System.out.println("There are no Regulations to delete...");
                done = true;
            }
        }
    }
    private void printDeleteMenu(){
        header();
        System.out.println("\n\t\t\t _____________________");
        System.out.println("\t\t\t|      DELETE         |");
        System.out.println("\t\t\t|_____________________|\n");
        System.out.println("Option 1: Delete Water Treatment Facility");
        System.out.println("Option 2: Delete Water Source"); //this is what we will work on
        System.out.println("Option 3: Delete Business");
        System.out.println("Option 4: Delete Regulation");
        System.out.println("Option 5: Return to Previous Menu");
    }
}
