package com.dam.ruben.ejer4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.dam.ruben.Persona;

public class Servidor {

	public static void main(String[] args) {

		int port = 5000;
		
		System.out.println("Starting server...");
		
		try {
			
			//Starts the server socket with the port
			ServerSocket server = new ServerSocket(port);
			
			Socket client = server.accept();
			
			//Create a connection between server and client 
			ObjectOutputStream outObjeto = new ObjectOutputStream(client.getOutputStream());
			
			Persona p = new Persona("Rubén", 19, 'M');
			
			//Send the object through the connection
			outObjeto.writeObject(p);
			
			System.err.println("SERVIDOR >> Envio a cliente: " + p.getName() + " - " + p.getAge() + " - " + p.getSex() + "\nEsperando respuesta....");
			
			//Get the object from the client
			ObjectInputStream inObjeto = new ObjectInputStream(client.getInputStream());
			
			//Parse the object
			Persona pMod = (Persona) inObjeto.readObject();
			
			System.err.println("SERVIDOR >> Recibo de cliente: " + pMod.getName()+ " - " + pMod.getAge() + " - " + pMod.getSex());
			
			outObjeto.close();
			inObjeto.close ();
			client.close ();
			server.close();
			
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			
		}

	}

}
