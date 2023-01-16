/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t4_ejer7;

import java.io.Serializable;
@SuppressWarnings ("serial")

/**
 *
 * @author Ruben Fayos
 */
public class Libro implements Serializable{
    
    private String titulo, autor;
    private int paginas, operacion;

    public Libro(String titulo, String autor, int paginas, int operacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.operacion = operacion;
    }

    public Libro() {
    }
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getOperacion() {
        return operacion;
    }

    public void setOperacion(int operacion) {
        this.operacion = operacion;
    }
    
    
    
}
