package edu.univ.dept;
import java.lang.Comparable;
import java.io.Serializable;
/**
 * Assignment: Program 9 | Instructor Factory
 * Instructions: Follow the uml diagram
 * Design Notes: Follow the uml diagram
 * Version: 1.0, 11/19/2025
 * @author: Christian Tampus
 * Class: CIS-315
 */
public class Instructor implements Comparable<Instructor>, Serializable {
	private int id;
	private int courseId;
	private String firstName;
	private String lastName;
	public Instructor() {
		this.id = Integer.MIN_VALUE;
		this.courseId = Integer.MIN_VALUE;
		this.firstName = "";
		this.lastName = "";
	}
	public void setId(int id) {
		this.id = id;
		return;
	}
	public int getId() {
		return this.id;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
		return;
	}
	public int getCourseId() {
		return this.courseId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		return;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
		return;
	}
	public String getLastName() {
		return this.lastName;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (obj instanceof Instructor) {
			Instructor other = (Instructor) obj;
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
		return this.lastName + ", " + this.firstName + " [" + this.id + "] teaches (" + this.courseId + ")";
	}
	@Override
	public int compareTo(Instructor other) {
		return this.lastName.compareTo(other.lastName);
	}
}