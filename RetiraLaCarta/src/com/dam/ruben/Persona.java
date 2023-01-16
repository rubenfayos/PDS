package com.dam.ruben;

import java.util.ArrayList;

public class Persona implements Runnable{
	
	private String nombre;
	private Juego juego;
	private ArrayList<String> cartasRecogidas;
	
	public Persona(String nombre, Juego juego) {
		this.nombre = nombre;
		this.juego = juego;
		this.cartasRecogidas = new ArrayList<>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public ArrayList<String> getCartasRecogidas() {
		return cartasRecogidas;
	}

	@Override
	public void run() {
		
		boolean comp = true;
		
		while(comp) {
			
			//Saca la carta
			String cartaSacada = juego.sacarCarta();
			
			//Comprueba que queden cartas
			if(cartaSacada != null) {
				
				//Muestra la carta sacada
				System.out.println(nombre + " ha sacado " + cartaSacada);
				
				//Añade la carta sacada al array
				cartasRecogidas.add(cartaSacada);
				
			}else {
				comp = false;
			}
			
			try {
				
				Thread.sleep((int) (1 + Math.random()* 5000));
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	
	

}
