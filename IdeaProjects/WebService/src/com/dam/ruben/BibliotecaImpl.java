package com.dam.ruben;

import javax.jws.WebService;

@WebService(endpointInterface = "com.dam.ruben.Biblioteca")
public class BibliotecaImpl implements Biblioteca{

    private MongoModel model;
    @Override
    public Libro buscarLibro(String nombre) {

        Libro l = new Libro();

        //Busca el libro
        l = model.Select(nombre);

        return l;
    }
}
