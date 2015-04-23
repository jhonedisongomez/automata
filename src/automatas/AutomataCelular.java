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
public class AutomataCelular {
    
    int[] carros = new int [3];
    int[] carril = new int [3];
    
    int tiempo = 5;
    int contadorCarro = 0;
    int contadorTime = 0;
    int contadorCarril = 0;
    
    //inicializamos los valores
    public int [] inicializarCar(){
        
        carros[0]=1;
        carros[1]=1;
        carros[2]=1;
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
            if(carril[carril.length] != -1){
               if(carril[0] == 0 ){
                   carril[0] = carro[contadorCarro];
                   System.out.println("comienzo con el carro " + carro[contadorCarro]);
                   contadorCarro++;
                   contadorCarril++;
                   recorrerAutomata(carril,carro);
                   
               //para adelantar vehiculo por el corredor    
               }else{
                    //definimos el limite de los carriles
                    if(contadorCarril-1 < carril.length && contadorCarril == carril.length ){
                    
                        if (carril[contadorCarril-1] == 1 && carril[contadorCarril]==0 ){
                   
                            carril[contadorCarril] = carro[contadorCarro-1];
                            System.out.println("comienzo con el carro " + carro[contadorCarro-1]);
                            carril[contadorCarril-1] = carro[contadorCarro];
                            System.out.println("comienzo con el carro " + carro[contadorCarro]);

                            if(carro[contadorCarro] < carro.length){
                                contadorCarro++;
                            }

                            contadorCarril++;
                            recorrerAutomata(carril,carro);
                        }
                    }else{
                        carril[contadorCarril] = -1;
                    }
                    
                   
               }
                   
                    
            }    
        }
        
    }
    
}
