package com.lti.service;

import com.lti.bean.Professor;
/** 
 * @desc this interface is implemented by PaymentServiceOperation class
 * @author Manikandan 
 */
public interface ProfessorServiceInterface {
	public void selectCourse(int courseId ,Professor professor);
	public void deselectCourse(int courseId, Professor professor);
	public void displaySelectedCoursesProfessor(Professor professor);
}
