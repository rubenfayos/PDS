
package carreracaracoles;

import java.util.HashMap;

public class Caracol implements Runnable{
	
	public Caracol() {
	}
	
	int posicion = 1;
	private HashMap<Integer, String> posiciones = new HashMap<>();

	@Override
	public void run() {
		
		String nombre = Thread.currentThread().getName();
		
		//Le asigna la velocidad aleatoriamente
		double velocidad = 7 + (Math.random() * 10);
                carrera(nombre, velocidad);
				
	}
	
	public void carrera(String nombre, double velocidad) {
		
		int distacia = 100;
		float distanciaRecorrida = 0;
		
		while(distanciaRecorrida < distacia) {
			
                    System.out.println(nombre + ", distancia recorrida: " + distanciaRecorrida);
                    distanciaRecorrida += velocidad;

                    try {
                            Thread.sleep(1000);
                    } catch (InterruptedException e) {
                            e.printStackTrace();
                    }
			
                }
		
		//Asigna la posicion
		posiciones.put(posicion, nombre);
		posicion++;
		
		if(posicion == 6) {
			resultados();
		}
	
	}

	public void resultados() {
		
		for(int i = 1; i <= 5; i++) {
			System.out.println("Nº " + i + ": " + posiciones.get(i));
		}
		
	}


}
