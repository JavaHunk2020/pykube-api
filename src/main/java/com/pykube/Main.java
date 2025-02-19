package com.pykube;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.ServletException;

public class Main {

	public static void main(String[] args) {
	        List<String> strings = Arrays.asList("he--o", "he-lo", "he12llo", "h-e-l-l-o", "hey", "h-llo", "hello");
	        List<String> matchingStrings = findMatchingStrings(strings, "hello");
	        System.out.println("Matching strings: " + matchingStrings);
	    }

	private static List<String> findMatchingStrings(List<String> strings, String string) {

		return null;
	}
}
