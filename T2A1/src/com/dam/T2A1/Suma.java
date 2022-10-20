package com.dam.T2A1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Suma {

public static int sumar(int n1, int n2){
        
        int suma = 0;
        for(int i = n1; i < n2; i++){
            
            suma = suma+i;
            
        }
        
        return suma;
          
    }
    
    public static void main(String[] args){
        
        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);
        
        int suma = sumar(n1, n2);
        
        System.out.println("El resultado es: " + suma);
        
        try {
	        File f = new File(args[2]);
	        FileWriter fWritter = new FileWriter(f);
			fWritter.write("El resultado es: " + suma);
			fWritter.flush();
			fWritter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
