package com.lti.application;

import java.util.Scanner;

import com.lti.bean.Admin;
import com.lti.bean.Professor;
import com.lti.bean.Student;
import com.lti.bean.User;
import com.lti.exception.InvalidLoginException;
import com.lti.service.UserServiceInterface;
import com.lti.service.UserServiceOperation;

/** 
 * @desc this class facilitates user interaction 
 * and user credential check

*/
public class UserClient {


	//public static void main(String[] args) {
	public void yes() {
		//Creating scanner object to get user inputs
		Scanner sc = new Scanner(System.in);

		//Creating UserServiceInterface object to call relevant methods
		UserServiceInterface userOperation = new UserServiceOperation();

		// user login landing page
		while (true) {
			System.out.println("*******WELCOME TO STUDENT MANAGEMENT SYSTEM***********");
			System.out.println("Enter your credentials");
			System.out.println("----------------------");

			// fetching input for user credentials
			System.out.println("Enter UserName");
			String username = sc.next();
			System.out.println("Enter password");
			String password = sc.next();
			try {

				// validating the user credentials
				User checkedUser = userOperation.validateUser(username, password);
				//After performing validation getting user role id and fetching to profile
				int profile = checkedUser.getRoleId();
				//After performing validation getting user user id and fetching to userid
				int userId = checkedUser.getUserId();

				switch (profile) {
				// if user is a student

				case 1:

					//If user enters 1, it will call User operation by passing userid parameter
					Student student = userOperation.fetchStudent(userId);
					StudentClient studentClient = new StudentClient();
					//After checking in database, calling the studentclient class
					studentClient.studentClientPage(student);

					continue;

				// if user is a professor

				case 2:
					
					//Checks professor data in database and fetch data of professor in professor variables
					Professor professor = userOperation.fetchProfessor(userId);
					ProfessorClient professorClient = new ProfessorClient(); 
																				
					professorClient.professorClientPage(professor);
					continue;

				// if user is an admin
					
				case 3: 
					//fetching admin object from admin table 
					Admin admin=userOperation.fetchAdmin(userId);
					AdminClient adminClient = new AdminClient();
					 //redirecting to admin client landing page
					adminClient.adminClientPage(admin);
					continue;

				}

			}
			// catching the InvalidLoginException in catch block
			catch (InvalidLoginException e) {
				System.out.println(e.getMessage());
				continue;
			}

			break;
		}
	}

}
