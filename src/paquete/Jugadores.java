package paquete;

import java.util.Scanner;

/**
 * Equipos
 * Equipos almacena nomre, apellidos y dorsal
 * @author Javier Garcia Aguilera
 */
public class Jugadores {

    private String nom;

    private String ape;
    private int dorsal;

    private int mejorPartido;

    private int numPartidos = 0;
    private double kmRecorridos = 0;


    public Jugadores(String nombre, String ape, int dorsal) {
        this.nom = nombre;
        this.dorsal = dorsal;
        this.ape = ape;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void aumentarMejorPartido() {

        this.mejorPartido = this.mejorPartido + 5;
        System.out.println("contador de mejor del partido del jugador " + this.nom + " aumentado a " + this.mejorPartido);
    }

    public void aumentarKilometrosRecorridos() {
        Scanner sn = new Scanner(System.in);
        this.numPartidos = this.numPartidos + 1;
        System.out.println("¿Cuantos kilometros ha recorrido el jugador " + this.nom + " en este partido?");

        kmRecorridos = kmRecorridos + sn.nextDouble();

        System.out.println("media de Kms recorridos del jugador " + this.nom + " actualizada a " + (this.kmRecorridos / numPartidos));
    }

    @Override
    public String toString() {
        return this.nom + " " + this.ape + " " + this.dorsal;
    }

    public String getJugadoresFederados() {
        return (this.nom + " " + this.ape + " | " + (this.kmRecorridos / this.numPartidos) + " | " + this.mejorPartido);
    }
}

