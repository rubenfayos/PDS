package com.dam.ruben;

public class Minero implements Runnable{

	private int bolsa;
	private int tiempoRecoleccion = 3;
	private Mina m;
	private String nombre;
	
	public void setTiempoRecoleccion(int tiempoRecoleccion) {
		this.tiempoRecoleccion = tiempoRecoleccion;
	}

	public int getBolsa() {
		return bolsa;
	}
	
	public String getNombre() {
		return nombre;
	}

	public Minero(Mina m, String nombre) {
		this.bolsa = 0;
		this.m = m;
		this.nombre = nombre;
	}

	public synchronized void recolectarRecursos(int cantidadRecolectar) {
		
		if(cantidadRecolectar <= m.getStock()) {
			m.setStock((int) (m.getStock() - cantidadRecolectar));
			System.out.println(nombre + " ha recolectado: " + cantidadRecolectar + ", Cantidad restante: " + m.getStock() );
			bolsa += cantidadRecolectar;
		}else {
			System.out.println(nombre +", no hay suficientes recuros" + ", Cantidad restante: " + m.getStock() );
		}
		
		
		try {
			
			//Espera para la recoleccion
			Thread.sleep(tiempoRecoleccion * 1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		
		while(m.getStock() > 0) {
			
			recolectarRecursos((int) (1+ Math.random()*10));
				
		}
		
		
	}
}
