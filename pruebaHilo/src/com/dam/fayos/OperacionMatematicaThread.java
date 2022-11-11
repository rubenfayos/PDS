package com.dam.fayos;

public class OperacionMatematicaThread implements Runnable {
	
	private String nombre;
	int numEjecucion;

	public OperacionMatematicaThread(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void run() {
		String cad;
		while (numEjecucion < 100) {
			for (double i=0; i<499.9; i=i+0.02) {
				Math.sqrt(i);
			}
			cad = "Soy el hilo " + this.nombre + ", i= " + numEjecucion;
			System.out.println(cad);
			numEjecucion++;
		}
	}
}
