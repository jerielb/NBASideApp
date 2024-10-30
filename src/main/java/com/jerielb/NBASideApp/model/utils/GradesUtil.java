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
				case "A+": total += 10; break;
				case "A": total += 9; break;
				case "A-": total += 8; break;
				
				case "B+": total += 7; break;
				case "B": total += 6; break;
				case "B-": total += 5; break;
				
				case "C+": total += 4; break;
				case "C": total += 3; break;
				case "C-": total += 2; break;
				
				case "D+": total += 1; break;
				default: break;
			}
		}
		
		// get Letter grade from rounded average
		switch((int) Math.round(total/rosterSize)) {
			case 10: result = "A+"; break;
			case 9: result = "A"; break;
			case 8: result = "A-"; break;
			
			case 7: result = "B+"; break;
			case 6: result = "B"; break;
			case 5: result = "B-"; break;
			
			case 4: result = "C+"; break;
			case 3: result = "C"; break;
			case 2: result = "C-"; break;
			
			case 1: result = "D+"; break;
			default: result = "F";
		}
		
		return result;
	}
	
}
