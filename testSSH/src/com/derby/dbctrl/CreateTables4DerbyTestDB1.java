package com.derby.dbctrl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by applec on 15/4/28.
 */
public class CreateTables4DerbyTestDB1 {
	private String framework = "embedded";
	private static String protocol = "jdbc:derby:";

	public static void main(String[] args) {
		Connection conn = null;
		ArrayList<Statement> statements = new ArrayList<Statement>(); // list of Statements, PreparedStatements
		PreparedStatement psInsert;
		PreparedStatement psUpdate;
		Statement s;
		ResultSet rs = null;
		try
		{

			String dbName = "/Users/applec/Documents/IdeaProjects/projectA/DerbyTestDB1"; // the name of the database

			conn = DriverManager.getConnection(protocol + dbName + ";create=true");

			System.out.println("Connected to and created database " + dbName);

			conn.setAutoCommit(false);

            /* Creating a statement object that we can use for running various
             * SQL statements commands against the database.*/
			s = conn.createStatement();
			statements.add(s);

			// delete the table
//			s.execute("drop table Factory");
//			System.out.println("Dropped table Factory");
//			s.execute("drop table Worker");
//			System.out.println("Dropped table Worker");

			// We create a table...
			s.execute("CREATE TABLE APP.Factory\n" +
					"(\n" +
					"    id INT PRIMARY KEY NOT NULL,\n" +
					"    name VARCHAR(50),\n" +
					"    ts DATE NOT NULL\n" +
					")");
			System.out.println("Created table Factory");

			s.execute("CREATE TABLE APP.Worker\n" +
					"(\n" +
					"    id INT PRIMARY KEY NOT NULL,\n" +
					"    name VARCHAR(50),\n" +
					"    factoryId INT NOT NULL\n" +
					")");
			s.execute("ALTER TABLE APP.Worker\n" +
					"ADD FOREIGN KEY (factoryId) REFERENCES Factory");
			System.out.println("Created table worker");


			psInsert = conn.prepareStatement(
					"insert into Factory values (?, ?, ?)");
			statements.add(psInsert);

			psInsert.setInt(1, 1);
			psInsert.setString(2, "Webster St.");
			psInsert.setDate(3, new Date(Calendar.getInstance().getTimeInMillis()));
			psInsert.executeUpdate();
			System.out.println("Inserted one record...");

			psInsert = conn.prepareStatement(
					"insert into Worker values (?, ?, ?)");
			statements.add(psInsert);

			psInsert.setInt(1, 1);
			psInsert.setString(2, "John");
			psInsert.setInt(3, 1);
			psInsert.executeUpdate();
			System.out.println("Inserted one record...");

			psInsert.setInt(1, 2);
			psInsert.setString(2, "Seline");
			psInsert.setInt(3, 1);
			psInsert.executeUpdate();
			System.out.println("Inserted one record...");


			conn.commit();
			System.out.println("Committed the transaction");
		}
		catch (SQLException sqle)
		{
			printSQLException(sqle);
		} finally {
			// release all open resources to avoid unnecessary memory usage

			// ResultSet
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
			} catch (SQLException sqle) {
				printSQLException(sqle);
			}

			// Statements and PreparedStatements
			int i = 0;
			while (!statements.isEmpty()) {
				// PreparedStatement extend Statement
				Statement st = (Statement)statements.remove(i);
				try {
					if (st != null) {
						st.close();
						st = null;
					}
				} catch (SQLException sqle) {
					printSQLException(sqle);
				}
			}

			//Connection
			try {
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException sqle) {
				printSQLException(sqle);
			}
		}
	}
	public static void printSQLException(SQLException e)
	{
		// Unwraps the entire exception chain to unveil the real cause of the
		// Exception.
		while (e != null)
		{
			System.err.println("\n----- SQLException -----");
			System.err.println("  SQL State:  " + e.getSQLState());
			System.err.println("  Error Code: " + e.getErrorCode());
			System.err.println("  Message:    " + e.getMessage());
			// for stack traces, refer to derby.log or uncomment this:
			//e.printStackTrace(System.err);
			e = e.getNextException();
		}
	}

}
