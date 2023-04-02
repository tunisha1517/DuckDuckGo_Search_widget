package duckDuckGoProject;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateSqliteDatabase {
	private static final String PATH = "jdbc:sqlite:duckduckgo.db";
	private static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS search_history (encrypted_search_query VARCHAR(20), searched_time INTEGER)";
	private static Connection connection = null;

	/**
	 * connects to the sqlite database followed by creation of new table if not
	 * created.
	 */
	private static void connect() {
		try {
			connection = DriverManager.getConnection(PATH);
			createTable(connection);
			System.out.println("connected");
		} catch (SQLException e) {
			System.out.println("Check database path url");
			e.getLocalizedMessage();
		}
	}

	/**
	 * creates a table in specified DB path if not exists.
	 * 
	 * @param connection
	 */
	private static void createTable(Connection connection) {
		try {
			Statement statement = connection.createStatement();
			String createQueary = CREATE_TABLE_QUERY;
			statement.executeUpdate(createQueary);
		} catch (SQLException e) {
			System.out.println("Error in sql query");
			e.getLocalizedMessage();
		}
	}

	/**
	 * takes the queryRequest, encrypts it using encrypt() of {@link EncryptQuery}
	 * and updates the database.
	 * 
	 * @param queryRequest
	 * @param searchedTime
	 * @throws NoSuchAlgorithmException
	 */
	public void updateDB(String queryRequest, long searchedTime) throws NoSuchAlgorithmException {

		String encryptedQuery = EncryptQuery.encrypt(queryRequest, EncryptQuery.generateKey(128),
				EncryptQuery.generateIv());

		UpdateSqliteDatabase.connect();
		UpdateSqliteDatabase.insert(encryptedQuery, searchedTime);
		return;
	}

	/**
	 * inserts data to database
	 * 
	 * @param encrSearchQuery
	 * @param searchTime
	 */
	private static void insert(String encrSearchQuery, long searchTime) {
		Statement statement;
		try {
			statement = connection.createStatement();
			String insert = "INSERT INTO search_history VALUES ('" + encrSearchQuery + "', " + searchTime + ")";
			statement.executeUpdate(insert);
			System.out.println("inserted");
		} catch (SQLException e) {
			System.out.println("Problem in inserting, check Insert query");
			e.getLocalizedMessage();
		}
	}

	/**
	 * previews data present in the database.
	 */
	private void display() {
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM search_history");
			while (rs.next()) {
				System.out.println("query : " + rs.getString("encrypted_search_query"));
				System.out.println("time : " + rs.getString("searched_time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Deletes data from database.
	 */
	private void delete() {
		Statement statement;
		try {
			statement = connection.createStatement();
			String insert = "DELETE FROM search_history";
			statement.executeUpdate(insert);
			System.out.println("deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
