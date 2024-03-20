/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tresenraya;

/**
 *
 * @author jeanm
 */
public class Coordenada {
        private int fila;
        private int columna;

        // Constructor que recibe fila y columna como argumentos
        public Coordenada(int fila, int columna) {
            this.fila = fila;
            this.columna = columna;
        }

        // Getter para la fila
        public int getFila() {
            return this.fila;
        }

        // Getter para la columna
        public int getColumna() {
            return this.columna;
        }

        // Método para determinar si una coordenada es válida para una dimensión dada
        public boolean isValida(int dimension) {
            // Verificar si la fila y la columna están dentro de los límites de la dimensión
            if (fila >= 0 && fila <= dimension && columna >= 0 && columna <= dimension) {
                return true; // La coordenada es válida
            } else {
                return false; // La coordenada no es válida
            }
        }
    }