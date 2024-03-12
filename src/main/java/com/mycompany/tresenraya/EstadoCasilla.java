/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tresenraya;

/**
 *
 * @author jeanm
 */
public enum EstadoCasilla {

    Ficha_X {
        @Override
        public String toString() {
            return "x";
        }
    },
    Ficha_O {
        @Override
        public String toString() {
            return "o";
        }
    },
    VACIO {
        @Override
        public String toString() {
            return " ";
        }
    }
}