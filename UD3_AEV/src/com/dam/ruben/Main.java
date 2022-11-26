package com.dam.ruben;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<Minero> mineros = new ArrayList<>();
		
		Mina mina = new Mina(200);
		
		int totalMineros = 10;
		
		for(int i = 1; i <= totalMineros; i++) {
			
			//Le añade la mina y el nombre
			Minero minero = new Minero(mina, "Minero " + i);
			mineros.add(minero);
			
			//Tiempo de recoleccion aleatorio
			minero.setTiempoRecoleccion((int) (1+ Math.random()*10));
			Thread hilo = new Thread(minero);
			
			hilo.start();		
				
		}
		
		while(mina.getStock() > 0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//Muestra el total recolectado cuando termine
		for(Minero m : mineros) {
			System.out.println(m.getNombre() + " total recolectado: " + m.getBolsa());
		}
		
	}

}
