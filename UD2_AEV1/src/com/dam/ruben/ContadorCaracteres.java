package com.dam.ruben;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ContadorCaracteres {

	public static int contar(char caracter, String nombreFichero) {
		int repeticiones = 0;
		String linea;

		try {
			FileInputStream fichero = new FileInputStream(nombreFichero);
			InputStreamReader fir = new InputStreamReader(fichero);
			BufferedReader br = new BufferedReader(fir);
			
			while((linea=br.readLine())!=null) {
				for(int i = 0; i < linea.length(); i++) {
					
		        	if(linea.charAt(i) == caracter) {
		        		repeticiones++;
		        	}
		        }		        
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("No se pudo abrir el fichero");

		} catch (IOException e) {
			System.out.println("No hay nada en el fichero");
		}
		
		return repeticiones;		
	}
	
	public static void main(String[] args) {
		
		//caracter a buscar
		char caracter = args[0].charAt(0);
		
		//Ruta al fichero datos
		String nombreFichero = args[1];
		
		//Cuenta las repeticiones del caracter
		int numero=contar(caracter, nombreFichero);	
		
		//Escribe el resultado en un fichero con su nombre
		writeFile(caracter, numero, args[2]);
	}
	
	public static void writeFile(char caracter,int repeticiones, String fichero) {
		
		try {
			
			FileWriter fw = new FileWriter(fichero);
			
			fw.write("Total repeticiones caracter " + caracter + ": " + repeticiones);
			fw.flush();
			fw.close();
			
		} catch (IOException e) {
			System.out.println("Algo ha fallado con el documento de salida");
		}
		
		
	}

}
