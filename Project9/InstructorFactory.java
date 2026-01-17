package edu.univ.dept;
import java.util.List;
import java.lang.Exception;
/**
 * Assignment: Program 9 | Instructor Factory
 * Instructions: Follow the uml diagram
 * Design Notes: Follow the uml diagram
 * Version: 1.0, 11/19/2025
 * @author: Christian Tampus
 * Class: CIS-315
 */
public interface InstructorFactory {
	public Instructor fetchInstructor(int id) throws InstructorException;
	public List fetchInstructors() throws InstructorException;
}