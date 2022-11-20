package com.dam.salva;

import java.util.LinkedList;

public class Consumidor implements Runnable {

	
	DatosCompartidos dc;
	String nombre;
	// Funcion del productor
	
	public Consumidor(DatosCompartidos dc, String nombre) {
		this.dc = dc;
		this.nombre = nombre;
	}	

	@Override
	public void run() {		
		while(true) {
			int stock = dc.consumir();
			System.err.println(this.nombre + " - consume item - STOCK:" + stock);
			try {
				Thread.sleep((int) (Math.random() * 3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
