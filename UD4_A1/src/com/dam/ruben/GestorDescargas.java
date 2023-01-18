package com.dam.ruben;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class GestorDescargas {
	
	public void descargarArchivo(String urlDescarga, String nombreArchivo) {
		
		System.out.println("Descargando " + urlDescarga);
		
		try {
			// Creamos un objeto de tipo URL
			URL url = new URL(urlDescarga);
			
			// Abrimos un canal de comunicacion de bytes con la url en cuesti�n.
			InputStream is = url.openStream();
			
			// Con el objeto InputStreamReader podemos convertir bytes en caracteres.
			InputStreamReader reader = new InputStreamReader(is);
			
			// Con el objeto BufferedReader podemos leer bloques enteros de  texto.
			BufferedReader bReader = new BufferedReader(reader);
			
			// Con el objeto fileWriter creamos un fichero en local con lo que hemos leido del servidor.
			FileWriter escritorFichero = new FileWriter(nombreArchivo);
			String linea;
			
			while ((linea = bReader.readLine()) != null) {
				escritorFichero.write(linea);
			}
			
			escritorFichero.close();
			bReader.close();
			reader.close();
			is.close();
			
			System.out.println("Fichero descargado correctamente en: " + nombreArchivo);
			
		} catch (MalformedURLException e) {
			System.out.println("URL mal escrita!");
		} catch (IOException e) {
			System.out.println("Fallo en la lectura del fichero");
		}
	}
}