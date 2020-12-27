package com.jelly;

import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static double getInput() { // Get the user's score as console input.
		double score = 0.00;
		System.out.print("\nPlease enter your grade average: ");
		Scanner scanner = new Scanner(System.in);
		try {
			score = scanner.nextDouble();
		} catch (InputMismatchException e) { // Re-prompt the user in favour of avoiding a crash with a user-unfriendly explanation.
			System.out.println("ERROR: Incorrect format, please try again!");
			getInput();
		}
		if (score < 0.00) {
			System.out.println("ERROR: Incorrect format, please try again!");
			getInput();
		}
		return score;
	}

	public static String replaceGrade(String[] output) { // Replace the letter grade placeholder with the desired letter grade.
		return output[0].replaceAll("%g%", output[1]);
	}

	public static byte b(int input) { // Make casting to a byte easier to type.
		return (byte) input;
	}

	public static String calculateGrade(final double SCORE) { // Assign a letter grade based on a provided score.
		final Hashtable<String, Byte> GRADES = new Hashtable<String, Byte>() {{ // Use of a single Hashtable, instead of two separate sets of variables for all letter grades and their boundaries, in favour of efficiency.
			put("A+", b(98));
			put("A", b(93));
			put("A-", b(90));
			put("B+", b(87));
			put("B", b(83));
			put("B-", b(80));
			put("C+", b(77));
			put("C", b(73));
			put("C-", b(70));
			put("D+", b(67));
			put("D", b(63));
			put("D-", b(60));
		}};
		String[] output = {"You achieved a grade %g%, with a grade percentage of %s%%!", ""}; // Use of a String[], instead of two separate strings for the output message and achieved letter grade, in favour of efficiency.
		if (SCORE >= GRADES.get(output[1] = "A+")) output[0] = replaceGrade(output); // The desired grade is assigned to the String[] within the condition, so as to avoid having to type out "A+" twice per check, in favour of efficiency.
		else if (SCORE >= GRADES.get(output[1] = "A")) output[0] = replaceGrade(output);
		else if (SCORE >= GRADES.get(output[1] = "A-")) output[0] = replaceGrade(output);
		else if (SCORE >= GRADES.get(output[1] = "B+")) output[0] = replaceGrade(output);
		else if (SCORE >= GRADES.get(output[1] = "B")) output[0] = replaceGrade(output);
		else if (SCORE >= GRADES.get(output[1] = "B-")) output[0] = replaceGrade(output);
		else if (SCORE >= GRADES.get(output[1] = "C+")) output[0] = replaceGrade(output);
		else if (SCORE >= GRADES.get(output[1] = "C")) output[0] = replaceGrade(output);
		else if (SCORE >= GRADES.get(output[1] = "C-")) output[0] = replaceGrade(output);
		else if (SCORE >= GRADES.get(output[1] = "D+")) output[0] = replaceGrade(output);
		else if (SCORE >= GRADES.get(output[1] = "D")) output[0] = replaceGrade(output);
		else if (SCORE >= GRADES.get(output[1] = "D-")) output[0] = replaceGrade(output);
		else {
			output[1] = "F";
			output[0] = replaceGrade(output);
		}
		return output[0].replaceAll("%s%", String.valueOf(SCORE));
	}

    public static void main(String[] args) {
		System.out.println(calculateGrade(getInput()));
    }

}
