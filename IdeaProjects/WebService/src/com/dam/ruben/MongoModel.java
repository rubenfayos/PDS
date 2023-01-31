package com.dam.ruben;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.JSONObject;

public class MongoModel {

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> coleccion;

    public void Conexion(){
        this.mongoClient = new MongoClient("localhost", 27017);
        this.database = mongoClient.getDatabase("Libros");
        this.coleccion = database.getCollection("libros");
    }

    public Libro Select(String nombre){

        //Establece conexión
        Conexion();

        Libro l = new Libro();

        BasicDBObject query = new BasicDBObject();
        query.put("Titol", nombre);

        //Busca según título
        MongoCursor<Document> cursor = this.coleccion.find(query).iterator();

            while(cursor.hasNext()){

                JSONObject obj = new JSONObject(cursor.next().toJson());
                l.setAutor(obj.getString("autor"));
                l.setTitulo(obj.getString("titulo"));
                l.setAñoNacimiento(obj.getString("año_nacimiento"));
                l.setAñoPublicacion(obj.getString("año_publicacion"));
                l.setEditorial(obj.getString("editorial"));
                l.setPaginas(obj.getString("total_paginas"));
            }

            cursor.close();


        return l;

    }

}
