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
public class Gamer extends Person {
	private int numOfGamesPlayed;
	private ArrayList<String> gameCodesList;
	private ArrayList<Double> gameScoresList;
	private static int maxNumOfGamesAllowed = 20;
	public Gamer(String name, String address) {
		super(name,address);
		this.numOfGamesPlayed = 0;
		this.gameCodesList = new ArrayList<String>();
		this.gameScoresList = new ArrayList<Double>();
	}
	public void addGameScore(String gameCode, double gameScore) {
		if (this.numOfGamesPlayed >= Gamer.maxNumOfGamesAllowed) {
			return;
		}
		this.gameCodesList.add(gameCode);
		this.gameScoresList.add(gameScore);
		this.numOfGamesPlayed++;
		return;
	}
	public void printScore() {
		for (int index = 0; index < this.numOfGamesPlayed; index++) {
			System.out.println(this.gameCodesList.get(index) + " " + this.gameScoresList.get(index));
		}
		return;
	}
	public double getAverageScore() {
		double totalScore = 0;
		for (Double score : this.gameScoresList) {
			totalScore += score;
		}
		return (totalScore / this.numOfGamesPlayed);
	}
	public static void setMaxNumOfGamesAllowed(int maxNumOfGamesAllowed) {
		Gamer.maxNumOfGamesAllowed = (maxNumOfGamesAllowed >= 0 ? maxNumOfGamesAllowed : Gamer.maxNumOfGamesAllowed);
		return;
	}
	public static int getMaxNumOfGamesAllowed() {
		return Gamer.maxNumOfGamesAllowed;
	}
}