
package lab9p1_hectorsabillon;
import java.util.Scanner;

public class Lab9P1_HectorSabillon {

    static Scanner leer = new Scanner(System.in);
    
    public static int menu(int opcion){
        System.out.println("1 <- Game of Life");
        System.out.println("2 <- Salida");
        System.out.println("Ingrese una opcion: ");
        opcion = leer.nextInt();
        return opcion;
    }
    
    
    public static void main(String[] args) {
        int opcion = 1;
        switch (menu(opcion)){
            case 1:
                Game llamar = new Game();
                int rondas = 0;
                /*int[][] tablero = llamar.tablero(10);
                ArrayList<String> coords = llamar.coordenadas(tablero);
                llamar.Print(coords);*/
                
                llamar.jugar(rondas);
        }
    }
    
}
