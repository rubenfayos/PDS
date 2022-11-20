package com.dam.salva;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int numHilos = 2;
		// Crea la cola y los hilos productor y consumidor
		// Hilo productor
		DatosCompartidos dc = new DatosCompartidos(10);
		Productor p = new Productor(dc, "productor");
		Thread productor = new Thread(p);
		Consumidor c = new Consumidor(dc, "consumidor_1");
		Thread consumidor = new Thread(c);
		Consumidor c2 = new Consumidor(dc, "consumidor_2");
		Thread consumidor2 = new Thread(c2);
		
		// Iniciar los hilos
		productor.start();
		consumidor.start();
		consumidor2.start();
		// Finalizar hilos, t1 antes que t2
		try {
			productor.join();
			consumidor.join();
			consumidor2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
