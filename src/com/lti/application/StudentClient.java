package com.lti.application;

import java.util.Date;
import java.util.Scanner;


import com.lti.bean.Student;
import com.lti.exception.UserNotFoundException;
import com.lti.service.CourseServiceInterface;
import com.lti.service.CourseServiceOperation;
import com.lti.service.GradeServiceInterface;
import com.lti.service.GradeServiceOperation;
import com.lti.service.NotificationServiceInterface;
import com.lti.service.NotificationServiceOperation;
import com.lti.service.PaymentServiceInterface;
import com.lti.service.PaymentServiceOperation;
import com.lti.service.RegistrationServiceInterface;
import com.lti.service.RegistrationServiceOperation;
import com.lti.service.StudentServiceInterface;
import com.lti.service.StudentServiceOperation;
/** 
 * @desc this class will hold functions for student interaction
 * includes Student Client landing page
 * @author Manikandan
 */
public class StudentClient {

	Student student = new Student();
	// initializing the scanner
	Scanner sc = new Scanner(System.in);

	// studentClient landing page
	public void studentClientPage(Student student) {

		// initializing the instance courseOperation to carry out course operations
		CourseServiceInterface courseOperation = new CourseServiceOperation();
		// initializing the instance studentOperation to carry out student operations
		StudentServiceInterface studentOperation = new StudentServiceOperation();

		// begin variable listing
		int choice;
		int courseId;
		Date currentDate = new Date();

		// student client landing page contents
		System.out.println("\nSuccesfully logged in as STUDENT on " + currentDate);
		while (true) {

			System.out.println("\nWelcome back  -  " + student.getName() + " !\n");

			// declaration of menu for student
			System.out.println("Choose an option");
			System.out.println("----------------");
			System.out.println("1. View All Courses");
			System.out.println("2. Add a course");
			System.out.println("3. Drop a course");
			System.out.println("4. View Selected Courses");
			System.out.println("5. Submit Registration");
			System.out.println("6. View Grades");
			System.out.println("7. Logout");
			choice = sc.nextInt();

			switch (choice) {
			// display all available courses for a particular student
			case 1:
				courseOperation.displayCourses(student);
				continue;

			// add a course by student
			case 2:
				if (student.isRegistrationStatus() == false) {
					System.out.println("Enter CourseID of the Course to be added");
					courseId = sc.nextInt();
					studentOperation.addCourse(courseId, student);
				} else {
					System.out.println("Registration already completed!");
				}
				continue;

			// drop a course by student
			case 3:
				if (student.isRegistrationStatus() == false) {
					System.out.println("Enter CourseID of the Course to be dropped");
					courseId = sc.nextInt();
					studentOperation.dropCourse(courseId, student);
				} else {
					System.out.println("Registration already completed!");
				}
				continue;

			// display all the courses that student has selected so far with Registration
			// status
			case 4:
				studentOperation.displaySelectedCourses(student);
				continue;

			// submit registration
			case 5:
				RegistrationServiceInterface registrationOperation = new RegistrationServiceOperation();

				// if student has already completed registration
				if (student.isRegistrationStatus()) {
					System.out.println("Registration already completed !");
					System.out.println("1. Show Registration Reciept");
					System.out.println("2. Back to main menu");
					int option = sc.nextInt();
					switch (option) {

					// displaying course registration receipt
					case 1:
						NotificationServiceInterface notificationOperation = new NotificationServiceOperation();
						notificationOperation.showRegistrationReciept(student);
						break;

					// back to main menu
					case 2:
						break;
					}
				}

				// if number of courses selected by students is <4 or >4
				else if (registrationOperation.checkCourseSelectionStatus(student) == false) {
					System.out.println("Please select EXACTLY 4 courses !");
				}

				// if number of courses selected is exactly 4 and courses are available
				else {
					System.out.println("Note: Once registered, you won't be able to alter your selections.");

					// listing further actions
					System.out.println("1. Submit Registration");
					System.out.println("2. Back to main menu");
			
					int option = sc.nextInt();
					switch (option) {

					// continuing with registration
					// calculating and displaying payment amount
					case 1:
						PaymentServiceInterface paymentOperation = new PaymentServiceOperation();
						double payableAmount = paymentOperation.calculatPayment(student);
						System.out.println("************************PAYMENT DETAILS******************************");
						System.out.println("Total payment amount: Rs 10000.00");
						System.out.println("Scholarship Perectage: " + student.getScholarshipPercentage());
						System.out.println("Total payable fees: Rs " + payableAmount); // total payable amount after
																						// deduction of scholarship
																						// allowance
						System.out.println("*********************************************************************");

						// listing further actions

						System.out.println("1. Pay Fees");
						System.out.println("2. Back to main menu");

						int option2 = sc.nextInt();
						switch (option2) {

						// choosing mode of payment
						case 1:
							System.out.println("************************PAYMENT GATEWAY******************************");
							System.out.println("Choose mode of payment");
							System.out.println("1. Debit Card");
							System.out.println("2. E- Wallet");
							System.out.println("3. Netbanking");
							System.out.println("*********************************************************************");
							int paymentOption = sc.nextInt();

							// submitting registration
							registrationOperation.submitRegistration(student);
							currentDate = new Date();
							switch (paymentOption) {
							// fees submission using debit card
							case 1:
								System.out.println(
										"Registration succesfully completed on " + currentDate + " using DEBIT_CARD");
								break;
							// fees submission using e-wallet
							case 2:
								System.out.println(
										"Registration succesfully completed on " + currentDate + " using E_WALLET");
								break;
							// fees submission using netbanking
							case 3:
								System.out.println(
										"Registration succesfully completed on " + currentDate + " using NETBANKING");
								break;

							}

							// registration details stored in database
							registrationOperation.generateRegistrationReciept(student, payableAmount, paymentOption);
							// listing further actions
							System.out.println("1. Show Registration Reciept");
							System.out.println("2. Back to main menu");
							int option3 = sc.nextInt();
							switch (option3) {
							// fetching and displaying registration
							case 1:
								NotificationServiceInterface notificationOperation = new NotificationServiceOperation();
								notificationOperation.showRegistrationReciept(student);
								break;

							case 2:
								break;
							}
							break;
						case 2:
							break;
						}
						break;

					case 2:
						break;

					}
				}
				continue;

			// display grades for student
			case 6:
				GradeServiceInterface gradeOperation = new GradeServiceOperation();
				gradeOperation.displayGrades(student);
				continue;

			// log out as a student
			case 7:
				currentDate = new Date();
				System.out.println("Succesfully logged out as on " + currentDate);
				break;

			}
			break;

		}
	}

}