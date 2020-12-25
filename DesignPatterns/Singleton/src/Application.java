import java.util.ArrayList;
import java.util.Scanner;

import model.Item;
import model.User;

public class Application {
	public static void main(String[] args) {
		
		User user =new User();
		Item item =new Item();
		ArrayList<User>userList=new ArrayList<User>();
		ArrayList<Item>itemList=new ArrayList<Item>();
		DatabaseHelper databaseHelper= DatabaseHelper.getDbHelper();
		Scanner sc = new Scanner(System.in);
		
		ManageUsers manageUsers=new ManageUsers();
		ManageItems manageItems=new ManageItems();
		
		databaseHelper.insertUser(manageUsers.addUser());
		databaseHelper.insertItem(manageItems.addItem());
		
		userList=databaseHelper.getUsers();
		itemList=databaseHelper.getItems();
		
		for (int i = 0; i <= userList.size(); i++) {
			System.out.println("Users are:"+userList.get(i).getFname()+" "+userList.get(i).getAddress()+" "+userList.get(i).getPhone());
		}
		
		for (int i = 0; i <= itemList.size(); i++) {
			System.out.println("items are:"+itemList.get(i).getItemName()+" "+itemList.get(i).getPurchasePrice()+" "+itemList.get(i).getSalesPrice());
		}
		
	
	}

}
