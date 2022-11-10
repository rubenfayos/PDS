/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package pong;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Ruben_Fayos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button button;
    private Separator barra1;
    @FXML
    private Circle pelota;
    
    private AnimationTimer animationBall;
    private int velocidadX = 3;
    private double velocidadY = 0;
    @FXML
    private Rectangle player1;
    @FXML
    private Rectangle player2;
    
    private int velJug1 = 0;
    private int velJug2 = 0;
    
    private AnimationTimer animationPlayers;
    @FXML
    private AnchorPane scene;
    @FXML
    private Pane tablero;
    @FXML
    private Rectangle margenBajo;
    @FXML
    private Rectangle margenArriba;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    velocidadY = Math.random()*10;
    if(velocidadY>3){
        velocidadY = 3;
    }
        
    //Animacion pelota
    animationBall = new AnimationTimer() {
        
        double posX = pelota.getCenterX();
        double posY = pelota.getCenterY();
        
        @Override
        public void handle(long now) {
            
        posX = pelota.getCenterX();
        posY = pelota.getCenterY();

        pelota.setCenterX(posX + velocidadX);
        pelota.setCenterY(posY + velocidadY);
        
        //Comprueba si la posicion de la pelota y el jugador coinciden
        Shape shapeCollision1 = Shape.intersect(player2, pelota);
        boolean colisionVacia1 = shapeCollision1.getBoundsInLocal().isEmpty();
    
        if (!colisionVacia1){
            //Velocidad negativa para cambiar direccion
            velocidadX = -3;
        }
        
        Shape shapeCollision2 = Shape.intersect(player1, pelota);
        boolean colisionVacia2 = shapeCollision2.getBoundsInLocal().isEmpty();
    
        if (!colisionVacia2){
            velocidadX = 3;
        }
        
        //Comprueba si choca abajo
        Shape shapeCollisionBajo = Shape.intersect(margenBajo, pelota);
        boolean colisionVaciaBajo = shapeCollisionBajo.getBoundsInLocal().isEmpty();
    
        if (!colisionVaciaBajo){
            velocidadY = -3;
        }
        
        //Comprueba si choca arriba
        Shape shapeCollisionArriba = Shape.intersect(margenArriba, pelota);
        boolean colisionVaciaArriba = shapeCollisionArriba.getBoundsInLocal().isEmpty();
    
        if (!colisionVaciaArriba){
            velocidadY = 3;
        }
        
        }};
    
    //Animacion jugadores
    
    animationPlayers = new AnimationTimer() {
        
        double posY_jug1 = player1.getY();
        double posY_jug2 = player2.getY();
        
        
        @Override
        public void handle(long now) {
            
            posY_jug1 += velJug1;
            posY_jug2 += velJug2;
            
            
            //TODO que no se salga del cuadro
            player1.setY(posY_jug1);
            player2.setY(posY_jug2);
        }};
     
    //Añade el listener para la una tecla pulsada
    
    scene.setOnKeyPressed(e ->{
        
        if(e.getCode() == KeyCode.W){ velJug1 = -5; }
        
        if(e.getCode() == KeyCode.S){ velJug1 = +5; }
        
        if(e.getCode() == KeyCode.UP){ velJug2 += -5; }
        
        if(e.getCode() == KeyCode.DOWN){ velJug2 = +5; }
        
        });
    
    scene.setOnKeyReleased(e ->{
            
        if ( (e.getCode() == KeyCode.W) || (e.getCode() == KeyCode.S) ){
        velJug1 = 0;
        }
        
        if ( (e.getCode() == KeyCode.UP) || (e.getCode() == KeyCode.DOWN) ){
        velJug2 = 0;
        }
        
        });   
    }  

    @FXML
    private void jugar(ActionEvent event) {
        
        animationBall.start();
        
        Thread hilo = new Thread();
        
        animationPlayers.start();
        
    }
    
}
