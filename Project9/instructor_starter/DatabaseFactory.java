package edu.univ.dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DatabaseFactory implements InstructorFactory {
	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://localhost:3306/university";
	private static final String USER = "root";
	private static final String PWD = "";
	private Connection connection = null;

	public DatabaseFactory() {
		// make sure connection works
		connect();
		close();
	}

	private void connect() {
		if (connection != null) {
			return;
		}
		try {
			java.lang.Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PWD);
		} catch (ClassNotFoundException e) {
			System.err.println("Driver not found: " + e);
		} catch (SQLException e) {
			System.err.println("SQL error: " + e);
		}
	}

	private void close() {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				System.err.println("Error closing connection: " + e);
			}
		}
	}


	@Override
	public Instructor fetchInstructor(int id) {
		connect();
		try {
			Statement stmt = connection.createStatement();
			String query = "select instructor_id, firstname, lastname, course_id from instructors where instructor_id = "
					+ id;
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				int iid = rs.getInt(1);
				int cid = rs.getInt(4);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				Instructor teacher = new Instructor();
				teacher.setCourseId(cid);
				teacher.setFirstName(firstName);
				teacher.setId(id);
				teacher.setLastName(lastName);
				
				return teacher;
			}
		} catch (SQLException e) {
			System.err.println("SQL error: " + e);
		} finally {
			close();
		}
		throw new RuntimeException("no such person");
	}

	@Override
	public List<Instructor> fetchInstructors() {
		List<Instructor> people = new ArrayList<>();
		connect();
		try {
			Statement stmt = connection.createStatement();
			String query = "select instructor_id, firstname, lastname, course_id from instructors";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt(1);
				int cid = rs.getInt(4);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				Instructor i = new Instructor();
				i.setCourseId(cid);
				i.setFirstName(firstName);
				i.setId(id);
				i.setLastName(lastName);
				people.add(i);
//				System.out.printf("%d,%d,%s,%s\n", id, cid, firstName, lastName);
			}
		} catch (SQLException e) {
			System.err.println("SQL error: " + e);
			throw new RuntimeException(e);
		} finally {
			close();
		}

		return people;
	}
}
