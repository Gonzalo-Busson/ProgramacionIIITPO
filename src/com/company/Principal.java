package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;


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
		
		//implementar el ingreso por pantalla\
		int i = Integer.parseInt(JOptionPane.showInputDialog("ingrese total de jugadores"));
		return i;
	}
	
	private static int obtenerPosicionInicial () {
		
		//implementar el ingreso por pantalla
		int i = Integer.parseInt(JOptionPane.showInputDialog("ingrese posicion inicial"));
		return i;
	}
	
	private static int obtenerPosicionJugadorGanador () {
		
		//implementar el ingreso por pantalla
		int i = Integer.parseInt(JOptionPane.showInputDialog("ingrese posicion jugador ganado"));
		return i;
	}

	private static int obtenerMaximaPosicionASaltar () {
		
		//implementar el ingreso por pantalla
		int i = Integer.parseInt(JOptionPane.showInputDialog("ingrese cantidad de saltos maximo"));
		return i;
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
