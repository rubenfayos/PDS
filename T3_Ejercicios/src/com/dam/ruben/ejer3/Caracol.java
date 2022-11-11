package com.dam.ruben.ejer3;

import java.util.HashMap;

public class Caracol implements Runnable{
	
	public Caracol() {
	}
	
	int posicion = 1;
	private HashMap<Integer, String> posiciones = new HashMap<>();

	@Override
	public void run() {
		
		String nombre = Thread.currentThread().getName();
		double velocidad = 3 + (Math.random() * 10);
		carrera(nombre, velocidad);
				
	}
	
	public void carrera(String nombre, double velocidad) {
		
		int distacia = 100;
		float distanciaRecorrida = 0;
		
		while(distanciaRecorrida < distacia) {
			
			System.out.println(nombre + ", distancia recorrida: " + distanciaRecorrida);
			distanciaRecorrida += velocidad;
			

		}
		
		posiciones.put(posicion, nombre);
		posicion++;
	
	}

	public HashMap<Integer, String> getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(HashMap<Integer, String> posiciones) {
		this.posiciones = posiciones;
	}

	


}
