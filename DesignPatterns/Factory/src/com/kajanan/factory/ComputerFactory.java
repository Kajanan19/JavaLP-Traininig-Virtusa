package com.kajanan.factory;

public class ComputerFactory {
	
	public static Computer getComputer(String type, String ram, String hdd, String cpu){
		
		if("PersonalComputer".equalsIgnoreCase(type)) {
			return new PersonalComputer(ram, hdd, cpu);
		}
		else if("Server".equalsIgnoreCase(type)) {
			return new Server(ram, hdd, cpu);
		}else {
			return null;
		}	
		
	}
}
