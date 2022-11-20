package com.dam.ruben.ejer5;

public class ControlSemaforos implements Runnable{
	
	private int estado;
	
	
	
	@Override
	public void run() {

		EncenderSemaforo1();
		EncenderSemaforo2();
			
	}
	
	
	public void EncenderSemaforo1() {
		
		System.out.println(Thread.currentThread().getName());
		
		if(estado == 1) {
			System.out.println("Semaforo en verde");
		}else {
			System.out.println("Semaforo en rojo");
		}
		
		
	}
	
	public void EncenderSemaforo2() {
		
		
		System.out.println(Thread.currentThread().getName());
		
		if(estado == 1) {
			System.out.println("Semaforo en rojo");
		}else {
			System.out.println("Semaforo en verde");
		}
		
	}



	public int getEstado() {
		return estado;
	}



	public void setEstado(int estado) {
		this.estado = estado;
	}


}
