package regex;

public class Validacions {
    
    public static void regexNomCognom(String nom, String cognom) {
        String regex = "^[A-Z][a-z]{2,14}$";
        if(nom.matches(regex)&& cognom.matches(regex)){
            System.out.println("Credencials Correctes");
        } else{
            System.out.println("Credencials icorrectes");
        }
    }
    public static void regexEmail(String email){
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if(email.matches(regex)){
            System.out.println("credencials Correctes");
        } else{
            System.out.println("Credencials Incorrectes");
        }
    }
    public static void regexData(String data){
        String regex = "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/\\d{4}$";
        if(data.matches(regex)){
            System.out.println("Credencials Correctes");
        } else{
            System.out.println("Credencials Incorrectes");
        }
    }
}
