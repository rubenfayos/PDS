package com.dam.ruben.ejer2;

public class Main {

	public static void main(String[] args) {
		
		int numHilos = 5;
		
		Contador c = new Contador(1, 5, "Hilo 1");
		
		for(int i = 1; i <= numHilos; i++) {
			c.setNombreHilo("Hilo " + i);
			c.setLimiteContador(500*i);
			Thread hilo = new Thread(c);
			hilo.start();
			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			
		}	


	}

}
