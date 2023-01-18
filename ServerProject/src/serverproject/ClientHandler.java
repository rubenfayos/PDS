/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverproject;

import compartido.Libro;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fayos
 */
public class ClientHandler implements Runnable{

        private final Socket clientSocket;
        private ObjectOutputStream outObjeto;
        private ObjectInputStream inObjeto;
        private SQLModel model;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }
        
        public void Get(Libro l){

            System.err.println("SERVIDOR >> Recibo de cliente");
            switch(l.getOperacion()){

                case 1: Add(l);
                break;

                case 2: Delete(l.getId());
                break;

                case 3: Edit(l.getId());
                break;

                default:
                    break;
            }

        }
        
        public void Add(Libro l){

            model.Insert(l);

        }
        
        public void Delete(int id){

            model.Delete(id);

        }
       
        public void Edit(int id){
        
            Libro l = model.Select(id);
            Send(l);
        
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
            
            model = new SQLModel();
            
            try {
                
                outObjeto = new ObjectOutputStream(clientSocket.getOutputStream());
                inObjeto = new ObjectInputStream(clientSocket.getInputStream());
                
                System.out.println("Conexion establecida");
                
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
                
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
