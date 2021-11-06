package com.company;

import java.util.ArrayList;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResolverProblemaImplementacion resolverProblema = new ResolverProblemaImplementacion();
		
		int nroJugadoresTotal = obtenerNroJugadoresTotales();
	    int posInicial = obtenerPosicionInicial();
	    int posJugadorGanador= obtenerPosicionJugadorGanador();
	    int maxPosASaltar = obtenerMaximaPosicionASaltar();
        ArrayList<Jugada> resultado = resolverProblema.resolverJuego(nroJugadoresTotal, posInicial, posJugadorGanador, maxPosASaltar);
	    imprimirResultado(resultado);
	
	}
	
	private static int obtenerNroJugadoresTotales () {
		
		//implementar el ingreso por pantalla
		
		return 20;
	}
	
	private static int obtenerPosicionInicial () {
		
		//implementar el ingreso por pantalla
		
		return 2;
	}
	
	private static int obtenerPosicionJugadorGanador () {
		
		//implementar el ingreso por pantalla
		
		return 2;
	}
	
	private static int obtenerMaximaPosicionASaltar () {
		
		//implementar el ingreso por pantalla
		
		return 6;
	}
	
	
	private static void imprimirResultado (ArrayList<Jugada> resultado) {
		System.out.println("Secuencia de Movimientos");
		int cont = 1;
		for (int i=0; i<resultado.size();i++) {
			if (resultado.get(i).pos == 0){
				System.out.print(" Movimientos para "+ cont+" saltos");
				System.out.println();
				cont++;
			}else
			{System.out.print(" = "+resultado.get(i).mov+" - "+resultado.get(i).pos);
			}

		}
	}
	

}
