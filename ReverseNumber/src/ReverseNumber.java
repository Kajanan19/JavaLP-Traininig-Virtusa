import java.util.InputMismatchException;
import java.util.Scanner;

public class ReverseNumber {
	 public static void main(String[] args) {
		 
		 Scanner sc = new Scanner(System.in);
		 int  reversed = 0;
		 
		  
		 System.out.println("Enter the Number:");
		 int number = 0;
		    
		    try {
		    	
		    	number = sc.nextInt();
		    	
		    } catch (InputMismatchException e) {
		        e.printStackTrace();
		    }
		    
		 
		 while(number != 0) {
	            int digit = number % 10;
	            reversed = reversed * 10 + digit;
	            number /= 10;
	        }
		 
		 
		 System.out.println("Reversed Number: " + reversed);
	}
}
