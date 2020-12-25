package com.kajanan.cor;

public class DollarTenDispenser implements DispenseChain {
	
	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		// TODO Auto-generated method stub
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		// TODO Auto-generated method stub
		if(cur.getAmount() >= 10){
			
			int num = cur.getAmount()/10;
			int remainder = cur.getAmount() % 10;
			System.out.println("Dispensing "+num+" 10$ note");
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		}else{
			
			this.chain.dispense(cur);
		}
	}

}
