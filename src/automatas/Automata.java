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
public class Automata {
    
    int[] carros = new int [3];
    int []carril = new int [3];
    
    int tiempo = 5;
    int contadorCarro = 0;
    int contadorTime = 0;
    
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
            if(carril[2] != -1){
                if(carril[0] ==0){
                    carril[0] =carro[contadorCarro];
                    System.out.println("comienzo con el carro "+ carro[contadorCarro]);
                    contadorCarro++;
                    recorrerAutomata(carril,carro);

                }else if(carril[0] == 1 && carril[1]== 0){

                    carril[1] = carro[contadorCarro-1];
                    System.out.println("Adelanto primer carril con el carro " +carro[contadorCarro-1] );
                    carril[0] = carro[contadorCarro];
                    System.out.println("comienzo con el carro " +carro[contadorCarro] );

                    contadorCarro++;
                    recorrerAutomata(carril,carro);


                }else if (carril[0] == 2 && carril[1]== 1 && carril[2] == 0){

                    carril[2] = carro[contadorCarro-2];
                    System.out.println("Adelanto segundo carril con el carro " +carro[contadorCarro-2] );
                    carril[1] = carro[contadorCarro-1];
                    System.out.println("Adelanto primer carril con el carro " +carro[contadorCarro-1] );
                    carril[0] = carro[contadorCarro];
                    System.out.println("comienzo con el carro " +carro[contadorCarro] );

                    contadorTime++;
                    recorrerAutomata(carril,carro);

                }else if(carril[0] == 3 && carril[1]== 2 && carril[2] == 1){
                    
                    carril[2] = carro[contadorCarro-1];
                    System.out.println("Adelanto segundo carril con el carro " +carro[contadorCarro-1] );
                    carril[1] = carro[contadorCarro];
                    System.out.println("Adelanto primer carril con el carro " +carro[contadorCarro] );
                    carril[0] = -1;
                    System.out.println("carril vacio");

                    contadorTime++;
                    recorrerAutomata(carril,carro);

                }else if(carril[0] == -1 && carril[1]== 3 && carril[2] == 2 ){
                    
                    carril[2] = carro[contadorCarro-1];
                    System.out.println("Adelanto segundo carril con el carro " +carro[contadorCarro-1] );
                    carril[1] = -1;
                    System.out.println("carril vacio");

                    carril[0] = -1;
                    System.out.println("carril vacio");

                    contadorTime++;
                    recorrerAutomata(carril,carro);

                }else if(carril[0] == -1 && carril[1]== -1 && carril[2] == 2 ){
                    
                    carril[2] = -1;
                    System.out.println("carril vacio");
                    carril[1] = -1;
                    System.out.println("carril vacio");

                    carril[0] = -1;
                    System.out.println("carril vacio");

                    contadorTime++;
                    recorrerAutomata(carril,carro);
                }    
            }
        }
    }
}
