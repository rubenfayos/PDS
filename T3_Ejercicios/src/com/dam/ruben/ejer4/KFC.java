package com.dam.ruben.ejer4;

public class KFC implements Runnable{
	
	private int totalAlitas = 100;
	private int alumno;
	

	public int getTotalAlitas() {
		return totalAlitas;
	}

	public void setTotalAlitas(int totalAlitas) {
		this.totalAlitas = totalAlitas;
	}
	
	public int getAlumno() {
		return alumno;
	}

	public void setAlumno(int alumno) {
		this.alumno = alumno;
	}

	@Override
	public void run() {
		
		int alitas = (int) (1+ Math.random()*10);
		consumirAlita(alitas);
		
	}
	
	synchronized private void consumirAlita(int alitas) {
		
		System.out.println("Alumno " + alumno + ", alitas que pide: " + alitas);
		if(totalAlitas-alitas >= 0) {
			totalAlitas -= alitas;
			System.out.println("Hay suficientes, alitas restantes: " + totalAlitas);
		}else {
			System.out.println("No hay suficientes, alitas restantes: " + totalAlitas);
		}
		
		
	}

	
	/*
	private syncronized void consumirAlita(int alitas) {
		
	}
	*/

}
