package com.dam.neoHelp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		long inicio = System.currentTimeMillis();
		
		ArrayList<Neo> NEOs = ReadNeos();
		
		for(Neo n : NEOs) {
			
			System.out.println("Neo " + n.getNombre() + ": ");
			System.out.println("");
			
		}
		
		long fin = System.currentTimeMillis();
        
        double tiempo = (double) ((fin - inicio)/1000);
         
        System.out.println("Tiempo total de cálculo: " + tiempo + "s");
		

	}
	
	public static ArrayList<Neo> ReadNeos() {
		
		ArrayList<Neo> NEOs = new ArrayList<Neo>();
		String line = "";
		
		try{  
			
		//parsing a CSV file into BufferedReader class constructor  
			
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\DAM 2\\DocumentosPrueba\\NEOs.csv")); 
			
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
