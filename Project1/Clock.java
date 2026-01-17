/*
 * Assignment: Program 1 | Event
 * Instructions: Prompts The End-User For The Event Start & End Times (Hours And Minutes) Then Displays It To The Screen.
 * Design Notes: Implemented Basic User Input Validation To Prevent Invalid Inputs For The Hours, Minutes & Label (AM & PM Only)
 * Version: 1.0, 8/27/2025
 * Author: Christian Tampus
 * Class: CIS-315
 */
public class Clock
{
	//Variables
	private int hours;
	private int minutes;
	private String label;
	//Default Constructor
	public Clock()
	{
		hours = 0;
		minutes = 0;
		label = "AM";
	};
	//Setter Methods
	public void setHours(int newHours)
	{
		hours = newHours;
	};
	public void setMinutes(int newMinutes)
	{
		minutes = newMinutes;
	};
	public void setLabel(String newLabel)
	{
		label = newLabel;
	};
	//Getter Methods
	public int getHours()
	{
		return hours;
	};
	public int getMinutes()
	{
		return minutes;
	};
	public String getLabel()
	{
		return label;
	};
};