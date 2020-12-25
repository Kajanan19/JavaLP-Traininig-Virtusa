package com.kajanan.prototype;

import java.util.List;

public class Application {
	public static void main(String[] args)  {
		Employees emps = new Employees();
		emps.loadData();
		try {
			//Use the clone method to get the Employee object
			Employees empsNew = (Employees) emps.clone();
			Employees empsNew1 = (Employees) emps.clone();
			
			List<String> list = empsNew.getEmpList();
			list.add("E");
			
			List<String> list1 = empsNew1.getEmpList();
			list1.remove("A");
			
			System.out.println("emps List: "+emps.getEmpList());
			System.out.println("empsNew List: "+list);
			System.out.println("empsNew1 List: "+list1);
		} catch (CloneNotSupportedException e) {
			// TODO: handle exception
			System.out.println("CloneNotSupportedException Occured: "+e);
		}
		
	}
	
}
