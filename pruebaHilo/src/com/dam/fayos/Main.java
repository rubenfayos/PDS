package com.dam.fayos;

public class Main {

	public static void main(String[] args) {
		
		int numHilos = 2;
		
		OperacionMatematicaThread op;
		
		for(int i = 0; i <numHilos; i++) {
			op = new OperacionMatematicaThread("nº" + i);
			Thread hilo = new Thread(op);
			hilo.start();
		}
		

	}

}
