package com.jerielb.NBASideApp.model.utils;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
public class GradesUtil {
	/**
	 * decodes the letter grades to integers
	 * averages the total then encode back to a letter grade
	 */
	public static String gradeAverage(List<String> grades, int rosterSize) {
		String result = null;
		double total = 0;
		
		// add grades
		for (String a : grades) {
			switch (a.toUpperCase(Locale.ROOT)) {
				case "A+": total += 9; break;
				case "A": total += 8; break;
				case "A-": total += 7; break;
				
				case "B+": total += 6; break;
				case "B": total += 5; break;
				case "B-": total += 4; break;
				
				case "C+": total += 3; break;
				case "C": total += 2; break;
				case "C-", "D+", "D": total += 1; break;
				
				case "F": break;
				default: // "S" grade
					total += 10; 
			}
		}
		
		// get Letter grade from rounded average
		System.out.println("Total: " + total + ", RosterSize: " + rosterSize);
		result = switch ((int) Math.round(total / rosterSize)) {
			case 9 -> "A+";
			case 8 -> "A";
			case 7 -> "A-";
			case 6 -> "B+";
			case 5 -> "B";
			case 4 -> "B-";
			case 3 -> "C+";
			case 2 -> "C";
			case 1 -> "C-";
			default -> // case 10
					"S";
		};
		
		return result;
	}
	
}
