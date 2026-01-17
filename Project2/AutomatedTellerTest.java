import java.util.Scanner;
import com.bibank.Checking;
/**
 * Assignment: Program 2 | ATM
 * Instructions: A program to be able to deposit and withdraw from a checking account that also displays the information
 * Design Notes: Implemented try/catch exception handling for the user inputs
 * Version: 1.0, 9/11/2025
 * Author: Christian Tampus
 * Class: CIS-315
 **/
public class AutomatedTellerTest
{
	public static int tryCatch(String currentUserInput)
	{
		try
		{
			int parseInt = Integer.parseInt(currentUserInput);
			return parseInt;
		}
		catch (Exception error)
		{
			return 0;
		}
	}
	public static void displayMenu()
	{
		System.out.println("Menu");
		System.out.println("================");
		System.out.println("1. Deposit");
		System.out.println("2. Withdraw");
		System.out.println("3. Exit\n");
		return;
	}
	public static void getUserInput(Scanner currentScanner, Checking currentChecking)
	{
		System.out.print("[SYSTEM MESSAGE] Enter Menu Selection: ");
		String currentUserInput = currentScanner.nextLine();
		int tryCatchResult = tryCatch(currentUserInput);
		switch(tryCatchResult)
		{
			case 1:
				System.out.print("[SYSTEM MESSAGE] Amount To Deposit: $");
				currentUserInput = currentScanner.nextLine();
				tryCatchResult = tryCatch(currentUserInput);
				System.out.println("[SYSTEM MESSAGE] Deposit Amount: $" + tryCatchResult);
				currentChecking.deposit(tryCatchResult);
				System.out.println("[SYSTEM MESSAGE] " + currentChecking.toString() + "\n");
				break;
			case 2:
				System.out.print("[SYSTEM MESSAGE] Amount To Withdraw: $");
				currentUserInput = currentScanner.nextLine();
				tryCatchResult = tryCatch(currentUserInput);
				System.out.println("[SYSTEM MESSAGE] Withdraw Amount: $" + tryCatchResult);
				System.out.println("[SYSTEM MESSAGE] Here Is Your Money: $" + currentChecking.withdraw(tryCatchResult));
				System.out.println("[SYSTEM MESSAGE] " + currentChecking.toString() + "\n");
				break;
			case 3:
				System.out.println("[SYSTEM MESSAGE] Goodbye!");
				break;
			default:
				System.out.println("[SYSTEM ERROR] Invalid Input, Try Again!\n");
				break;
		}
		if (tryCatchResult != 3)
		{
			getUserInput(currentScanner,currentChecking);
		}
		return;
	}
	public static void main(String[] args)
	{
		Scanner newScanner = new Scanner(System.in);
		Checking newChecking = new Checking("A123",100);
		displayMenu();
		getUserInput(newScanner,newChecking);
		return;
	}
}