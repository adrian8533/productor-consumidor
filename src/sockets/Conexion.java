package sockets;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author Adrián García
 */
public class Conexion{
    private final int puerto = 1234; //puerto para la conexión
    private final String host = "localhost"; //host para la conexión
    protected String mensaje; //Mensajes recibidos por el servidor
    protected ServerSocket ss; //Socket del servidor
    protected Socket cs; //Socket del cliente
    protected DataOutputStream salidaServidor, salidaCliente; //Flujo de datos de salida

    public Conexion(String tipo) throws IOException //Constructor
    {
        if(tipo.equalsIgnoreCase("servidor"))
        {
            ss = new ServerSocket(puerto);//Se crea el socket para el servidor en puerto
            cs = new Socket(); //Socket para el cliente
        }
        else
        {
            cs = new Socket(host, puerto); //Socket para el cliente en localhost en puerto 8080
        }
    }
}
