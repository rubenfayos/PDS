/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ae1_t1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author DAM 2
 */
public class AE1_T1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        App app = new App();
        
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        numeros.add(2);
        numeros.add(32);
        numeros.add(76);
        numeros.add(28);
        numeros.add(5);
        numeros.add(121);
        numeros.add(777);
        
        
        Scanner teclado = new Scanner(System.in);
        int eleccion = 0;
        while(eleccion <= 8) {
            System.out.println("Bienvenido a la aplicación elige un apartado: \n1)Hola mundo \n2)Array nombres \n3)Sumar pares \n4)Calcular factorial 15"
                + "\n5)Mayor de un array \n6)Ordenar array inverso \n7)Mostrar salario y puesto \n8)Numeros entre intervalo");
            eleccion = teclado.nextInt();
            
            switch (eleccion) {
                case 1:
                    app.sayHello();
                    break;
                case 2:
                    Apartado2();
                    break;
                case 3:
                    Apartado3();
                    break;
                case 4:
                    Apartado4();
                    break;
                case 5:
                    System.out.println("El número mayor es: " + Apartado5(numeros) + "\n");
                    break;
                case 6:
                    Apartado6();
                    break;
                case 7:
                    Apartado7();
                    break;
                case 8:
                    Apartado8();
                    break;
                
            }
            
        }
        
        
                
        
        
    }
    
    public static void Apartado2(){
        
        /*
        Crea un array de elementos que contenga el nombre de 6 compañeros de clase y...
            a. Haz que se escriban por la consola en líneas consecutivas.
            b. Haz lo mismo, pero empleando un objeto de tipo lista.
        */
        
        String[] compañerosArray = new String[6];
        
        compañerosArray[0] = "Antoni";
        compañerosArray[1] = "Rubén";
        compañerosArray[2] = "Oscar";
        compañerosArray[3] = "Miguel Angel";
        compañerosArray[4] = "Alex";
        compañerosArray[5] = "Carles";
        
        System.out.println("\nArray: ");
        for(String compañero : compañerosArray){
            System.out.println(compañero);
        }
    
        ArrayList<String> compañerosList = new ArrayList<String>();
        
        compañerosList.add("Antoni");
        compañerosList.add("Rubén");
        compañerosList.add("Oscar");
        compañerosList.add("Miguel Angel");
        compañerosList.add("Alex");
        compañerosList.add("Carles");
        
        System.out.println("Lista: ");
        for(String compañero : compañerosList){
            System.out.println(compañero);
        }
        
    }
    
    
    public static void Apartado3(){
        
        //Escribe un método que sume los números pares hasta el número que acepta como
        //parámetro y devuelva el resultado de la suma.
        
        Scanner teclado = new Scanner(System.in);
        
        int num = 0;
        int suma = 0;
        
        do{
            
            System.out.println("Introduce un número: ");
            num = teclado.nextInt();
            suma+= num;
            
        }while(num%2 == 0);
        
        System.out.println("Resultado de la suma: " + suma);
        
        
    }
    
    public static void Apartado4(){
        
        
        //Escribe el código necesario para calcular el factorial del número 15, en menos de 5 instrucciones.

        long suma = 1;
        
        for(int i = 1; i <= 15; i++){
            suma*= i;
        }
        
        System.out.println("El factorial de 15 es: " + suma);
        
    }
    
    public static int Apartado5(ArrayList<Integer> lista){
        
        
        //Escribe un método que acepte un array o una lista de elementos y devuelva el mayor de ellos.

        
        int maxNum = 0;
        
        for(int num : lista){
            if(num > maxNum)
                    maxNum = num;
        }
         
        return maxNum;
        
    }
    
    public static void Apartado6(){
        
        /*
        Escribe un método que pida 5 números enteros (sin validación de momento), los muestre
        por consola en orden inverso y devuelva la suma de todos los números proporcionados.
        */
        
        Scanner teclado = new Scanner(System.in);
        int suma = 0;
        
        ArrayList<Integer> listaNums = new ArrayList<Integer>();
        
        for(int i= 0; i < 5; i++){
            System.out.println("Introduce un número: ");
            listaNums.add(teclado.nextInt());
            suma += listaNums.get(i);
            
        }
        
        System.out.println("Lista en reversa: ");
        
        Collections.sort(listaNums, Collections.reverseOrder());
        
        for(int numeros : listaNums){

            System.out.println(numeros);

        }
        
        
                
    }
    
    public static void Apartado7(){
        
        /*
        Escribe un método que pida por teclado el nombre y los años de experiencia como
        desarrollador de software y muestre el nivel y el salario en base al siguiente criterio:
            a. Si lleva menos de 1 año --> “Desarrollador Junior L1 – 15000-18000”
            b. Si lleva entre 1 y 2 años --> “Desarrollador Junior L2 – 18000-22000”
            c. Si lleva entre 3 y 5 años --> ”Desarrollador Senior L1 – 22000-28000”
            d. Si lleva entre 5 y 8 años --> “Desarrollador Senior L2 – 28000-36000”
            e. Si lleva más de 8 años --> “Analista / Arquitecto. Salario a convenir en base a rol
        */
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Introduce tu nombre: ");
        String nombre = teclado.nextLine();
        
        System.out.println("Introduce tus años de experiencia: ");
        int añosExperiencia = teclado.nextInt();
        
        String puestoSueldo = "";
        
        if(añosExperiencia < 1){
            puestoSueldo =  "Desarrollador Junior L1 – 15000-18000";
        }else if(añosExperiencia >= 1 && añosExperiencia < 3 ){
            puestoSueldo =  "Desarrollador Junior L2 – 18000-22000"; 
        }else if(añosExperiencia >= 3 && añosExperiencia < 5){
            puestoSueldo =  "Desarrollador Senior L1 – 22000-28000";
        }else if(añosExperiencia >= 5 && añosExperiencia < 8){
            puestoSueldo =  "Desarrollador Senior L2 – 28000-36000"; 
        }else if(añosExperiencia >= 8){
            puestoSueldo =  "Analista / Arquitecto. Salario a convenir en base a rol";
        }
        
        System.out.println("Hola " + nombre + " debido a tus experiencia su puesto y sueldo es: " + puestoSueldo);
        
    }
    
    public static void Apartado8(){
        
        /*
        Escribe un método que pida por teclado 2 números como extremos de un intervalo. Luego
        imprime por pantalla todos los números entre ese intervalo, indicando junto al número si es
        un número primo o no. Al terminar de mostrar los números por pantalla, debe mostrar un
        mensaje indicando el tiempo consumido en la ejecución del método.
        */
        
        long startTime = System.nanoTime();
        
        int num1, num2, numAux;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Introduce el primer número: ");
        num1 = teclado.nextInt();
        
        System.out.println("Introduce el segundo número: ");
        num2 = teclado.nextInt();
        
        if(num1 > num2){
            numAux = num1;
            num1 = num2;
            num2 = numAux;
               
        }
        
        String primo;
        
        while(num1 <= num2){
            
            primo = "primo";
            
            for(int i = 2; i < num1; i++){
                if(num1 % i == 0){
                    primo = "no primo";
                    break;
                }
            }
            
            if(num1 != num2)
                System.out.print(num1 + " " + primo + ", ");
            else
                System.out.print(num1 + " " + primo + ".");
            
            num1++;
        }
        
        long endTime   = System.nanoTime();
        long totalTime = (endTime - startTime) / 1000000000;
        System.out.println("\nTiempo de ejecucion: " + totalTime + "s.");
        
        
    }
    
    
    
}
