package com.lti.service;

import com.lti.bean.Student;

/** 
 * @desc this class will hold functions for Payment service operation
 * examples include calculatPayment(Student student)
 * @author Manikandan 
 */
public class PaymentServiceOperation implements PaymentServiceInterface{

	// calculate final payableAmount for student after deducting scholarship allowance
	public double calculatPayment(Student student) {

		int standardPayment= 10000;
		int scholarshipPercentage=student.getScholarshipPercentage();
		double payableAmount= standardPayment*(0.01*(100-scholarshipPercentage));
		return payableAmount;

	}
}
