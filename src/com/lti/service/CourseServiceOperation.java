package com.lti.service;

import java.util.List;

import com.lti.bean.Course;
import com.lti.bean.Student;
import com.lti.dao.CourseDao;
import com.lti.dao.CourseDaoImpl;
import com.lti.exception.CourseNotFoundException;


public class CourseServiceOperation implements CourseServiceInterface{

	//initializing logger


	CourseDao courseDao= new CourseDaoImpl();

	// display list of available courses for student 
	public void displayCourses(Student student) {
		System.out.println("LIST OF AVAILABLE COURSES");
		System.out.println("-------------------------");

		List<Course> courses = courseDao.displayCourses(student);
		for(Course course:courses) {
			if(course.getStudentsEnrolled()<10) {
				System.out.println("\nCOURSE ID="+course.getCourseId()+"|  COURSE TITLE= "+course.getCourseTitle() +"|  COUSRE DESCRIPTION="+course.getCourseDescription()+"|  CREDITS="+course.getCredits());

			}
		}
		System.out.println("*************************************************************************************************************");
	}
	
	//display available courses for professor to select
	public void displayCoursesProfessor() {
		System.out.println("****************************LIST OF AVAILABLE COURSES************************************");
		System.out.println("COURSE ID      COURSE TITLE         COUSRE DESCRIPTION             ");
		List<Course> courses = courseDao.displayCoursesProfessor();
		courses.forEach(course ->System.out.println(course.getCourseId()+"               "+course.getCourseTitle()+"               "+course.getCourseDescription()));

		System.out.println("******************************************************************************************");

	}

	// insert a new course in database
	public void insertCourse(Course course) {
		courseDao.insertCourse(course);
	}

	//delete an existing course
	public void deleteCourse(int courseId)throws CourseNotFoundException{
		courseDao.deleteCourse(courseId);
	}




}
