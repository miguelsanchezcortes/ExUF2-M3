package llistes;

public class Vista {
    public static void mostrarMenu() {
        System.out.println("Selecciona una opció...");
        System.out.println("1. Llistar persones");
        System.out.println("2. Seleccionar una persona");
        System.out.println("3. Afegir persona");
        System.out.println("0. Sortir");
    }
    public static String[][] avaluarOpcio(String[][] persones, int op) {
        switch (op) {
            case 1:// 1. Llistar persones
                Persona.llistarPersones(persones);
                break;
            case 2:// 2. Seleccionar una persona
                persones = Persona.seleccionarPersona(persones);
                break;
            case 3: // afegir persona
                persones = Persona.afegirPersona(persones);
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
    public static void mostrarSubmenuSeleccionarPersona() {
        System.out.println("Selecciona una opció:");
        System.out.println("1. Llistar dades de la persona");
        System.out.println("2. Modificar dades de la persona");
        System.out.println("3. Eliminar persona");
    }
    public static String[][] avaluarOpcioPersonaSeleccionada(String[][] persones, int posPersonaSeleccionada, int op) {
        switch (op) {
            case 1:// 1. Llistar dades de la persona
                Persona.llistarPersonaSeleccionada(persones, posPersonaSeleccionada);
                break;
            case 2:// 2. Modificar dades de la persona
                persones = Persona.modificarPersonaSeleccionada(persones, posPersonaSeleccionada);
                break;
            case 3: // Eliminar persona seleccionada
                persones = Persona.eliminarPersonaSeleccionada(persones, posPersonaSeleccionada);
                break;
            default:
                System.out.println("Opció incorrecta...");
                break;
        }

        return persones;
    }
}
