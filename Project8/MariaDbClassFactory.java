package edu.una.csis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MariaDbClassFactory implements ClassFactory {

	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://localhost:3306/university";
	private static final String USER = "root";
	private static final String PWD = "test123";

	@Override
	public CollegeClass fetchClass(int id) {
		
		CollegeClass theClass = new CollegeClass();
		
		try {
			Class.forName(DRIVER);
			Connection connection = DriverManager.getConnection(URL, USER, PWD);
			Statement stmt = connection.createStatement();

			String query = "select * from classes where class_id = " + id;

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				theClass.setId(rs.getInt(1));
				theClass.setInstructorId(rs.getInt(2));
				theClass.setName(rs.getString(3));
				theClass.setHours(rs.getInt(4));
			}

		} catch (java.lang.ClassNotFoundException cnfe) {
			System.err.println("Configuration error: " + cnfe.getMessage());
		} catch (SQLException se) {
			System.err.println("SQL Exception: " + se);
		}
		return theClass;
	}

	@Override
	public List<CollegeClass> fetchAllClasses() {
		List<CollegeClass> all = new ArrayList<>();
		try {
			Class.forName(DRIVER);
			Connection connection = DriverManager.getConnection(URL, USER, PWD);
			Statement stmt = connection.createStatement();

			String query = "select * from classes";

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				CollegeClass theClass = new CollegeClass();
				theClass.setId(rs.getInt(1));
				theClass.setInstructorId(rs.getInt(2));
				theClass.setName(rs.getString(3));
				theClass.setHours(rs.getInt(4));
				
				all.add(theClass);
			}

		} catch (java.lang.ClassNotFoundException cnfe) {
			System.err.println("Configuration error: " + cnfe.getMessage());
		} catch (SQLException se) {
			System.err.println("SQL Exception: " + se);
		}
		return all;
	}

}