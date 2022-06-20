/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fumadores;
import java.io.IOException;
import sockets.Servidor;


/**
 *
 * @author Adrián García
 */
//Clase principal que hará uso del servidor
public class MainServidor {
   public static void main(String[] args) throws IOException
    {
        Servidor recepcion = new Servidor(); //Se crea el servidor

        System.out.println("Iniciando servidor\n");
        recepcion.startServer(); //Se inicia el servidor
    }
   
}
