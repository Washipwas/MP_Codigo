import java.io.Serializable;

/**
 * 
 */
public abstract class Equipo implements Serializable {

    /**
     * Default constructor
     */


    public Equipo(String nombre, int equipoClase,int modificadorAtaque, int modificadorDefensa) {
        this.nombre = nombre;
        this.equipoClase = equipoClase;
        this.modificadorDeAtaque =  modificadorAtaque;
        this.modificadorDeDefensa =  modificadorDefensa;
    }

    private String nombre;
    private int equipoClase;


    public int getModificadorDeAtaque() {
        return modificadorDeAtaque;
    }

    public int getModificadorDeDefensa() {
        return modificadorDeDefensa;
    }

    private int modificadorDeAtaque;


    private int modificadorDeDefensa;



    public int generarPotencialDefensa() {
        return this.modificadorDeDefensa;
    }

    public String getId() {
        return this.nombre;
    }

    public int getNum() {
        return this.equipoClase;
    }

    protected void setId(String nombre) {
        this.nombre = nombre;
    }

    protected void setModificadorDeAtaque(int valor) {
        this.modificadorDeAtaque = valor;
    }

    protected void setModificadorDeDefensa(int valor) {
        this.modificadorDeDefensa = valor;
    }
}