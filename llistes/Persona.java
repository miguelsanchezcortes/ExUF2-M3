package llistes;

import java.util.Scanner;

public class Persona {
    public static String[][] getPersones() {
        String[][] persones = {
                { "nom1", "cognom1", "18", "7382828" },
                { "nom2", "cognom2", "19", "4568152" },
                { "nom3", "cognom3", "20", "4588877" },
                { "nom4", "cognom4", "11", "3521467" },
                { "nom5", "cognom5", "12", "9658763" }
        };
        return persones;
    }

    public static void llistarPersones(String[][] persones) {
        // opció1
        System.out.println("Nom Cognom Edat Telèfon");
        for (int i = 0; i < persones.length; i++) {
            for (int j = 0; j < persones[i].length; j++) {
                System.out.print(persones[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        // opció2
        System.out.println("Llista de persones");
        for (int i = 0; i < persones.length; i++) {
            llistarPersonaSeleccionada(persones, i);
        }
        System.out.println();
    }

    public static String[][] seleccionarPersona(String[][] persones) {

        int posPersonaSeleccionada = getPosPersona(persones);

        Vista.mostrarSubmenuSeleccionarPersona();

        int op = Utils.llegirEnterPerTeclat();

        persones = Vista.avaluarOpcioPersonaSeleccionada(persones, posPersonaSeleccionada, op);

        return persones;
    }
    public static int getPosPersona(String[][] persones) {
        int posPersonaSeleccionada;
        // mostrem la llista de persones per seleccionar-ne una
        System.out.println("Llista de persones:");
        for (int i = 0; i < persones.length; i++) {
            System.out.println(i + ". " + "Nom:" + persones[i][0]);
        }
        // comprovem que la persona seleccionada està dintre del rang de
        // les posicions
        do {
            System.out.print("Selecciona una persona ");
            posPersonaSeleccionada = Utils.llegirEnterPerTeclat();
        } while (posPersonaSeleccionada < 0 || posPersonaSeleccionada > persones.length - 1);
        return posPersonaSeleccionada;
    }
    public static void llistarPersonaSeleccionada(String[][] persones, int posPersonaSeleccionada) {
        System.out.println(posPersonaSeleccionada +
                ". Nom:" + persones[posPersonaSeleccionada][0] +
                " Cognom:" + persones[posPersonaSeleccionada][1] +
                " Edat:" + persones[posPersonaSeleccionada][2] +
                " Telèfon:" + persones[posPersonaSeleccionada][3]);
    }
    public static String[][] modificarPersonaSeleccionada(String[][] persones, int posPersonaSeleccionada) {
        // mostrem camp a camp, mostrant el valor actual i preguntant si vol
        // modificar-lo
        Scanner lector = new Scanner(System.in);
        System.out.println("Dades de la persona selecciona");
        System.out.println("Nom: " + persones[posPersonaSeleccionada][0]);
        int opPersonaSeleccionada = ' ';
        while (opPersonaSeleccionada != 's' && opPersonaSeleccionada != 'n') {
            System.out.println("Vols modificar les dades? (s/n)");
            opPersonaSeleccionada = lector.nextLine().charAt(0);
        }
        if (opPersonaSeleccionada == 's') {
            System.out.println("Donam el nom");
            persones[posPersonaSeleccionada][0] = Utils.llegirStringPerTeclat();
        }
        System.out.println("Cognom: " + persones[posPersonaSeleccionada][1]);
        opPersonaSeleccionada = ' ';
        while (opPersonaSeleccionada != 's' && opPersonaSeleccionada != 'n') {
            System.out.println("Vols modificar les dades? (s/n)");
            opPersonaSeleccionada = lector.nextLine().charAt(0);
        }
        if (opPersonaSeleccionada == 's') {
            System.out.println("Donam el cognom");
            persones[posPersonaSeleccionada][1] = Utils.llegirStringPerTeclat();
        }
        System.out.println("Edat: " + persones[posPersonaSeleccionada][2]);
        opPersonaSeleccionada = ' ';
        while (opPersonaSeleccionada != 's' && opPersonaSeleccionada != 'n') {
            System.out.println("Vols modificar les dades? (s/n)");
            opPersonaSeleccionada = lector.nextLine().charAt(0);
        }
        if (opPersonaSeleccionada == 's') {
            System.out.println("Donam la edat");
            persones[posPersonaSeleccionada][2] = String.valueOf(Utils.llegirEnterPerTeclat());
        }
        System.out.println("Telèfon: " + persones[posPersonaSeleccionada][3]);
        opPersonaSeleccionada = ' ';
        while (opPersonaSeleccionada != 's' && opPersonaSeleccionada != 'n') {
            System.out.println("Vols modificar les dades? (s/n)");
            opPersonaSeleccionada = lector.nextLine().charAt(0);
        }
        if (opPersonaSeleccionada == 's') {
            System.out.println("Donam el telèfon");
            persones[posPersonaSeleccionada][3] = String.valueOf(Utils.llegirStringPerTeclat());
        }

        return persones;
    }
    public static String[][] eliminarPersonaSeleccionada(String[][] persones, int posPersonaSeleccionada) {
        // Creem un nou array amb una posició menys
        String[][] personesAux = new String[persones.length - 1][persones[0].length];

        // copiem tots els valors excepte la persona seleccionada
        for (int i = 0, j = 0; i < persones.length; i++) {
            if (i != posPersonaSeleccionada) {
                personesAux[j] = persones[i];
                j++;
            }
        }

        // Intercanviem valors dels arrays
        persones = personesAux;

        System.out.println("Persona eliminada correctament");

        return persones;
    }
    public static String[][] afegirPersona(String[][] persones) {
        // creem un array amb una posició més per la primer dimensió
        // per la segona dimensió posem la longitud de qualsevol persona
        String[][] personesAux = new String[persones.length + 1][persones[0].length];

        // copiem totes les dades al nou array
        for (int i = 0; i < persones.length; i++) {
            for (int j = 0; j < persones[i].length; j++) {
                personesAux[i][j] = persones[i][j];
            }
        }

        // Demanem les dades de la nova persona i les posem a l'última posició
        System.out.print("Donam el nom: ");
        personesAux[personesAux.length - 1][0] = Utils.llegirStringPerTeclat();
        System.out.print("Donam el cognom: ");
        personesAux[personesAux.length - 1][1] = Utils.llegirStringPerTeclat();
        System.out.print("Donam l'edat: ");
        personesAux[personesAux.length - 1][2] = String.valueOf(Utils.llegirEnterPerTeclat());
        System.out.print("Donam el telèfon: ");
        personesAux[personesAux.length - 1][3] = String.valueOf(Utils.llegirEnterPerTeclat());
        System.out.println("Persona inserida correctament");
        System.out.println();

        // Intercanviem valors dels arrays
        persones = personesAux;

        return persones;
    }
}
