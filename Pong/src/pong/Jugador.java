package pong;


import java.awt.Rectangle;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Shape;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ruben_Fayos
 */
public class Jugador extends Rectangle implements Runnable{
    
    private int velocidad = 0;
    private int puntos = 0;
    private double y;
    private AnimationTimer animationPlayer;
    private AnchorPane scene;

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
 

    public void setHeight(int height) {
        this.height = height;
    }

    public Jugador() {
    } 

    public AnchorPane getScene() {
        return scene;
    }

    public void setScene(AnchorPane scene) {
        this.scene = scene;
    }
    
    
    @Override
    public void run() {
        
        animationPlayer = new AnimationTimer() {
        
        @Override
        public void handle(long now) {
            
            setY(getY() + velocidad);
            
               
        }};
     
    //Añade el listener para la una tecla pulsada
    scene.setOnKeyPressed(e ->{
        
        if(e.getCode() == KeyCode.W){ velocidad = -6; }
        
        if(e.getCode() == KeyCode.S){ velocidad = 6; }
        
        if(e.getCode() == KeyCode.UP){ velocidad = -6; }
        
        if(e.getCode() == KeyCode.DOWN){ velocidad = 6; }
        
        });
    
    scene.setOnKeyReleased(e ->{
            
        if ( (e.getCode() == KeyCode.W) || (e.getCode() == KeyCode.S) ){
        velocidad = 0;
        }
        
        if ( (e.getCode() == KeyCode.UP) || (e.getCode() == KeyCode.DOWN) ){
        velocidad = 0;
        }
        
        });
    
    animationPlayer.start();
        
        
    }
    
    
    
}
