package com.lti.service;

import com.lti.bean.Student;

public interface GradeServiceInterface {
	public void displayGrades(Student student);
	public void uploadGrades(int studentId, int courseId, String grade);
}
