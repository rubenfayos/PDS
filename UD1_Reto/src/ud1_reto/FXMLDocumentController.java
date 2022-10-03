/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package ud1_reto;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author DAM 2
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField inputText;
    @FXML
    private TextField outputText;
    
    private void handleButtonAction(ActionEvent event) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void traducirMorse(ActionEvent event) {
        
        String text = inputText.getText();
        
        HashMap<String, String> traductor = new HashMap<>();
        
        //Asignar campos al diccionario
        traductor.put("A", ".-");
        traductor.put("B", "-...");
        traductor.put("C", "-.-.");
        traductor.put("CH", "----");
        traductor.put("D", "-..");
        traductor.put("E", ".");
        traductor.put("F", "..-.");
        traductor.put("G", "--.");
        traductor.put("H", "....");
        traductor.put("I", "..");
        traductor.put("J", ".---");
        traductor.put("K", "-.-");
        traductor.put("L", ".-..");
        traductor.put("M", "--");
        traductor.put("N", "-.");
        traductor.put("Ñ", "--.--");
        traductor.put("O", "---");
        traductor.put("P", ".--.");
        traductor.put("Q", "--.-");
        traductor.put("R", ".-.");
        traductor.put("S", "...");
        traductor.put("T", "-");
        traductor.put("U", "..-");
        traductor.put("V", "...-");
        traductor.put("W", ".--");
        traductor.put("X", "-..-");
        traductor.put("Y", "-.--");
        traductor.put("Z", "--..");
        traductor.put("0", "-----");
        traductor.put("1", ".----");
        traductor.put("2", "..---");
        traductor.put("3", "...--");
        traductor.put("4", "....-");
        traductor.put("5", ".....");
        traductor.put("6", "-....");
        traductor.put("7", "--...");
        traductor.put("8", "---..");
        traductor.put("9", "----.");
        traductor.put(".", ".-.-.-");
        traductor.put(",", "--..--");
        traductor.put(":", "---...");
        traductor.put("?", "..--..");
        traductor.put("'", ".----.");
        traductor.put("-", "-....-");
        traductor.put("/", "-..-.");
        traductor.put("\"", ".-..-.");
        traductor.put("@", ".--.-.");
        traductor.put("=", "-...-");
        traductor.put("!", "−.−.−−");
        traductor.put(" ", " ");

        String words[] = text.split("");
        String traduction = "";
        
        for(String word : words){
            
            traduction+= traductor.get(word.toUpperCase()) + " ";
            
        }
        
        outputText.setText(traduction);
        
    }
        
        

    @FXML
    private void traducirNatural(ActionEvent event) {
        
        String text = inputText.getText();
        
        HashMap<String, String> traductor = new HashMap<>();
        
        //Asignar campos al diccionario
        traductor.put(".-", "A");
        traductor.put("-...", "B");
        traductor.put("-.-.", "C");
        traductor.put("----", "CH");
        traductor.put("-..", "D");
        traductor.put(".", "E");
        traductor.put("..-.", "F");
        traductor.put("--.", "G");
        traductor.put("....", "H");
        traductor.put("..", "I");
        traductor.put(".---", "J");
        traductor.put("-.-", "K");
        traductor.put(".-..", "L");
        traductor.put("--", "M");
        traductor.put("-.", "N");
        traductor.put("--.--", "Ñ");
        traductor.put("---", "O");
        traductor.put(".--.", "P");
        traductor.put("--.-", "Q");
        traductor.put(".-.", "R");
        traductor.put("...","S");
        traductor.put("-", "T");
        traductor.put("..-", "U");
        traductor.put("...-", "V");
        traductor.put(".--", "W");
        traductor.put("-..-", "X");
        traductor.put("-.--", "Y");
        traductor.put("--..", "Z");
        traductor.put("-----", "0");
        traductor.put(".----", "1");
        traductor.put("..---", "2");
        traductor.put("...--", "3");
        traductor.put("....-", "4");
        traductor.put(".....", "5");
        traductor.put("-....", "6");
        traductor.put("--...", "7");
        traductor.put("---..", "8");
        traductor.put("----.", "9");
        traductor.put(".-.-.-", ".");
        traductor.put("--..--", ",");
        traductor.put("---...", ":");
        traductor.put("..--..", "?");
        traductor.put(".----.", "'");
        traductor.put("-....-", "-");
        traductor.put("-..-.", "/");
        traductor.put(".-..-.", "\"");
        traductor.put(".--.-.", "@");
        traductor.put("-...-", "=");
        traductor.put("−.−.−−", "!");
        traductor.put("", " ");
        
        

        String words[] = text.split(" ");
        String traduction = "";
        
        for(String word : words){
            
            traduction+= traductor.get(word).toLowerCase();
            
        }

        
        outputText.setText(traduction.replace("  ", " "));
        
    }
    
}
