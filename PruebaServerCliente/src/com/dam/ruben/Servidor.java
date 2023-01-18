package com.dam.ruben;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws InterruptedException {

		int port = 5000;
		
		System.out.println("Starting server...");
		
		try {
			
			//Starts the server socket with the port
			ServerSocket server = new ServerSocket(port);
			
			Socket client = server.accept();
			
			Thread.sleep(5000);
			
			//Create a connection between server and client 
			ObjectOutputStream outObjeto = new ObjectOutputStream(client.getOutputStream());
			ObjectInputStream inObjeto = new ObjectInputStream(client.getInputStream());
			
			Persona p = new Persona("Rubén", 19, 'M');
			
			Thread.sleep(5000);
			
			//Send the object through the connection
			outObjeto.writeObject(p);
			
			System.err.println("SERVIDOR >> Envio a cliente: " + p.getName() + " - " + p.getAge() + " - " + p.getSexo());
			
			//Get the object from the client
			
			
			//Parse the object
			Persona pMod = (Persona) inObjeto.readObject();
			
			System.err.println("SERVIDOR >> Recibo de cliente: " + pMod.getName()+ " - " + pMod.getAge());
			
			outObjeto.close();
			inObjeto.close ();
			client.close ();
			server.close();
			
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			
		}

	}

}
