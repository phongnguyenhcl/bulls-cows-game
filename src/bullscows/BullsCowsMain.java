package bullscows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BullsCowsMain {

	public static void grader(String code, String guess) {
		String result = "";
		int bull = 0;
		int cow = 0;
		// find the occurrences of bulls and cows
		for (int i = 0; i < code.length(); i++) {
			/*
			 * if exists, pos will not be -1 if pos equals to i means it's a bull if not,
			 * then it's a cow.
			 */
			int pos = code.indexOf(guess.charAt(i));
			if (pos != -1) {
				if (pos == i) {
					bull++;
				} else {
					cow++;
				}
			}
		}

		// structures result to be printed
		if (bull > 0 && cow > 0) {
			result += (bull + " bull(s). and " + cow + " cow(s)");
		} else if (bull > 0 && cow == 0) {
			result += bull + " bull(s)";
		} else if (bull == 0 && cow > 0) {
			result += cow + " cow(s)";
		} else {
			result += " None";
		}

		System.out.printf("Grade:%s. The secret code is %s.", result, code);

	}

	public static String generateSecretCode(int numberOfDigit) {
		List<Integer> uniqueDigits = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
		do {
			Collections.shuffle(uniqueDigits);
		} while (uniqueDigits.get(0) == 0);

		StringBuilder code = new StringBuilder();
		for (int digit : uniqueDigits) {
			code.append(digit);
		}

		return code.substring(0, numberOfDigit).toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfDigit = scanner.nextInt();
		
		String secretCode;
		if (numberOfDigit > 10) {
			System.out.println(
					"Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
		} else {
			secretCode = generateSecretCode(numberOfDigit);
			System.out.printf("The random secret number is %s.\n", secretCode);
		}
		scanner.close();
	}
}
