package com.dam.salva;

import java.util.LinkedList;

public class DatosCompartidos {
	LinkedList<Integer> listaElementos = new LinkedList<>();
	int capacidad = 5;

	public DatosCompartidos(int capacidad) {
		listaElementos = new LinkedList<Integer>();
		listaElementos.add(1);
		listaElementos.add(1);
		listaElementos.add(1);
		listaElementos.add(1);
		listaElementos.add(1);
		this.capacidad = capacidad;
	}

	public synchronized int consumir() {

		while (listaElementos.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}

		listaElementos.removeFirst();
		notifyAll();

		return (listaElementos.size());
	}

	public synchronized int producir(Integer c) {

		while (listaElementos.size() == capacidad) {
			try {
				wait();
			} catch (InterruptedException e) {

			}
		}

		listaElementos.addLast(c);
		notifyAll();
		
		return listaElementos.size();
	}
}
