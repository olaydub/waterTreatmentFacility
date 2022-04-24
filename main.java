//Author: Oliver Waller
//Date: 12/12/21
//Description: main class to run program

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class main {

    public static void main(String args[]) throws SQLException, IOException {
        //create null connection to pass to main menu
        //only authenticate when required
        Connection conn = null;
        mainMenu m = new mainMenu();
        m.runMainMenu(conn);
    }
}


