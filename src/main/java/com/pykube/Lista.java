package com.pykube;

import java.util.ArrayList;
import java.util.List;

public class Lista {
	
	
	public static void main(String[] args) {
		List<String> lkist=new ArrayList<String>();
		lkist.add("nagen");
		lkist.add("ameya");
		lkist.add("login");
		lkist.add("ashta");
		
		lkist.forEach(s->{
			if(s.equalsIgnoreCase("ameya")) {
			   return;
			}
			System.out.println(s);
		});
	}

}
