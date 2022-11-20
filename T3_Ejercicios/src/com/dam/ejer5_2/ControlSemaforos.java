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
			
		estadoSemaforo = 2;
		notifyAll();
			
	}
	
	public synchronized void encenderSemaforo2() {
		
		
		while(estadoSemaforo == 1) {
			
			System.out.println("Semaforo 2: rojo ");
			
			try {
				//Esperar semaforo 1
				wait();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
		}
		
		System.out.println("Semaforo 2: verde ");
		
		
		
		estadoSemaforo = 1;
		notifyAll();

		
	}

	@Override
	public void run() {
		
		while(true) {
			
			if(Thread.currentThread().getName().equals("s1")) {
					encenderSemaforo1();
			}
				
			if(Thread.currentThread().getName().equals("s2")) {
					encenderSemaforo2();
	
			}
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
}
