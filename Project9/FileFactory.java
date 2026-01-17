package edu.univ.dept;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Assignment: Program 9 | Instructor Factory
 * Instructions: Follow the uml diagram
 * Design Notes: Follow the uml diagram
 * Version: 1.0, 11/19/2025
 * @author: Christian Tampus
 * Class: CIS-315
 */
public class FileFactory implements InstructorFactory {
	private String fileName;
	//THIS IS EXTRA STUFF FOR ADDED FUNCTIONALITY
	public FileFactory() {
		this.fileName = "";
		return;
	}
	//THIS IS EXTRA STUFF FOR ADDED FUNCTIONALITY
	public FileFactory(String fileName) {
		this.fileName = fileName;
		return;
	}
	//THIS IS EXTRA STUFF FOR ADDED FUNCTIONALITY
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	//THIS IS EXTRA STUFF FOR ADDED FUNCTIONALITY
	public String getFileName() {
		return this.fileName;
	}
	@Override
	public Instructor fetchInstructor(int id) throws InstructorException {
		Instructor currentInstructor = null;
		boolean found = false;
		int line = 1;
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(this.fileName)))) {
			while (bufferedReader.ready() && !found) {
				String dataLine = bufferedReader.readLine();
				String[] dataArray = dataLine.split(",");
				try {
					if (dataArray.length != 4) {
						throw new InstructorException("[SYSTEM ERROR] FileFactory Invalid Data Input On Line: " + line);
					}
					else if (Integer.parseInt(dataArray[0]) == id) {
						currentInstructor = new Instructor();
						currentInstructor.setId(Integer.parseInt(dataArray[0]));
						currentInstructor.setCourseId(Integer.parseInt(dataArray[1]));
						currentInstructor.setFirstName(dataArray[2]);
						currentInstructor.setLastName(dataArray[3]);
						found = true;
						break;
					}
				}
				catch (InstructorException error) {
					System.err.println(error.getMessage());
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
		if (currentInstructor == null) {
			throw new InstructorException("[SYSTEM ERROR] FileFactory Instructor Id: " + id + " Not Found!");
		}
		return currentInstructor;
	}
	@Override
	public List fetchInstructors() throws InstructorException {
		List<Instructor> instructorsList = new ArrayList<Instructor>();
		int line = 1;
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(this.fileName)))) {
			while (bufferedReader.ready()) {
				String dataLine = bufferedReader.readLine();
				String[] dataArray = dataLine.split(",");
				try {
					if (dataArray.length != 4) {
						throw new InstructorException("[SYSTEM ERROR] FileFactory Invalid Data Input On Line: " + line);
					}
					else {
						Instructor newInstructor = new Instructor();
						newInstructor.setId(Integer.parseInt(dataArray[0]));
						newInstructor.setCourseId(Integer.parseInt(dataArray[1]));
						newInstructor.setFirstName(dataArray[2]);
						newInstructor.setLastName(dataArray[3]);
						instructorsList.add(newInstructor);
					}
				}
				catch (InstructorException error) {
					System.err.println(error.getMessage());
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
		if (instructorsList.size() <= 0) {
			throw new InstructorException("[SYSTEM ERROR] FileFactory No Instructors Found!");
		}
		Collections.sort(instructorsList);
		return instructorsList;
	}
}