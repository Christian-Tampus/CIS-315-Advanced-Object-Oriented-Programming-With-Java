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
public class TestGameData {
	public static void main(String[] args) {
		System.out.println("[SYSTEM MESSAGE] Program Start!\n");
		String[] gameCodesArray = {"FortN","Galax","MineC","Game4","Game5","Game6WhichShouldNotBeAddedIntoTournamentHost"};
		double[] gameScoresArray = {970.0,680.0,123.0,456.0,789.0,101112.0};
		Gamer gamer1 = new Gamer("Alan Smith","FLORENCE");
		Gamer gamer2 = new Gamer("Alan Smith","FLORENCE");
		Gamer gamer3 = new Gamer("Pam Greene","ATLANTA");
		for (int index = 0; index < gameCodesArray.length; index++) {
			gamer1.addGameScore(gameCodesArray[index],gameScoresArray[index]);
		}
		System.out.println(gamer1);
		System.out.println("[SYSTEM MESSAGE] Games gamer1(" + gamer1 + ") Has Played:");
		gamer1.printScore();
		System.out.println(gamer1.getAverageScore()+"\n");
		TournamentHost tournamentHost1 = new TournamentHost("Pam Greene","ATLANTA");
		TournamentHost tournamentHost2 = new TournamentHost("Pam Greene","ATLANTA");
		TournamentHost tournamentHost3 = new TournamentHost("Alan Smith","FLORENCE");
		System.out.println(tournamentHost1);
		System.out.println("\n[SYSTEM MESSAGE] Testing addGame() To tournamentHost1 (First Attempt):\n");
		for (int index = 0; index < gameCodesArray.length; index++) {
			if (tournamentHost1.addGame(gameCodesArray[index])) {
				System.out.println(gameCodesArray[index] + " added");
			}
			else {
				System.out.println(gameCodesArray[index] + " cannot be added");
			}
		}
		System.out.println("\n[SYSTEM MESSAGE] Testing addGame() To tournamentHost1 (Second Attempt):\n");
		for (int index = 0; index < gameCodesArray.length; index++) {
			if (tournamentHost1.addGame(gameCodesArray[index])) {
				System.out.println(gameCodesArray[index] + " added");
			}
			else {
				System.out.println(gameCodesArray[index] + " cannot be added");
			}
		}
		System.out.println("\n[SYSTEM MESSAGE] Testing removeGame() From tournamentHost1 (First Attempt):\n");
		for (int index = 0; index < gameCodesArray.length; index++) {
			if (tournamentHost1.removeGame(gameCodesArray[index])) {
				System.out.println(gameCodesArray[index] + " removed");
			}
			else {
				System.out.println(gameCodesArray[index] + " cannot be removed");
			}
		}
		System.out.println("\n[SYSTEM MESSAGE] Testing addGame() To TournamentHost tournamentHost1 (Second Attempt):\n");
		for (int index = 0; index < gameCodesArray.length; index++) {
			if (tournamentHost1.removeGame(gameCodesArray[index])) {
				System.out.println(gameCodesArray[index] + " removed");
			}
			else {
				System.out.println(gameCodesArray[index] + " cannot be removed");
			}
		}
		if (tournamentHost1.removeGame("ThisGameIsNotInTheList")) {
			System.out.println("ThisGameIsNotInTheList removed");
		}
		else {
			System.out.println("ThisGameIsNotInTheList cannot be removed");
		}
		System.out.println("\n[SYSTEM MESSAGE] Testing equals():\n");
		System.out.println("> gamer1.equals(null) => [" + gamer1 + "].equals(null) => " + gamer1.equals(null));
		System.out.println("> tournamentHost1.equals(null) => [" + tournamentHost1 + "].equals(null) => " + tournamentHost1.equals(null));
		/**
		 * NOTE: NotPerson class can easily be removed, it is simply here for testing purposes!!! (code below)
		 **/
		NotPerson notPerson1 = new NotPerson();
		System.out.println("> gamer1.equals(notPerson1) => [" + gamer1 + "].equals(notPerson1) => " + gamer1.equals(notPerson1));
		System.out.println("> tournamentHost1.equals(notPerson1) => [" + tournamentHost1 + "].equals(notPerson1) => " + tournamentHost1.equals(notPerson1));
		/**
		 * NOTE: NotPerson class can easily be removed, it is simply here for testing purposes!!! (code above)
		 **/
		System.out.println("> gamer1.equals(gamer1) => [" + gamer1 + "].equals(" + gamer1 + ") => " + gamer1.equals(gamer1));
		System.out.println("> tournamentHost1.equals(tournamentHost1) => [" + tournamentHost1 + "].equals(" + tournamentHost1 + ") => " + tournamentHost1.equals(tournamentHost1));
		System.out.println("> gamer1.equals(gamer2) => [" + gamer1 + "].equals(" + gamer2 + ") => " + gamer1.equals(gamer2));
		System.out.println("> gamer1.equals(gamer3) => [" + gamer1 + "].equals(" + gamer3 + ") => " + gamer1.equals(gamer3));
		System.out.println("> tournamentHost1.equals(tournamentHost2) => [" + tournamentHost1 + "].equals(" + tournamentHost2 + ") => " + tournamentHost1.equals(tournamentHost2));
		System.out.println("> tournamentHost1.equals(tournamentHost3) => [" + tournamentHost1 + "].equals(" + tournamentHost3 + ") => " + tournamentHost1.equals(tournamentHost3));
		System.out.println("> gamer1.equals(tournamentHost2) => [" + gamer1 + "].equals(" + tournamentHost2 + ") => " + gamer1.equals(tournamentHost2));
		System.out.println("> gamer1.equals(tournamentHost3) => [" + gamer1 + "].equals(" + tournamentHost3 + ") => " + gamer1.equals(tournamentHost3));
		System.out.println("> tournamentHost1.equals(gamer2) => [" + tournamentHost1 + "].equals(" + gamer2 + ") => " + tournamentHost1.equals(gamer2));
		System.out.println("> tournamentHost1.equals(gamer3) => [" + tournamentHost1 + "].equals(" + gamer3 + ") => " + tournamentHost1.equals(gamer3));
		System.out.println("\n[SYSTEM MESSAGE] Program Terminated...");
	}
}