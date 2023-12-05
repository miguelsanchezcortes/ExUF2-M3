public class ex2 {
    public static void main(String[] args) {
        area(14);
        longitud(14);
    }
    public static double area(double radi){
        double area;
        double pi = 3.14;
         area = pi * (radi * radi);
         return area;
    }
    public static double longitud(double radi){
        double longitud;
        double pi = 3.14;
        longitud = 2* pi * radi;
        return longitud;
    }
}
