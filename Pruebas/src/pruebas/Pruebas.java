/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author DAM 2
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        
        Calendar c = Calendar.getInstance();
        
        int mes;
        
        do{
        
        System.out.println("Introduce tu mes de nacimiento: \n1.-Enero \n2.-Febrero \n3.-Marzo \n4.-Abril \n5.-Mayo \n6.-Junio "+
"	            "+ "\n7.-Julio \n8.-Agosto \n9.-Septiembre \n10.-Octubre \n11.-Noviembre \n12.-Diciembre");
        
        mes = teclado.nextInt() - 1;
        
        if(mes > 11){
            System.out.println("No es un mes correcto");
        }
        
        }while(mes > 11);
        
        c.set(Calendar.MONTH, mes);
        
        System.out.println("Ahora introduce tu dia de nacimiento: ");
        
        int dia = teclado.nextInt();
        
        c.set(Calendar.DAY_OF_MONTH, dia);
        
        int yearDay =c.get(Calendar.DAY_OF_YEAR);
        
        if(yearDay > 20 && yearDay <= 50){
            System.out.println("Eres Acuario");
            
        }else if(yearDay >= 51 && yearDay <= 79){
            System.out.println("Eres Piscis");
            
        }else if(yearDay >= 80 && yearDay <= 110){
            System.out.println("Eres Aries");
            
        }else if(yearDay >= 111 && yearDay <= 141){
            System.out.println("Eres Tauro");
            
        }else if(yearDay >= 142 && yearDay <= 173){
            System.out.println("Eres Géminis");
            
        }else if(yearDay >= 174 && yearDay <= 204){
            System.out.println("Eres Cancer");
            
        }else if(yearDay >= 205 && yearDay <= 235){
            System.out.println("Eres Leo");
            
        }else if(yearDay >= 236 && yearDay <= 266){
            System.out.println("Eres Virgo");
            
        }else if(yearDay >= 267 && yearDay <= 296){
            System.out.println("Eres Libra");
            
        }else if(yearDay >= 297 && yearDay <= 326){
            System.out.println("Eres Escorpio");
            
        }else if(yearDay >= 327 && yearDay <= 355){
            System.out.println("Eres Sagitario");
            
        }else if(yearDay >= 356 && yearDay <= 19){
            System.out.println("Eres Capricornio");
        }
        
        System.out.println("Prediccion: ");
        
        ArrayList<String> predicciones = new ArrayList<String>();
        
        predicciones.add("Vas a morir en breve");
        predicciones.add("Te va a ir bien en el trabajo");
        predicciones.add("Pedro Sánchez va a aparecer en tu casa y te va a matar");
        predicciones.add("Te vas a encontrar un billete de 300€");
        predicciones.add("Te vas a quedar calvo/a");
        predicciones.add("Vas a ir a comer al Domino's Pizza");
        predicciones.add("Salva te va a mandar muchos ejercicios");
        predicciones.add("Te van a invitar a un bocadillo xxl del Reyton");
        predicciones.add("Un perro te va a morder el culo");
        predicciones.add("Te va a tocar la lotería");
        
        int prediccion = (int) (Math.random() * (predicciones.size() - 0 + 1) + 0);
        
        System.out.println("Prediccion: " +  predicciones.get(prediccion));
        
        
       

    }
    
}
