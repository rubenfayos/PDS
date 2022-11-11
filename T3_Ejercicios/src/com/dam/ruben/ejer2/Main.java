package com.dam.ruben.ejer2;

public class Main {

	public static void main(String[] args) {
		
		int numHilos = 5;
		
		for(int i = 1; i <= numHilos; i++) {
			Contador c = new Contador(1*i, 5*i, "Hilo " + i);
			Thread hilo = new Thread(c);
			hilo.start();
		}


	}

}
