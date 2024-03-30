import java.io.Serializable;

/**
 * 
 */
public abstract class HabilidadEspecial implements Serializable {

    /**
     * Default constructor
     *
     */
    public HabilidadEspecial(String nombre, int valorAtaque, int valorDefensa) {
        this.nombre = nombre;
        this.valorAtaque = valorAtaque;
        this.valorDefensa = valorDefensa;
    }

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private static int valorAtaque;

    /**
     * 
     */
    private int valorDefensa;

    public  int getValorAtaque() {
        return this.valorAtaque;
    }

    public int getValorDefensa() {
        return this.valorDefensa;
    }




}