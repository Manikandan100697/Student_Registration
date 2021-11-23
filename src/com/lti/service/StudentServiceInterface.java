package com.lti.service;

import com.lti.bean.Student;

public interface StudentServiceInterface {
	
	public void addCourse(int courseId, Student student);
	public void dropCourse(int courseId,Student student);
	public void displaySelectedCourses(Student student);
}
