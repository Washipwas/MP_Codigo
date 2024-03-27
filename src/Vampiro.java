/**
 * 
 */
public class Vampiro extends Personaje {


    public Vampiro(String nombre, int salud, int poder,int puntoSangre,int edad) {
        super(nombre,poder,salud);
        this.puntoSangre = puntoSangre;
        this.edad = edad;
    }


    public int sumarPotencialAtaque(Vampiro vampiro, HabilidadEspecial hab, int poder) {
        int potencial;
        int sangre = vampiro.getPuntoSangre();
        potencial = sangre + hab.getValorAtaque() + poder;
        if (sangre > 5){
            potencial+= 2;
        }
        return potencial;
    }

    public int getPuntoSangre() {
        return puntoSangre;
    }




    private int puntoSangre;
    private int edad;



}