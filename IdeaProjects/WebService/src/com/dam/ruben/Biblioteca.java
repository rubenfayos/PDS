package com.dam.ruben;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Biblioteca {

    @WebMethod
    public Libro buscarLibro(String nombre);
}
