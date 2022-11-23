/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package carreracaracoles;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Ruben_Fayos
 */
public class FXMLDocumentController implements Initializable {
    
    private TextArea salidaText;
    @FXML
    private AnchorPane fondo;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void start(ActionEvent event) {
        
        int numHilos = 1;
		
        Caracol c = new Caracol();
        

        for(int i = 1; i <= numHilos; i++) {
            Thread hilo = new Thread(c);
            hilo.setName("Caracol " + i);
            hilo.start();

        }
        
        notifyAll();
        
    }
    
    public class Caracol implements Runnable{
	
	public Caracol() {}
	
	int posicion = 1;
	private HashMap<Integer, String> posiciones = new HashMap<>();

	@Override
	public void run() {
		
		String nombre = Thread.currentThread().getName();
		
		//Le asigna la velocidad aleatoriamente
		double velocidad = 7 + (Math.random() * 10);
                pruen();
                
                //carrera(nombre, velocidad);

				
	}
        
        public void pruen(){
            ProgressBar pb = new ProgressBar();
            pb.setProgress(10);
            fondo.getChildren().add(pb);
        }
	
	public void carrera(String nombre, double velocidad) {
		
		int distacia = 100;
		float distanciaRecorrida = 0;
		
		while(distanciaRecorrida < distacia) {
			
                    salidaText.setText(salidaText.getText() + nombre + ", distancia recorrida: " + distanciaRecorrida + "\n\r");
                    distanciaRecorrida += velocidad;

                    try {
                            Thread.sleep(1000);
                    } catch (InterruptedException e) {
                            e.printStackTrace();
                    }
			
                }
		
		//Asigna la posicion
		posiciones.put(posicion, nombre);
		posicion++;
		
		if(posicion == 6) {
			resultados();
		}
	
	}

	public void resultados() {
		
            for(int i = 1; i <= 5; i++) {
                System.out.println("Nº " + i + ": " + posiciones.get(i));
            }
		
	}
    }
    
}
