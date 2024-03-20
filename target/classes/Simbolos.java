/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tresenraya;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jeanm
 */
public class Simbolos {
    private final String[][] packs = {
        {"X", "O"},
        {"$", "€"},
        {"!", "?"}
    };
    private int packSeleccionado;

    public Simbolos() {
        this.packSeleccionado = 0;
    }

    public void seleccionar() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Seleccione una pareja de símbolos para jugar:");
        for (int i = 0; i < packs.length; i++) {
            System.out.print((i + 1) + ". ");
            for (int j = 0; j < packs[i].length; j++) {
                System.out.print(packs[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println((this.packs.length +1)+". Seleccionar aleatoriamente");
        System.out.print("Ingrese el número de la opción: ");
        int opcion = teclado.nextInt();

        if (opcion == this.packs.length +1) {
            Random random = new Random();
            this.packSeleccionado = random.nextInt(packs.length);
        } else if (opcion >= 1 && opcion <= packs.length) {
            this.packSeleccionado = opcion - 1;
        } else {
            System.out.println("Opción no válida");
        }
    }

    public String obtenerSimbolo(EstadoCasilla estadoCasilla) {
        if (estadoCasilla == EstadoCasilla.Ficha_X) {
            return packs[packSeleccionado][0];
        } else if (estadoCasilla == EstadoCasilla.Ficha_O) {
            return packs[packSeleccionado][1];
        } else {
            return " ";
        }
    }
}

