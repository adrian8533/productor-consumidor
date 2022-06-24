/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *///
package fumadores;
import java.io.IOException;
import sockets.Cliente;
/**
 *
 * @author Adrián García
 */
//Clase principal que hará uso del cliente
public class MainCliente {
    public static void main(String[] args) throws IOException
    {
        Cliente solicitud = new Cliente(); //Se crea el cliente

        System.out.println("Iniciando cliente\n");
        solicitud.startClient(); //Se inicia el cliente
    }
}
