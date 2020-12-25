import java.awt.Cursor;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Item;
import model.User;

public class DatabaseHelper {
	
	 private static volatile DatabaseHelper databaseHelper;
	 private static final String DATABASE_NAME="Company";

	 private static final String TABLE_USER="user";
	 private static final String TABLE_ITEM="item";
	 
	 Connection conn = null;
	 PreparedStatement statement;
	 ArrayList<User> userList;
	 ArrayList<Item> itemList;
	 User user;
	 Item item;
	 
	 
	    //Table user
	    private static final String USER_ID="id";
	    private static final String USER_FIRSTNAME="firstname";
	    private static final String USER_ADDRESS="address";
	    private static final String USER_PHONE="phone";
	 
	    //Table item
	    private static final String ITEM_ID="item_id";
	    private static final String ITEM_NAME="item_name";
	    private static final String ITEM_SALESPRICE="item_salesprice";
	    private static final String ITEM_PURCHASEPRICE="item_purchaseprice";
	    
	    //query for  Table User
        String CREATE_USER_TABLE = (" CREATE TABLE IF NOT EXISTS " + TABLE_USER
                +"("+USER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT , "
                +USER_FIRSTNAME+" TEXT , "
                +USER_ADDRESS+" VARCHAR , "
                +USER_PHONE+" VARCHAR)");
        
        //create query for itemtable
        String CREATE_ITEM_TABLE = (" CREATE TABLE IF NOT EXISTS " + TABLE_ITEM
                +"("+ITEM_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"
                +ITEM_NAME+" TEXT , "
                +ITEM_SALESPRICE+" INTEGER , "
                +ITEM_PURCHASEPRICE+" TEXT )");
	    
	    // Defines the JDBC URL. As you can see, we are not specifying
        // the database name in the URL.
        String url = "jdbc:mysql://localhost";

        // Defines username and password to connect to database server.
        String username = "root";
        String password = "";
        
        // SQL command to create a database in MySQL.
        String sql = ("CREATE DATABASE IF NOT EXISTS"+ DATABASE_NAME);
	    
	    private DatabaseHelper() {
	    	
			if(databaseHelper != null) {
				throw new RuntimeException("Plaese use getDBManager method");
			}else {
				
			}
		}
		
		public static DatabaseHelper getDbHelper() {
			if(databaseHelper == null) {
				synchronized (DatabaseHelper.class) {
					if(databaseHelper == null) {
						databaseHelper= new DatabaseHelper();
					}
				}
			}
			return databaseHelper;
		}
	    
	    public Connection getConnection() {
	    	
	    	if(conn == null) {
	    		synchronized (DatabaseHelper.class) {
					if (conn==null) {
						try {
							Class.forName("com.mysql.jdbc.Driver").newInstance();
							conn = DriverManager.getConnection(url, username, password);
							statement = conn.prepareStatement(sql);
							statement = conn.prepareStatement(CREATE_USER_TABLE);
							statement = conn.prepareStatement(CREATE_ITEM_TABLE);
							
							System.out.println("Database created succesfully!");

						} catch (Exception e) {
							System.out.println("Error from dbconnection"); 
						}
					}
				}
	    	}
	    	
	    	return conn;
	    }
	    
	    
	    public ArrayList<User> getUsers() {
	    	
	    	userList=new ArrayList<>();
	    	

			try {
				String query = "select * from "+TABLE_USER+ " ORDER BY "+USER_ID+" DESC";
				Statement st = getConnection().createStatement();
				ResultSet rs = st.executeQuery(query);

				while (rs.next()) {
					System.out.println(rs.getString(1));
					User usr = new User();

		            usr.setFname(rs.getString(USER_FIRSTNAME));
		            usr.setAddress(rs.getString(USER_ADDRESS));
		            usr.setPhone(rs.getString(USER_PHONE));
		            userList.add(usr);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	        return userList;
	    }
	    
	    
	    
        public ArrayList<Item> getItems() {
           itemList=new ArrayList<>();
	    	

			try {
				
				String query = "select * from "+TABLE_ITEM+ " ORDER BY "+ITEM_ID+" DESC";
				Statement st = getConnection().createStatement();
				ResultSet rs = st.executeQuery(query);

				while (rs.next()) {
					System.out.println(rs.getString(1));
					Item item = new Item();

					item.setItemName(rs.getString(ITEM_NAME));
					item.setPurchasePrice(rs.getDouble((ITEM_PURCHASEPRICE)));
		            item.setSalesPrice(rs.getDouble(ITEM_SALESPRICE));
		            itemList.add(item);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("SQLException Occured");
			}
			
	        return itemList;
	    }
        
        
       public void insertUser(User user) {
    	   
    	   user=new User();
    	   this.user=user;
    	   
    	   try {

                String query = "INSERT INTO `"+TABLE_USER+"` (`"+USER_FIRSTNAME+"`, `"+USER_ADDRESS+"`, `"+USER_PHONE+"`) VALUES ('" + user.getFname() + "', '" + user.getAddress() + "', '" + user.getPhone() + "')";
                Statement st = getConnection().createStatement();
				ResultSet rs = st.executeQuery(query);
				System.out.println("Users Inserted Successfully");
            } 
            catch (Exception eb) {
               eb.printStackTrace();
            }
            
            
       }
       
       public void insertItem(Item item) {
    	   item=new Item();
    	   this.item=item;
    	  
    	   try {

                String query = "INSERT INTO `"+ TABLE_ITEM +"` (`"+ITEM_NAME+"`, `"+ITEM_SALESPRICE+"`, `"+ITEM_PURCHASEPRICE+"`) VALUES ('" + item.getItemName() + "', '" + item.getSalesPrice() + "', '" + item.getPurchasePrice() + "')";
                Statement st = getConnection().createStatement();
				ResultSet rs = st.executeQuery(query);
				System.out.println("Items Inserted Successfully");
            } 
            catch (Exception eb) {
               eb.printStackTrace();
            }
            
            
       }
}
