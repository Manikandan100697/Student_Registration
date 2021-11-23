package com.lti.service;

import com.lti.bean.Student;
/** 
 * @desc this interface is implemented by GradeServiceOperation class
 * @author Manikandan 
 */
public interface GradeServiceInterface {
	public void displayGrades(Student student);
	public void uploadGrades(int studentId, int courseId, String grade);
}
