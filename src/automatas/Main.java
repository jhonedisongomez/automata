/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automatas;

/**
 *
 * @author jhon
 */
public class Main {

    int cont; 
    boolean aceptada;/*para guardar los caratcteres y los va ir separando*/ 
    char [] car; 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AutomataCelular objAutomata2 = new AutomataCelular();
        
        int[] arreglo = objAutomata2.inizializar();
        int [] carros = objAutomata2.inicializarCar();
        
        objAutomata2.recorrerAutomata(arreglo,carros);
    }
     
    
}
