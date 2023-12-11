package llistes;

public class Utils {

    static String llegirStringPerTeclat() {
    
        String paraula = "";
        boolean llegit = false;
        while (!llegit) {
            llegit = Exercici4Sol.lector.hasNextLine();
            if (llegit) {
                paraula = Exercici4Sol.lector.nextLine();
            } else {
                System.out.println("Això no és una cadena de text");
                Exercici4Sol.lector.next();
            }
        }
        return paraula;
    }
    
}
