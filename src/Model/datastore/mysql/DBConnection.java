package Model.datastore.mysql;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 * The database connection code. This establishes a connection to the database server and table.
 * @author Team-Juan
 * @version 1.0
 */
public class DBConnection {

	/**
	 * Creates the connection to the database server and table using the provided database properties.
	 * @return The database connection identifier.
	 */
	public static Connection getConnection() {
        Properties props = new Properties();
        Connection con = null;
        try {
            props.load(new FileInputStream("Files/mysql/db.properties"));
            Class.forName(props.getProperty("DB_DRIVER_CLASS"));
            con = DriverManager.getConnection(
                    props.getProperty("DB_URL")
                    + "?user=" + props.getProperty("DB_USERNAME")
                    + "&password=" + props.getProperty("DB_PASSWORD")
                    + "&useSSL=" + props.getProperty("USE_SSL"));
        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.println("db error in getConnection()");
            e.printStackTrace();
        }
        return con;
    }
	
	/**
	 * Main method of the program. Launches the method to connect to the database.
	 * @param args Arguments for the main method.
	 */

    public static void main(String[] args) {
        getConnection();
    }
}
