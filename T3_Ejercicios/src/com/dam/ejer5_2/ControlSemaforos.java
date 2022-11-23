package com.dam.ejer5_2;

public class ControlSemaforos implements Runnable{
	
	//1 = semaforo1 | 2 = semaforo2
	private int estadoSemaforo;
	
	public int getEstadoSemaforo() {
		return estadoSemaforo;
	}

	public void setEstadoSemaforo(int estadoSemaforo) {
		this.estadoSemaforo = estadoSemaforo;
	}

	public synchronized void encenderSemaforo1() {
		
		while(true) {
		
			while(estadoSemaforo == 2) {
				
				System.out.println("Semaforo 1: rojo ");
				
				try {
					//Esperar semaforo 2
					wait();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			
			System.out.println("Semaforo 1: verde ");
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				
			estadoSemaforo = 2;
			notifyAll();
			
		}
			
	}
	
	public synchronized void encenderSemaforo2() {
		
		
		while(true) {
		
			while(estadoSemaforo == 1) {
				
				System.out.println("Semaforo 2: rojo ");
				
				try {
					
					//Esperar semaforo 1
					wait();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
			}
			
			//Como el otro semaforo ahora está rojo pasa este a verde
			System.out.println("Semaforo 2: verde ");
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			estadoSemaforo = 1;
			notifyAll();
		}

		
	}

	@Override
	public void run() {
		
		//Asigna los semaforos
		if(Thread.currentThread().getName().equals("s1")) {
				encenderSemaforo1();
		}
			
		if(Thread.currentThread().getName().equals("s2")) {
				encenderSemaforo2();

		}
			
		
	}
	
}
