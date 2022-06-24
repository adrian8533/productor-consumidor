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
 * @author adrián garcía
 */
public class Fumador extends Thread{
    //creo un objecto con cada uno de los bancos de ingredientes que existen.
    private Servidor.Fosforos fosforos;
    private Servidor.Papel papel;
    private Servidor.Tabaco tabaco;
    
    public Fumador(Servidor.Fosforos fosforos, Servidor.Papel papel,
            Servidor.Tabaco tabaco){
        this.fosforos = fosforos;
        this.papel = papel;
        this.tabaco = tabaco;
    }
    
    public void fumando(int tipo){ //acá se guardan las trazas según el fumador.
        System.out.println("["+String.valueOf(tipo)+"]Armando cigarro..."); //esto se cambia por llenar el .txt
        System.out.println("["+String.valueOf(tipo)+"]Fumando...");
    }
    
    public void run(int tipo){//mando una variable con el tipo de fumador
        int i=0; //para variar la forma en que busca
        try{
        switch(tipo){
            case 0://el fumador siempre tiene tabaco.
                while(true){//busca los otros dos ingredientes.
                    if(i==0){ //variar la busqueda de ingredientes
                        papel.Sacar();
                        fosforos.Sacar();
                        fumando(tipo);
                        Thread.sleep(2000); //detiene el hilo mientras está fumando
                    }
                    else{
                        fosforos.Sacar();
                        papel.Sacar();
                        fumando(tipo);
                        Thread.sleep(2000); //detiene el hilo mientras está fumando
                    }
                    if(i==1) i=0; // para variar cómo busca
                    else i = 1;
                }
            case 1://el fumador siempre tiene papel
                while(true){//busca los otros dos ingredientes.
                    if(i==0){ //variar la busqueda de ingredientes
                        tabaco.Sacar();
                        fosforos.Sacar();
                        fumando(tipo);
                        Thread.sleep(2000); //detiene el hilo mientras está fumando
                    }
                    else{
                        fosforos.Sacar();
                        tabaco.Sacar();
                        fumando(tipo);
                        Thread.sleep(2000); //detiene el hilo mientras está fumando
                    }
                    if(i==1) i=0; // para variar cómo busca
                    else i = 1;
                }
            case 2://el fumador siempre tiene fosforo
                while(true){//busca los otros dos ingredientes.
                    if(i==0){ //variar la busqueda de ingredientes
                        tabaco.Sacar();
                        papel.Sacar();
                        fumando(tipo);
                        Thread.sleep(2000); //detiene el hilo mientras está fumando
                    }
                    else{
                        papel.Sacar();
                        tabaco.Sacar();
                        fumando(tipo);
                        Thread.sleep(2000); //detiene el hilo mientras está fumando
                    }
                    if(i==1) i=0; // para variar cómo busca
                    else i = 1;
                }    
        }
        } catch (InterruptedException ex) {
                Logger.getLogger(Agente.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}