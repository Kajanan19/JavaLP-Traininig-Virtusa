package com.kajanan.cor;

import java.util.Scanner;

public class Application {
	
	private DispenseChain c1;

	public Application() {
		// initialize the chain
		this.c1 = new DollarFiftyDispenser();
		DispenseChain c2 = new DollarTwentyDispenser();
		DispenseChain c3 = new DollarTenDispenser();

		// set the chain of responsibility
		c1.setNextChain(c2);
		c2.setNextChain(c3);
	}

	public static void main(String[] args) {
		Application application = new Application();
		while (true) {
			int amount = 0;
			System.out.println("Enter amount to dispense");
			Scanner input = new Scanner(System.in);
			amount = input.nextInt();
			if (amount % 10 != 0) {
				System.out.println("Amount should be in multiple of 10s.");
				return;
			}
			// process the request
			application.c1.dispense(new Currency(amount));
		}

	}

}
