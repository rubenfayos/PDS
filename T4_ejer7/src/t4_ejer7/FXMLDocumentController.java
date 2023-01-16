package t4_ejer7;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Ruben Fayos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField idText;
    @FXML
    private TextField tituloText;
    @FXML
    private TextField autorText;
    @FXML
    private TextField paginasText;
    
    private Cliente cliente;
    private Servidor server;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        server = new Servidor();
        Thread serverT = new Thread(server);
        serverT.start(); 
        cliente = new Cliente();
        
               
                
    }    

    @FXML
    private void ADD(ActionEvent event) {
        
        Libro l = getLibro();
        l.setOperacion(1);
        l.setTitulo("Titulo");
        
        cliente.Send(l);
        
    }

    @FXML
    private void Delete(ActionEvent event) {
        
        
      
        
    }

    @FXML
    private void Edit(ActionEvent event) {
    }
    
    private Libro getLibro(){
        
        Libro l = new Libro();
        
        l.setTitulo(tituloText.getText());
        l.setAutor(autorText.getText());
        l.setPaginas(200);
        
        return l;
        
    }
    
}
