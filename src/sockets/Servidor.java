/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;
import java.lang.Object;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.locks.Condition;
import sockets.Conexion;//importo los métodos de la clase conexión
/**
 *
 * @author Adrian García
 */
public class Servidor extends Conexion{ //Se hereda de conexión
    public Servidor() throws IOException{super("servidor");} //Se usa el constructor para servidor de Conexion
    public void startServer(){//Método para iniciar el servidor
        try
        {
            System.out.println("Esperando..."); //Mensaje de espera
            cs = ss.accept(); //Acepta la conexión el socket
            System.out.println("Cliente en línea");
            salidaCliente = new DataOutputStream(cs.getOutputStream()); //Establezco la salida del cliente
            salidaCliente.writeUTF("Petición recibida y aceptada"); //Envío un mensaje al cliente
            //Se obtiene el flujo entrante desde el cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            while((mensaje = entrada.readLine()) != null) //Mientras haya mensajes desde el cliente
            {
                System.out.println(mensaje); //Muestro el mensaje recibido
            }
            System.out.println("Fin de la conexión");
            ss.close();//Cierro la conexión con el cliente
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

public class Tabaco{  //PRIMER BANCO
    private boolean vacio;
    public synchronized void Poner() throws InterruptedException{
        while(vacio == false){
            wait(); //mientras no haya ingredientes para sacar voy a dormir
        }
        vacio = false; // si se vació vuelvo a llenar
        notifyAll();
    }
    public synchronized int Sacar() throws InterruptedException{
        while(vacio == true){
            wait(); //mientras no haya ingredientes para sacar voy a dormir
        }
        vacio = true; // después que saqué lo vuelvo a dejar vacio
        notifyAll();
        return 0; // retorno 0 para que sepa que se agarró un tabaco
    }
}

public class Papel{  //SEGUNDO BANCO
    private boolean vacio;
    public Papel(){
        boolean vacio;
    }
    public synchronized void Poner() throws InterruptedException{
        while(vacio == false){
            wait(); //si está lleno no se puede poner y va a dormir
        }
        vacio = false; // si se vació vuelvo a llenar
        notify();
    }
    public synchronized int Sacar() throws InterruptedException{
        while(vacio == true){
            wait(); //mientras no haya ingredientes para sacar voy a dormir
        }
        vacio = true; // después que saqué lo vuelvo a dejar vacio
        notify();
        return 1; // retorno 2 para que sepa que se agarró un papel
    }
 }

public class Fosforos{  //TERCER BANCO
    private boolean vacio;
    public Fosforos(){
        vacio = true;
    }
    public synchronized void Poner() throws InterruptedException{
        while(vacio == false){
            wait(); //si está lleno no se puede poner y va a dormir
        }
        vacio = false; // si se vació puedo volver a llenar
        notify();
    }
    public synchronized int Sacar() throws InterruptedException{
        while(vacio == true){
            wait(); //mientras no haya ingredientes para sacar voy a dormir
        }
        vacio = true; // después que saqué lo vuelvo a dejar vacio
        notify();
        return 2; // retorno 3 para que sepa que se agarró un fosforo
    }
 }



}