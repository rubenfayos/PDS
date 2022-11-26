package com.dam.ruben.ejer5;

public class Main {

	public static void main(String[] args) {

		ControlSemaforos cs = new ControlSemaforos();
		cs.setEstadoSemaforo(2);
		
		Thread semaforo1 = new Thread(cs);
		semaforo1.setName("s1");
		semaforo1.start();
		
		Thread semaforo2 = new Thread(cs);
		semaforo2.setName("s2");
		semaforo2.start();
		
	}

}
