import java.io.*;

/**
 * 
 */
public class UsuarioEstandar extends Usuario {


    public UsuarioEstandar(String nombre, String nick, String password) {
        super(nombre, nick, password);
        this.numeroDeRegistro = generarNumeroDeRegistro();
        this.bloqueado = false;
        this.personajeUser = null;
        this.desafiante = null;
        this.posiblebloqueado = false;
    }

    private String numeroDeRegistro;
    private PersonajeUser personajeUser;
    private boolean bloqueado;
    private boolean posiblebloqueado;
    private UsuarioEstandar desafiante;

    public String generarNumeroDeRegistro() {
        try {
            String filePath = UtilConstants.FILE_NUMREG;
            File archivo = new File(filePath);
            if (!archivo.exists()) {
                archivo.createNewFile();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                    String nuevaLinea = "-1 Z";
                    writer.write(nuevaLinea);
                }
            }
            String linea;
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                linea = reader.readLine();
            }

            if (linea != null) {
                String[] partes = linea.split(" ");
                int num = Integer.parseInt(partes[0]);
                String letra = partes[1];
                if (letra.equalsIgnoreCase("Z")) {
                    letra = "A";
                    num++;
                } else {
                    char siguienteLetra = (char) (letra.charAt(0) + 1);
                    letra = String.valueOf(siguienteLetra);
                }
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                    String nuevaLinea = num + " " + letra;
                    writer.write(nuevaLinea);
                    return (letra + num + num + letra + letra);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Object getArmaduraActiva() {
        return this.personajeUser.getArmaduraActiva();
    }
@Override
    public Object getArmaActiva() {
        return this.personajeUser.getArmaActiva();
    }

    public boolean getBloqueado(){
        return this.bloqueado;
    }

    public void setBloqueado(Boolean bool){
        this.bloqueado = bool;
    }

    @Override
    public void setPersonajeUser(Personaje personaje) {//deberia ser personaje, no PersonajeUser
        this.personajeUser.setPersonaje(personaje);
    }

    @Override
    public Personaje getPersonaje() {
        if (personajeUser == null){
            return null;
        }
        return this.personajeUser.getPersonaje();
    }

    @Override
    public void setDesafiante(Usuario usuarioActivo) {
        this.desafiante = (UsuarioEstandar) usuarioActivo;
    }

    @Override
    public Object getDesafiante() {
        return this.desafiante;
    }

    @Override
    public boolean oroValido(int dinero) {
        return this.personajeUser.oroSufiencte(dinero);
    }

    @Override
    public PersonajeUser getPersonajeUser() {
        return this.personajeUser;
    }

    @Override
    public void newPersonajeUser(Personaje personaje) {
        this.personajeUser = new PersonajeUser(personaje);
    }
    @Override
    public void setArmaIzq(Arma arma) {
        this.personajeUser.setArmaIzq(arma);
    }
    @Override
    public void setArmaDer(Arma arma) {
        this.personajeUser.setArmaDer(arma);
    }
    @Override
    public int getManosLibres() {
        return personajeUser.getManosLibres();
    }
    @Override
    public void mostrarArmas() {
        this.personajeUser.mostrarArmas();
    }
    @Override
    public boolean existeEquipo(String opcion) {
        return this.personajeUser.existeEquipo(opcion);
    }
    @Override
    public boolean existeEquipoArmadura(String opcion) {
        return this.personajeUser.existeEquipoArmadura(opcion);
    }
    @Override
    public int manosSuficientes(String opcion) {
        return this.personajeUser.manosSuficientes(opcion);
    }
    @Override
    public void mostrarTodasArmas() {
        this.personajeUser.mostrarTodasArmas();
    }
    @Override
    public void mostrarTodasArmaduras() {
        this.personajeUser.mostrarTodasArmaduras();
    }
    @Override
    public Object getArma(String opcion) {
        return this.personajeUser.getArma(opcion);
    }
    @Override
    public Object getArmadura(String opcion) {
        return this.personajeUser.getArmadura(opcion);
    }
    @Override
    public void mostrarArmadura() {
        this.personajeUser.mostrarArmadura();
    }
    @Override
    public void setBloqueado() {
        this.bloqueado = true;
    }
    @Override
    public boolean notieneArmadura() {
        return this.personajeUser.notieneArmadura();
    }
    @Override
    public void setArmadura(Armadura armadura) {
        this.personajeUser.setArmadura(armadura);
    }
    @Override
    public void setPosibleBloqueado(boolean b) {
        this.posiblebloqueado = b;
    }
    @Override
    public boolean getPosibleBloqueado() {
        return this.posiblebloqueado;
    }
}