package regex;

import java.util.Scanner;

public class ex1 {
public static void main(String[] args) {
    Scanner lector = new Scanner(System.in);
    String nom = "";
    String cognom = "";
    String email = "";
    String data = "";
    System.out.println("donam un nom");
    nom = lector.nextLine();
    System.out.println("Donam el cognom");
    cognom = lector.nextLine();
    System.out.println("donam el email");
    email = lector.nextLine();
    System.out.println("Donam la data");
    data = lector.nextLine();
    //comprovarNomCognom(nom, cognom);
    //comprovarLlargadaNomCognom(nom, cognom);
    //comprovarDigitsNomCognom(nom, cognom);
    Validacions.regexNomCognom(nom, cognom);
    Validacions.regexEmail(email);
    Validacions.regexData(data);
}





private static void comprovarNomCognom(String nom, String cognom) {
    char primerCaracterNom = nom.charAt(0);
    char primerCaracterCognom = cognom.charAt(0);
    if(!Character.isUpperCase(primerCaracterNom) && !Character.isUpperCase(primerCaracterCognom)){
        System.out.println("La primera lletra del teu nom i cognom ha de ser majuscules");
    } else{
        System.out.println("Nom i Cognom correctes");
    }
}

private static void comprovarLlargadaNomCognom(String nom, String cognom) {
    if((nom.length() >= 3 && nom.length() <= 15) && (cognom.length()>=3 && cognom.length() <=15)){
        System.out.println("Credencials correctes");
    } else{
        System.out.println("El nom i cognom han de tenir com a mínim 3 caracters i màxim 15");
    }
}

private static void comprovarDigitsNomCognom(String nom, String cognom) {
    boolean digit;
    for(int i = 0; i<nom.length(); i++){
        if(Character.isDigit(nom.charAt(i))){
            digit = true;
        }
    }
    for(int i = 0; i<cognom.length(); i++){
        if(Character.isDigit(cognom.charAt(i))){
            digit = true;
        }
    }
    if(digit = false){
        System.out.println("Credencials correctes");
    } else{
        System.out.println("credencials incorrectes");
    }
    
}


    
}