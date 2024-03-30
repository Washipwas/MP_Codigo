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
    }

    private String numeroDeRegistro;
    private PersonajeUser personajeUser;
    private boolean bloqueado;
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
        return this.personajeUser.getPersonaje();
    }

    @Override
    public boolean getPersonajeNull() {
        return this.personajeUser == null;
    }

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
    public void setArma(Arma arma) {
        this.personajeUser.setArma(arma);
    }
}