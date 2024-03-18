package paquete;

import java.util.Objects;
import java.util.Scanner;

/**
 * Equipos
 * Equipos almacena division, nombre y jugadores
 * @author Javier Garcia Aguilera
 */

public class Equipos {

    private static final int N = 5;
    private String division;

    private int nJugadores = 0;
    private String nombre;

    Jugadores[] jugador = new Jugadores[N];
    private boolean creado = false;
    divisiones div;

    enum divisiones {
        division1,
        division2,
        division3
    }

    public Equipos(int ndiv, String nombre){
        switch(ndiv){
            case 1:
                this.division = String.valueOf(div.division1);
                break;
            case 2:
                this.division = String.valueOf(div.division2);
                break;
            case 3:
                this.division = String.valueOf(div.division3);
                break;
        }
        this.nombre = nombre;
        this.creado = true;
    }

    public boolean altaJugador(String nomJ, String ape, int dorsal){

        boolean flag = true;

        if (nJugadores != 5){
            jugador[nJugadores] = new Jugadores(nomJ, ape, dorsal);
            this.nJugadores = this.nJugadores + 1;
        } else {
            flag = false;
        }

        return flag;


    }

    public void mostrarJugadorPorDorsal(int dorsal){
        int i = this.nJugadores;
        for(i = this.nJugadores; i < N; i++){

            if (Objects.equals(jugador[i].getDorsal(), dorsal)) {
                System.out.println(jugador[i]);
                break;
            }
        }

    }

    public int mostrarTodosJugadores(){

        int i = 0;
        System.out.println("HAY " + this.nJugadores + " JUGADORES");
        for(i = 0; i < N; i++){

            if (jugador[i] == null) {
                break;
            } else {
                System.out.println((i+1) + ".- " + jugador[i]);
            }

        }

        return i;

    }

    public void aumentarMejorPartido(int numeroJugador){
        jugador[numeroJugador].aumentarMejorPartido();
    }

    public void aumentarKilometrosRecorridos(int numeroJugador){
        jugador[numeroJugador].aumentarKilometrosRecorridos();
    }


    public boolean isCreado() {
        return creado;
    }

    public String getDivision() {
        return division;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarJugadoresFederados(){

        int i = 0;
        for(i = 0; i < N; i++){

            if (jugador[i] == null) {
                break;
            } else {
                System.out.print(this.nombre + " | ");
                System.out.println(jugador[i].getJugadoresFederados());
            }

        }

    }
}
