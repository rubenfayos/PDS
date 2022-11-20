package com.dam.ruben.ejer5;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		ControlSemaforos cs = new ControlSemaforos();
		cs.setEstado(1);
		
		Thread hilo = new Thread(cs);
		hilo.setName("Hilo 1");
		hilo.start();
		
		Thread hilo2 = new Thread(cs);
		hilo2.setName("Hilo 2");
		hilo2.start();
		
		hilo.start();
		hilo2.start();

	}

}
