/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz.daw;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class MatrizString {

    private String[][] matriz;
    private static int contadorInstancias;

    //Constructor parametrizado
    public MatrizString(int valor) {
        this.matriz = new String[valor][valor];
        contadorInstancias++;
    }

    //Constructor por defecto
    public MatrizString() {
        this.matriz = new String[10][10];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = "Default";
            }
        }
        this.contadorInstancias++;

    }

    //Constructor copia
    public MatrizString(MatrizString aux) {
        this.matriz = new String[aux.matriz.length][aux.matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                this.matriz[i][j] = aux.matriz[i][j];
            }
        }
        this.contadorInstancias++;
    }

    //Getter del contador 
    public int getContadorInstancias() {
        return contadorInstancias;
    }

    public void llenar() {

        Scanner teclado = new Scanner(System.in);
        String valor = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.println("Introduce un texto para la posición: " + i + j);
                valor = teclado.nextLine();
                matriz[i][j] = valor;
            }
        }

    }

    //Mostrar
    public void mostrar() {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] == null) {
                    System.out.println("[]");
                } else {
                    System.out.println("el valor es: " + matriz[i][j]);
                }
            }
        }

    }

    //mostrar tmp   
    public static void mostrar(MatrizString tmp) {

        for (int i = 0; i < tmp.matriz.length; i++) {
            for (int j = 0; j < tmp.matriz.length; j++) {
                System.out.println(tmp.matriz[i][j]);
                if (tmp.matriz[i][j] == null) {
                    System.out.println("[]");
                }
            }
        }

    }

    public static boolean comparar(MatrizString a, MatrizString b) {

        if (a.matriz.length == b.matriz.length) {
            for (int i = 0; i < a.matriz.length; i++) {
                for (int j = 0; j < a.matriz.length; j++) {
                    if (!a.matriz[i][j].equals(b.matriz[i][j])) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    

    public static MatrizString concatenar(MatrizString a, MatrizString b){
        
        MatrizString aux = new MatrizString();
        String cadena="";
        
        if (a.matriz.length== b.matriz.length) {
            aux.matriz= new String[a.matriz.length][b.matriz.length];
            for (int i = 0; i < a.matriz.length; i++) {
                for (int j = 0; j < a.matriz.length; j++) {
                   aux.matriz[i][j]= a.matriz[i][j] + b.matriz[i][j]; 
                }
            }
        }
        return aux;
    }
    
    public MatrizString copia(){
        MatrizString aux= new MatrizString(matriz.length);
        for (int i = 0; i < aux.matriz.length; i++) {
            for (int j = 0; j < aux.matriz.length; j++) {
                aux.matriz[i][j]= this.matriz[i][j];
            }
        }
        return aux;
    }
    
    public Coordenada buscar(String cadena){
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[i].length; j++) {
                if (this.matriz[i][j].equals(cadena)) {
                    Coordenada aux= new Coordenada(i,j);
                    return aux;
                }
            }
        }
        Coordenada ejem= new Coordenada(-1,-1);
        return ejem;
    }
    
    public ArrayList<Coordenada> buscarEnLista(String cadena){
         ArrayList <Coordenada>ejem= new ArrayList<>();
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz.length; j++) {
                if (this.matriz[i][j].equals(cadena)) {
                    Coordenada aux = new Coordenada(i,j);
                    ejem.add(aux);
                }
            }
        }
        return ejem;
    }
    
}
