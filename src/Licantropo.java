/**
 * 
 */
public class Licantropo extends Personaje {

    private int rabia;
    private Don don;


    public Licantropo(String nombre, int salud, int poder, int rabia) {
        super(nombre, poder , salud);
        this.rabia = 10;
        don = new Don("Don",3, 1);
        crearDebilidades();
        crearFortalezas();

    }


    @Override
    public int sumarPotencialAtaque() {
        int valor = super.getPoder() + rabia + getValorAtaqueArmaActiva() + getValorAtaqueArmaduraActiva() + getFortalezaActiva().getValor();
        if (don.getRabia() < rabia){
            rabia -= don.getRabia();
            return valor + don.getValorAtaque();
        }
        else {
            return valor;
        }

    }

    @Override
    public int sumarPotencialDefensa() {
        int valor = super.getPoder() + rabia + getValorDefensaArmaActiva() + getValorDefensaArmaduraActiva() - getDebilidadActiva().getValor();
        if (don.getRabia() < rabia){
            rabia -= don.getRabia();
            return valor + don.getValorDefensa();
        }
        else {
            return valor;
        }

    }

    private void crearDebilidades(){
        Debilidad debilidad1 = new Debilidad("Agua Bendita", 3);
        getDebilidades().put(debilidad1.getNombre(), debilidad1);
        Debilidad debilidad2 = new Debilidad("Plata", 3);
        getDebilidades().put(debilidad2.getNombre(), debilidad2);

    }

    private void crearFortalezas(){
        Fortaleza fortaleza1 = new Fortaleza("Sentidos Agudizados", 2);
        getFortalezas().put(fortaleza1.getNombre(), fortaleza1);
        Fortaleza fortaleza2 = new Fortaleza("Fuerza Descontrolada", 4);
        getFortalezas().put(fortaleza2.getNombre(), fortaleza2);
    }



}