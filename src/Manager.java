import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Manager implements Serializable {

    public Manager(String fichero) {
        this.terminal = new TextTerminal();
        this.listaUsuarios = new HashMap<>();
        this.listaPersonajes = new HashMap<>();
        this.listaCombates = new HashMap<>();
        this.listaArmas = new HashMap<>();
        this.listaArmaduras = new HashMap<>();
        this.Ranking= new String[10];
        aniadirPersonajes();
    }

    private void aniadirPersonajes() {
        Vampiro vamp = new Vampiro("Vampiro 1",1,2,3,30000);
        aniadir(vamp,UtilConstants.FILE_PERSONAJES);
        vamp = new Vampiro("Vampiro 2",3,4,2,2311);
        aniadir(vamp,UtilConstants.FILE_PERSONAJES);
        Licantropo lic = new Licantropo("Licantropo 1",4,1,4);
        aniadir(lic,UtilConstants.FILE_PERSONAJES);
        lic = new Licantropo("Licantropo 2",2,3,3);
        aniadir(lic,UtilConstants.FILE_PERSONAJES);
        Cazador caz = new Cazador("Cazador 1",1,2);
        aniadir(caz,UtilConstants.FILE_PERSONAJES);
        caz = new Cazador("Cazador 2",2,3);
        aniadir(caz,UtilConstants.FILE_PERSONAJES);

        Arma arma1 = new Arma("Pump", 1,1, 3, 0);
        aniadir(arma1,UtilConstants.FILE_ARMAS);
        Arma arma2 = new Arma("Catana",2,2, 2, 0);
        aniadir(arma2,UtilConstants.FILE_ARMAS);
        Arma arma3 = new Arma("Cañon de mano", 3, 1, 2, 0);
        aniadir(arma3,UtilConstants.FILE_ARMAS);
        Arma arma4 = new Arma("Lanza Cohetes", 1,2, 3, 1);
        aniadir(arma4,UtilConstants.FILE_ARMAS);
        guardar();

        Armadura armadura1 = new Armadura("Armadura de papel",2,0, 1);
        aniadir(armadura1,UtilConstants.FILE_ARMADURAS);
        Armadura armadura2 = new Armadura("Armadura de dioses",1, 1, 3);
        aniadir(armadura2,UtilConstants.FILE_ARMADURAS);
        Armadura armadura3 = new Armadura("Armadura ardiente", 1,3, 1);
        aniadir(armadura3,UtilConstants.FILE_ARMADURAS);
        Armadura armadura4 = new Armadura("Armadura siniestra",3, 2, 2);
        aniadir(armadura4,UtilConstants.FILE_ARMADURAS);
    }

    //como he leido la info del fichero pues entonces los aributos ya tienen la información correspondiente
    private Map<String,Personaje> listaPersonajes;
    private String[] Ranking; //ver la manera en la que metamos la
    private Map<String,Usuario> listaUsuarios;
    private Map<String,Combate> listaCombates;
    private Map<String,Arma> listaArmas;
    private Map<String,Armadura> listaArmaduras;
    private transient TextTerminal terminal;

    public void aniadir(Object object, String fichero){
        if (object instanceof Usuario) {
            listaUsuarios.put(((Usuario) object).getNick(), (Usuario) object);
        } else if (object instanceof Personaje){
            listaPersonajes.put(((Personaje) object).getNombre(), (Personaje) object);
        } else if (object instanceof Combate){
            listaCombates.put(((Combate) object).getId(), (Combate) object);
        } else if (object instanceof Arma) {
            listaArmas.put(((Arma) object).getId(), (Arma) object);
        } else if (object instanceof Armadura) {
            listaArmaduras.put(((Armadura) object).getId(), (Armadura) object);
        }
        try (ObjectOutputStream objetoSalida = new ObjectOutputStream(new FileOutputStream(fichero + "usuarios.ser"))) {
            objetoSalida.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void guardar() {
        try (ObjectOutputStream objetoSalida = new ObjectOutputStream(new FileOutputStream(UtilConstants.FILE_USERS + "usuarios.ser"))) {
            objetoSalida.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(Object obj,String fichero) {
        if (obj instanceof Usuario){
            listaUsuarios.remove(((Usuario) obj).getNick());
        } else if (obj instanceof Personaje){
            listaPersonajes.remove(((Personaje) obj).getNombre());
        } else if (obj instanceof Combate){
            listaCombates.remove(((Combate) obj).getId());
        }  else if (obj instanceof Arma){
            listaArmas.remove(((Arma) obj).getId());
        } else if (obj instanceof Armadura){
            listaArmaduras.remove(((Armadura) obj).getId());
        }
        try (ObjectOutputStream objetoSalida = new ObjectOutputStream(new FileOutputStream(fichero + "usuarios.ser"))) {
            objetoSalida.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean existe(String id, int num) {
        if (num == 1){
            return this.listaUsuarios.containsKey(id);
        } else if (num == 2){
            return this.listaPersonajes.containsKey(id);
        } else if (num == 3){
            return this.listaCombates.containsKey(id);
        } else if (num == 4){
            return this.listaArmas.containsKey(id);
        } else if (num == 5) {
            return this.listaArmaduras.containsKey(id);
        } else return false;
    }

    public void mostrar(int num) {
        if (num == 1) {
            for (Map.Entry<String, Usuario> entry : listaUsuarios.entrySet()) {
                String key = entry.getKey();
                terminal.show("Clave: " + key);
            }
        } else if (num == 2) {
            for (Map.Entry<String, Personaje> entry : listaPersonajes.entrySet()) {
                String key = entry.getKey();
                Personaje personaje = listaPersonajes.get(key);
                if (personaje instanceof Vampiro){
                    terminal.show(UtilConstants.ANSI_RED + "Clase: Vampiro" + UtilConstants.ANSI_RESET);
                } else if (personaje instanceof Licantropo) {
                    terminal.show(UtilConstants.ANSI_BLUE + "Clase: Licántropo" + UtilConstants.ANSI_RESET);
                }  else if (personaje instanceof Cazador) {
                    terminal.show(UtilConstants.ANSI_GREEN + "Clase: Cazador" + UtilConstants.ANSI_RESET);
                }
                personaje.mostrarAtributos();
                if (personaje instanceof Vampiro){
                    ((Vampiro) personaje).mostrarAtributosExtras();
                } else if (personaje instanceof Licantropo) {
                    ((Licantropo) personaje).mostrarAtributosExtras();
                } else{
                    terminal.show("");
                }
            }
        } else if (num == 3) {
            for (Map.Entry<String, Combate> entry : listaCombates.entrySet()) {
                String key = entry.getKey();
                terminal.show("Clave: " + key);
            }
        } else if (num == 4) {
            for (Map.Entry<String, Arma> entry : listaArmas.entrySet()) {
                String key = entry.getKey();
                terminal.show("Nombre: " + key);
                Arma arma = listaArmas.get(key);
                terminal.show(String.valueOf(arma.getManos()));
            }
        } else if (num == 5) {
            for (Map.Entry<String, Armadura> entry : listaArmaduras.entrySet()) {
                String key = entry.getKey();
                terminal.show("Clave: " + key);
            }
        }
    }

    public void mostrarUsuariosBloqueados() {
        terminal.show("Usuarios Bloqueados:");
        for (Map.Entry<String, Usuario> entry : listaUsuarios.entrySet()) {
            Usuario user = entry.getValue();
            if (user instanceof UsuarioEstandar){
                if (((UsuarioEstandar) user).getBloqueado()){
                    terminal.show(user.getNick());
                }
            }
        }
    }

    public void mostrarUsuariosNoNormas() {
        terminal.show("Usuarios:");
        for (Map.Entry<String, Usuario> entry : listaUsuarios.entrySet()) {
            Usuario user = entry.getValue();
            if (user instanceof UsuarioEstandar){
                terminal.show(user.getNick());
            }
        }
    }

    public boolean datosCorrectos(String nick, String password) {
        Usuario user = listaUsuarios.get(nick); //se asocia a la clase "user" el elemento dentro de la lista de usuarios que tenga el mismo nick
        return (password.equalsIgnoreCase(user.getPassword())); //compara las dos cadenas de texto, la que se le pasa y aquella que está guardada en la clase "user"
        //retorna un verdadero o falso dependiendo de la comparativa
    }

    public Usuario asociarUsuario(String nick) { //busca en su lista de ususarios aquel que tenga el mismo nick y posteriormente se le retorna ese objeto de tipo usuario
        return listaUsuarios.get(nick);
    }

    public Personaje asociarPersonaje(String nick) {
        return listaPersonajes.get(nick);
    }

    public boolean datosUsuarioEstandar(String nick) {
        Usuario user = listaUsuarios.get(nick);
        return user instanceof UsuarioEstandar;
    }

    public void bloquear_desbloquear(String nick,boolean valor) {
        Usuario user = listaUsuarios.get(nick);
        if (user instanceof UsuarioEstandar){
            ((UsuarioEstandar) user).setBloqueado(valor);
            terminal.show("Usuario bloqueado con éxito");
            try (ObjectOutputStream objetoSalida = new ObjectOutputStream(new FileOutputStream(UtilConstants.FILE_USERS + "usuarios.ser"))) {
                objetoSalida.writeObject(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            terminal.show("El nick no pertenece a un usuario");
        }
    }

    public void setTerminal() {
        this.terminal = new TextTerminal();
    }


    public void mostrarUsuariosParaDesafiar(String nick) {
        terminal.show("Usuarios para desafiar:");
        for (Map.Entry<String, Usuario> entry : listaUsuarios.entrySet()) {
            Usuario user = entry.getValue();
            if (user instanceof UsuarioEstandar){
                if (!(((UsuarioEstandar) user).getBloqueado())){
                    if (user.getNick() != nick) {
                        terminal.show(user.getNick());
                    }
                }
            }
        }
    }

    public boolean existeDesafiar(String opcion) {
        Boolean encontrado = false;
        for (Map.Entry<String, Usuario> entry : listaUsuarios.entrySet()) {
            Usuario user = entry.getValue();
            if (user instanceof UsuarioEstandar){
                if (!(((UsuarioEstandar) user).getBloqueado())){
                    if (user.getNick().equalsIgnoreCase(opcion)) {
                        encontrado = true;
                    }
                }
            }
        }
        return encontrado;
    }

    public void asociarDesafio(String opcion) {
        Combate combate = this.listaCombates.get(opcion);
        combate.asociarDesafio();
    }

    public void mostarRanking(){
        terminal.show("Los mejores jugadores son:");
        for(int i =0; i<Ranking.length;i++){
            terminal.show(i+1+".-"+" "+this.Ranking[i]);
        }
    }

    public void mostrarRegistro(String usuario){
           for(Map.Entry<String,Combate>entrada:listaCombates.entrySet()){ //va a recorrer el mapa entero sacando el combate y viendo si el usuario está dentro de este
               Combate combate=entrada.getValue();
               UsuarioEstandar usuario1= combate.getPersonaje1();
               UsuarioEstandar usuario2=combate.getPersonaje2();
               if (usuario.equals(usuario1.getNombre()) && usuario.equals(combate.getGanador())){
                   terminal.show("El jugador: "+usuario+" ha combatido con "+usuario2.getNombre()+" en el que se apostó "+combate.getOroApostado()+" y salió vencedor");
               }
               else if (usuario.equals(usuario2.getNombre()) && usuario.equals(combate.getGanador())) {
                   terminal.show("El jugador: "+usuario+" ha combatido con "+usuario1.getNombre()+" en el que se apostó "+combate.getOroApostado()+" y salió vencedor");
               }
           }

    }

    public Object getObject(String nombre, int num) {
        if (num == 1){
            return this.listaUsuarios.get(nombre);
        } else if (num == 2){
            return this.listaPersonajes.get(nombre);
        } else if (num == 3){
            return this.listaCombates.get(nombre);
        } else if (num == 4){
            return this.listaArmas.get(nombre);
        } else if (num == 5) {
            return this.listaArmaduras.get(nombre);
        }
        return null;
    }

    public void mostrarEquipo(int num) {
        for (Map.Entry<String, Arma> entry : listaArmas.entrySet()) {
            String key = entry.getKey();
            Arma arma = listaArmas.get(key);
            if (arma.getNum() == num) {
                System.out.print( "* ");
                System.out.print("Nombre: " + key + "    ");
                System.out.print("Manos: " + String.valueOf(arma.getManos()) + "    ");
                System.out.print("Modificador de Ataque: " + arma.getModificadorDeAtaque() + "    ");
                System.out.println("Modificador de Defensa: " + arma.getModificadorDeDefensa());
            }
        }
    }

    public boolean existeEquipo(String opcion, int num) {
        if (listaArmas.containsKey(opcion)){
            Arma arma = listaArmas.get(opcion);
            if (arma.getNum() == num){
                return true;
            }
        }
        return false;
    }

    public int manosSuficientes(String opcion) {
        if (existe(opcion,4)){
            Arma arma = listaArmas.get(opcion);
            return arma.getManos();
        }
        return 0;
    }

    public void mostrarEquipoArmadura(int num) {
        for (Map.Entry<String, Armadura> entry : listaArmaduras.entrySet()) {
            String key = entry.getKey();
            Armadura armadura = listaArmaduras.get(key);
            if (armadura.getNum() == num) {
                System.out.print( "* ");
                System.out.print("Nombre: " + key + "    ");
                System.out.print("Modificador de Ataque: " + armadura.getModificadorDeAtaque() + "    ");
                System.out.println("Modificador de Defensa: " + armadura.getModificadorDeDefensa());
            }
        }
    }

    public boolean existeEquipoArmadura(String opcion, int num) {
        if (listaArmaduras.containsKey(opcion)){
            Armadura armadura = listaArmaduras.get(opcion);
            if (armadura.getNum() == num){
                return true;
            }
        }
        return false;
    }
}