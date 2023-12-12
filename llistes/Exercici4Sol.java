package llistes;


import java.util.Scanner;

public class Exercici4Sol {
    /**
     * 4. Escriu un programa que emmagatzema dades de
     * 5 persones i en concret guarda, el nom, cognoms,
     * edat i telèfon. Les dades es guardaran en un array.
     * El programa ha de poder llistar totes les persones,
     * seleccionar un persona i sortir del programa.
     * Si es selecciona una persona es podran llistar
     * les seves dades o modificar-les. També es podran
     * afegir i eliminar persones.
     */

    static Scanner lector;

    public static void main(String[] args) {
        lector = new Scanner(System.in);
        String[][] persones = Persona.getPersones();

        int op;

        do {
            Vista.mostrarMenu();
            op = Utils.llegirEnterPerTeclat();
            persones = Vista.avaluarOpcio(persones, op);

        } while (op != 0);
        lector.close();
    }
    
}
