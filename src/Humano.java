/**
 * 
 */
public class Humano extends Esbirro {

    /**
     * Default constructor
     */
    public Humano(String nombre, int vida, String valorLealtad) {
        super(nombre,vida);
        this.valorLealtad = valorLealtad;
    @Override
    protected void mostrarExtra() {
        System.out.println("Valor Lealtad: " + this.valorLealtad);

    }
    private String valorLealtad;

}