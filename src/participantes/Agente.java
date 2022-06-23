/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package participantes;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Agente extends Thread{
    public void run(){
        int banco1,banco2;//para guardar el número aleatorio
        Random dado = new Random();//función para generar el aleatorio
        while(true){
            try {
                banco1 = dado.nextInt(3); //obtengo aleatoriamente un banco
                banco2 = dado.nextInt(3); //obtengo aleatoriamente un banco
                //todas las siguietes son las diferentes opciones de llenado.
                switch(banco1) {
                    case 0:
                      System.out.println("Llenado tabaco"); //esto se cambia por llenar el .txt   
                      Thread.sleep(2000); //detiene el hilo durante dos segundos mientras llena
                      break;
                    case 1:
                      System.out.println("Llenado papel"); //esto se cambia por llenar el .txt   
                      Thread.sleep(2000); //detiene el hilo durante dos segundos mientras llena
                      break;
                    case 2:
                      System.out.println("Llenado fosforo"); //esto se cambia por llenar el .txt   
                      Thread.sleep(2000); //detiene el hilo durante dos segundos mientras llena
                      break;
                }   
                switch(banco2) {
                    case 0:
                      System.out.println("Llenado tabaco"); //esto se cambia por llenar el .txt   
                      Thread.sleep(2000); //detiene el hilo durante dos segundos mientras llena
                      break;
                    case 1:
                      System.out.println("Llenado papel"); //esto se cambia por llenar el .txt   
                      Thread.sleep(2000); //detiene el hilo durante dos segundos mientras llena
                      break;
                    case 2:
                      System.out.println("Llenado fosforo"); //esto se cambia por llenar el .txt   
                      Thread.sleep(2000); //detiene el hilo durante dos segundos mientras llena
                      break;
                }   
            } catch (InterruptedException ex) {
                Logger.getLogger(Agente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
