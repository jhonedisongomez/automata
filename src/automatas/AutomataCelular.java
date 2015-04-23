/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automatas;

import java.util.ArrayList;

/**
 *
 * @author jhon
 */
public class AutomataCelular {
    
    int[] carros = new int [3];
    int[] carril = new int [3];
    
    int tiempo = 5;
    int contadorCarro = 0;
    int contadorTime = 0;
    int contadorCarril = carril.length;
    int [] cola;
    
    //inicializamos los valores
    public int [] inicializarCar(){
        
        carros[0]=1;
        carros[1]=2;
        carros[2]=3;
        return carros;
    }
    
    public int[] inizializar(){
        for (int carrilIx = 0 ; carrilIx<carril.length;carrilIx++){
            carril[carrilIx] = 0;
        }
        return carril;
    }
    
    public void recorrerAutomata(int []carril, int[] carro){
        
        if(contadorTime< tiempo){
            
                
            if(carril[0] == 0){
                carril[0] = 1;
                System.out.println("comienzo con el carro " + carro[contadorCarro]);
                       
                
                recorrerAutomata(carril,carro);

            }else{
                for(int carrilIx = 2;carrilIx>0; carrilIx--){

                    //para el comienzo
                    if(carrilIx == 0 && carril[carrilIx] == 0){
                        carril[carrilIx] = 1;
                        System.out.println("comienzo con el carro " + carro[contadorCarro]);

                        if(contadorCarro<carro.length-1){
                            contadorCarro++;
                        }
                        recorrerAutomata(carril,carro);

                    //para adelantar    
                    }else if(carril[carrilIx] == 0 && carril[carrilIx-1] == 1){
                        carril[carrilIx] = 1;
                        carril[carrilIx-1] = 0;
                        System.out.println("adelanto con el carro " + carro[contadorCarro]);
                        //cola[contadorCarril] = carro[contadorCarro];   
                       if(contadorCarro<carro.length-1){
                            contadorCarro++;
                        }
                        recorrerAutomata(carril,carro);

                    }else if (carrilIx == carril[carril.length-1] && carril[carrilIx-1] == 1){
                        carril[carril.length-1] = 1;
                        carril[carrilIx-1] = 0;
                        System.out.println("termino del carril " + carro[contadorCarro]);
                        if(carril[0] == 0){
                            carril[0] = -1;
                        }
                        //contadorCarro--;
                        recorrerAutomata(carril,carro);
                    }
                }    
            }
        tiempo++;    
        }
        
    }
    
}
