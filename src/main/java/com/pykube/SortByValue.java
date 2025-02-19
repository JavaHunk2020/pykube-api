package com.pykube;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortByValue {

	public static void main(String[] args) {
		 // Example Map
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);
        map.put("D", 25);
        
        Map<String, Integer> smap= map.entrySet().stream()
        		.sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(c->c.getKey(),c3->c3.getValue(),(c1,c2)->c2,LinkedHashMap::new));
        System.out.println(smap);
        
        
	}
}
