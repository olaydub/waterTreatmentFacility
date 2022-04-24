//Authors: Kunga Kngochetsang
//Date: 12/12/21
//Description: statistics class to output specific statistics from the DB.
//             includes methods that use SQL statements. No user input
//             required.


import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//prints all statistics related to Average consumption, waste, and treatment
// needed
public class statistics {
    public void printAllStats(Connection conn) throws SQLException {
        connectionHandler ch = new connectionHandler();
        conn = ch.establish(conn, false); //no authentication needed
        System.out.println("---------------------Statistic Report--------------------\n");
        printAVGConsumption(conn, "Agricultural");
        printAVGConsumption(conn, "Industrial");
        printAVGWaste(conn, "Agricultural");
        printAVGWaste(conn, "Industrial");
        printTreatmentNeed(conn);
    }
    //Accepts a connection and String that identifies business type
    // (better code reuse)
    public void printAVGConsumption(Connection conn, String b) throws SQLException {
        Statement stmt = conn.createStatement();
        //assuming that avgWaterConsumption is calculated on a yearly basis
        //and value stored is indeed the Avg over the last year
        String query = "select avg(AvgWaterConsumpPerMonth)\n" +
                "from Business\n" +
                "where BusinessType = \"" + b + "\""; //includes business type
        ResultSet rset;
        rset = stmt.executeQuery(query);
        while (rset.next()){
            System.out.println( b + " Business Average " +
                    "Monthly Consumption of Water: "
                    + rset.getBigDecimal(1));
        }
        rset.close();
        stmt.close();
    }

    //prints average monthly waste per business type specified
    public void printAVGWaste(Connection conn, String b) throws SQLException {
        Statement stmt = conn.createStatement();
        String query = "select  avg(AvgWasteGeneratedPerMonth)\n" +
                "from Business\n" +
                "where BusinessType = '" + b +"'";
        ResultSet rset;
        rset = stmt.executeQuery(query);
        while (rset.next()){
            System.out.println(b + " Business Average Monthly Waste of Water: "
                    + rset.getBigDecimal(1));
        }
        rset.close();
        stmt.close();
    }

    //prints the treatment needed (calculated as sum of average monthly waste
    //among all businesses
    public void printTreatmentNeed(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        String query = "select  avg(AvgWaterConsumpPerMonth), " +
                "avg(AvgWasteGeneratedPerMonth)," +
                "sum(AvgWasteGeneratedPerMonth) \n"
                + "from Business;\n";
        ResultSet rset;
        rset = stmt.executeQuery(query);
        while (rset.next()){
            System.out.println("AVG Monthly Water Consumption: " + rset.getBigDecimal(1));
            System.out.println("AVG Monthly Waste Generated: " + rset.getBigDecimal(2));
            System.out.println("Amount of Water needing treatment: " + rset.getBigDecimal(3));
        }
        rset.close();
        stmt.close();
    }

}
