package com.greatlearning.paymoneyapp.driver;

import java.util.Scanner;

public class DriverClass {

	public static int getnooftransaction(int[] transactionDetails, int target) {
		int sumoftransaction = 0;
		int arrayindex;
		for (arrayindex = 0; arrayindex < transactionDetails.length; arrayindex++) {
			sumoftransaction += transactionDetails[arrayindex];
			if (sumoftransaction >= target)
				return arrayindex + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int arrayIndex;
		int target;
		int targetsteps;

		try (Scanner scanner = new Scanner(System.in)) {

			System.out.println("Enter the size of transaction array");
			int sizeOfTrans = scanner.nextInt();
			int[] transactionDetails = new int[sizeOfTrans];

			System.out.println("Enter the values of array");
			for (arrayIndex = 0; arrayIndex < sizeOfTrans; arrayIndex++) {
				transactionDetails[arrayIndex] = scanner.nextInt();
			}

			System.out.println("Enter the no of targets that needs to be achieved");
			int noOfTargets = scanner.nextInt();
			while (noOfTargets > 0) {
				System.out.println("Enter the value of target");
				target = scanner.nextInt();
				targetsteps = getnooftransaction(transactionDetails, target);
				if (targetsteps < 0) {
					System.out.println("Given target is not achieved");
				} else {
					System.out.println("Target achieved after " + getnooftransaction(transactionDetails, target)
							+ " transactions");
				}
				noOfTargets--;
			}
			scanner.close();
		} catch (Exception e) {
			System.out.println("Invalid input!! Please enter a number");
		}
	}

}
