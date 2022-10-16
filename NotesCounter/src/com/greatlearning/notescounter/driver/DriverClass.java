package com.greatlearning.notescounter.driver;

import java.util.Arrays;
import java.util.Scanner;

import com.greatlearning.notescounter.utility.countingNotes;

public class DriverClass {

	public static void main(String args[]) {
		try (Scanner scanner = new Scanner(System.in)) {
			int sizeofcurrency = 0;
			int amounttopay = 0;

			System.out.println("Enter the size of denomination");
			sizeofcurrency = scanner.nextInt();
			System.out.println("Enter the currency denominations value");
			int[] currencydemo = new int[sizeofcurrency];
			int[] currencycount = new int[sizeofcurrency];
			for (int arrayindex = 0; arrayindex < sizeofcurrency; arrayindex++) {
				currencydemo[arrayindex] = scanner.nextInt();
			}
			System.out.println("Enter the amount you want to pay");
			amounttopay = scanner.nextInt();
			Arrays.sort(currencydemo);
			amounttopay = countingNotes.countNotes(currencydemo, currencycount, 0, sizeofcurrency - 1, amounttopay);

			if (amounttopay > 0) {
				System.out.println("Amount cannot be paid in give denominations!");
			} else {
				System.out.println("Your payment approach in order to give min no of notes will be");
				for (int arrayindex = sizeofcurrency - 1; arrayindex > 0; arrayindex--) {
					if (currencycount[arrayindex] > 0) {
						System.out.println(currencydemo[arrayindex] + ":" + currencycount[arrayindex]);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid input! Please enter a valid value");
		}
	}
}
