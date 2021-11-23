package com.lti.application;

import java.util.Scanner;

import com.lti.exception.InputMismatchException;
import com.lti.exception.InvalidLoginException;
import com.lti.service.UserServiceInterface;
import com.lti.service.UserServiceOperation;

public class CRSMenu {

	public static void main(String[] args) {
		
		//Creating scanner object to get inputs from the end user
		Scanner sc = new Scanner(System.in);
		
		//boolean value is always true so that it will continue to loop the process
		boolean statement = true;
		
		//While statement executes continuously
		while (statement) {
			// Menu starting page of the application
			System.out.println("*******Main Menu***********");
			System.out.println("\n\nPress any key as mention below");
			System.out.println("----------------------");

			System.out.println("1. Login to portal");
			System.out.println("2. Student Registration");
			System.out.println("3. Update Password");
			System.out.println("4. Press other keys to exit");
			
			//Using try, catch block to get any input mismatch error
			try {
			int choice = sc.nextInt();
			if(choice>=5) {
				
				// It throws to the customized exception which we created
				throw new InputMismatchException();
			}
			UserClient userClient = new UserClient();
			
			//Applying switch statement as per user input
			switch(choice) {
			case 1:
				
				//redirecting to user page for login
				userClient.yes();
				continue;
			case 2:
				userClient.yes();
				continue;
			case 3:
				System.out.println("");
				continue;

			default:
				System.out.println("Exiting....");
				//It will make switch statement false once user entered number 4
				statement = false;
					
			}
			
		}	
			//Declaring catch block to get any input error from the end user
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				continue;
		}
			
			break;
			
		}

	}

}
