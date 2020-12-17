import java.io.IOException;

public class AddToBasket {
	 String itemName;
	 double itemPrice;
	 double discountGiven;
	 double finalTotal;
	 WriteToReport writeToReport=new WriteToReport();
	 String writeString;
	 
	//Add Items details and write on Report file
	public void addItemsDetailsToBasket(String itemName, double itemPrice, double discountGiven, double finalTotal) throws ItemsNotFoundException, IOException {
		this.itemName=itemName;
		this.itemPrice=itemPrice;
		this.discountGiven=discountGiven;
		this.finalTotal=finalTotal;
		//Assign to a String
		writeString=itemName+" "+String.valueOf(itemPrice)+" "+String.valueOf(discountGiven)+" "+String.valueOf(finalTotal);
		System.out.println(writeString);
		
		//Write on a file
		writeToReport.writeToReportFile(writeString);
	}
}
