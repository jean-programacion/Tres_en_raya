/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tresenraya;

import static com.mycompany.tresenraya.TresEnRaya.teclado;
import java.util.Scanner;

/**
 *
 * @author jeanm
 */
public class Jugador {

    public static final EstadoCasilla FICHA_X = EstadoCasilla.Ficha_X;
    public static final EstadoCasilla FICHA_0 = EstadoCasilla.Ficha_O;

    public void ponerFicha(Tablero tablero) {
    boolean fichaColocada = false;
    EstadoCasilla fichaJugador = (this.ficha == EstadoCasilla.Ficha_X) ? EstadoCasilla.Ficha_X : EstadoCasilla.Ficha_O;

    System.out.println("\n\nJugador con " + fichaJugador);
    
    while (!fichaColocada) {
        Coordenada coordenada = recogerCoordenada();
        Coordenada coordenadaCorregida = new Coordenada(coordenada.getFila() - 1, coordenada.getColumna() - 1);
        if (coordenadaCorregida.isValida(tablero.DIMENSIONES) && !tablero.isOcupada(coordenadaCorregida)) {
            tablero.ponerFicha(coordenadaCorregida, fichaJugador);
            fichaColocada = true;
        } else {
            System.out.println("¡Error! Coordenada ocupada en el tablero");
        }
    }
}

    private Coordenada recogerCoordenada() {
    int fila = 0, columna = 0;
    boolean coordenadaValida = false;

    while (!coordenadaValida) {
        System.out.print("\nIntroduce fila [1-3]: ");
        if (teclado.hasNextInt()) {
            fila = teclado.nextInt();
            if (fila < 1 || fila > 3) {
                System.out.println("¡Error! Introduce una coordenada válida");
                continue;
            }
        } else {
            System.out.println("¡Error! Debe introducir un número entero");
            teclado.next(); // Descarta la entrada no válida
            continue;
        }

        System.out.print("Introduce columna [1-3]: ");
        if (teclado.hasNextInt()) {
            columna = teclado.nextInt();
            if (columna < 1 || columna > 3) {
                System.out.println("¡Error! Introduce una coordenada válida");
                continue;
            }
        } else {
            System.out.println("¡Error! Debe introducir un número entero");
            teclado.next(); // Descarta la entrada no válida
            continue;
        }

        coordenadaValida = true; // Si llegamos a este punto, la coordenada es válida
    }

    return new Coordenada(fila, columna);
}

    EstadoCasilla ficha;

    public Jugador(EstadoCasilla ficha) {
        this.ficha = ficha;
    }

    public void cantarVictoria() {
        System.out.println("\n¡El jugador " + this.ficha + " es el ganador!");
    }

    public int pedirInt(String peticion, String error) {
        teclado = new Scanner(System.in);
        do {
            System.out.print(peticion);
            if (teclado.hasNextInt()) {
                return teclado.nextInt();
            }
            System.out.println(error);
            teclado.next();
        } while (true);
    }
    
}