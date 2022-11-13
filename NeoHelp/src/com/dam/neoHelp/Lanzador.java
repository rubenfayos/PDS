package com.dam.neoHelp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lanzador {
	
	//Lanzador sin lectura por bloques

	public static void main(String[] args) throws InterruptedException {
		
		//Directorio con los ficheros del resultado
		File f = new File("D:\\DocumentosPrueba\\NEOs");
		
		//Elimina los ficheros existentes
		if(f.exists()) {
			
			File[] files = f.listFiles();
			
			for(File tempf : files) {
				tempf.delete();
			}
			
		}else
			f.mkdir();
		
		//String dir ="C:\\Users\\DAM 2\\DAM\\PDS\\PDS\\NeoHelp\\bin";
		String dir ="C:\\Users\\Fayos\\DAM\\PDS\\NeoHelp\\bin";
		String clase = "com.dam.neoHelp.Neo";
		Lanzador lp = new Lanzador();
		
		long inicio = System.currentTimeMillis();
		
		ArrayList<Neo> NEOs = ReadNeos();
		
		int i = 0;
		
		while(i < NEOs.size()) {
			
			for(int l = 0; l < 4; l++) {
				
				//Comprobación cantidad de NEOs restantes
				if(l+i >= NEOs.size())
					break;
				
				Neo n = NEOs.get(l+i);
				
				
				
				//Lista de parametros
				List<String> lst = new ArrayList<String>();  
				lst.add("java");
				lst.add(clase);
				
				//Añade el NEO 
				lst.add(n.getNombre());
				lst.add(String.valueOf(n.getPosicionNEO()));
				lst.add(String.valueOf(n.getVelocidadNEO()));
				
				lst.add(dir);
				lp.ejecutar(lst);
				
			}
			
			i+=4;
			Thread.sleep(1000);
			
				
		}
		
		long fin = System.currentTimeMillis();
        
        double tiempo = (double) ((fin - inicio)/1000);
         
        System.out.println("Tiempo total de cálculo: " + tiempo + "s");
				

	}
	
	public void ejecutar(List<String> lst){
		
        ProcessBuilder pb;
        
        try{
        	//Añade la ruta de la clase y la elimina
        	File dir = new File((String) lst.get(5));
        	lst.remove(5);
        	
            pb = new ProcessBuilder(lst);
            pb.directory(dir);
            pb.inheritIO();
            pb.start();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
	}
	
	public static ArrayList<Neo> ReadNeos() {
		
		//Método para leer csv
		
		ArrayList<Neo> NEOs = new ArrayList<Neo>();
		String line = "";
		
		try{  
			
		//parsing a CSV file into BufferedReader class constructor  
			
			BufferedReader br = new BufferedReader(new FileReader("D:\\DocumentosPrueba\\NEOs.csv")); 
			
			while ((line = br.readLine()) != null){  
				
				Neo n = new Neo();
				
				String[] values = line.split(",");    // use comma as separator  
			
				n.setNombre(values[0]);
				n.setPosicionNEO(Double.parseDouble(values[1]));
				n.setVelocidadNEO(Double.parseDouble(values[2]));
				NEOs.add(n);
				
			}
			
		}catch (IOException e){  
			e.printStackTrace();  
		}  
		  
		
		return NEOs;
		
	}
        
}