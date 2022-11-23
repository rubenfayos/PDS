package com.dam.neoHelp;

public class Main {

	public static void main(String[] args) {
		
		int numHilos = 10;
		Neo n = new Neo();
		
		for(int i = 0; i < 6; i++) {
			Thread h = new Thread(n);
			h.start();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

	}

}
