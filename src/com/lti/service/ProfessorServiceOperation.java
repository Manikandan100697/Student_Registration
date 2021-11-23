package com.lti.service;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.dao.ProfessorDao;
import com.lti.dao.ProfessorDaoImpl;

/** 
 * @desc this class will hold functions for Professor service operation
 * examples include selectCourse(int courseId ,Professor professor),deselectCourse(int courseId, Professor professor)
 * @author Manikandan 
 */

public class ProfessorServiceOperation implements ProfessorServiceInterface{

	ProfessorDao professorDao= new ProfessorDaoImpl();

	// select course by professsor
	public void selectCourse(int courseId ,Professor professor){
		professorDao.selectCourse(courseId, professor);
	}

	// deselect course by professor
	public void deselectCourse(int courseId, Professor professor){
		professorDao.deselectCourse(courseId, professor);
	}

	//display list of courses selected by professor
	public void displaySelectedCoursesProfessor(Professor professor){
		System.out.println("********************************LIST OF SELECTED COURSES******************************");	
		System.out.println("COURSE ID      COURSE TITLE                         NUMBER OF STUDENTS ENROLLED");
		List<Course> courses = professorDao.displaySelectedCoursesProfessor(professor);
		courses.forEach(course -> System.out.println(course.getCourseId()+"               "+course.getCourseTitle()+"                               "+course.getStudentsEnrolled()));

		System.out.println("*****************************************************************************************");
	}

	

}

