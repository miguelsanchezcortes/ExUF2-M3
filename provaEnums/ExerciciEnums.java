package provaEnums;

import java.util.Scanner;

public class ExerciciEnums {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        String nom = "";
        NivellEstudi estudi;
        estudi = NivellEstudi.GRAU_SUPERIOR;

        String[][] alumnes = {
            {"Miguel","Sánchez","20",estudi.toString()},
            {"Bilal","Boulouban","21", NivellEstudi.GRAU_SUPERIOR.toString()},
            {"Marc","Garcia","17", NivellEstudi.SECUNDARI.toString()}
        };
        System.out.println("digam el nom de l'alumne que vols veure el seu nivell d'estudis");
        nom = lector.nextLine();
        for(int i = 0; i < alumnes.length; i ++){
            for(int j = 0; j < alumnes[i].length; j++){
                if(alumnes[i][0] == nom){
                    System.out.println("L'alumne " + alumnes[i][0] + " Està fent: " + alumnes[i][3]);
                }
            }
        }
    }
}
