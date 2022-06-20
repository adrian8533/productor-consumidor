/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
}