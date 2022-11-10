package com.dam.neoHelp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class Neo {
	
	private String nombre;
	private double posicionNEO;
	private double velocidadNEO;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPosicionNEO() {
		return posicionNEO;
	}
	public void setPosicionNEO(double posicionNEO) {
		this.posicionNEO = posicionNEO;
	}
	public double getVelocidadNEO() {
		return velocidadNEO;
	}
	public void setVelocidadNEO(double velocidadNEO) {
		this.velocidadNEO = velocidadNEO;
	}
	
	public static void main(String[] args) {
		
		//Crea un NEO a través de los parámetros leidos y ejecuta el método
		Neo n = new Neo();
		n.setNombre(args[0]);
		n.setPosicionNEO(Double.parseDouble(args[1]));
		n.setVelocidadNEO(Double.parseDouble(args[2]));
		
		n.CalcularProbabilidades();
		
	}
	
	
	public void CalcularProbabilidades() {
		
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
        
        EscribirFichero(this.nombre, salida);

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
