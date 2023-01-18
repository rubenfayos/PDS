package com.dam.ruben;

public class Main {

	public static void main(String[] args) {
		
		GestorDescargas gd=new GestorDescargas();
		String url= "http://localhost:80/Pr/Hola.txt";
		String nombreArchivo= "ejemplo_local2.txt";
		
		// String url= "http://localhost:80/psp/ejemplo.jpg";
		// String nombreArchivo= "ejemplo_local.jpg";
				
		gd.descargarArchivo(url, nombreArchivo);		
	}

}
