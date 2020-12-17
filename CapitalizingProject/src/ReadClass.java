import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.IIOException;

public class ReadClass {
	
	public static void main(String[] args) throws IOException {
		//FileReader 
		FileReader fileReader=null;
		BufferedReader bufferedReader=null;
		
	    //FileWriter
		FileWriter fileWriter=null;
		PrintWriter printWriter=null;
		
		
		try {
			
			//Reading the File
			//Giving the path of File to read
			fileReader =new FileReader("C:\\Users\\kajanan\\Desktop\\kajanan.txt");
			bufferedReader=new BufferedReader(fileReader);
			
			//Writing the file
			//Giving the path of File to write
			fileWriter=new FileWriter("C:\\Users\\kajanan\\Desktop\\Result.txt");
			printWriter=new PrintWriter(fileWriter);
			
			String thisLineString;
			while((thisLineString=bufferedReader.readLine())!=null) {
				
				System.out.println(thisLineString);
				
				// Creating array of string length 
				char[] ch = new char[thisLineString.length()]; 
		  
		        // Copy character by character into array 
		        for (int i = 0; i < thisLineString.length(); i++) { 
		            ch[i] = thisLineString.charAt(i); 
		        } 
		  
		        to_upper(ch);
		       
		       // Printing content of array 
		        for (char c : ch) { 
		            System.out.print(c); 
		            printWriter.write(c);
		        } 
		        
		       
			}
				
			
		} finally {
			
			if(bufferedReader != null) {
				bufferedReader.close();
			}
			if (fileReader != null) {
				fileReader.close();
			}
			
			if (fileWriter != null) {
				fileWriter.close();
			}
			
			if(printWriter != null) {
				printWriter.close();
			}
		}
		
	
	}
	
	// Converts a string to uppercase 
    static String to_upper(char[] in) 
    { 
        for (int i = 0; i < in.length; i++)  
        { 
            if ('a' <= in[i] & in[i] <= 'z') 
            { 
                in[i] = (char) (in[i] - 'a' + 'A'); 
            } 
        } 
        return String.valueOf(in); 
    } 

}
