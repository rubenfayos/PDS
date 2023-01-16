package com.dam.ruben;

public class Main {

	public static void main(String[] args) {
		
		GestorDescargas gd=new GestorDescargas();
		String url= "http://localhost:80/PSP/prueba.txt";
		String nombreArchivo= "ejemplo_local.txt";
		
		// String url= "http://localhost:80/psp/ejemplo.jpg";
		// String nombreArchivo= "ejemplo_local.jpg";
				
		gd.descargarArchivo(url, nombreArchivo);		
	}

}
