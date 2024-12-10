/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimaevaluacion;
import java.util.Scanner;

/**
 *
 * @author eliel
 */
public class UltimaEvaluacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("selecciona una opcion:");
        System.out.println("1 suma recursiva de elementos en un arreglo");
        System.out.println("2 lista circular concatenada");
        System.out.println("3 inversion de pila");
        System.out.println("4 multiplicacion de factorial por potencia");
        System.out.print("ingresa el numero del ejercicio: ");
        int opcion = sc.nextInt();
        
        switch (opcion) {
            case 1:
                recursivo();
                break;
            case 2:
                listaCircular();
                break;
            case 3:
                invertirPila();
                break;
            case 4:
                System.out.print("Ingresa el número para calcular su factorial: ");
                int a = sc.nextInt();
                System.out.print("Ingresa la base para la potencia: ");
                int base = sc.nextInt();
                System.out.print("Ingresa el exponente para la potencia: ");
                int exponente = sc.nextInt();
                factorial(a, base, exponente);
                break;
            default:
                System.out.println("opcion no valida.");
        }
        
        
    }
    
    //el primer ejercicio del examen
    public static void recursivo() {
        int[] array = {3,5,6,1,3,5};
        int suma = sumar(array, array.length);
        System.out.println("la suma de los elementos es: " + suma);
    }
    
    public static int sumar(int[] arreglo, int n) {
        if (n == 0) {
            return 0;
        }
        return arreglo[n - 1] + sumar(arreglo, n - 1);
    }
    
    //el segundo ejercicio del examen
    public static void listaCircular() {
        ListaCircular lista = new ListaCircular();
        lista.agregar("hola");
        lista.agregar("como");
        lista.agregar("estas?");
        System.out.println("cadena concatenada: " + lista.concatenar());
    }

    static class Nodo {
        String dato;
        Nodo sig;

        public Nodo(String dato) {
            this.dato = dato;
            this.sig = null;
        }
    }

    static class ListaCircular {
        Nodo L;

        public void agregar(String palabra) {
            Nodo nuevo = new Nodo(palabra);
            if (L == null) {
                L = nuevo;
                L.sig = L;
            } else {
                Nodo aux = L;
                while (aux.sig != L) {
                    aux = aux.sig;
                }
                aux.sig = nuevo;
                nuevo.sig = L;
            }
        }

        public String concatenar() {
            if (L == null) return "";
            Nodo aux = L;
            StringBuilder resultado = new StringBuilder();
            do {
                resultado.append(aux.dato).append(" ");
                aux = aux.sig;
            } while (aux != L);
            return resultado.toString().trim();
        }
    }
    
    //el tercer ejercicio del examen
    public static void invertirPila() {
        int[] pila = {1, 2, 3, 4, 5};
        System.out.println("pila invertida:");
        pilaInvertida(pila, pila.length - 1);
    }

    public static void pilaInvertida(int[] pila, int i) {
        if (i < 0) return;
        System.out.println(pila[i]);
        pilaInvertida(pila, i - 1);
    }
    
    //el ultimo ejercicio del examen
    public static void factorial(int a, int base, int exponente) {
        int factorialA = factorial(a);
        int potenciaB = potencia(base, exponente);
        int resultado = factorialA + potenciaB;
        System.out.println("el resultado de la operacion es: " + resultado);
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int potencia(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        }
        return base * potencia(base, exponente - 1);
    }
}
