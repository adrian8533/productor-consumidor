package participantes;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrián García
 */
public class Fumador 
{
    private int ingrediente;// los ingredientes que tiene
    private String nombre;
    private boolean activo = false;// si se encuentra activo o no
    
    public Fumador(String strNom, int Elem)
    {
        this.setElemento(Elem);
        this.setNombre(strNom);
    }

    public boolean puedoFumar(int a, int b) 
    {        
        try 
        {
        	activo = false;            
            if ((a + b + ingrediente) == 3) //verifica si tiene los materiales para fumar
            {
                activo = true;
                Enrrollando();
                Fumando();                
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Fumador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return activo;
    }

    public void Enrrollando() throws InterruptedException { //simula que está enrrollando el cigarro
        System.out.println(this.getNombre() + "Enrrollando cigarrillo...");
        Thread.sleep(1 * 1000);
    }

    public void Fumando() throws InterruptedException { //el fumador comienza a fumar
        System.out.println("Empezando a fumar....");
        Thread.sleep(((int) (Math.random() * 10)) * 500);
        System.out.println("Termina de fumar...");
    }

    public int getElemento() 
    {
        return ingrediente;
    }

    public void setElemento(int ingrediente)
    {
        this.ingrediente = ingrediente;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public boolean isActivo()
    {
        return activo;
    }

    public void setActivo(boolean activo)
    {
        this.activo = activo;
    }
}