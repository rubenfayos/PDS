package com.dam.ruben;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import jdk.nashorn.internal.objects.annotations.Property;

/**
 *
 * @author Ruben Fayos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TableColumn<BetterFile, String> fileNameColumn;
    @FXML
    private TableView<BetterFile> filesTable;
    
    String url= "http://localhost:80/PSP/";
    File selectedFile;
    @FXML
    private TextField fileName;
    @FXML
    private TableColumn<BetterFile, String> fileSizeColumn;

    public void setSelectedFile(File selectedFile) {
        this.selectedFile = selectedFile;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        fileNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        fileSizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        
        
        filesTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {

                //Si el item seleccionado != null
                if(filesTable.getSelectionModel().getSelectedItem() != null) {    
                    setSelectedFile(filesTable.getSelectionModel().getSelectedItem());                    
                }

            }
        
        });
        
    }    

    @FXML
    private void listFiles(ActionEvent event) {
        
        
        BetterFile file = new BetterFile("C:\\xampp\\htdocs\\PSP");
        
        ArrayList<BetterFile> files = new ArrayList<>();
   
        files = file.listFiless();

        ObservableList<BetterFile> filesOL= FXCollections.observableArrayList(files);
        
        filesTable.setItems(filesOL);

        
    }

    @FXML
    private void downloadFile(ActionEvent event) {
        
        try {
            
            // Creamos un objeto de tipo URL
            URL url = new URL(this.url + selectedFile.getName());
            
            String localFile = fileName.getText();
            
            // Abrimos un canal de comunicacion de bytes con la url en cuestion.
            InputStream is = url.openStream();
            
            // Con el objeto InputStreamReader podemos convertir bytes en caracteres.
            InputStreamReader reader = new InputStreamReader(is);
            
            // Con el objeto BufferedReader podemos leer bloques enteros de  texto.
            BufferedReader bReader = new BufferedReader(reader);
            
            FileWriter escritorFichero = new FileWriter(localFile);
            
            String linea;
			
            while ((linea = bReader.readLine()) != null) {
                    escritorFichero.write(linea);
            }
            
            escritorFichero.close();
            bReader.close();
            reader.close();
            is.close();
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
