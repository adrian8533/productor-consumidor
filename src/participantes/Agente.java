package participantes;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import sockets.Servidor;
import sockets.Servidor.Fosforos;
import sockets.Servidor.Papel;
import sockets.Servidor.Tabaco;

/**
 *
 * @author USER
 * me faltan varias cosas la cantidad de ingredientes y las trazas 
 * 
 */
public class Agente extends Thread{
    //creio un objecto con cada uno de los bancos de ingredientes que existen.
    private Servidor.Fosforos fosforos;
    private Servidor.Papel papel;
    private Servidor.Tabaco tabaco;
    
    public Agente(Servidor.Fosforos fosforos, Servidor.Papel papel,
            Servidor.Tabaco tabaco){
        this.fosforos = fosforos;
        this.papel = papel;
        this.tabaco = tabaco;
    }
    
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
                      tabaco.Poner();
                      Thread.sleep(2000); //detiene el hilo durante dos segundos mientras llena
                      break;
                    case 1:
                      System.out.println("Llenado papel"); //esto se cambia por llenar el .txt   
                      papel.Poner();
                      Thread.sleep(2000); //detiene el hilo durante dos segundos mientras llena
                      break;
                    case 2:
                      System.out.println("Llenado fosforo"); //esto se cambia por llenar el .txt   
                      fosforos.Poner();
                      Thread.sleep(2000); //detiene el hilo durante dos segundos mientras llena
                      break;
                }   
                switch(banco2) {
                    case 0:
                      System.out.println("Llenado tabaco"); //esto se cambia por llenar el .txt
                      tabaco.Poner();
                      Thread.sleep(2000); //detiene el hilo durante dos segundos mientras llena
                      break;
                    case 1:
                      System.out.println("Llenado papel"); //esto se cambia por llenar el .txt   
                      papel.Poner();
                      Thread.sleep(2000); //detiene el hilo durante dos segundos mientras llena
                      break;
                    case 2:
                      System.out.println("Llenado fosforo"); //esto se cambia por llenar el .txt   
                      fosforos.Poner();
                      Thread.sleep(2000); //detiene el hilo durante dos segundos mientras llena
                      break;
                }   
            } catch (InterruptedException ex) {
                Logger.getLogger(Agente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
