package InternshipTask;

import java.util.Scanner;
import java.lang.StringBuilder;

public class Task_One {
	public static void main(String[] args) {
				
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the first integer:");
		int firstNumber = sc.nextInt();		
		System.out.println("Enter the second integer:");
		int secondNumber = sc.nextInt();
		System.out.println("Enter a floating-point number:");
		double pointNumber = sc.nextDouble();		
		System.out.println("Enter a single character:");
		char ch = sc.next().charAt(0);
		System.out.println("Enter a boolean value (true/false):");
		boolean blvalue = sc.nextBoolean();
		System.out.println("Enter your name:");
		String name = sc.next();
		
		System.out.println("Sum of 10 and 20 is:"+ (firstNumber + secondNumber));
		System.out.println("Difference between 10 and 20 is:" + (firstNumber - secondNumber));
		System.out.println("Product of 10 and 20 is:"+ (firstNumber * secondNumber) );
		System.out.println( pointNumber +"multiplied by 2 is:" +(pointNumber*2));
		System.out.println("The next character after '"+ch+"' is:"+ ++ch);
		System.out.println("The opposite of "+blvalue + "is:" + !blvalue);
		System.out.println("Hello,"+ name+"!");
		
		
		
	}

}
