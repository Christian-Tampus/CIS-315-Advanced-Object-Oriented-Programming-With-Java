import java.util.ArrayList;
/**
 * Assignment: Program 4 | BankingSystem
 * Instructions: A banking system designed to read in 3 files and use ArrayLists to store the data and use them to create an ArrayList of BankAccounts
 * Design Notes: No additional design changes were added
 * Version: 1.0, 10/2/2025
 * Author: Christian Tampus
 * Class: CIS-315
 **/
public class BankingApp {
	private static ArrayList<BankAccount> loadAccounts(ArrayList<String> names, ArrayList<Double> checking, ArrayList<Double> savings){
		ArrayList<BankAccount> bankAccountArrayList = new ArrayList<BankAccount>();
		for (int index = 0; index < names.size(); index++) {
			bankAccountArrayList.add(new BankAccount(names.get(index), checking.get(index), savings.get(index)));
		}
		return bankAccountArrayList;
	}
	public static void main(String[] args) {
		// TODO: call FileUtils to get data from names, checking, savings
		String[] names = FileUtils.read("names.txt");
		double[] checking = FileUtils.readRealValues("checking.txt");
		double[] savings = FileUtils.readRealValues("savings.txt");
		// TODO: convert primitive arrays to Lists
		ArrayList<String> namesArrayList = CollectionUtils.arrayToList(names);
		ArrayList<Double> checkingArrayList = CollectionUtils.arrayToList(checking);
		ArrayList<Double> savingsArrayList = CollectionUtils.arrayToList(savings);
		// TODO: call loadAccounts passing all three Lists
		ArrayList<BankAccount> bankAccountArrayList = loadAccounts(namesArrayList,checkingArrayList,savingsArrayList);
		// TODO: display all account information (a la 9.21)
		System.out.println("--------------------------------");
		System.out.println("DISPLAY ALL ACCOUNT INFORMATION!");
		System.out.println("--------------------------------\n");
		for (int index = 0; index < bankAccountArrayList.size(); index++) {
			System.out.println(bankAccountArrayList.get(index).getName());
			System.out.printf("$%.2f\n", bankAccountArrayList.get(index).getChecking());
			System.out.printf("$%.2f\n\n", bankAccountArrayList.get(index).getSavings());
		}
		// TODO: transfer $100 from checking to savings within each object
		for (int index = 0; index < bankAccountArrayList.size(); index++) {
			bankAccountArrayList.get(index).transferToSavings(100);
		}
		System.out.println("------------------------------------------");
		System.out.println("TRANSFER $100.00 FROM CHECKING TO SAVINGS!");
		System.out.println("------------------------------------------\n");
		// TODO: display all account information (a la 9.21)
		for (int index = 0; index < bankAccountArrayList.size(); index++) {
			System.out.println(bankAccountArrayList.get(index).getName());
			System.out.printf("$%.2f\n", bankAccountArrayList.get(index).getChecking());
			System.out.printf("$%.2f\n\n", bankAccountArrayList.get(index).getSavings());
		}
	}
}