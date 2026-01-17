package edu.una.csis;
/**
 * Assignment: Program 8 | Factory Method
 * Instructions: Follow the uml diagram
 * Design Notes: Follow the uml diagram
 * Version: 1.0, 11/11/2025
 * @author: Christian Tampus
 * Class: CIS-315
 */
import java.lang.Comparable;
import java.io.Serializable;
public class CollegeClass implements Comparable<CollegeClass>, Serializable {
	private int id;
	private int instructorId;
	private String name;
	private int hours;
	public CollegeClass() {
		this.id = -1;
		this.instructorId = -1;
		this.name = "";
		this.hours = -1;
	}
	public void setId(int id) {
		this.id = id;
		return;
	}
	public int getId() {
		return this.id;
	}
	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
		return;
	}
	public int getInstructorId() {
		return this.instructorId;
	}
	public void setName(String name) {
		this.name = name;
		return;
	}
	public String getName() {
		return this.name;
	}
	public void setHours(int hours) {
		this.hours = hours;
		return;
	}
	public int getHours() {
		return this.hours;
	}
	@Override
	public int compareTo(CollegeClass other) {
		return this.name.compareTo(other.name);
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (obj instanceof CollegeClass) {
			CollegeClass other = (CollegeClass) obj;
			return this.id == other.id;
		}
		return false;
	}
	@Override
	public int hashCode() {
		return this.id;
	}
	@Override
	public String toString() {
		return this.name + "(" + this.hours + ") taught by " + this.instructorId + "[" + this.id + "]";
	}
}