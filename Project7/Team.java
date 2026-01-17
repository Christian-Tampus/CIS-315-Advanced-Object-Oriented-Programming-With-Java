package org.nit;
/**
 * Assignment: Program 7 | NIT Tournament
 * Instructions: Create an interactive, command line application that creates Team objects from a database (flat file) and allows the end-user to list all teams in the tournament and get the details on any specified team.
 * Design Notes: Added extra menu prompt for l[ookup] team details so that the user can continue to lookup specific team names until they are ready to return back to the start main menu by entering [back].
 * Version: 1.0, 11/3/2025
 * Author: Christian Tampus
 * Class: CIS-315
 **/
public class Team {
	private String name;
	private String fullName;
	private String confShort;
	private String conference;
	private String coach;
	private String seed;
	public Team(String name, String fullName, String confShort, String conference, String coach, String seed) {
		this.name = name;
		this.fullName = fullName;
		this.confShort = confShort;
		this.conference = conference;
		this.coach = coach;
		this.seed = seed;
	}
	public void setName(String name) {
		this.name = name;
		return;
	}
	public String getName() {
		return this.name;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
		return;
	}
	public String getFullName() {
		return this.fullName;
	}
	public void setConfShort(String confShort) {
		this.confShort = confShort;
		return;
	}
	public String getConfShort() {
		return this.confShort;
	}
	public void setConference(String conference) {
		this.conference = conference;
		return;
	}
	public String getConference() {
		return this.conference;
	}
	public void setCoach(String coach) {
		this.coach = coach;
		return;
	}
	public String getCoach() {
		return this.coach;
	}
	public void setSeed(String seed) {
		this.seed = seed;
		return;
	}
	public String getSeed() {
		return this.seed;
	}
	@Override
	public String toString() {
		return this.name + " " + this.fullName + " " + this.confShort + " " + this.conference + " " + this.coach + " " + this.seed;
	}
}