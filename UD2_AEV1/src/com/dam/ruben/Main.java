package com.dam.ruben;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static final String PREFIJO_FICHEROS = "fichero_";
	
	public static void lanzarContadorCaracteres(String ruta, String caracter, String nombreFicheroDatos, File dir, String nombreFicheroResultado) throws IOException {
		
		ProcessBuilder pb;
        try{
            pb = new ProcessBuilder("java",
            						ruta,
            						caracter,
            						nombreFicheroDatos,
            						nombreFicheroResultado);
            pb.directory(dir);
            //Solo funciona uno de los 2 al mismo tiempo
            //pb.redirectOutput(new File("C:\Users\DAM 2\DAM\PDS\PDS\T2A1\archivos\\salida.txt"));
            pb.inheritIO();
            pb.start();
        }catch(Exception e){
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.out.println("Generando informe...");
		
		//Rutas
		File dir = new File("C:\\Users\\DAM 2\\DAM\\PDS\\PDS\\UD2_AEV1\\bin");
		String ruta = "com.dam.ruben.ContadorCaracteres";
		String rutaFicheroDatos = "C:\\Users\\DAM 2\\DocumentosPrueba\\MaterialEntregable\\Datos.txt";
		
		//Nombre y inicializacion
		String nombre = "ruben";
		String caracter = null;
		
		//Iteración del nombre
		for(int i = 0; i< nombre.length(); i++) {
			iar
			caracter = String.valueOf(nombre.charAt(i));
			String rutaFicheroResultado = "C:\\Users\\DAM 2\\DocumentosPrueba\\MaterialEntregable\\" + PREFIJO_FICHEROS + caracter + ".txt";
			
			//Lanzador del proceso
			lanzarContadorCaracteres(ruta, caracter, rutaFicheroDatos, dir, rutaFicheroResultado);
			
		}
		
		//Espera para la creacion de ficheros
		Thread.sleep(1000);
		
		System.out.println("Información generada: ");
		lecturaFicheros(nombre);

	}
	
	public static void lecturaFicheros(String nombre) {
		
		String caracter;
		
		//Lectura ficheros
		for(int i = 0; i< nombre.length(); i++) {
			
			caracter = String.valueOf(nombre.charAt(i));
			try {
				
				FileReader FicheroResultado = new FileReader("C:\\Users\\DAM 2\\DocumentosPrueba\\MaterialEntregable\\" + PREFIJO_FICHEROS + caracter + ".txt");
				BufferedReader bf = new BufferedReader(FicheroResultado);
				System.out.println(bf.readLine());
				
			} catch (FileNotFoundException e) {
				System.out.println("No se ha podido leer algún fichero");
			} catch (IOException e) {
				System.out.println("No se ha podido leer algún fichero");
			}
			
			
			
		}
		
	}

}
