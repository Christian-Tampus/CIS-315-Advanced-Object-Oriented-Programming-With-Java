/**
 * Assignment: Program 8 | Factory Method
 * Instructions: Follow the uml diagram
 * Design Notes: Follow the uml diagram
 * Version: 1.0, 11/11/2025
 * @author: Christian Tampus
 * Class: CIS-315
 */
import java.lang.Exception;
import java.util.List;
import edu.una.csis.*;
public class Driver {
	private static final MariaDbClassFactory MARIA_DB_CLASS_FACTORY = new MariaDbClassFactory();
	public static void main(String [] args) {
		System.out.println("[SYSTEM MESSAGE] Program Started!");
		System.out.println("\n[SYSTEM MESSAGE] Testing show():\n");
		Driver.show();
		System.out.println("\n[SYSTEM MESSAGE] Testing show(1):\n");
		Driver.show(1);
		System.out.println("\n[SYSTEM MESSAGE] Testing show(-1):\n");
		Driver.show(-1);
		System.out.println("\n[SYSTEM MESSAGE] Program Terminated...");
		return;
	}
	private static void show() {
		try {
			List<CollegeClass> collegeClasses = Driver.MARIA_DB_CLASS_FACTORY.fetchAllClasses();
			if (collegeClasses.size() == 0) {
				throw new NotFoundException("NoClassesFoundException: no classes found");
			}
			for (CollegeClass collegeClass : collegeClasses) {
				System.out.println(collegeClass);
			}
		}
		catch (NotFoundException error) {
			System.out.println(error.getMessage());
		}
		catch (Exception error) {
			System.out.println(error.getMessage());
		}
		return;
	}
	private static void show(int id) {
		try {
			if (Driver.MARIA_DB_CLASS_FACTORY.fetchClass(id).getId() == -1) {
				throw new NotFoundException("ClassNotFoundWithIdException: class not found with with id " + id);
			}
			System.out.println(Driver.MARIA_DB_CLASS_FACTORY.fetchClass(id).toString());
		}
		catch (NotFoundException error) {
			System.out.println(error.getMessage());
		}
		catch (Exception error) {
			System.out.println(error.getMessage());
		}
		return;
	}
}