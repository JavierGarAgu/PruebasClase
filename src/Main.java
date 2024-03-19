// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import paquete.*;

import java.util.Objects;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        final int N = 3;

        Scanner sn = new Scanner(System.in);
        int op = 0;
        Equipos[] equipo = new Equipos[N];

        while (op != -1) {

            System.out.println("Elija opción:");
            System.out.printf("1.- Crear equipo  \n" +
                              "2.- Crear jugador \n" +
                              "3.- Mostrar todos los jugadores de un equipo \n" +
                              "4.- aumentar mejor jugador por partido \n" +
                              "5.- aumentar kilometros recorridos de nuevo partido \n" +
                              "6.- Mostrar todos los jugadores federados \n");
            op = sn.nextInt();

            switch(op){

                case 1:
                    crearEquipo(equipo);
                    break;

                case 2:
                    crearJugador(equipo);
                    break;
                case 3:

                    int respuesta = menuInteractivoTodosLosEquipos(equipo);
                    equipo[respuesta].mostrarTodosJugadores();
                    break;

                case 4:

                    aumentarMejorPartido(equipo);

                    break;

                case 5:
                    aumentarKilometrosRecorridos(equipo);
                    break;
                case 6:
                    mostrarTodosLosJugadoresDeTodosLosEquipos(equipo);
            }
        }
    }


    public static void crearJugador(Equipos[] equipo){
        boolean flag;
        Scanner sn = new Scanner(System.in);
        int i = 0;
        final int N = 3;
        i = menuInteractivoTodosLosEquipos(equipo);

        if (i == -1){
            System.out.println("no se puede seguir creando el jugador...");
        } else {
            System.out.println("Dime el nombre del jugador");
            String nomJ = sn.next();
            System.out.println("Dime el apellido del jugador");
            String ape = sn.next();
            System.out.println("Dime el dorsal del jugador");
            int dorsal = sn.nextInt();

            flag = equipo[i].altaJugador(nomJ, ape, dorsal);
            if (!flag){
                System.out.println("ERROR, NUMERO MAXIMO DE JUGADORES ALCANZADO");
            } else {
                System.out.println("JUGADOR CREADO");
                equipo[i].mostrarTodosJugadores();
            }
        }

    }

    public static void crearEquipo(Equipos[] equipo){
        Scanner sn = new Scanner(System.in);
        final int N = 3;
        int i = 0;
        int division;
        System.out.println("Dime un nombre");
        String nombre = sn.next();
        do {
            System.out.println("Dime una division (solo 1, 2, 3)");
            division = sn.nextInt();
        } while ((division != 1) && (division != 2) && (division != 3));

        for(i = 0; i < N; i++){

            if (equipo[i] == null) {
                equipo[i] = new Equipos(division, nombre);
                break;
            }
        }

        if (i == N){
            System.out.println("ERROR, YA NO SE PUEDEN CREAR MAS EQUIPOS");
        } else {
            System.out.println("EQUIPO CREADO");
            System.out.println("NOMBRE: " + equipo[i].getNombre());
            System.out.println("DIVISION: " + equipo[i].getDivision());
        }

    }

    public static void aumentarMejorPartido(Equipos[] equipo){
        Scanner sn = new Scanner(System.in);
        int i = menuInteractivoTodosLosEquipos(equipo);

        int j = equipo[i].mostrarTodosJugadores();

        int numeroJugador = 0;

        if (j == 0){
            System.out.println("No hay jugadores creados, para crear utilice la opción nº 2 'crear jugador'");
        } else {
            do {
                System.out.println("Seleccione numero de jugador");
                numeroJugador = sn.nextInt();
            } while ((numeroJugador < 1) || (numeroJugador >= j+1));
        }

        equipo[i].aumentarMejorPartido(numeroJugador-1);
    }

    public static int menuInteractivoTodosLosEquipos(Equipos[] equipo){
        Scanner sn = new Scanner(System.in);
        final int N = 3;
        int i = 0;
        int numeroEquipo = 0;

        for(i = 0; i < N; i++){

            if (equipo[i] == null) {
                break;
            } else {
                System.out.println((i + 1) + ".- " + equipo[i].getNombre());
            }

        }

        if (i == 0){
            System.out.println("No hay equipos creados, para crear utilice la opción nº 1 'crear equipo de futbol'");
        } else {
            do {
                System.out.println("Seleccione numero de equipo");
                numeroEquipo = sn.nextInt();
            } while ((numeroEquipo < 1) || (numeroEquipo >= i+1));
        }

        return (numeroEquipo - 1);
    }

    public static void aumentarKilometrosRecorridos(Equipos[] equipo){
        Scanner sn = new Scanner(System.in);
        int i = menuInteractivoTodosLosEquipos(equipo);

        int j = equipo[i].mostrarTodosJugadores();

        int numeroJugador = 0;

        if (j == 0){
            System.out.println("No hay jugadores creados, para crear utilice la opción nº 2 'crear jugador'");
        } else {
            do {
                System.out.println("Seleccione numero de jugador");
                numeroJugador = sn.nextInt();
            } while ((numeroJugador < 1) || (numeroJugador >= j+1));
        }

        equipo[i].aumentarKilometrosRecorridos(numeroJugador-1);
    }

    public static void mostrarTodosLosJugadoresDeTodosLosEquipos(Equipos[] equipo){
        final int N = 3;
        for(int i = 0; i < N; i++){

            if (equipo[i] == null) {
                break;
            } else {
                equipo[i].mostrarJugadoresFederados();
            }

        }
    }



}