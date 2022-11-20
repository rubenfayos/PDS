package com.dam.ruben.ejer4;

public class Main {

	public static void main(String[] args) throws InterruptedException {
	
		KFC kfc = new KFC();
		
		while(kfc.getTotalAlitas() > 0) {
			for(int i = 1; i <= 30; i++) {
				//Comprueba si siguen quedando alitas
				if(kfc.getTotalAlitas() == 0)
					break;
				
				kfc.setAlumno(i);
				Thread hilo = new Thread(kfc);
				hilo.start();
			}
		}

	}

}
