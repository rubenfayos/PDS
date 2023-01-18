/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import compartido.Libro;

/**
 *
 * @author Fayos
 */
public class SQLModel {
    
    private Connection conn;
    
    public SQLModel(){
        
    }
    
    public void Conexion(){
        
        String url;  
        this.conn = null;  
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");  
            url="jdbc:mysql://localhost:3306/libros";
            
            this.conn = DriverManager.getConnection(url, "root", ""); 
            
        }catch (Exception e) {  
            System.out.println(e.toString());
        }
        
    }
    
    public int Insert(Libro l){
        
        Conexion();
        int temp = 0;
        
        try {
            
            //SQL de insert
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO libros (titulo, autor, paginas) VALUES(?,?,?);");
            
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getAutor());
            ps.setInt(3, l.getPaginas());
            
            //Comprueba si se ha insertado correctamente
            temp = ps.executeUpdate();
                 
        } catch (SQLException ex) {
            Logger.getLogger(SQLModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return temp;    
    }
    
    public int Delete(int id){
        
        Conexion();
        int temp = 0;
        
        try {
            
            //SQL de insert
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM libros WHERE id = ?;");
            
            ps.setInt(1, id);

            //Comprueba si se ha insertado correctamente
            temp = ps.executeUpdate();
                 
        } catch (SQLException ex) {
            Logger.getLogger(SQLModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return temp;  
    }
    
    public Libro Select(int id){
        
        Libro l = new Libro();
        
        Conexion();
        
        try {
            
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM libros WHERE id=?");
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
            
                l.setTitulo(rs.getString("titulo"));
                    
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(SQLModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return l;
        
    }
    
}
