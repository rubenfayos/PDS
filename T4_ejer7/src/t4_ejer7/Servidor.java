package t4_ejer7;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import t4_ejer7.Libro;

public class Servidor implements Runnable{
    
    int port = 5000;
    private ServerSocket server;
    private Socket client;
    ObjectOutputStream outObjeto;
    ObjectInputStream inObjeto;

	public Servidor(){

            try {

                System.out.println("Starting server...");


                //Starts the server socket with the port
                this.server = new ServerSocket(5000);

                


            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
			
	}
        
        public void Add(Libro l){
            
            System.out.print(l.getTitulo());
            
        }
        
       public void Delete(Libro l){
            
            
            
        }
       
       public void Edit(Libro l){
           
       }
       
       public void Get(Libro l){
           
           System.err.println("SERVIDOR >> Recibo de cliente");
           switch(l.getOperacion()){
               
               case 1: Add(l);
               break;
               
               case 2: Delete(l);
               break;
               
               case 3: Edit(l);
               break;
               
               default:
                   break;
           }
           
       }
       
       public void Send(Libro l){
           
        try {
            
            //Send the object through the connection
            outObjeto.writeObject(l);
            
            System.err.println("SERVIDOR >> Envio a cliente");
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
           
       }

    @Override
    public void run() {
        
        System.err.println("Servidor iniciado");
        
        try {
            client = server.accept();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            //Create input connection between server and client
            inObjeto = new ObjectInputStream(client.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(true){
            
            try {
                
                Libro l = (Libro) inObjeto.readObject();
                Get(l);
                
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
     
    }
        
}

