package com.jerielb.NBASideApp.model;

import com.jerielb.NBASideApp.model.utils.GradesUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GradesUtilTest {
	
	@Test
	public void testGradeUtil() {
		List<String> grades = new ArrayList<>();
		grades.add("A");
		grades.add("B");
		grades.add("C");
		grades.add("D");
		grades.add("F");
		
		String result = GradesUtil.gradeAverage(grades, grades.size());
		
		System.out.println("Result: " + result);
		assertEquals("C+", result);
	}
	
	@Test
	public void testGradeUtil2() {
		List<String> grades = new ArrayList<>();
		grades.add("A+");
		grades.add("C+");
		grades.add("C");
		grades.add("C");
		grades.add("C");
		
		String result = GradesUtil.gradeAverage(grades, grades.size());
		
		System.out.println("Result: " + result);
		assertEquals("B-", result);
	}
}
