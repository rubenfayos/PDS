package com.dam.ruben.ejer1;

public class Main {

	public static void main(String[] args) {
		
		int numHilos = 2;
		
		for(int i = 1; i <= numHilos; i++) {
			MostrarASCII ma = new MostrarASCII(i);
			Thread hilo = new Thread(ma);
			hilo.start();
		}


	}

}
