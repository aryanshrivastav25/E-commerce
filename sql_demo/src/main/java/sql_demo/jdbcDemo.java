package sql_demo;

import java.sql.*;

public class jdbcDemo {
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        /*
         * import package
         * Load and register drivers
         * Create connection
         * create and execute statement
         * Close connection
         */

        // Class.forName("com.mysql.cj.jdbc.Driver"); // Load and register driver
        // Loading and registering drivers is optional, automatically done

        String url = "jdbc:mysql://localhost:3306/students"; // database url
        // url consist of "jdbc" + "mysql" or "orcale" or "postgresql" +
        // "://localhost:3306/" (which is the IP address, if using database from other
        // system, their IP address needs to be mentioned) + "database name" (which is
        // to be accessed)
        Connection con = DriverManager.getConnection(url, "root", "Ar@20051125"); // Set up connection
        Statement s = con.createStatement(); // Used to execute queries

        String query = "SELECT * FROM COURSE;";
        ResultSet rs = s.executeQuery(query); // Execute a read query

        System.out.println(rs.next()); // next() will return true, if the next rows exist and move the pointer to next
                                       // row;
        // By default the next pointer points to the header of the table, not the first
        // row
        // So using rs.next() once will move the pointer to the 1st row
        System.out.println("Connection established");

        String result = rs.getString("CNAME"); // get the value of the column "CNAME"
        // "We can get onle the value of only one column at a time";
        System.out.println(result);

        System.out.println();

        Statement s2 = con.createStatement();
        Boolean status = s2.execute("INSERT INTO COURSE VALUES(\"A12\", \"DAA\", \"HELL\", 2, 90.0, \"CIS\");");
        // Return true if the the query returns some ResultSet, return false if the
        // query is DML (INSERT, UPDATE, DELETE)

        System.out.println(status);

        ResultSetMetaData r2 = rs.getMetaData();
        for (int i = 1; i <= r2.getColumnCount(); i++) {
            System.out.println(r2.getColumnName(i));
        }

        // columnIndex starts with 1
        while (rs.next()) {
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                System.out.print(rs.getObject(i) + " ");
            }
            System.out.println();
        }

        /*
         * If a statement is created with a connection, when we execute a query, if it
         * return a ResultSet
         * If another query is executed using the same Statement object, the ResultSet
         * object of the previous query gets automatically closed and its methods can no
         * longer be called
         * So if we need to execute another query, either create a new Statement object
         * or close the previous ResultSet object or execute the query with the same
         * statement only after all the required operations from the previous ResultSet
         * have been done.
         */

        Boolean a = s2.execute("DELETE FROM COURSE WHERE CNO = \"A12\";");
        System.out.println("Deletion done");

        a = s2.execute("SELECT * FROM COURSE;");
        ResultSet rs3 = null;
        if (a) {
            rs3 = s2.getResultSet(); // WORKS ONLY IF the last executed query using execute() is a read query
            // Otherwise it returns null
        }

        while (rs3.next()) {
            for (int i = 1; i <= rs3.getMetaData().getColumnCount(); i++) {
                System.out.print(rs3.getObject(i) + " ");
            }
            System.out.println();
        }


        String cno = "A13", cname = "COMPUTER NETWORKS", cdesp = "IPVP", cdept = "CIS";
        int cred = 4;
        float clabfee = 200;

        String Q = "INSERT INTO COURSE VALUES(?, ?, ?, ?, ?, ?);";
        PreparedStatement s5 = con.prepareStatement(Q);
        
        s5.setString(1, cno);
        s5.setString(2, cname);
        s5.setString(3, cdesp);
        s5.setInt(4, cred);
        s5.setFloat(5, clabfee);
        s5.setString(6, cdept);
        s5.execute();

        ResultSet rs6 = s2.executeQuery("SELECT * FROM COURSE"); // s2 is on object of Statement
        while (rs6.next())
        {
            for (int i = 1; i <= rs6.getMetaData().getColumnCount(); i++) {
                System.out.print(rs6.getObject(i) + " ");
            }
            System.out.println();
        }

        s2.execute("DELETE FROM COURSE WHERE CNO = 'A13'");
        con.close();
    }
}
