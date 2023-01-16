package com.dam.neoHelp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class Neo implements Runnable{
	
	private String nombre;
	private double posicionNEO;
	private double velocidadNEO;
	private BufferedReader br;
	
	public Neo() {
		
		try {
			
			this.br = new BufferedReader(new FileReader("D:\\DocumentosPrueba\\NEOs.csv"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
	}
	
	@Override
	public void run() {
		
		readCsv();
	}
	
	public synchronized void readCsv() {
		
		String line;
		
		try {
			
			line = br.readLine();
			if(line == null)
				return;
			
			String[] values = line.split(",");    // use comma as separator  
		
			String nombre = values[0];
			Double posicionNeo = Double.parseDouble(values[1]);
			Double VelocidadNEO = Double.parseDouble(values[2]);
			
			CalcularProbabilidades(nombre, posicionNeo, VelocidadNEO);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public void CalcularProbabilidades(String nombre, Double posicionNeo, Double VelocidadNEO) {
		
		//Obtiene el tiempo de ejecución
		long inicio = System.currentTimeMillis();
		
		double posicionTierra = 1;
		double velocidadTierra = 100;
		
		for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) { 
			posicionNEO = posicionNEO + velocidadNEO * i; 
			posicionTierra = posicionTierra + velocidadTierra * i;
		}
		
		double resultado = 100 * Math.random() *
				Math.pow( ((posicionNEO-posicionTierra)/(posicionNEO+posicionTierra)), 2);
		
		//Salida para el fichero
		String salida = "";
		
		salida += "Neo " + nombre + ": \n";
        salida += "Probabilidades de colisión: " + String.format("%,.2f", resultado) + "%" + "\n";
        
        if(resultado > 10) {
			salida += "¡¡ALERTA POR COLISION!!" + "\n";
		}else {
			salida += "Valores normales" + "\n";
		}
        
		//tiempo de ejecución final
        long fin = System.currentTimeMillis();
        
        double tiempo = (double) ((fin - inicio)/1000);
         
        salida += "Tiempo de cálculo: " + tiempo + "\n";
        
        EscribirFichero(nombre, salida);

	}
	
	public void EscribirFichero(String nombre, String salida) {
		
		//Ruta carpeta datos
		//File f = new File("C:\\Users\\DAM 2\\DocumentosPrueba\\NEOs");
		
		try {
			
			File f= new File("D:\\DocumentosPrueba\\NEOs\\" +nombre + ".txt");
			FileWriter fw = new FileWriter(f);
			fw.write(salida);
			fw.flush();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
