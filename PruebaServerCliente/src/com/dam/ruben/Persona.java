package com.dam.ruben;

import java.io.Serializable;
@SuppressWarnings ("serial")

public class Persona implements Serializable{
	
	private String name;
	private int age;
	private char sexo;
	
	public Persona(String name, int age, char sexo) {
		super();
		this.name = name;
		this.age = age;
		this.sexo = sexo;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	
}
