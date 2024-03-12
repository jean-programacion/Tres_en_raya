/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tresenraya;

/**
 *
 * @author jeanm
 */
public class Tablero {

    public final int DIMENSIONES = 3;
    EstadoCasilla[][] casillas = new EstadoCasilla[DIMENSIONES][DIMENSIONES];

    public Tablero() {
        this.vaciar();
    }

    public void mostrar() {
        System.out.print(" __ | ");
        for (int i = 1; i <= this.casillas.length; i++) {
            System.out.print(i + " | ");
        }
        for (int i = 0; i < this.casillas.length; i++) {
            System.out.print("\n| " + (i + 1) + " ");

            for (int j = 0; j < this.casillas[i].length; j++) {
                System.out.print("| " + this.casillas[i][j] + " ");
            }
            System.out.print("|");
        }
    }

    public void vaciar() {
        // Recorre todas las casillas del tablero y las establece como VACIO
        for (int i = 0; i < this.DIMENSIONES; i++) {
            for (int j = 0; j < this.DIMENSIONES; j++) {
                this.casillas[i][j] = EstadoCasilla.VACIO;
            }
        }
    }

    public boolean estaLleno() {
        // Recorre todas las casillas del tablero
        int contador = 0;
        for (int i = 0; i < DIMENSIONES; i++) {
            for (int j = 0; j < DIMENSIONES; j++) {
                // Si alguna casilla está vacía, el tablero no está lleno
                if (this.casillas[i][j] != EstadoCasilla.VACIO) {
                    contador++;
                }
            }
        }
        // Si no se encontró ninguna casilla vacía, el tablero está lleno
        return (contador == (this.DIMENSIONES * this.DIMENSIONES));

    }

    public boolean hayTresEnRaya() {
        return hayTresEnRaya(EstadoCasilla.Ficha_X) || hayTresEnRaya(EstadoCasilla.Ficha_O);
    }

    private boolean hayTresEnRaya(EstadoCasilla color) {
        int contador = 0;
        for (int i = 0; i < this.DIMENSIONES; i++) {
            for (int j = 0; j < this.DIMENSIONES; j++) {
                if (this.casillas[i][j] == color) {
                    contador++;
                    if (contador == this.DIMENSIONES) {
                        return true;
                    }
                } else {
                    contador = 0;
                }
            }
            contador++;
        }
        // Comprueba columnas
        for (int j = 0; j < this.DIMENSIONES; j++) {
            for (int i = 0; i < this.DIMENSIONES; i++) {
                if (this.casillas[i][j] == color) {
                    contador++;
                    if (contador == this.DIMENSIONES) {
                        return true;
                    }
                } else {
                    contador = 0;
                }
            }
            contador = 0; // Reinicia el contador para cada columna
        }

        // Comprueba diagonales
        for (int i = 0; i < this.DIMENSIONES; i++) {
            if (this.casillas[i][i] == color) {
                contador++;
                if (contador == this.DIMENSIONES) {
                    return true;
                }
            } else {
                contador = 0;
            }
        }
        contador = 0; // Reinicia el contador para la diagonal principal

        for (int i = 0; i < this.DIMENSIONES; i++) {
            if (this.casillas[i][this.DIMENSIONES - 1 - i] == color) {
                contador++;
                if (contador == this.DIMENSIONES) {
                    return true;
                }
            } else {
                contador = 0;
            }
        }

        return false;
    }

    public boolean isOcupada(Coordenada coordenada) {

        int fila = coordenada.getFila();
        int columna = coordenada.getColumna();

        // Verificar si la coordenada está dentro de los límites del tablero
        if (fila < 0 || fila >= DIMENSIONES || columna < 0 || columna >= DIMENSIONES) {
            // La coordenada está fuera del tablero, por lo que está ocupada
            return true;
        }

        // Verificar si la casilla en la coordenada está ocupada
        return casillas[fila][columna] != EstadoCasilla.VACIO;
    }

    public void ponerFicha(Coordenada coordenada, EstadoCasilla color) {

        int fila = coordenada.getFila();
        int columna = coordenada.getColumna();

        // Verificar si la coordenada está dentro de los límites del tablero
        if (fila >= 0 && fila < DIMENSIONES && columna >= 0 && columna < DIMENSIONES) {
            // Asignar el color de la ficha en la casilla correspondiente
            casillas[fila][columna] = color;
        } else {
            // Si la coordenada está fuera de los límites del tablero, lanzar una excepción o manejar el error de alguna otra manera
            System.out.println("La coordenada está fuera del tablero.");
        }
    }

    public boolean haGanado(EstadoCasilla ficha) {
        // Comprobar filas
        for (int i = 0; i < DIMENSIONES; i++) {
            if (casillas[i][0] == ficha && casillas[i][1] == ficha && casillas[i][2] == ficha) {
                return true;
            }
        }

        // Comprobar columnas
        for (int i = 0; i < DIMENSIONES; i++) {
            if (casillas[0][i] == ficha && casillas[1][i] == ficha && casillas[2][i] == ficha) {
                return true;
            }
        }

        // Comprobar diagonales
        if (casillas[0][0] == ficha && casillas[1][1] == ficha && casillas[2][2] == ficha) {
            return true;
        }
        if (casillas[0][2] == ficha && casillas[1][1] == ficha && casillas[2][0] == ficha) {
            return true;
        }

        // Si no se cumple ninguna de las condiciones anteriores, el jugador no ha ganado
        return false;
    }
}