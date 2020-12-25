import java.util.Scanner;

import model.User;

public class ManageUsers {
	User user =new User();
	Scanner sc = new Scanner(System.in);
	
	public User addUser() {
		
	
		  //Add Name
		    System.out.println("Enter User Name");
		    String userName = sc.nextLine();
		    user.setFname(userName);
		    
		  //Add address
		    System.out.println("Enter Address:");
		    String address = sc.nextLine();
		    user.setAddress(address);
		    
		  //Add Phone 
		    System.out.println("Enter Phone Number:");
            int phoneNumber;
		    
		    try {
		    	phoneNumber = sc.nextInt();
		    	user.setPhone(String.valueOf(phoneNumber));
		    } catch (IllegalArgumentException e) {
		        e.printStackTrace();
		    }
		
		
		return user;
	}
}
