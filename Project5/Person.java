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
public class Person {
	private String name;
	private String address;
	public Person(String name, String address) {
		this.name = name;
		this.address = address;
	}
	public void setName(String name) {
		this.name = name;
		return;
	}
	public void setAddress(String address) {
		this.address = address;
		return;
	}
	public String getName() {
		return this.name;
	}
	public String getAddress() {
		return this.address;
	}
	@Override
	public String toString() {
		return this.name + " " + this.address;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj != null) {
			if (this == obj) {
				return true;
			}
			else if (obj instanceof Person) {
				Person other = (Person) obj;
				return (this.name.equals(other.getName()) && this.address.equals(other.getAddress()));
			}
		}
		return false;
	}
}