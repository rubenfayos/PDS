package com.dam.ruben.ejer3;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		
		int numHilos = 5;
		
		Caracol c = new Caracol();
		
		for(int i = 1; i <= numHilos; i++) {
			Thread hilo = new Thread(c);
			hilo.setName("Caracol " + i);
			hilo.start();
	
		}
		
		
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		HashMap<Integer, String> posiciones = c.getPosiciones();
		
		for(int i = 1; i <= 5; i++) {
			System.out.println("Nº " + i + ": " + posiciones.get(i));
		}
		
		


	}

}
