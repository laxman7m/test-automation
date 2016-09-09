package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtils {

	public Connection conn = null;
	public static PreparedStatement stmt = null;
	public static ResultSet rs = null;
	static String resultValue = null;

	/**
	 * @method Connection connectToTestDB
	 * @description This method will return database connection.
	 * 
	 * @author Laxman.M
	 */
	public static Connection connectToTestDB() throws ClassNotFoundException, SQLException {
		Log.info("Loading Oracle Driver");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Log.info("Connecting to Database");
		String connStr = "jdbc:oracle:thin:@" + Config.DB_Host + ":" + Config.DB_Port + ":" + Config.DB_Name;
		Connection conn = DriverManager.getConnection(connStr, Config.DB_username, Config.DB_password);
		Log.info("Database Connected :" + conn + " || Class: DatabaseUtils | Method: connectToTestDB | Input: null");
		return conn;
	}

	/**
	 * @method String executeSQLQuery
	 * @description This method will result of sql query.
	 * @param sqlQuery
	 * 
	 * @author Laxman.M
	 */
	public static String executeSQLQuery(Connection conn, String sqlQuery) throws SQLException {
		stmt = conn.prepareStatement(sqlQuery);
		rs = stmt.executeQuery();
		try {
			while (rs.next()) {
				resultValue = rs.getString(1).toString();
				Log.info("Query Result :" + resultValue
						+ " || Class: DatabaseUtils | Method: executeSQLQuery | Input: sqlQuery" + sqlQuery);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException err) {
			Log.info("No Records obtained for this specific query");
			err.printStackTrace();
		}
		return resultValue;
	}

	/**
	 * @method void closeDB
	 * @description This method will disconnect from database.
	 * @param sqlQuery
	 * 
	 * @author Laxman.M
	 */
	public static void closeDB(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
				Log.info("Database Disonnected :" + conn + " || Class: DatabaseUtils | Method: closeDB | Input: null");
			} catch (SQLException ex) {
				Log.info("SQL Exception:" + ex.getStackTrace());
			}
		}
	}

}
