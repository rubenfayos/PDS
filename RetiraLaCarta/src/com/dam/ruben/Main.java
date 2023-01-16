package com.dam.ruben;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		int totalPersonas = Integer.parseInt(args[0]);
		
		ArrayList<Persona> personas = new ArrayList<>();
		
		Juego juego = new Juego();
		
		
		//Recorre y crea las personas
		for(int i = 1; i <= totalPersonas; i++) {
			
			Persona p = new Persona("Persona " + i, juego);
			personas.add(p);
			Thread h = new Thread(p);
			h.start();
			
		}
		
			
		//Comprueba que haya terminado la ejecucion
		while(juego.getBaraja().size() > 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//Imprime la baraja de cada persona
		for(Persona p : personas) {
			System.out.println("\n-----------------------------------------" );
			System.out.println( p.getNombre() + ", cartas recogidas(" + p.getCartasRecogidas().size()+"): " );
			for(String carta : p.getCartasRecogidas()) {
				System.out.println(carta);
			}
			
		}

	}

}
