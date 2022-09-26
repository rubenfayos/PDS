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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    private ImageView img;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        if(!this.signoText.equals("Signo del horoscopo: "))
            this.signoText.setText("Signo del horoscopo: ");
        if(!this.prediccionText.equals("Predicción: ")){
            this.prediccionText.setText("Predicción: ");
        }
        
        

        int yearDay = fecha.getValue().getDayOfYear();
        
        String signo = "";
        String imgUrl = "";
            
        if(yearDay > 20 && yearDay <= 50){
            signo =  "Acuario";
            imgUrl = "https://rsc.lavanguardia.com/img/horoscopo/ico-acuario.png";
            
        }else if(yearDay >= 51 && yearDay <= 79){
            signo =  "Piscis";
            imgUrl = "https://rsc.lavanguardia.com/img/horoscopo/ico-piscis.png";
            
        }else if(yearDay >= 80 && yearDay <= 110){
            signo =  "Aries";
            imgUrl = "https://rsc.lavanguardia.com/img/horoscopo/ico-aries.png";
            
        }else if(yearDay >= 111 && yearDay <= 141){
            signo =  "Tauro";
            imgUrl = "https://rsc.lavanguardia.com/img/horoscopo/ico-tauro.png";
            
        }else if(yearDay >= 142 && yearDay <= 173){
            signo =  "Géminis";
            imgUrl = "https://rsc.lavanguardia.com/img/horoscopo/ico-geminis.png";
            
        }else if(yearDay >= 174 && yearDay <= 204){
            signo =  "Cancer";
            imgUrl = "https://rsc.lavanguardia.com/img/horoscopo/ico-cancer.png";
            
        }else if(yearDay >= 205 && yearDay <= 235){
            signo =  "Leo";
            imgUrl = "https://rsc.lavanguardia.com/img/horoscopo/ico-leo.png";
            
        }else if(yearDay >= 236 && yearDay <= 266){
            signo =  "Virgo";
            imgUrl = "https://rsc.lavanguardia.com/img/horoscopo/ico-virgo.png";
            
        }else if(yearDay >= 267 && yearDay <= 296){
            signo =  "Libra";
            imgUrl = "https://rsc.lavanguardia.com/img/horoscopo/ico-libra.png";
            
        }else if(yearDay >= 297 && yearDay <= 326){
            signo =  "Escorpio";
            imgUrl = "https://rsc.lavanguardia.com/img/horoscopo/ico-escorpio.png";
            
        }else if(yearDay >= 327 && yearDay <= 355){
           signo =  "Sagitario";
           imgUrl = "https://rsc.lavanguardia.com/img/horoscopo/ico-sagitario.png";
            
        }else if(yearDay >= 356 && yearDay <= 19){
            signo =  "Capricornio";
            imgUrl = "https://rsc.lavanguardia.com/img/horoscopo/ico-capricornio.png";
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
        
        
        
        Image i = new Image(imgUrl);
        this.img.setImage(i);
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
