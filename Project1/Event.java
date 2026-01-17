/*
 * Assignment: Program 1 | Event
 * Instructions: Prompts The End-User For The Event Start & End Times (Hours And Minutes) Then Displays It To The Screen.
 * Design Notes: Implemented Basic User Input Validation To Prevent Invalid Inputs For The Hours, Minutes & Label (AM & PM Only)
 * Version: 1.0, 8/27/2025
 * Author: Christian Tampus
 * Class: CIS-315
 */
import java.util.Scanner;
public class Event
{
	public static void main(String[] args)
	{
		//Variables
		Clock eventStartClock = new Clock();
		Clock eventEndClock = new Clock();
		Scanner userInputScanner = new Scanner(System.in);
		String hoursPromptText = "[SYSTEM MESSAGE] Please Enter The Time For Hours [1-12]:";
		String minutesPromptText = "[SYSTEM MESSAGE] Please Enter The Time For Minutes [0-59]:";
		String labelPromptText = "[SYSTEM MESSAGE] Please Enter The Label [AM Or PM]:";
		String invalidInputPromptText = "[SYSTEM ERROR] Invalid Input!";
		int hours;
		int minutes;
		String label;
		//Get Input For Start Hours
		System.out.println("[SYSTEM MESSAGE] Program Start!");
		System.out.println("[SYSTEM MESSAGE] Please Enter The Start Time:");
		System.out.println(hoursPromptText);
		hours = Integer.parseInt(userInputScanner.nextLine());
		//Basic Input Validation For Start Hours
		while(hours < 1 || hours > 12)
		{
			System.out.println(invalidInputPromptText);
			System.out.println(hoursPromptText);
			hours = Integer.parseInt(userInputScanner.nextLine());
		};
		//Get Input For Start Minutes
		System.out.println(minutesPromptText);
		minutes = Integer.parseInt(userInputScanner.nextLine());
		//Basic Input Validation For Start Minutes
		while(minutes < 0 || minutes > 59)
		{
			System.out.println(invalidInputPromptText);
			System.out.println(minutesPromptText);
			minutes = Integer.parseInt(userInputScanner.nextLine());
		};
		//Get Input For Start Label
		System.out.println(labelPromptText);
		label = (userInputScanner.nextLine()).toUpperCase();
		//Basic Input Validation For Start Minutes
		while(!label.equals("AM") && !label.equals("PM"))
		{
			System.out.println(invalidInputPromptText);
			System.out.println(labelPromptText);
			label = (userInputScanner.nextLine()).toUpperCase();
		};
		//Set Hours, Minutes & Label For The eventStartClock Object
		eventStartClock.setHours(hours);
		eventStartClock.setMinutes(minutes);
		eventStartClock.setLabel(label);
		//Get Input For End Hours
		System.out.println("[SYSTEM MESSAGE] Please Enter The End Time:");
		System.out.println(hoursPromptText);
		hours = Integer.parseInt(userInputScanner.nextLine());
		//Basic Input Validation For End Hours
		while(hours < 1 || hours > 12)
		{
			System.out.println(invalidInputPromptText);
			System.out.println(hoursPromptText);
			hours = Integer.parseInt(userInputScanner.nextLine());
		};
		//Get Input For End Minutes
		System.out.println(minutesPromptText);
		minutes = Integer.parseInt(userInputScanner.nextLine());
		//Basic Input Validation For End Minutes
		while(minutes < 0 || minutes > 59)
		{
			System.out.println(invalidInputPromptText);
			System.out.println(minutesPromptText);
			minutes = Integer.parseInt(userInputScanner.nextLine());
		};
		//Get Input For End Label
		System.out.println(labelPromptText);
		label = (userInputScanner.nextLine()).toUpperCase();
		//Basic Input Validation For End Minutes
		while(!label.equals("AM") && !label.equals("PM"))
		{
			System.out.println(invalidInputPromptText);
			System.out.println(labelPromptText);
			label = (userInputScanner.nextLine()).toUpperCase();
		};
		//Set Hours, Minutes & Label For The eventEndClock Object
		eventEndClock.setHours(hours);
		eventEndClock.setMinutes(minutes);
		eventEndClock.setLabel(label);
		//Print Time For eventStartClock Object
		System.out.println("[SYSTEM MESSAGE] Your Event Starts At:");
		//Modify The Output To Handle Minutes That Are Less Than Or Equal To 9 By Adding A 0 In Front Of The Minutes
		System.out.println(eventStartClock.getHours() + ":" + (eventStartClock.getMinutes() <= 9 ? "0" + eventStartClock.getMinutes() : eventStartClock.getMinutes()) + " " + eventStartClock.getLabel());
		//Print Time For eventEndClock Object
		System.out.println("[SYSTEM MESSAGE] Your Event Ends At:");
		//Modify The Output To Handle Minutes That Are Less Than Or Equal To 9 By Adding A 0 In Front Of The Minutes
		System.out.println(eventEndClock.getHours() + ":" + (eventEndClock.getMinutes() <= 9 ? "0" + eventEndClock.getMinutes() : eventEndClock.getMinutes()) + " " + eventEndClock.getLabel());
		//Close The Scanner
		userInputScanner.close();
		System.out.println("[SYSTEM MESSAGE] Program Terminated...");
	};
};