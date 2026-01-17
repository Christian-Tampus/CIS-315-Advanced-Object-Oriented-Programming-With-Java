import java.util.ArrayList;
/**
 * Assignment: Program 4 | BankingSystem
 * Instructions: A banking system designed to read in 3 files and use ArrayLists to store the data and use them to create an ArrayList of BankAccounts
 * Design Notes: No additional design changes were added
 * Version: 1.0, 10/2/2025
 * Author: Christian Tampus
 * Class: CIS-315
 **/
public class CollectionUtils {
	public static ArrayList<Double> arrayToList(double[] array) {
		ArrayList<Double> doubleArrayList = new ArrayList<Double>();
		for (int index = 0; index < array.length; index++) {
			doubleArrayList.add(array[index]);
		}
		return doubleArrayList;
	}
	public static ArrayList<String> arrayToList(String[] array) {
		ArrayList<String> stringArrayList = new ArrayList<String>();
		for (int index = 0; index < array.length; index++) {
			stringArrayList.add(array[index]);
		}
		return stringArrayList;
	}
}
