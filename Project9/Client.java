import edu.univ.dept.*;
import java.util.List;
/**
 * Assignment: Program 9 | Instructor Factory
 * Instructions: Follow the uml diagram
 * Design Notes: Follow the uml diagram
 * Version: 1.0, 11/19/2025
 * @author: Christian Tampus
 * Class: CIS-315
 */
public class Client {
	private static final InstructorFactory FILE_FACTORY = new FileFactory("instructors.csv");
	private static final InstructorFactory HARD_CODED_FACTORY = new HardCodedFactory(10);
	public static void main(String[] args) {
		
		//RUN THIS EXAMPLE CLI INPUT: java {File Name Here} all test123 -10 -9 -8 -7 -6 -5 -4 -3 -2 -1 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 ALL "!@#$%^&*()_+"
		
		System.out.println("[SYSTEM MESSAGE] Program Start!");
		System.out.println("[SYSTEM MESSAGE] Please Enter 'all' To Display All Instructors Or Any Integer Value Where All Inputs Are Separated By A Space Into The CLI Example: [java {File Name Here} all 1 2 3 4 5 ALL]");
		if (args.length == 0) {
			System.exit(0);
		}
		else {
			String fullCommand = "";
			for (int index = 0; index < args.length; index++) {
				fullCommand += " " + args[index];
			}
			System.out.println("[SYSTEM MESSAGE] Executing Commands:" + fullCommand);
			for (int index = 0; index < args.length; index++) {
				String command = args[index].toLowerCase();
				if (command.equals("all")) {
					System.out.println("[SYSTEM MESSAGE] Command: " + command + "\n");
					Client.displayAll();
					System.out.println("__________________________");
				}
				else {
					try {
						System.out.println("[SYSTEM MESSAGE] Command: " + command + "\n");
						Client.display(Integer.parseInt(command));
						System.out.println("__________________________");
					}
					catch (NumberFormatException error) {
						System.err.println("[SYSTEM MESSAGE] Invalid Command: " + command);
						System.out.println("__________________________");
					}
				}
			}
		}
		System.out.println("[SYSTEM MESSAGE] Program Terminated...");
	}
	private static void display(int id) {
		System.out.println("[SYSTEM MESSAGE] display(" + id + "): ");
		try {
			System.out.println(Client.FILE_FACTORY.fetchInstructor(id));
			System.out.println("");
		}
		catch (InstructorException error) {
			System.err.println(error.getMessage());
		}
		try {
			System.out.println(Client.HARD_CODED_FACTORY.fetchInstructor(id));
		}
		catch (InstructorException error) {
			System.err.println(error.getMessage());
		}
		return;
	}
	private static void displayAll() {
		try {
			List<Instructor> instructorsFileFactoryList = Client.FILE_FACTORY.fetchInstructors();
			for (int index = 0; index < instructorsFileFactoryList.size(); index++) {
				System.out.println(instructorsFileFactoryList.get(index));
			}
			System.out.println("");
		}
		catch (InstructorException error) {
			System.err.println(error.getMessage());
		}
		try {
			List<Instructor> instructorsHardCodedList = Client.HARD_CODED_FACTORY.fetchInstructors();
			for (int index = 0; index < instructorsHardCodedList.size(); index++) {
				System.out.println(instructorsHardCodedList.get(index));
			}
		}
		catch (InstructorException error) {
			System.err.println(error.getMessage());
		}
		return;
	}
}