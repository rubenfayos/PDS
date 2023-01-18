package com.dam.ruben;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		
		String host = "localhost";
		int port = 5000;
		
		System.out.println("Starting client...");

		try {
			
			//Starts the client socket
			Socket client = new Socket(host,port);
			
			System.out.println("Esperando conexion");
			
			ObjectInputStream inObjeto = new ObjectInputStream(client.getInputStream());
			
			//Create an output from the socket
			ObjectOutputStream pMod = new ObjectOutputStream(client.getOutputStream());
			
			//Get the object sent from the server
			Persona p = (Persona) inObjeto.readObject();
			
			System.out.println("CLIENTE >> Recibo del servidor: "+p.getName() + " - " + p.getAge() + " - " + p.getSexo());
			
			p.setName("Jose Garcia");
			p.setAge(30);
			
			//Send the object
			pMod.writeObject(p);
			
			System.out.println("CLIENTE >> Envio al servidor: "+p.getName() + " - " + p.getAge());
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
