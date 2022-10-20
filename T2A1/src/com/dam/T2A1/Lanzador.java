package com.dam.T2A1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lanzador {

	public static void main(String[] args) {
		
		File dir = new File("C:\\Users\\DAM 2\\DAM\\PDS\\PDS\\T2A1\\bin");
		String clase = "com.dam.T2A1.Suma";
		
		Lanzador lp = new Lanzador();
		File output1 = new File("C:\\Users\\DAM 2\\DAM\\PDS\\PDS\\T2A1\\archivos\\output1.txt");
        lp.ejecutar(clase, 10, 20, dir, output1.getAbsolutePath());
        File output2 = new File("C:\\Users\\DAM 2\\DAM\\PDS\\PDS\\T2A1\\archivos\\output2.txt");
        lp.ejecutar(clase, 20, 30, dir, output2.getAbsolutePath());
        
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        lp.readFile(output1);
		lp.readFile(output2);
        
        
    }
    
    public void ejecutar(String ruta, Integer n1, Integer n2, File dir, String output){
        ProcessBuilder pb;
        try{
            pb = new ProcessBuilder("java",
            						ruta,
            						n1.toString(),
            						n2.toString(),
            						output);
            pb.directory(dir);
            //Solo funciona uno de los 2 al mismo tiempo
            //pb.redirectOutput(new File("C:\Users\DAM 2\DAM\PDS\PDS\T2A1\archivos\\salida.txt"));
            pb.inheritIO();
            pb.start();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    
    public void readFile(File f){
    	
    	try {	
    		
	    	FileReader fr = new FileReader(f);
	    	int c = 0;
    	
			while(( c = fr.read()) != -1) {
				System.out.print((char)c);
			}
			
			System.out.println();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Algún error ha ocurrido");
		}
	
    }

}
