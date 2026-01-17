import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Assignment: Program 4 | BankingSystem
 * Instructions: A banking system designed to read in 3 files and use ArrayLists to store the data and use them to create an ArrayList of BankAccounts
 * Design Notes: No additional design changes were added
 * Version: 1.0, 10/2/2025
 * Author: Christian Tampus
 * Class: CIS-315
 **/
/**
 * This class can be used to create an object that is capable of reading a simple text file.
 * <p>
 * Instantiate the object by passing in the name of the file.
 * <p>
 * The file is assumed to exist in the current directory (AKA folder).
 * 
 * @author The Infrastructure Team
 */
public class FileUtils {

    private final static String DEFAULT_PATH = ".";

    /**
     * Returns a fixed-size array of String objects that represent each line of the file.
     */
    public static  String[] read(String filename) {
        Scanner sc = null;
        filename = DEFAULT_PATH + "/" + filename;
        
        // allocate the fixed-size array to return
        int num = numLines(filename);
        String[] lines = new String[num];

        // initialize the scanner
        try {
            File file = new File(filename);
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
  
        // populate the array with lines from the file
        int i = 0;
        while (sc.hasNext()) {
            lines[i++] = sc.nextLine();
        }
        return lines;
    }
    
    public static double[] readRealValues(String filename) {
    	String[] lines = read(filename);
    	
    	double[] values = new double[lines.length];
    	for (int i = 0; i < lines.length; i++) {
    		values[i] = Double.parseDouble(lines[i]);
    	}
    	return values;
    }

    /**
     * Returns the number of lines in the given file.
     */
    private static int numLines(String fullFileName) {
        File file = new File(fullFileName);
        Scanner sc = null;
        int num = 0;
        
        // create the Scanner object, passing in the file
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // loop over each line in the file to count the number of lines
        while (sc.hasNext()) {
            num++;
            sc.nextLine();
        }
        return num;
    }

}