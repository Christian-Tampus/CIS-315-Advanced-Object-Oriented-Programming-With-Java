package edu.una.csis;
/**
 * Assignment: Program 8 | Factory Method
 * Instructions: Follow the uml diagram
 * Design Notes: Follow the uml diagram
 * Version: 1.0, 11/11/2025
 * @author: Christian Tampus
 * Class: CIS-315
 */
import java.util.List;
public interface ClassFactory {
	public CollegeClass fetchClass(int id);
	public List<CollegeClass> fetchAllClasses();
}