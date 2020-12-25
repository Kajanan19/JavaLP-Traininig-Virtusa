import java.util.Scanner;

import model.Item;
import model.User;

public class ManageItems {
	
	Item item=new Item();
	Scanner sc = new Scanner(System.in);
	
	public Item addItem() {
		
	
		
		  //Add Name
		    System.out.println("Enter item Name");
		    String itemName = sc.nextLine();
		    item.setItemName(itemName);
		    
		  //Add purchasePrice
		    System.out.println("Enter Purchase Price:");
		    double purchasePrice=0; 
		    try {
		    	purchasePrice = sc.nextDouble();
			    item.setPurchasePrice(purchasePrice);
			} catch (Exception e) {
				// TODO: handle exception
			}
		    
		    
		  //Add salesPrice
		    System.out.println("Enter Sales Price:");
		    double salesPrice=0; 
		    try {
		    	salesPrice = sc.nextDouble();
			    item.setSalesPrice(salesPrice);
			} catch (Exception e) {
				// TODO: handle exception
			}
		    
		
		 return item;
	}
}
