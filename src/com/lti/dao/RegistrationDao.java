package com.lti.dao;

import java.util.List;

import com.lti.bean.Notification;
import com.lti.bean.Student;


public interface RegistrationDao {
	public boolean numberOfCoursesSelected (Student student);
	public void submitRegistration (Student student);
	public void generateRegistrationReciept(Student student, double payableAmount, int payModeId);
	public Notification showRegistrationReciept(Student student);
	public List<Integer> displayRegisteredStudentsInCourse(int courseId);
}
