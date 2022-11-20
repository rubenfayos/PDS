/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package pong;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

/**
 *
 * @author Ruben_Fayos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button button;
    @FXML
    private Circle pelota;
    @FXML
    private Rectangle player1;
    @FXML
    private Rectangle player2;
    
    private AnimationTimer animationBall;
    private AnimationTimer animationBall2;
    
    private int velocidadX = 3;
    private double velocidadY = 0;
    
    private int velocidadX2 = 3;
    private double velocidadY2 = 0;
    
    private int velJug1 = 0;
    private int velJug2 = 0;
    
    private int puntosJugador1;
    private int puntosJugador2;
    
    private boolean pelotaFuego = false;
    
    private AnimationTimer animationPowerUp;
    
    private AnimationTimer animationPlayers;
    @FXML
    private AnchorPane scene;
    @FXML
    private Pane tablero;
    @FXML
    private Rectangle margenBajo;
    @FXML
    private Rectangle margenArriba;
    @FXML
    private Rectangle margenIzquierda;
    @FXML
    private Rectangle margenDerecha;
    @FXML
    private Text marcador;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    velocidadY = Math.random()*6;
    if(velocidadY>3)
        velocidadY = velocidadY-6;
        
    //Animacion pelota
    animationBall = new AnimationTimer() {
        
        double posX = pelota.getCenterX();
        double posY = pelota.getCenterY();
        
        @Override
        public void handle(long now) {
            
        posX = pelota.getCenterX() + velocidadX;
        posY = pelota.getCenterY() + velocidadY;

        pelota.setCenterX(posX);
        pelota.setCenterY(posY);
        
        //Comprueba si la posicion de la pelota y el jugador2 coinciden
        Shape shapeCollision1 = Shape.intersect(player2, pelota);
        boolean colisionVacia1 = shapeCollision1.getBoundsInLocal().isEmpty();
        
        //Comprueba si la posicion de la pelota y el jugador1 coinciden
        Shape shapeCollision2 = Shape.intersect(player1, pelota);
        boolean colisionVacia2 = shapeCollision2.getBoundsInLocal().isEmpty();
        
        //Comprueba si choca abajo
        Shape shapeCollisionBajo = Shape.intersect(margenBajo, pelota);
        boolean colisionVaciaBajo = shapeCollisionBajo.getBoundsInLocal().isEmpty();
 
        //Comprueba si choca arriba
        Shape shapeCollisionArriba = Shape.intersect(margenArriba, pelota);
        boolean colisionVaciaArriba = shapeCollisionArriba.getBoundsInLocal().isEmpty();
        
        //Comprueba si la pelota choca con la izquierda
        Shape shapeCollisionIzquierda = Shape.intersect(margenIzquierda, pelota);
        boolean colisionVaciaIzquierda = shapeCollisionIzquierda.getBoundsInLocal().isEmpty();
        
        //comprueba si la pelota choca con la derecha
        Shape shapeCollisionDerecha = Shape.intersect(margenDerecha, pelota);
        boolean colisionVaciaDerecha = shapeCollisionDerecha.getBoundsInLocal().isEmpty();
        
        if (!colisionVacia1){
            
            //activa la colision solo si la pelota no está en modo fuego
            if(!pelotaFuego){
            //Velocidad negativa para cambiar direccion
            velocidadX = -9;
            }
            
        }

        if (!colisionVacia2){
            
            //activa la colision solo si la pelota no está en modo fuego
            if(!pelotaFuego){
            //Velocidad negativa para cambiar direccion
            velocidadX = 9;
            }
            
        }
    
        if (!colisionVaciaBajo){
            //Velocidad negativa para cambiar direccion
            velocidadY = -3;
        }
    
        if (!colisionVaciaArriba){
            velocidadY = 3;
        }
          
        if (!colisionVaciaIzquierda){
            
            //Devuelve la pelota al estado normal
            pelotaFuego = false;
                
            //Suma puntos y vuelve a la posicion inicial
            puntosJugador2++;
            actualizarMarcador();
            pelota.setCenterX(375);
            pelota.setCenterY(255);
            velocidadX = -3;
            
            //Inclinacion aleatoria
            velocidadY = Math.random()*6;
            if(velocidadY>3)
            velocidadY = velocidadY-6;    
        }
        
        
        if (!colisionVaciaDerecha){
            
            //Devuelve la pelota al estado normal
            pelotaFuego = false;
            
            //Suma puntos y vuelve a la posicion inicial
            puntosJugador1++;
            actualizarMarcador();
            pelota.setCenterX(375);
            pelota.setCenterY(255);
            velocidadX = 3;
            
            //Inclinacion aleatoria
            velocidadY = Math.random()*6;
            if(velocidadY>3)
            velocidadY = velocidadY-6;
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
            
            player1.setLayoutY(posY_jug1);
            player2.setLayoutY(posY_jug2);
            
            //Comprueba si la posicion de la pelota y el jugador2 coinciden
            Shape shapeCollisionAbajo_jugador2 = Shape.intersect(player2, margenBajo);
            boolean colisionVaciaAbajo_jugador2 =  shapeCollisionAbajo_jugador2.getBoundsInLocal().isEmpty();
            
            //Limites jugadores
        
            if(!colisionVaciaAbajo_jugador2){
                
                posY_jug2 = margenBajo.getLayoutY() - player2.getHeight();
                
            }
            
            //Comprueba si la posicion de la pelota y el jugador2 coinciden
            Shape shapeCollisionArriba_jugador2 = Shape.intersect(player2, margenArriba);
            boolean colisionVaciaArriba_jugador2 =  shapeCollisionArriba_jugador2.getBoundsInLocal().isEmpty();
            
            if(!colisionVaciaArriba_jugador2){
                
                posY_jug2 = margenArriba.getLayoutY();
                
            }
            
            //Comprueba si la posicion de la pelota y el jugador2 coinciden
            Shape shapeCollisionAbajo_jugador1 = Shape.intersect(player1, margenBajo);
            boolean colisionVaciaAbajo_jugador1 =  shapeCollisionAbajo_jugador1.getBoundsInLocal().isEmpty();
            
            //Limites jugadores
        
            if(!colisionVaciaAbajo_jugador1){
                
                posY_jug1 = margenBajo.getLayoutY() - player1.getHeight();
                
            }
            
            //Comprueba si la posicion de la pelota y el jugador2 coinciden
            Shape shapeCollisionArriba_jugador1 = Shape.intersect(player1, margenArriba);
            boolean colisionVaciaArriba_jugador1 =  shapeCollisionArriba_jugador1.getBoundsInLocal().isEmpty();
            
            if(!colisionVaciaArriba_jugador1){
                
                posY_jug1 = margenArriba.getLayoutY();
                
            }
 
        }};

     
    //Añade el listener para la una tecla pulsada
    scene.setOnKeyPressed(e ->{
        
        if(e.getCode() == KeyCode.W){ velJug1 = -6; }
        
        if(e.getCode() == KeyCode.S){ velJug1 = 6; }
        
        if(e.getCode() == KeyCode.UP){ velJug2 = -6; }
        
        if(e.getCode() == KeyCode.DOWN){ velJug2 = 6; }
        
        });
    
    
    
    scene.setOnKeyReleased(e ->{
            
        if ( (e.getCode() == KeyCode.W) || (e.getCode() == KeyCode.S) ){
        velJug1 = 0;
        }
        
        if ( (e.getCode() == KeyCode.UP) || (e.getCode() == KeyCode.DOWN) ){
        velJug2 = 0;
        }
        
        }); 
    
        animationPlayers.start();
 
    }
    
    private void actualizarMarcador(){
        
        if(puntosJugador1 == 4){
            añadirPelota(-2);
        }else if(puntosJugador2 == 4){
            añadirPelota(2);
        }
        
        marcador.setText(String.valueOf(puntosJugador1) + " : " + String.valueOf(puntosJugador2));
        if(puntosJugador1 >= 5){
            marcador.setText("El jugador 1 ha ganado");
            animationBall.stop();
            animationBall2.stop();
        }else if(puntosJugador2 >= 5){
            marcador.setText("El jugador 2 ha ganado");
            animationBall.stop();
            animationBall2.stop();
        }
        
    }
    
    private void añadirPelota(int velocidadx){
        
        Circle pelota2 = new Circle(12);
        tablero.getChildren().add(pelota2);
        pelota2.setCenterX(350);
        pelota2.setCenterY(255);
        
        //Le asigna la direccion dependiendo de quien va perdiendo
        velocidadX2 = velocidadx;
        
        //Inclinacion aleatoria
        velocidadY2 = Math.random()*6;
        if(velocidadY2>3)
            velocidadY2 = velocidadY2-6;
        
        //Animacion pelota
        animationBall2 = new AnimationTimer() {
        
        double posX2 = pelota2.getCenterX();
        double posY2 = pelota2.getCenterY();
        
        @Override
        public void handle(long now) {
            
        posX2 = pelota2.getCenterX();
        posY2 = pelota2.getCenterY();

        pelota2.setCenterX(posX2 + velocidadX2);
        pelota2.setCenterY(posY2 + velocidadY2);
        
        //Comprueba si la posicion de la pelota y el jugador2 coinciden
        Shape shapeCollision1_pelota2 = Shape.intersect(player2, pelota2);
        boolean colisionVacia1_pelota2 = shapeCollision1_pelota2.getBoundsInLocal().isEmpty();
        
        //Comprueba si la posicion de la pelota y el jugador1 coinciden
        Shape shapeCollision2_pelota2 = Shape.intersect(player1, pelota2);
        boolean colisionVacia2_pelota2 = shapeCollision2_pelota2.getBoundsInLocal().isEmpty();
        
        //Comprueba si choca abajo
        Shape shapeCollisionBajo_pelota2 = Shape.intersect(margenBajo, pelota2);
        boolean colisionVaciaBajo_pelota2 = shapeCollisionBajo_pelota2.getBoundsInLocal().isEmpty();
 
        //Comprueba si choca arriba
        Shape shapeCollisionArriba_pelota2 = Shape.intersect(margenArriba, pelota2);
        boolean colisionVaciaArriba_pelota2 = shapeCollisionArriba_pelota2.getBoundsInLocal().isEmpty();
        
        //Comprueba si la pelota choca con la izquierda
        Shape shapeCollisionIzquierda_pelota2 = Shape.intersect(margenIzquierda, pelota2);
        boolean colisionVaciaIzquierda_pelota2 = shapeCollisionIzquierda_pelota2.getBoundsInLocal().isEmpty();
        
        //comprueba si la pelota choca con la derecha
        Shape shapeCollisionDerecha_pelota2 = Shape.intersect(margenDerecha, pelota2);
        boolean colisionVaciaDerecha_pelota2 = shapeCollisionDerecha_pelota2.getBoundsInLocal().isEmpty();
        
        if (!colisionVacia1_pelota2){
            //Velocidad negativa para cambiar direccion
            velocidadX2 = -8;
        }

        if (!colisionVacia2_pelota2){
            velocidadX2 = 8;
        }
    
        if (!colisionVaciaBajo_pelota2){
            //Velocidad negativa para cambiar direccion
            velocidadY2 = -3;
        }
    
        if (!colisionVaciaArriba_pelota2){
            velocidadY2 = 3;
        }
          
        if (!colisionVaciaIzquierda_pelota2){
            
            //Suma puntos y vuelve a la posicion inicial
            puntosJugador2++;
            actualizarMarcador();
            pelota2.setCenterX(375);
            pelota2.setCenterY(255);
            velocidadX2 = 3;
            
            //Inclinacion aleatoria
            velocidadY2 = Math.random()*6;
            if(velocidadY2>3)
            velocidadY2 = velocidadY2-6;
        }
        
        
        if (!colisionVaciaDerecha_pelota2){
            
            //Suma puntos y vuelve a la posicion inicial
            puntosJugador1++;
            actualizarMarcador();
            pelota2.setCenterX(375);
            pelota2.setCenterY(255);
            velocidadX2 = -3;
            
            //Inclinacion aleatoria
            velocidadY2 = Math.random()*6;
            if(velocidadY2>3)
            velocidadY2 = velocidadY2-6;
        }
        
        }};
        
        animationBall2.start();
         
    }
    
    private void agrandarJugador(Rectangle player){
        
        player.setHeight(300);
        player.setLayoutY(100);
        
    }

    @FXML
    private void jugar(ActionEvent event) {
        
        puntosJugador1 = 0;
        puntosJugador2 = 0;
        agrandarJugador(player1);
        
        animationBall.start();
           
    }
    
    private void PowerUp(){
         
   
        animationBall = new AnimationTimer() {
            
        Image img = new Image(this.getClass().getResource("/res/marselo.png").toString());
        ImageView powerUp = new ImageView(img);
        powerUp.setFitHeight(100);
        powerUp.setFitWidth(100);
        powerUp.setLayoutX(325);
        tablero.getChildren().add(powerUp);
        
        
        double posXPowerUp = 0;
        double posYPowerUp = 0;
        
        @Override
        public void handle(long now) {
            
        
        /*
        pelota2.setCenterY(posY2 + velocidadY2);
        
        //Comprueba si la posicion de la pelota y el jugador2 coinciden
        Shape shapeCollision1_pelota2 = Shape.intersect(player2, pelota2);
        boolean colisionVacia1_pelota2 = shapeCollision1_pelota2.getBoundsInLocal().isEmpty();
        
        //Comprueba si la posicion de la pelota y el jugador1 coinciden
        Shape shapeCollision2_pelota2 = Shape.intersect(player1, pelota2);
        boolean colisionVacia2_pelota2 = shapeCollision2_pelota2.getBoundsInLocal().isEmpty();
        
        //Comprueba si choca abajo
        Shape shapeCollisionBajo_pelota2 = Shape.intersect(margenBajo, pelota2);
        boolean colisionVaciaBajo_pelota2 = shapeCollisionBajo_pelota2.getBoundsInLocal().isEmpty();
 
        //Comprueba si choca arriba
        Shape shapeCollisionArriba_pelota2 = Shape.intersect(margenArriba, pelota2);
        boolean colisionVaciaArriba_pelota2 = shapeCollisionArriba_pelota2.getBoundsInLocal().isEmpty();
        
        //Comprueba si la pelota choca con la izquierda
        Shape shapeCollisionIzquierda_pelota2 = Shape.intersect(margenIzquierda, pelota2);
        boolean colisionVaciaIzquierda_pelota2 = shapeCollisionIzquierda_pelota2.getBoundsInLocal().isEmpty();
        
        //comprueba si la pelota choca con la derecha
        Shape shapeCollisionDerecha_pelota2 = Shape.intersect(margenDerecha, pelota2);
        boolean colisionVaciaDerecha_pelota2 = shapeCollisionDerecha_pelota2.getBoundsInLocal().isEmpty();
        
        */
        
    }};
        
    }
}
