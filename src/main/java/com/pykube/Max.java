package com.pykube;

import java.util.HashMap;
import java.util.Map;

public class Max {

	public static void main(String[] args) {
		 HashMap<String, Integer> map = new HashMap<>();
	        map.put("A", 10);
	        map.put("B", 20);
	        map.put("E", 15);
	        map.put("D", 25);

	        // Finding the entry with the maximum value
	        Map.Entry<String, Integer> maxEntry = map.entrySet()
	            .stream()
	            .max(Map.Entry.comparingByKey())
	            .orElse(null); // or handle the case when the map is empty
	        
	        System.out.println(maxEntry);
	}
}
