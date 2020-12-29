package bullscows;
import java.util.Scanner;

public class BullsCowsMain {
	
	public static void grader (String code, String guess) {
		String result = "";
		int bull = 0;
		int cow = 0;
		// find the occurrences of bulls and cows
		for (int i = 0; i < code.length(); i++) {
			/* if exists, pos will not be -1
			 * if pos equals to i means it's a bull
			 * if not, then it's a cow.
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
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String guess = scanner.nextLine();
		String code = "9305";
		grader(code, guess);
	}
}
