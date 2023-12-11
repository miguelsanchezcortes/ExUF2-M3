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
            mostrarMenu();
            op = llegirEnterPerTeclat();
            persones = avaluarOpcio(persones, op);

        } while (op != 0);
        lector.close();
    }

    

    private static void mostrarMenu() {
        System.out.println("Selecciona una opció...");
        System.out.println("1. Llistar persones");
        System.out.println("2. Seleccionar una persona");
        System.out.println("3. Afegir persona");
        System.out.println("0. Sortir");
    }

    private static String[][] avaluarOpcio(String[][] persones, int op) {
        switch (op) {
            case 1:// 1. Llistar persones
                llistarPersones(persones);
                break;
            case 2:// 2. Seleccionar una persona
                persones = seleccionarPersona(persones);
                break;
            case 3: // afegir persona
                persones = afegirPersona(persones);
                break;
            case 0:// 0. Sortir
                System.out.println("Adèu...");
                break;
            default:
                System.out.println("Opció incorrecta...");
                break;
        }

        return persones;
    }

    private static void llistarPersones(String[][] persones) {
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

    private static String[][] seleccionarPersona(String[][] persones) {

        int posPersonaSeleccionada = getPosPersona(persones);

        mostrarSubmenuSeleccionarPersona();

        int op = llegirEnterPerTeclat();

        persones = avaluarOpcioPersonaSeleccionada(persones, posPersonaSeleccionada, op);

        return persones;
    }

    private static int getPosPersona(String[][] persones) {
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
            posPersonaSeleccionada = llegirEnterPerTeclat();
        } while (posPersonaSeleccionada < 0 || posPersonaSeleccionada > persones.length - 1);
        return posPersonaSeleccionada;
    }

    private static void mostrarSubmenuSeleccionarPersona() {
        System.out.println("Selecciona una opció:");
        System.out.println("1. Llistar dades de la persona");
        System.out.println("2. Modificar dades de la persona");
        System.out.println("3. Eliminar persona");
    }

    private static String[][] avaluarOpcioPersonaSeleccionada(String[][] persones, int posPersonaSeleccionada, int op) {
        switch (op) {
            case 1:// 1. Llistar dades de la persona
                llistarPersonaSeleccionada(persones, posPersonaSeleccionada);
                break;
            case 2:// 2. Modificar dades de la persona
                persones = modificarPersonaSeleccionada(persones, posPersonaSeleccionada);
                break;
            case 3: // Eliminar persona seleccionada
                persones = eliminarPersonaSeleccionada(persones, posPersonaSeleccionada);
                break;
            default:
                System.out.println("Opció incorrecta...");
                break;
        }

        return persones;
    }

    private static void llistarPersonaSeleccionada(String[][] persones, int posPersonaSeleccionada) {
        System.out.println(posPersonaSeleccionada +
                ". Nom:" + persones[posPersonaSeleccionada][0] +
                " Cognom:" + persones[posPersonaSeleccionada][1] +
                " Edat:" + persones[posPersonaSeleccionada][2] +
                " Telèfon:" + persones[posPersonaSeleccionada][3]);
    }

    private static String[][] modificarPersonaSeleccionada(String[][] persones, int posPersonaSeleccionada) {
        // mostrem camp a camp, mostrant el valor actual i preguntant si vol
        // modificar-lo
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
            persones[posPersonaSeleccionada][2] = String.valueOf(llegirEnterPerTeclat());
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

    private static String[][] eliminarPersonaSeleccionada(String[][] persones, int posPersonaSeleccionada) {
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

    private static String[][] afegirPersona(String[][] persones) {
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
        personesAux[personesAux.length - 1][2] = String.valueOf(llegirEnterPerTeclat());
        System.out.print("Donam el telèfon: ");
        personesAux[personesAux.length - 1][3] = String.valueOf(llegirEnterPerTeclat());
        System.out.println("Persona inserida correctament");
        System.out.println();

        // Intercanviem valors dels arrays
        persones = personesAux;

        return persones;
    }

    private static int llegirEnterPerTeclat() {

        int enterLlegit = 0;
        boolean llegit = false;
        while (!llegit) {
            llegit = lector.hasNextInt();
            if (llegit) {
                enterLlegit = lector.nextInt();
            } else {
                System.out.println("Això no és un enter");
                lector.next();
            }
        }
        lector.nextLine();
        return enterLlegit;
    }
}
