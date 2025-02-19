package com.pykube;

import java.util.Scanner;

public class aaa {

	  public static String MathChallenge(String str) {
	    // code goes here 
	    String parts[] =str.split(" "); 
	    String leftPart = parts[0]; //4
	    char operator=parts[1].charAt(0); // -
	    String middlePart = parts[2];// =
	    String rightPart = parts[4];//x

	    int missingDigit=-1;
	    if(leftPart.contains("x")) {
	        findDigitForMissingPart(leftPart,middlePart,operator,rightPart);
	    } else if(middlePart.contains("x")) {
	        findDigitForMissingPart(middlePart,leftPart,operator,rightPart);
	    }  else {
	        findDigitForMissingPart(rightPart,leftPart,operator,middlePart);
	    }
	    

	    return String.valueOf(missingDigit);
	  }
	  private static int findDigitForMissingPart(String missingPart,String part1,char operator,String part2){
	    
	      for(int i=0;i<=9;i++) {
	        String testString=missingPart.replace('x',(char)('0'+i));
	        int testValue=Integer.parseInt(testString);
	        int value1=Integer.parseInt(part1);
	        int value2=Integer.parseInt(part2);
	        if(operator=='+'){
	          if(testValue==value1+value2) {
	             return i;
	          }

	        }else if(operator=='-'){
	           if(testValue==value1-value2) {
	             return i;
	          }
	        } else if(operator=='*'){
	          if(testValue==value1*value2) {
	             return i;
	          }
	        }else if(operator=='/'){
	         if(testValue==value1/value2) {
	             return i;
	          }
	        }
	      }
	      return -1;
	  }

	  public static void main (String[] args) {  
	    // keep this function call here     
	    Scanner s = new Scanner(System.in);
	    System.out.print(MathChallenge(s.nextLine())); 
	  }
	}