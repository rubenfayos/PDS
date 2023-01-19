package com.dam.ruben;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Scanner;

public class Cliente {
	
	static PrintWriter salida = null;

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		String host = "localhost";
		int puerto = 1234;
		
		//Inicializacion de variables
		Socket cliente = null;
		ObjectInputStream inObject = null;
		ObjectOutputStream outObject = null;
		
		try{

			cliente = new Socket(host, puerto);
			
			salida = new PrintWriter(new FileWriter("ClienteLog.txt"));

			System.out.println("[" + Calendar.getInstance().getTime() + "] Cliente >> Conexión establecida");
			salida.println("[" + Calendar.getInstance().getTime() + "] Cliente >> Conexión establecida");
			
			//Establecemos los sockets
			inObject = new ObjectInputStream(cliente.getInputStream());
			outObject = new ObjectOutputStream(cliente.getOutputStream());
			
			User u = new User();
			
			//Recibe el objeto
			u = (User) inObject.readObject();
			
			System.out.println("[" + Calendar.getInstance().getTime() + "] Cliente >> Inicio de sesion");
			salida.println("[" + Calendar.getInstance().getTime() + "] Cliente >> Inicio de sesion");
			System.out.println("[" + Calendar.getInstance().getTime() + "] Cliente >> Introduce tu nombre de usuario: ");
			salida.println("[" + Calendar.getInstance().getTime() + "] Cliente >> Introduce tu nombre de usuario: ");
			
			u.setNombre(teclado.nextLine());
			
			System.out.println("[" + Calendar.getInstance().getTime() + "] Cliente >> Introduce tu contraseña: ");
			salida.println("[" + Calendar.getInstance().getTime() + "] Cliente >> Introduce tu contraseña: ");
			
			String contraseña = teclado.nextLine();
			
			contraseña = StringToMD5(contraseña);
					
			u.setContraseña(contraseña);
			
			//Envia el objeto
			outObject.writeObject(u);
			
			u = (User) inObject.readObject();
			
			if(checkLogin(u.getEstado()) == 1) {
				System.out.println("[" + Calendar.getInstance().getTime() + "] Cliente >> Sesion verificada");
				salida.println("[" + Calendar.getInstance().getTime() + "] Cliente >> Sesion verificada");
			}else {
				System.out.println("[" + Calendar.getInstance().getTime() + "] Cliente >> Datos de sesion incorrectos");
				salida.println("[" + Calendar.getInstance().getTime() + "] Cliente >> Datos de sesion incorrectos");
			}
			
		} catch (IOException | ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} finally {
			
			if (salida != null) {
				salida.flush();
		        salida.close(); // **** closing it flushes it and reclaims resources ****
		     }
			
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
			
			System.out.println("[" + Calendar.getInstance().getTime() + "] Cliente >> Sesion terminada");
			salida.println("[" + Calendar.getInstance().getTime() + "] Cliente >> Sesion terminada");
		}

	}
	
	private static String StringToMD5(String contraseña) {
		
		//Convierte la contraseña a hash con MD5
		
		try {
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(contraseña.getBytes());
	        BigInteger number = new BigInteger(1, messageDigest);
	        contraseña = number.toString(16);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
        
		
        return contraseña;
	}
	
	private static int checkLogin(String estado) {
		
		//Comprueba el estado
			
		if (estado.equals("OK")) {
			return 1;
		}

		return 0;
		
	}

}
