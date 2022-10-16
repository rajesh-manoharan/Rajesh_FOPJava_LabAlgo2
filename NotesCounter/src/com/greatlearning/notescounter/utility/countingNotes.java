package com.greatlearning.notescounter.utility;

public class countingNotes {

	public static int countNotes(int[] arrDenominations, int[] counter, int low, int high, int amountToPay) {
		if (amountToPay == 0) {
			return 0;
		}
		if (amountToPay < arrDenominations[0]) {
			return amountToPay;
		}

		if (amountToPay == arrDenominations[0]) {
			counter[0] = amountToPay / arrDenominations[0];
			return 0;
		}

		if (amountToPay >= arrDenominations[high]) {
			counter[high] = amountToPay / arrDenominations[high];
			amountToPay %= arrDenominations[high];
			if (amountToPay == 0) {
				return 0;
			} else {
				return countNotes(arrDenominations, counter, 0, high - 1, amountToPay);
			}
		}
		int mid = (low + high) / 2;
		if (amountToPay <= arrDenominations[mid]) {
			return countNotes(arrDenominations, counter, 0, mid - 1, amountToPay);
		}
		return countNotes(arrDenominations, counter, 0, high - 1, amountToPay);
	}

}
