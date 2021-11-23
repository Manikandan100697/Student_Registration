package com.lti.service;

import com.lti.bean.Professor;

public interface ProfessorServiceInterface {
	public void selectCourse(int courseId ,Professor professor);
	public void deselectCourse(int courseId, Professor professor);
	public void displaySelectedCoursesProfessor(Professor professor);
}
