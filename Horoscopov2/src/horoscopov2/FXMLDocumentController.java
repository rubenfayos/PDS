/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package horoscopov2;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

/**
 *
 * @author DAM 2
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button button;
    @FXML
    private DatePicker fecha;
    private Label signo;
    @FXML
    private Label signoText;
    @FXML
    private Label prediccionText;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        

        int yearDay = fecha.getValue().getDayOfYear();
        
        String signo = "";
        
        
        if(yearDay > 20 && yearDay <= 50){
            signo =  "Acuario";
            
        }else if(yearDay >= 51 && yearDay <= 79){
            signo =  "Piscis";
            
        }else if(yearDay >= 80 && yearDay <= 110){
            signo =  "Aries";
            
        }else if(yearDay >= 111 && yearDay <= 141){
            signo =  "Tauro";
            
        }else if(yearDay >= 142 && yearDay <= 173){
            signo =  "Géminis";
            
        }else if(yearDay >= 174 && yearDay <= 204){
            signo =  "Cancer";
            
        }else if(yearDay >= 205 && yearDay <= 235){
            signo =  "Leo";
            
        }else if(yearDay >= 236 && yearDay <= 266){
            signo =  "Virgo";
            
        }else if(yearDay >= 267 && yearDay <= 296){
            signo =  "Libra";
            
        }else if(yearDay >= 297 && yearDay <= 326){
            signo =  "Escorpio";
            
        }else if(yearDay >= 327 && yearDay <= 355){
           signo =  "Sagitario";
            
        }else if(yearDay >= 356 && yearDay <= 19){
            signo =  "Capricornio";
        }
        
        ArrayList<String> predicciones = new ArrayList<String>();
        
        predicciones.add("Vas a morir en breve");
        predicciones.add("Te va a ir bien en el trabajo");
        predicciones.add("Pedro Sánchez va a aparecer en tu casa y te va a matar");
        predicciones.add("Te vas a encontrar un billete de 300€");
        predicciones.add("Te vas a quedar calvo/a");
        predicciones.add("Vas a ir a comer al Domino's Pizza");
        predicciones.add("Salva te va a mandar muchos ejercicios");
        predicciones.add("Te van a invitar a un bocadillo xxl del Reyton");
        predicciones.add("Un perro te va a morder el culo");
        predicciones.add("Te va a tocar la lotería");
        
        int prediccion = (int) (Math.random() * (predicciones.size() - 0 + 1) + 0);
        
        signoText.setText(signoText.getText() + signo);
        prediccionText.setText(prediccionText.getText() + predicciones.get(prediccion));
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
