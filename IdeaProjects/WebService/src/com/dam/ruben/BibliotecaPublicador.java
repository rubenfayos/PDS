package com.dam.ruben;

import javax.xml.ws.Endpoint;

public class BibliotecaPublicador {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Endpoint.publish("http://localhost:5000/WS/Biblioteca", new BibliotecaImpl());
        System.out.println("Servicio iniciado");
    }

}
