package com.dam.ruben.ejer1;

import java.nio.channels.AsynchronousChannel;

public class MostrarASCII implements Runnable{
	
	private int tipo;
	
	public MostrarASCII(int tipo) {
		super();
		this.tipo = tipo;
	}
	
	synchronized public void cuenta(int i) {
		
		while(i <= 255) {
			System.out.println("Hilo " + tipo + ": " + i + ", valor: " + (char)i);
			i += 2;
		}
		
	}
	
	@Override
	public void run() {
		
		int i = 20;
		
		i += tipo;
				
		cuenta(i);
			
	}

}
