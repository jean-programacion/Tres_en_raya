/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tresenraya;

import java.util.Scanner;

/**
 *
 * @author jeanm
 */
public class TresEnRaya {

    public static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Vamos a jugar al \"Tres en Raya\" \n");

        TresEnRaya tressEnRaya = new TresEnRaya();

        do {
            tressEnRaya.jugar();
            System.out.print("¿Quieres volver a jugar? [S/N]: ");
        } while (teclado.next().equalsIgnoreCase("S"));

    }

    public void jugar() {
        Simbolos simbolo = new Simbolos();
        simbolo.seleccionar();
        Tablero tablero = new Tablero();
        tablero.mostrar(simbolo);
        Jugador jugador1 = new Jugador(simbolo,EstadoCasilla.Ficha_X);
        Jugador jugador2 = new Jugador(simbolo,EstadoCasilla.Ficha_O);
        Jugador ganador = null;

        while (!tablero.estaLleno()) {
            jugador1.ponerFicha(tablero);
            tablero.mostrar(simbolo);
            if (tablero.haGanado(jugador1.getFicha())) {
                ganador = jugador1;
                break; // Jugador 1 gana
            }

            if (tablero.estaLleno()) {
                break; // Empate
            }

            jugador2.ponerFicha(tablero);
            tablero.mostrar(simbolo);
            if (tablero.haGanado(jugador2.getFicha())) {
                ganador = jugador2;
                break; // Jugador 2 gana
            }
        }

        if (ganador != null) {
            ganador.cantarVictoria(); // Llamar al método para determinar el resultado final
        } else {
            System.out.println("El juego terminó en empate.");
        }
    }
    
}
