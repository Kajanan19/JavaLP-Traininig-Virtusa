package com.kajanan.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable {
	
	 List<String> empList;
	 
	 public Employees() {
		// TODO Auto-generated constructor stub
		 empList = new ArrayList<String>();
	}
	 
	 public Employees(List<String> list){
		 this.empList=list;
	 }
	 
	 public void loadData(){
			//read all employees from database and put into the list
			empList.add("A");
			empList.add("B");
			empList.add("C");
			empList.add("D");
		}
	 
	 public List<String> getEmpList() {
			return empList;
		}
	 
	 @Override
		public Object clone() throws CloneNotSupportedException{
		 
				List<String> temp = new ArrayList<String>();
				for(String s : this.getEmpList()){
					temp.add(s);
				}
				
				return new Employees(temp);
		}

}
