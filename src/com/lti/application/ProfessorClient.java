package com.lti.application;

import java.util.Date;
import java.util.Scanner;

import com.lti.bean.Professor;
import com.lti.service.CourseServiceInterface;
import com.lti.service.CourseServiceOperation;
import com.lti.service.GradeServiceInterface;
import com.lti.service.GradeServiceOperation;
import com.lti.service.ProfessorServiceInterface;
import com.lti.service.ProfessorServiceOperation;
import com.lti.service.RegistrationServiceInterface;
import com.lti.service.RegistrationServiceOperation;


public class ProfessorClient {
	// initializing the logger
	

		// initializing the scanner
		Scanner sc= new Scanner(System.in); 
		
		// professor client landing page
		public void professorClientPage(Professor professor) {

			int courseId;

			// initializing the instance courseOperation to carry out course operations 
			CourseServiceInterface courseOperation= new CourseServiceOperation();
			// initializing the instance professorOperation to carry out professor operations 
			ProfessorServiceInterface professorOperation= new ProfessorServiceOperation();

			Date currentDate = new Date();
			// professor client page contents
			System.out.println("\nSuccesfully logged in as PROFESSOR on "+ currentDate);
			while(true) {
				System.out.println("\nWelcome "+professor.getName()+" !");


				// display menu list for professor
				System.out.println("Choose an option"); 
				System.out.println("----------------");
				System.out.println("1. View Courses to teach");
				System.out.println("2. Select a course");
				System.out.println("3. Deselect a course");
				System.out.println("4. View Selected Courses");
				//System.out.println("5. Upload Grades");
				System.out.println("6. Logout");

				int choice= sc.nextInt();

				switch(choice) {
				// display all the courses available for professor to teach
				case 1:
					courseOperation.displayCoursesProfessor();
					continue;

				// select a course to teach
				case 2:
					System.out.println("Enter CourseID of the Course to be selected");
					courseId= sc.nextInt();
					professorOperation.selectCourse(courseId, professor);
					continue;

				// deselect a course
				case 3:
					System.out.println("Enter CourseID of the Course to be deselected");
					courseId= sc.nextInt();
					professorOperation.deselectCourse(courseId, professor);
					continue;

				// display list of courses selected by professor to teach
				case 4:
					professorOperation.displaySelectedCoursesProfessor(professor);
					continue;

				// upload grades 
				case 5:
					RegistrationServiceInterface registartionOperation= new RegistrationServiceOperation();
					System.out.println("Enter the CourseID to upload grades");
					courseId= sc.nextInt();
					// shows the list of students enrolled in particular course
					registartionOperation.displayRegisteredStudentsInCourse(courseId);
					System.out.println("Enter the StudentID to upload grades");
					int studentId= sc.nextInt();
					System.out.println("Enter the grade");
					String grade= sc.next();
					// grade submission
					GradeServiceInterface gradeOperation= new GradeServiceOperation();
					gradeOperation.uploadGrades(studentId, courseId, grade);
					continue;

				// log out as a professor
				case 6:
					currentDate = new Date();
					System.out.println("Succesfully logged out as on "+ currentDate);
					break;

				}
				break;

			}
		}

}
