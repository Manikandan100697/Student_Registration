package com.lti.service;

import com.lti.bean.Student;

public interface RegistrationServiceInterface {
public boolean checkCourseSelectionStatus(Student student);
	
	public void submitRegistration (Student student);
	
	public void generateRegistrationReciept(Student student, double payableAmount, int payModeId);
	public void displayRegisteredStudentsInCourse(int courseId);

}
