/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam.ruben;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Ruben Fayos
 */

public class BetterFile extends File{
    
    private int size;
    private File f;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public BetterFile(String s) {
        super(s);
        this.size = this.getSize();
    }

    
    public ArrayList<BetterFile> listFiless() {
        
        String[] ss = list();
        if (ss == null) return null;
        
        ArrayList<BetterFile> files = new ArrayList<>();
        
        for (int i = 0; i < ss.length; i++) {
            files.add(new BetterFile(ss[i]));
        }
        return files;
        
    }
    
    
    
 
}
