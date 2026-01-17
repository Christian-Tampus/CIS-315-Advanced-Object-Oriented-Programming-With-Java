package edu.una.csis;
/**
 * Assignment: Program 8 | Factory Method
 * Instructions: Follow the uml diagram
 * Design Notes: Follow the uml diagram
 * Version: 1.0, 11/11/2025
 * @author: Christian Tampus
 * Class: CIS-315
 */
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class FileFactory implements ClassFactory {
	private final String FILE_NAME = "courses.csv";
	@Override
	public CollegeClass fetchClass(int id) {
		CollegeClass collegeClass = new CollegeClass();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
			int line = 1;
			while (bufferedReader.ready()) {
				String dataLine = bufferedReader.readLine();
				String[] dataLineArray = dataLine.split(",");
				try {
					if (dataLineArray.length != 4) {
						throw new Exception("[SYSTEM ERROR] Input Line [" + line + "] Does Not Have Exactly 4 Data Points For CollegeClass Fields!");
					}
					else if (Integer.parseInt(dataLineArray[0]) == id) {
						collegeClass.setId(Integer.parseInt(dataLineArray[0]));
						collegeClass.setInstructorId(Integer.parseInt(dataLineArray[1]));
						collegeClass.setName(dataLineArray[2]);
						collegeClass.setHours(Integer.parseInt(dataLineArray[3]));
					}
				}
				catch (NumberFormatException error) {
					System.err.println(error.getMessage());
				}
				catch (Exception error) {
					System.err.println(error.getMessage());
				}
				line++;
			}
		}
		catch (FileNotFoundException error) {
			System.err.println(error.getMessage());
		}
		catch (IOException error) {
			System.err.println(error.getMessage());
		}
		return collegeClass;
	}
	@Override
	public List<CollegeClass> fetchAllClasses() {
		List<CollegeClass> collegeClassesArray = new ArrayList<CollegeClass>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))) {
			int line = 1;
			while (bufferedReader.ready()) {
				String dataLine = bufferedReader.readLine();
				String[] dataLineArray = dataLine.split(",");
				try {
					if (dataLineArray.length != 4) {
						throw new Exception("[SYSTEM ERROR] Input Line " + line + " Does Not Have Exactly 4 Data Points For CollegeClass Fields!");
					}
					else {
						CollegeClass collegeClass = new CollegeClass();
						collegeClass.setId(Integer.parseInt(dataLineArray[0]));
						collegeClass.setInstructorId(Integer.parseInt(dataLineArray[1]));
						collegeClass.setName(dataLineArray[2]);
						collegeClass.setHours(Integer.parseInt(dataLineArray[3]));
						collegeClassesArray.add(collegeClass);
					}
				}
				catch (NumberFormatException error) {
					System.err.println(error.getMessage());
				}
				catch (Exception error) {
					System.err.println(error.getMessage());
				}
				line++;
			}
		}
		catch (FileNotFoundException error) {
			System.err.println(error.getMessage());
		}
		catch (IOException error) {
			System.err.println(error.getMessage());
		}
		return collegeClassesArray;
	}
}