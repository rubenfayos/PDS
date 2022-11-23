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
		
		contar(inicioContador, limiteContador, nombreHilo);
			
	}
	
	public void contar(int inicio, int limite, String nombre) {
		
		for(int i = inicio; i <= limite; i++) {
			System.out.println(nombre + ": " + i);
		}
		
	}



	public int getInicioContador() {
		return inicioContador;
	}



	public void setInicioContador(int inicioContador) {
		this.inicioContador = inicioContador;
	}



	public int getLimiteContador() {
		return limiteContador;
	}



	public void setLimiteContador(int limiteContador) {
		this.limiteContador = limiteContador;
	}



	public String getNombreHilo() {
		return nombreHilo;
	}



	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}
}
