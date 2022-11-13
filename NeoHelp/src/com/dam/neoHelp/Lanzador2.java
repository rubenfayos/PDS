package com.dam.neoHelp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Lanzador2 {
	
	//Lanzador con lectura por bloques

	public static void main(String[] args) throws InterruptedException, IOException {
		
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
		
		Lanzador2 lp = new Lanzador2();
		
		long inicio = System.currentTimeMillis();
		
		// make a connection to the file
		Path file = Paths.get("D:\\DocumentosPrueba\\NEOs.csv");

	    // read all lines of the file
	    long count = 0;
		try {
			
			count = Files.lines(file).count();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BufferedReader br = new BufferedReader(new FileReader("D:\\DocumentosPrueba\\NEOs.csv")); 
		
		int i = 0;
		while(i < count) {
			
			ArrayList<Neo> NEOs = ReadNeo(br);
				
				for(Neo n : NEOs) {
					
					lp.ejecutar(crearLista(n));		
				}
			
			i+=NEOs.size();
			Thread.sleep(1000);
					
		}
		
		br.close();
		
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
	
	public static List<String> crearLista(Neo n) {
		
		//Crea una lista con los parametros
		
		//String dir ="C:\\Users\\DAM 2\\DAM\\PDS\\PDS\\NeoHelp\\bin";
		String dir ="C:\\Users\\Fayos\\DAM\\PDS\\NeoHelp\\bin";
		String clase = "com.dam.neoHelp.Neo";
		
		//Lista de parametros
		List<String> lst = new ArrayList<String>();  
		lst.add("java");
		lst.add(clase);
		
		//Añade el NEO 
		lst.add(n.getNombre());
		lst.add(String.valueOf(n.getPosicionNEO()));
		lst.add(String.valueOf(n.getVelocidadNEO()));
		
		lst.add(dir);
		
		return lst;
		
	}
	
	public static ArrayList<Neo> ReadNeo(BufferedReader br) {
		
		//Método para leer csv
		
		ArrayList<Neo> NEOs = new ArrayList<>();
		
		for(int i = 0; i < 4 ; i++) {
			
			try{   
				
				Neo n = new Neo();
				
				String line = br.readLine();
				
				if(line == null)
					break;
				
				String[] values = line.split(",");    // use comma as separator  
			
				n.setNombre(values[0]);
				n.setPosicionNEO(Double.parseDouble(values[1]));
				n.setVelocidadNEO(Double.parseDouble(values[2]));
				
				NEOs.add(n);
					
					
			}catch (IOException e){  
				e.printStackTrace();  
			}  
			
		}
		
		return NEOs;
		
	}
        
}