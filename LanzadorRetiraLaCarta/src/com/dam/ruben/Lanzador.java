package com.dam.ruben;

import java.io.File;

public class Lanzador {
	
	public static void main(String[] args) {
		
		Lanzador lp = new Lanzador();
		
		//Ruta de la carpeta bin
		String ruta = "C:\\Users\\DAM 2\\DAM\\PDS\\PDS\\RetiraLaCarta\\bin";
		
		//Fichero para la salida de la ejecucion
		String ficheroSalida = "C:\\Users\\DAM 2\\DocumentosPrueba\\RetiraLaCarta.txt";
		
		//Ejecuta
		lp.ejecutar(ruta, "4", ficheroSalida);
		
		System.out.println("Lanzado");
		
		
	}
	
	//Lanzar el Main
	public void ejecutar (String ruta, String totalPersonas, String ficheroSalida) {
		
		String clase = "com.dam.ruben.Main";
		

		try {
			
			ProcessBuilder pb = new ProcessBuilder("java", clase, totalPersonas);
			pb.directory(new File(ruta));
			
			//Salida
			pb.redirectOutput(new File(ficheroSalida));
			pb.start();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
