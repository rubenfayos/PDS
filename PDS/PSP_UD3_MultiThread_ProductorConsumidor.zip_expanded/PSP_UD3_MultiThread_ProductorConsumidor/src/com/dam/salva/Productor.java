package com.dam.salva;

import java.util.LinkedList;

public class Productor implements Runnable {

	
	DatosCompartidos dc;
	String nombre;
	// Funcion del productor
	
	public Productor(DatosCompartidos dc, String nombre) {
		this.dc = dc;
		this.nombre = nombre;
	}
	

	@Override
	public void run() {		
		int valor = 0;
		while(true) {
			valor++;
			int stock = dc.producir(valor);
			System.err.println(this.nombre + " - produce item  - STOCK:" + stock);
			try {
				Thread.sleep((int) (Math.random() * 3000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
