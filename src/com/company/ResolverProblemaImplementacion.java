package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class ResolverProblemaImplementacion implements ResolverProblemaInterface {

	@Override
	public ArrayList<Jugada> resolverJuego(int nroJugadoresTotal, int posInicial, int posJugadorGanador, int maxPosASaltar) {
		// TODO Auto-generated method stub
		int[] jugadores = new int[nroJugadoresTotal];
		ArrayList<Jugada>  jugadas= new ArrayList<Jugada>();
		ArrayList<Jugada>  respuestas = new ArrayList<Jugada>();
		Jugada corte = new Jugada();
		Jugada jugada = new Jugada();
		corte.setPos(0);
		corte.setMov(Movimiento.IZQ);
		for (int i = 1 ; i<=maxPosASaltar;i++){
			respuestas.addAll(backtracking(jugadores,posInicial,posJugadorGanador,i,jugadas));
			respuestas.add(corte);
			jugadores = new int[nroJugadoresTotal];
			jugadas= new ArrayList<Jugada>();
		}

	
		return respuestas;
	}

	public ArrayList<Jugada> backtracking(int[] jugadores, int posInicial, int posJugadorGanador, int maxPosASaltar,ArrayList<Jugada>  jugadas){
		for (int i = 0 ;i<=1;i++){
			if(jugadoresActivos(jugadores)==1 && jugadores[posJugadorGanador-1]==0){
				return jugadas;
			}else{
				int jugadorEliminado= jugadorEliminado(jugadores,posInicial,maxPosASaltar,i);
				int sigPos= sigPos(jugadores,jugadorEliminado,i);
				Jugada jugada = realizarJugada(jugadores,posInicial,maxPosASaltar,i);
				if (jugadorEliminado!=posJugadorGanador){
					jugadas.add(jugada);
					jugadores[jugadorEliminado-1]=1;
					backtracking(jugadores,sigPos,posJugadorGanador,maxPosASaltar,jugadas);
					if (jugadas.size()==jugadores.length-1){
						return jugadas;
					}
					jugadas.remove(jugada);
					jugadores[jugadorEliminado-1]=0;
				}
			}
		}
		return jugadas;
	}
	public static void imprimirResultado (ArrayList<Jugada> resultado) {
		System.out.println("Secuencia de Movimientos");
		for (int i=0; i<resultado.size();i++) {
			System.out.print(" = "+resultado.get(i).mov+" - "+resultado.get(i).pos);
		}
	}

	public Jugada realizarJugada(int[] jugadores, int posInicial, int maxPosASaltar,int dir){
		Jugada jugada = new Jugada();
		jugada.setPos(jugadorEliminado(jugadores,posInicial,maxPosASaltar,dir));
		if (dir==0){
			jugada.setMov(Movimiento.DER);
		}else {
			jugada.setMov(Movimiento.IZQ);
		}
		return jugada;
	}

	public int jugadorEliminado(int[] jugadores, int posInicial, int maxPosASaltar, int dir){
		int jugadorAEliminar=posInicial;
		int cont=0;
		if (dir == 0){
			while (cont!=maxPosASaltar+1){
				jugadorAEliminar++;
				if (jugadorAEliminar>jugadores.length){
					jugadorAEliminar=1;
				}
				if (jugadores[jugadorAEliminar-1]==0){
					cont++;
				}
			}

		}else{
			while (cont!=maxPosASaltar+1){
				jugadorAEliminar--;
				if (jugadorAEliminar<1){
					jugadorAEliminar=jugadores.length;
				}
				if (jugadores[jugadorAEliminar-1]==0){
					cont++;
				}
			}
		}

		return jugadorAEliminar;
	}

	public int sigPos(int[] jugadores, int jugadorEliminado, int dir){
		int sigPos= jugadorEliminado;
		int cont=0;
		if (dir==0){
			while (cont!=1){
				sigPos++;
				if (sigPos>jugadores.length){
					sigPos=1;
				}
				if (jugadores[sigPos-1]==0){
					cont++;
				}
			}
		}else{
			while (cont!=1){
				sigPos--;
				if (sigPos<1){
					sigPos=jugadores.length;
				}
				if (jugadores[sigPos-1]==0){
					cont++;
				}
			}
		}

		return sigPos;
	}

	public int jugadoresActivos(int[] jugadores){
		int activos=0;
		for (int i = 0 ; i<jugadores.length;i++){
			if (jugadores[i]==0){
				activos++;
			}
		}
		return activos;
	}
}