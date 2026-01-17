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
	private static final ClassFactory MARIA_DB_CLASS_FACTORY = new MariaDbClassFactory();
	private static final ClassFactory FILE_CLASS_FACTORY = new FileFactory();
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
			List<CollegeClass> collegeClassesMariaDB = Driver.MARIA_DB_CLASS_FACTORY.fetchAllClasses();
			List<CollegeClass> collegeClassesFileFactory = Driver.FILE_CLASS_FACTORY.fetchAllClasses();
			if (collegeClassesMariaDB.size() <= 0 && collegeClassesFileFactory.size() <= 0) {
				throw new NotFoundException("[SYSTEM ERROR] MARIA_DB_CLASS_FACTORY: no classes found & FILE_CLASS_FACTORY: no classes found");
			}
			else if (collegeClassesMariaDB.size() <= 0) {
				System.out.println("[SYSTEM MESSAGE] FILE_CLASS_FACTORY:");
				for (CollegeClass collegeClass : collegeClassesFileFactory) {
					System.out.println(collegeClass);
				}
				throw new NotFoundException("[SYSTEM ERROR] MARIA_DB_CLASS_FACTORY: no classes found");
			}
			else if (collegeClassesFileFactory.size() <= 0) {
				System.out.println("[SYSTEM MESSAGE] MARIA_DB_CLASS_FACTORY:");
				for (CollegeClass collegeClass : collegeClassesMariaDB) {
					System.out.println(collegeClass);
				}
				throw new NotFoundException("[SYSTEM ERROR] FILE_CLASS_FACTORY: no classes found");
			}
			else {
				System.out.println("[SYSTEM MESSAGE] MARIA_DB_CLASS_FACTORY:");
				for (CollegeClass collegeClass : collegeClassesMariaDB) {
					System.out.println(collegeClass);
				}
				System.out.println("\n[SYSTEM MESSAGE] FILE_CLASS_FACTORY:");
				for (CollegeClass collegeClass : collegeClassesFileFactory) {
					System.out.println(collegeClass);
				}
			}
		}
		catch (NotFoundException error) {
			System.err.println(error.getMessage());
		}
		catch (Exception error) {
			System.err.println(error.getMessage());
		}
		return;
	}
	private static void show(int id) {
		try {
			CollegeClass collegeClassMariaDB = Driver.MARIA_DB_CLASS_FACTORY.fetchClass(id);
			CollegeClass collegeClassFileFactory = Driver.FILE_CLASS_FACTORY.fetchClass(id);
			if (collegeClassMariaDB.getId() != id && collegeClassFileFactory.getId() != id) {
				throw new NotFoundException("[SYSTEM ERROR] MARIA_DB_CLASS_FACTORY & FILE_CLASS_FACTORY: class not found with id " + id);
			}
			else if (collegeClassMariaDB.getId() != id) {
				System.out.println("[SYSTEM MESSAGE] FILE_CLASS_FACTORY:");
				System.out.println(collegeClassFileFactory);
				throw new NotFoundException("[SYSTEM ERROR] MARIA_DB_CLASS_FACTORY: class not found with id " + id);
			}
			else if (collegeClassFileFactory.getId() != id) {
				System.out.println("[SYSTEM MESSAGE] MARIA_DB_CLASS_FACTORY:");
				System.out.println(collegeClassMariaDB);
				throw new NotFoundException("[SYSTEM ERROR] FILE_CLASS_FACTORY: class not found with id " + id);
			}
			else {
				System.out.println("[SYSTEM MESSAGE] MARIA_DB_CLASS_FACTORY:");
				System.out.println(collegeClassMariaDB);
				System.out.println("[SYSTEM MESSAGE] FILE_CLASS_FACTORY:");
				System.out.println(collegeClassFileFactory);
			}
		}
		catch (NotFoundException error) {
			System.err.println(error.getMessage());
		}
		catch (Exception error) {
			System.err.println(error.getMessage());
		}
		return;
	}
}