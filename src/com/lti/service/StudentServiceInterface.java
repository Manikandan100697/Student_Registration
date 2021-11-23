package com.lti.service;

import com.lti.bean.Student;
/** 
 * @desc this interface is implemented by StudentServiceOperation class
 * @author Manikandan 
 */
public interface StudentServiceInterface {
	
	public void addCourse(int courseId, Student student);
	public void dropCourse(int courseId,Student student);
	public void displaySelectedCourses(Student student);
}
