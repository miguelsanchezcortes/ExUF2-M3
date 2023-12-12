package llistes;

import java.util.Scanner;

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
    public static int llegirEnterPerTeclat() {
        Scanner lector = new Scanner(System.in);
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
