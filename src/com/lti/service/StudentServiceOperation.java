package com.lti.service;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Student;
import com.lti.dao.StudentDao;
import com.lti.dao.StudentDaoImpl;


public class StudentServiceOperation implements StudentServiceInterface{

	//initializing logger


	StudentDao studentDao= new StudentDaoImpl();

	// add course by student against courseId
	public void addCourse(int courseId, Student student) {
		studentDao.addCourse(courseId, student);
	}

	// drop course by student against courseId
	public void dropCourse(int courseId,Student student) {
		studentDao.dropCourse(courseId, student);
	}

	//display courses selected by student
	public void displaySelectedCourses(Student student) {
		System.out.println("***********************************LIST OF SELECTED COURSES******************************");	
		System.out.println("COURSE ID      COURSE TITLE           		    CREDITS           ");
		List<Course> courses = studentDao.displaySelectedCourses(student);
		courses.forEach(course -> System.out.println(course.getCourseId()+"               "+course.getCourseTitle()+"                    "+course.getCredits()));
		boolean status= student.isRegistrationStatus();
		if(status)
			System.out.println("++++++++++++++++++++++++++++REGISTRATION STATUS: COMPLETED ++++++++++++++++++++++++++++");
		else
			System.out.println("++++++++++++++++++++++++++++REGISTRATION STATUS: PENDING ++++++++++++++++++++++++++++++");

	}

}
