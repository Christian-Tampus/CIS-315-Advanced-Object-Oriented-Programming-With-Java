/**
 * Assignment: Program 5 | Summit
 * Instructions:
 * -Create four classes Person (Parent), Gamer (Child), TournamentHost (Child), TestGameData (Driver)
 * -All classes override toString() and returns the name and address with a space in between
 * -Person class includes private name & address, a constructor that accepts name & address as inputs, getters & setters, and equals is overridden to check if name and address are the same
 * -Gamer class includes the number of games played, game codes, game scores, a constructor that accepts name & address as inputs, a class variable for max number of games allowed, addGameScore(), printScore(), getAverageScore() methods
 * -TournamentHost class includes number of games played, a constructor that accepts name & address as inputs, a class variable for the max number of games for each tournament, addGame(), removeGame() methods
 * -All classes are inside the com.summit.package
 * -TestGameData has one main method and tests the functionality of all the methods for all the classes
 * Design Notes:
 * -addGameScore() checks to make sure the numOfGamesPlayed is less than the maxNumOfGamesAllowed for the Gamer class
 * -added a getter & setter for the class variable maxNumOfGamesAllowed for the Gamer class
 * -addGame() checks to make sure numOfGamesPlayed is less than the maxNumOfGamesAllowed
 * -added a getter & setter for the class variable maxNumOfGamesAllowed for the TournamentHost class for the TournamentHost class
 * -setter for the maxNumOfGamesAllowed variables only allow it to be set to a number that is >= 0
 * -addded NotPerson class to test .equals() method
 * Version: 1.0, 10/13/2025
 * Author: Christian Tampus
 * Class: CIS-315
 **/
package com.summit;
import java.util.ArrayList;
public class TournamentHost extends Person {
	private int numOfGamesPlayed;
	private ArrayList<String> gameCodesList;
	private static int maxNumOfGamesAllowed = 5;
	public TournamentHost(String name, String address) {
		super(name,address);
		this.numOfGamesPlayed = 0;
		this.gameCodesList = new ArrayList<String>();
	}
	public boolean addGame(String gameCode) {
		if (this.gameCodesList.indexOf(gameCode) != -1 || this.numOfGamesPlayed >= TournamentHost.maxNumOfGamesAllowed) {
			return false;
		}
		this.gameCodesList.add(gameCode);
		this.numOfGamesPlayed++;
		return true;
	}
	public boolean removeGame(String gameCode) {
		if (this.gameCodesList.indexOf(gameCode) == -1) {
			return false;
		}
		this.gameCodesList.remove(this.gameCodesList.indexOf(gameCode));
		this.numOfGamesPlayed--;
		return true;
	}
	public static void setMaxNumOfGamesAllowed(int maxNumOfGamesAllowed) {
		TournamentHost.maxNumOfGamesAllowed = (maxNumOfGamesAllowed >= 0 ? maxNumOfGamesAllowed : TournamentHost.maxNumOfGamesAllowed);
		return;
	}
	public static int getMaxNumOfGamesAllowed() {
		return TournamentHost.maxNumOfGamesAllowed;
	}
}