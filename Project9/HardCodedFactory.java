package edu.univ.dept;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
/**
 * Assignment: Program 9 | Instructor Factory
 * Instructions: Follow the uml diagram
 * Design Notes: Follow the uml diagram
 * Version: 1.0, 11/19/2025
 * @author: Christian Tampus
 * Class: CIS-315
 */
public class HardCodedFactory implements InstructorFactory {
	private List<Instructor> instructorsList;
	//THIS IS EXTRA STUFF FOR ADDED FUNCTIONALITY
	public HardCodedFactory() {
		this.instructorsList = new ArrayList<Instructor>();
	}
	//THIS IS EXTRA STUFF FOR ADDED FUNCTIONALITY
	public HardCodedFactory(int numOfInstructors) {
		this.instructorsList = new ArrayList<Instructor>();
		if (numOfInstructors >= 1) {
			for (int id = 1; id <= numOfInstructors; id++) {
				Instructor newInstructor = new Instructor();
				newInstructor.setId(id);
				newInstructor.setCourseId(id);
				newInstructor.setLastName("LastName_" + id);
				newInstructor.setFirstName("FirstName_" + id);
				this.instructorsList.add(newInstructor);
			}
		}
	}
	@Override
	public Instructor fetchInstructor(int id) throws InstructorException {
		Instructor currentInstructor = null;
		for (int index = 0; index < this.instructorsList.size(); index++) {
			if (this.instructorsList.get(index).getId() == id) {
				currentInstructor = this.instructorsList.get(index);
				break;
			}
		}
		if (currentInstructor == null) {
			throw new InstructorException("[SYSTEM ERROR] HardCodedFactory Instructor Id: " + id + " Not Found!");
		}
		return currentInstructor;
	}
	@Override
	public List fetchInstructors() throws InstructorException {
		if (this.instructorsList.size() == 0) {
			throw new InstructorException("[SYSTEM ERROR] HardCodedFactory No Instructors Found!");
		}
		Collections.sort(this.instructorsList);
		return this.instructorsList;
	}
}