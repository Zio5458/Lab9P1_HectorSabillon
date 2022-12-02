/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9p1_hectorsabillon;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
public class Game {
    
    Random random = new Random();
    Scanner leer = new Scanner(System.in);
    
    private int[][] tablero;
    private int rondas;
    
    public int[][] tablero (int size){
        int[][] inicial = new int[10][10];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                inicial[i][j] = random.nextInt(2);
            }
        }
        
        for (int i = 0; i < inicial.length; i++){
            for (int j = 0; j < inicial[i].length; j++){
                if (i == 0 || j == 0 || i == inicial.length-1 || j == inicial[i].length-1){
                    inicial[i][j] = 0;
                }
            }
        }
        
        this.tablero = inicial;
        return tablero;
    }
    
    public ArrayList<String> coordenadas(int[][] tablero){
        tablero = this.tablero;
        ArrayList<String> coords = new ArrayList<>();
        for (int i = 0; i < tablero.length; i++){
            for (int j = 0; j < tablero[i].length; j++){
                if (tablero[i][j] == 1){
                    coords.add((Integer.toString(i) + ":" + Integer.toString(j)));
                }
            }
        }
        return coords;
    }
    
    public int numero_de_rondas(int rondas){
        System.out.println("Ingrese la cantidad de rondas a jugar: ");
        rondas = leer.nextInt();
        this.rondas = rondas;
        return rondas;
    }
    
    public void jugar(int x){
        numero_de_rondas(rondas);
        tablero(10);
        int[][] tablero = this.tablero;
        x = this.rondas;
        int cont = 0;
        for (int i = 0; i < tablero.length; i++){
            for (int j = 0; j < tablero[i].length; j++){
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }//Tablero inicial
        
        System.out.println();
        
        do{
            nextGen();
            Print(coordenadas(tablero));
            cont++;
        } while (cont < rondas); //llamado de los otros metodos
    }
    
    public int[][] nextGen(){
        int[][] tablero = this.tablero;
        for (int i = 0; i < tablero.length; i++){
            for (int j = 0; j < tablero[i].length; j++){
                int cont_vecinos = 0;
                if (tablero[i][j] == 1){
                    if (tablero [i-1][j-1] == 1){
                        cont_vecinos++;
                    }
                    if (tablero[i][j-1] == 1){
                        cont_vecinos++;
                    }
                    if (tablero[i+1][j-1] == 1){
                        cont_vecinos++;
                    }
                    if (tablero[i-1][j] == 1){
                        cont_vecinos++;
                    }
                    if (tablero[i+1][j] == 1){
                        cont_vecinos++;
                    }
                    if (tablero[i-1][j+1] == 1){
                        cont_vecinos++;
                    }
                    if (tablero[i][j+1] == 1){
                        cont_vecinos++;
                    }
                    if (tablero[i+1][j+1] == 1){
                        cont_vecinos++;
                    }
                    if (cont_vecinos < 2){
                        tablero[i][j] = 0;
                    }
                    if (cont_vecinos >= 3){
                        tablero[i][j] = 0;
                    }
                    if (cont_vecinos == 2){
                        tablero[i][j] = 1;
                    }
                }
                if (tablero[i][j] == 0){
                    if (i == 0 || j == 0 || i == tablero.length-1 || j == tablero[i].length-1){
                        tablero[i][j] = 0;
                    } else if (cont_vecinos == 3){
                            tablero[i][j] = 1;
                    }
                }
            }
        }
        return tablero;
    }
    
    public int[][] Print(ArrayList<String> x){
        x = coordenadas(this.tablero);
        int[][] sig_tablero = new int[10][10];
        for (int i = 0; i < x.size(); i++){
            String[] split = x.get(i).split(":", 0);
            int coordx = Integer.parseInt(split[0]);
            int coordy = Integer.parseInt(split[1]);
            sig_tablero[coordx][coordy] = 1;
        }
        
        for (int i = 0; i < sig_tablero.length; i++){
            for (int j = 0; j < sig_tablero[i].length; j++){
                System.out.print(sig_tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        
        return sig_tablero;
    }
    
}//Fin clase Game
