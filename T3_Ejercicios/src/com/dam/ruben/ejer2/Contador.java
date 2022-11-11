package com.dam.ruben.ejer2;

public class Contador implements Runnable{
	
	private int inicioContador, limiteContador;
	private String nombreHilo;
	
	public Contador(int inicioContador, int limiteContador, String nombreHilo) {
		super();
		this.inicioContador = inicioContador;
		this.limiteContador = limiteContador;
		this.nombreHilo = nombreHilo;
	}
	
	@Override
	public void run() {
		
		for(int i = inicioContador; i <= limiteContador; i++) {
			System.out.println(nombreHilo + ": " + i);
		}
			
	}
}
