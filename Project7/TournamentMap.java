import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import org.nit.Team;
/**
 * Assignment: Program 7 | NIT Tournament
 * Instructions: Create an interactive, command line application that creates Team objects from a database (flat file) and allows the end-user to list all teams in the tournament and get the details on any specified team.
 * Design Notes: Added extra menu prompt for l[ookup] team details so that the user can continue to lookup specific team names until they are ready to return back to the start main menu by entering [back].
 * Version: 1.0, 11/3/2025
 * Author: Christian Tampus
 * Class: CIS-315
 **/
public class TournamentMap {
	//Testing around with StringWriter & PrintWriter classes, made it private for testing purposes
	private static final StringWriter STRING_WRITER = new StringWriter();
	private static final PrintWriter PRINT_WRITER = new PrintWriter(STRING_WRITER);
	public static void main (String[] args) {
		final String ERROR_STRING = "[SYSTEM MESSAGE] User Input Error, Please Try Again!";
		List<Team> teamList = new ArrayList<Team>();
		Map<String, Team> teamMap = new HashMap<String, Team>();
		TournamentMap.populateList(teamList,"2025_NIT.csv");
		TournamentMap.populateMap(teamMap,teamList);
		Scanner userInputScanner = new Scanner(System.in);
		String userInput = "";
		PRINT_WRITER.println("Menu");
		PRINT_WRITER.println("=====================");
		PRINT_WRITER.println("d[isplay] all teams");
		PRINT_WRITER.println("l[ookup] team details");
		PRINT_WRITER.println("q[uit]");
		do {
			TournamentMap.displayMenu();
			userInput = userInputScanner.nextLine();
			userInput = userInput.toLowerCase();
			//This is strongly specific to make sure that the user actually inputs "display" and not something like "d[*] where '*' is any character for any 'n' amount"
			//We could use regular expressions (regex) however this is outside the scope of this assignment
			if (userInput.equals("d") || userInput.equals("display")) {
				String displayString = "[";
				for (Team team : teamList) {
					displayString += team.getName() + ", ";
				}
				displayString = displayString.substring(0,displayString.length() - 2) + "]";
				System.out.println(displayString);
			//This is strongly specific to make sure that the user actually inputs "lookup" and not something like "l[*] where '*' is any character for any 'n' amount"
			//We could use regular expressions (regex) however this is outside the scope of this assignment
			} else if (userInput.equals("l") || userInput.equals("lookup")) {
				do {
					System.out.print("Please Enter Team Name (Example: North Alabama) To Look Up Or Enter [back] To Return To Main Menu:");
					userInput = userInputScanner.nextLine();
					if (userInput.equals("back")) {
						break;
					}
					if (teamMap.containsKey(userInput)) {
						Team team = teamMap.get(userInput);
						System.out.println(team.getSeed());
						System.out.println(team.getName());
						System.out.println(team.getFullName() + " from the " + team.getConference() + " Short Conference Name: (" + team.getConfShort() + ") Coach: " + team.getCoach());
					} else {
						System.out.println(ERROR_STRING);
					}
				} while (true);
			//This is strongly specific to make sure that the user actually inputs "quit" and not something like "q[*] where '*' is any character for any 'n' amount"
			//We could use regular expressions (regex) however this is outside the scope of this assignment
			} else if (!userInput.equals("q") && !userInput.equals("quit")) {
				System.out.println(ERROR_STRING);
			}
		//This is strongly specific to make sure that the user actually inputs "quit" and not something like "q[*] where '*' is any character for any 'n' amount"
		//We could use regular expressions (regex) however this is outside the scope of this assignment
		} while (!userInput.equals("q") && !userInput.equals("quit"));
		userInputScanner.close();
		System.out.println("[SYSTEM MESSAGE] Program Terminated...");
	}
	private static void displayMenu() {
		/*
		ORIGINAL CODE:
		System.out.println("Menu");
		System.out.println("=====================");
		System.out.println("d[isplay] all teams");
		System.out.println("l[ookup] team details");
		System.out.println("q[uit]");
		 */
		System.out.print(TournamentMap.STRING_WRITER.toString());
		return;
	}
	private static void populateMap(Map<String, Team> map, List<Team> list) {
		for (Team team : list) {
			map.put(team.getName(),team);
		}
		return;
	}
	private static void populateList(List<Team> list, String fileName) {
		for (Team team : TournamentMap.readFile(fileName)) {
			list.add(team);
		}
		return;
	}
	private static ArrayList<Team> readFile(String fileName) {
		ArrayList<Team> teamList = new ArrayList<Team>();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
			boolean firstLine = true;
			while (bufferedReader.ready()) {
				if (firstLine == false) {
					String teamDataStringLine = bufferedReader.readLine();
					StringTokenizer stringTokenizer = new StringTokenizer(teamDataStringLine,",");
					//Skip Season
					stringTokenizer.nextToken();
					//Get all data tokens, IMPORTANT! the order of which is important when getting the nextToken()!
					String confShort = stringTokenizer.nextToken();
					String conference = stringTokenizer.nextToken();
					String name = stringTokenizer.nextToken();
					String coach = stringTokenizer.nextToken();
					String fullName = stringTokenizer.nextToken();
					String seed = stringTokenizer.nextToken();
					//add to teamlist
					teamList.add(new Team(name,fullName,confShort,conference,coach,seed));
				} else {
					//Skip header
					bufferedReader.readLine();
					firstLine = false;
				}
			}
			bufferedReader.close();
		} catch (FileNotFoundException error) {
			System.out.println("[SYSTEM ERROR] FileNotFoundException:");
			error.printStackTrace();
		} catch (IOException error) {
			System.out.println("[SYSTEM ERROR] IOException:");
			error.printStackTrace();
		}
		return teamList;
		/*
		ORIGINAL CODE:
		ArrayList<Team> teamList = new ArrayList<Team>();
		File inputFile = new File(fileName);
		try {
			Scanner fileScanner = new Scanner(inputFile);
			//Skip header
			fileScanner.nextLine();
			while (fileScanner.hasNextLine()) {
				String teamDataStringLine = fileScanner.nextLine();
				//Split teamDataStringLine via ',' delimiter, teamDataArray should always have length of 7
				String[] teamDataArray = teamDataStringLine.split(",");
				//Skip teamDataArray[0] since that is the season and we do not have a season String field for the Team() constructor
				teamList.add(new Team(teamDataArray[3],teamDataArray[5],teamDataArray[1],teamDataArray[2],teamDataArray[4],teamDataArray[6]));
			}
			//close scanner
			fileScanner.close();
		}
		catch (FileNotFoundException error) {
			throw new RuntimeException(error);
		}
		return teamList;
		*/
	}
}