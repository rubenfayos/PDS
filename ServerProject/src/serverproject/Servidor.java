package serverproject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor{
    
    private static ServerSocket server;
    private static Socket client;
    
    
    private SQLModel model;

    public static void main(String[] args){
        
        try {
            
            server = new ServerSocket(5000);
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while (true) {
            
            try {
                
                Socket client = server.accept();
                System.out.println("New client connected");
                ClientHandler cliente = new ClientHandler(client);
                new Thread(cliente).start();
                
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
          
    

