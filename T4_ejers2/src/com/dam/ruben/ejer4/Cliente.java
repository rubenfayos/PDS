package com.dam.ruben.ejer4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import com.dam.ruben.Persona;

public class Cliente {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		String host = "localhost";
		int port = 5000;
		
		System.out.println("Starting client...");

		try {
			
			//Starts the client socket
			Socket client = new Socket(host,port);
			
			//Get the object sent from the server
			ObjectInputStream inObjeto = new ObjectInputStream(client.getInputStream());
			Persona p = (Persona) inObjeto.readObject();
			
			System.out.println("CLIENTE >> Recibo del servidor: "+p.getName() + " - " + p.getAge());
			
			System.out.println("Name: ");
			p.setName(teclado.nextLine());
			
			System.out.println("Age: ");
			p.setAge(teclado.nextInt());
			
			teclado.nextLine();
			
			System.out.println("Sex (M | F): ");
			p.setSex(teclado.nextLine().charAt(0));
			
			//Create an output from the socket
			ObjectOutputStream pMod = new ObjectOutputStream(client.getOutputStream());
			
			//Send the object
			pMod.writeObject(p);
			
			System.out.println("CLIENTE >> Envio al servidor: " + p.getName() + " - " + p.getAge() + " - " + p.getSex());
			inObjeto.close();
			pMod.close();
			client.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
