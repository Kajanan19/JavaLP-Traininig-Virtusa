package com.kajanan.factory;

public class Application {
	public static void main(String[] args) {
		
		Computer PersonalComputer = ComputerFactory.getComputer("PersonalComputer","2 GB","500 GB","2.4 GHz");
		Computer server = ComputerFactory.getComputer("server","16 GB","1 TB","2.9 GHz");
		
		System.out.println("Factory PC Config::"+PersonalComputer);
		System.out.println("Factory Server Config::"+server);
	
	}
}
