package t4_ejer7;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import t4_ejer7.Libro;

public class Cliente {
    
    String host = "localhost";
    int port = 5000;
    private Socket client;
    private ObjectInputStream inObjeto;
    ObjectOutputStream outObjeto;

	public Cliente() {
		
            try {
                
                System.out.println("Starting client...");
                
                //Starts the client socket
                client = new Socket(host,port);
                
                //Get the object sent from the server
                //inObjeto = new ObjectInputStream(client.getInputStream());
                

                //Create an output from the socket
                outObjeto = new ObjectOutputStream(client.getOutputStream());

                
                //inObjeto.close();
                //client.close();
                
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
			
	}
        
        public void Send(Libro l){
            
            try {

                System.out.println("CLIENTE >> Envio al servidor");

                //Send the object
                outObjeto.writeObject(l);

            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        public Libro Get(){
            
            Libro l = null;
            
            try {

                System.out.println("CLIENTE >> Objeto recibido del servidor");

                l = (Libro) inObjeto.readObject();

            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return l;
        
        }

}
