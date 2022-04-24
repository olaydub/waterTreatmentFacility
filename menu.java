//Authors: Kunga Kngochetsang, Oliver Waller
//Date: 12/12/21
//Description: menu class UI that provides user input methods and exit boolean
//              for exiting menus

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.Scanner;

public class menu {
    boolean exit;
    public void menu(){
        exit = false;
    }

    //get numeric input
    //takes min and max menu option to be flexible with submenus
    public static int getInput(int min, int max){
        Scanner userInput = new Scanner(System.in);
        int choice = -1;
        //make this flexible for all menus
        while (choice < min || choice > max){
            try {
                System.out.print("Enter Option Number: ");
                choice = Integer.parseInt(userInput.nextLine());
                if (choice < min || choice > max){
                    System.out.println("Invalid number. Please Choose an " +
                                        "option between "
                                        + min + " and " + max);
                }
            }
            catch (NumberFormatException e){
                System.out.println("Invalid choice. Please Try again.");
            }
        }
        return choice;
    }
    //read string entry
    public static String readEntry(String prompt) {
        try {
            StringBuffer buffer = new StringBuffer();
            System.out.print(prompt);
            System.out.flush();
            int c = System.in.read();
            while (c != '\n' && c != -1) {
                buffer.append((char) c);
                c = System.in.read();
            }
            return buffer.toString().trim();
        } catch (IOException e) {
            return "";
        }
    }
    public void starLine(int n){
        for(int i = 0; i < n; i++){
            System.out.print("*");
        }
    }
    public void header(){
        starLine(62);
        System.out.println("\nWelcome to the DSS for Washington's Water " +
                "Treatment Facilities");
        starLine(62);
    }

}