package com.bibank;
/**
 * Assignment: Program 2 | ATM
 * Instructions: A program to be able to deposit and withdraw from a checking account that also displays the information
 * Design Notes: Implemented try/catch exception handling for the user inputs
 * Version: 1.0, 9/11/2025
 * Author: Christian Tampus
 * Class: CIS-315
 **/
public class Checking
{
	private String id;
	private double balance;
	public Checking(String id)
	{
		this.id = id;
		this.balance = 0;
	}
	public Checking(String id, double balance)
	{
		this.id = id;
		this.balance = balance;
	}
	public String getId()
	{
		return this.id;
	}
	public double getBalance()
	{
		return this.balance;
	}
	public double withdraw(double amount)
	{
		this.balance -= (amount <= this.balance && amount >= 0 ? amount : 0);
		return (amount <= this.balance && amount >= 0 ? amount : 0);
	}
	public void deposit(double amount)
	{
		this.balance += (amount >= 0 ? amount : 0);
		return;
	}
	public String toString()
	{
		return "Checking Id: " + this.id + "; Checking Balance: " + this.balance;
	}
}