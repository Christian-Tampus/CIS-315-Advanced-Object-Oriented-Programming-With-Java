package com.podcatcher;
/**
 * Assignment: Program 3 | Podcast
 * Instructions: A Podcast system that allows applications to manage podcasts
 * Design Notes: Added constants (final), input validation for Podcast() & setFollowers(), added a test for if a podcast is popular
 * Version: 1.0, 9/15/2025
 * Author: Christian Tampus
 * Class: CIS-315
 **/
public class Podcast {
	private final int POPULAR_FOLLOWERS_THRESHOLD = 10000;
	private String title;
	private String producer;
	private int followers;
	private boolean allContentFree;
	public Podcast() {
		this.title = "";
		this.producer = "";
		this.followers = 0;
		this.allContentFree = true;
	}
	public Podcast(String title, String producer) {
		this.title = title;
		this.producer = producer;
		this.followers = 0;
		this.allContentFree = true;
	}
	public Podcast(String title, String producer, int follows, boolean free) {
		this.title = title;
		this.producer = producer;
		this.followers = (follows >= 0 ? follows : 0);
		this.allContentFree = free;
	}
	public String getTitle() {
		return this.title;
	}
	public String getProducer() {
		return this.producer;
	}
	public int getFollowers() {
		return this.followers;
	}
	public boolean isAllContentFree() {
		return this.allContentFree;
	}
	public void setFollowers(int number) {
		this.followers = (number >= 0 ? number : this.followers);
	}
	public void setAllContentFree(boolean flag) {
		this.allContentFree = flag;
	}
	public boolean isPopular() {
		return (this.allContentFree == false && this.followers > POPULAR_FOLLOWERS_THRESHOLD);
	}
	//toString() method returns a String that contains all fields with each field separated by a single space
	public String toString() {
		return this.title + " " + this.producer + " " + this.followers + " " + this.allContentFree;
	}
}