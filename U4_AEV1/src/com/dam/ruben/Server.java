package com.dam.ruben;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Server {

	static DateFormat dateFormat = null;
	static PrintWriter salida;
	
	public static void main(String[] args) {
		
		int puerto = 1234;
		
		//Inicializacion de variables
		Socket cliente = null;
		ObjectInputStream inObject = null;
		ObjectOutputStream outObject = null;
		ServerSocket server = null;
		
		//Fecha para el log
		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		try {
			
			salida = new PrintWriter(new FileWriter("ServerLog.txt"));
			server= new ServerSocket(puerto);
			
			cliente = server.accept();
			
			System.out.println("[" + Calendar.getInstance().getTime() + "] Servidor >> Conexion con cliente establecida");
			salida.println("[" + Calendar.getInstance().getTime() + "] Servidor >> Conexion con cliente establecida");
			
			//Establecemos los sockets
			outObject = new ObjectOutputStream(cliente.getOutputStream());
			inObject = new ObjectInputStream(cliente.getInputStream());
			
			User u = new User();
			
			outObject.writeObject(u);
			
			u = (User) inObject.readObject();
			
			System.out.println("[" + Calendar.getInstance().getTime() + "] Servidor >> Peticion de sesion recibida");
			salida.println("[" + Calendar.getInstance().getTime() + "] Servidor >> Peticion de sesion recibida");
			
			//Comprueba los datos del usuario
			u = checkUser(u);
			
			outObject.writeObject(u);
			
			salida.flush();
			salida.close();
			
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			
			//Cerrando conexiones
			salida.flush();
			salida.close();
			
			try {
				cliente.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				outObject.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				inObject.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("[" + Calendar.getInstance().getTime() + "] Servidor >> Sesion terminada");
			salida.println("[" + Calendar.getInstance().getTime() + "] Servidor >> Sesion terminada");
			
		}
		
	}
	
	
	private static User checkUser(User checkUser) {
		
		//devuelve el usuario comprobado
		
		ArrayList<User> usuarios = new ArrayList<User>();
		usuarios.add(new User("Pepe", "ab969aa0034b1f4fbe8dc46845139a19"));
		usuarios.add(new User("Paco", "4ace048d93419dc5064c42f638199102"));
		usuarios.add(new User("Emma", "d8578edf8458ce06fbc5bb76a58c5ca4"));
		usuarios.add(new User("Paula", "dcddffaeeeaa015163376cfac35eeeca"));

		
		for(User u: usuarios) {
			
			if (u.getNombre().equals(checkUser.getNombre()) && u.getContraseña().equals(checkUser.getContraseña()) ) {
				System.out.println("[" + Calendar.getInstance().getTime() + "] Servidor >> Datos de sesion correctos");
				salida.println("[" + Calendar.getInstance().getTime() + "] Servidor >> Datos de sesion correctos");
				checkUser.setEstado("OK");
				return checkUser;
			}
			
		}
		
		System.out.println("[" + Calendar.getInstance().getTime() + "] Servidor >> Datos de sesion incorrectos");
		salida.println("[" + Calendar.getInstance().getTime() + "] Servidor >> Datos de sesion incorrectos");
		checkUser.setEstado("ERROR");
		return checkUser;
		
	}

}
