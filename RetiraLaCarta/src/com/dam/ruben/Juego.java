package com.dam.ruben;

import java.util.ArrayList;

public class Juego {
	
	ArrayList<String> baraja;
	
	public ArrayList<String> getBaraja() {
		return baraja;
	}

	public void setBaraja(ArrayList<String> baraja) {
		this.baraja = baraja;
	}

	public Juego() {
		
		//Creacion de baraja automatizada	
		baraja = new ArrayList<>();
		
		String[] palos = {"Espadas", "Bastos", "Copas", "Oros"};
		for(String p: palos) {
			for(int i = 1; i <= 12; i++) {
				baraja.add(i + " de " + p);
			}
		}
		
		
	}
	
	public synchronized String sacarCarta() {
		
		if(baraja.size() == 0) {
			return null;
		}else {
			
			//Coge un index aleatorio
			int cartaAleatoria = (int) (1 + Math.random()* baraja.size() - 1);
			
			//Saca la carta y la elimina
			String carta = baraja.get(cartaAleatoria);
			baraja.remove(cartaAleatoria);
			return carta;
		}
		
		
		
		
	}

}
