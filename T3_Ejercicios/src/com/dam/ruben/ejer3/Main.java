package com.dam.ruben.ejer3;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		
		int numHilos = 5;
		
		Caracol c = new Caracol();
		
		for(int i = 1; i <= numHilos; i++) {
			c = new Caracol();
			Thread hilo = new Thread(c);
			hilo.setName("Caracol " + i);
			hilo.start();
	
		}
		

	}

}
