package com.lti.application;

import java.util.Date;
import java.util.Scanner;

import com.lti.bean.Admin;
import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.bean.Student;
import com.lti.bean.User;
import com.lti.service.CourseServiceInterface;
import com.lti.service.CourseServiceOperation;
import com.lti.service.UserServiceInterface;
import com.lti.service.UserServiceOperation;

public class AdminClient {

	// initializing the scanner
	Scanner sc = new Scanner(System.in);

	// admin client landing page
	public void adminClientPage(Admin admin) {

		// initializing the instance userOperation to carry out user operations
		UserServiceInterface userOperation = new UserServiceOperation();
		// initializing the instance courseOperation to carry out course operations
		CourseServiceInterface courseOperation = new CourseServiceOperation();

		// begin variable listing
		User user;
		int userId;
		int profileOption;

		Date currentDate = new Date();
		// display contents of admin client landing page
		System.out.println("Succesfully logged in as ADMIN on " + currentDate);
		while (true) {
			// diplay menu list for admin
			System.out.println("Welcome " + admin.getName() + " !");
			System.out.println("Choose an option");
			System.out.println("1. Create user");
			System.out.println("2. Update user");
			System.out.println("3. Delete user");
			System.out.println("4. Add a new Course");
			System.out.println("5. Delete Course");
			System.out.println("6. Display users");
			System.out.println("7. Logout");

			int choice = sc.nextInt();
			switch (choice) {
			// create a new user
			case 1:
				user = new User();

				System.out.println("Enter UserId");
				userId = sc.nextInt();
				user.setUserId(userId);
				System.out.println("Enter Username");
				user.setUserName(sc.next());
				System.out.println("Enter Password");
				user.setUserPassword(sc.next());

				System.out.println("Enter Profile ");
				System.out.println("1. Student");
				System.out.println("2. Professor");
				System.out.println("3. Admin");
				profileOption = sc.nextInt();
				switch (profileOption) {
				// if user is a student
				case 1:
					user.setRoleId(1);
					userOperation.createUser(user);
					Student student = new Student();
					student.setStudentId(userId);
					System.out.println("Enter Name");
					student.setName(sc.next());
					System.out.println("Enter gender");
					student.setGender(sc.next());
					System.out.println("Enter Phone Number");
					student.setPhoneNumber(sc.nextInt());
					System.out.println("Enter Semester");
					student.setSemester(sc.nextInt());
					System.out.println("Enter Branch");
					student.setBranch(sc.next());
					student.setRegistrationStatus(false);
					System.out.println("Enter Scholarship Allowance Percentage");
					student.setScholarshipPercentage(sc.nextInt());
					// create student
					userOperation.createStudent(student);
					break;

				// if user is a professor

				case 2:
					user.setRoleId(2);
					userOperation.createUser(user);
					Professor professor = new Professor();
					professor.setProfessorId(userId);
					System.out.println("Enter Name");
					professor.setName(sc.next());
					System.out.println("Enter gender");
					professor.setGender(sc.next());
					System.out.println("Enter Phone Number");
					professor.setPhoneNumber(sc.nextInt());
					System.out.println("Enter Designation");
					professor.setDesignation(sc.next());
					// create professor userOperation.createProfessor(professor); break;

					// if user is an admin

				case 3:
					user.setRoleId(3);
					userOperation.createUser(user);
					Admin newAdmin = new Admin();
					newAdmin.setAdminId(userId);
					System.out.println("Enter Name");
					newAdmin.setName(sc.next());
					System.out.println("Enter gender");
					newAdmin.setGender(sc.next());
					System.out.println("Enter Phone Number");
					newAdmin.setPhoneNumber(sc.nextInt()); // create admin
					userOperation.createAdmin(newAdmin);
					break;

				}
				continue;

			// insert a new course
			case 4:
				Course course = new Course();
				System.out.println("Enter catalogId");
				course.setCatalogId(sc.nextInt());
				System.out.println("Enter CousreId");
				course.setCourseId(sc.nextInt());
				System.out.println("Enter Course Title");
				course.setCourseTitle(sc.next());
				System.out.println("Enter Course Description ");
				course.setCourseDescription(sc.next());
				System.out.println("Enter Semester");
				course.setSemester(sc.nextInt());
				System.out.println("Enter Branch ");
				course.setBranch(sc.next());
				System.out.println("Enter credits");
				course.setCredits(sc.nextInt());
				// course added in the database
				courseOperation.insertCourse(course);
				continue;

			// log out as admin

			case 7:
				System.out.println("Succesfully logged out as on " + currentDate);
				break;

			}
			break;

		}

	}

}
