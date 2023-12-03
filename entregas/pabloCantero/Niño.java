import java.util.Random;

public class Niño {
    private String nombre;
    private Pizarra pizarraPequeña;

    public Niño(String nombre) {
        this.nombre = nombre;
    }

    public void setPizarra(Pizarra unaPizarra) {
        pizarraPequeña = unaPizarra;
    }

    public String getNombre() {
        return nombre;
    }
    public void recibirMensaje(String mensaje) {
        pizarraPequeña.escribirMensaje(modificarMensaje(mensaje));
        System.out.println("[" + nombre + "] recibe [" + mensaje + "] y ha escrito [" + pizarraPequeña.leer() + "]");        
    }
    
    private String modificarMensaje(String mensaje){
        Random random = new Random();
        String alfabeto = "abcdefghijklmnopqrstuvwxyz";
        boolean letraCambiada= false;
        while(!letraCambiada){
           
             int posicion = random.nextInt(mensaje.length());
            char letra = mensaje.charAt(posicion);
            int posicionNueva = random.nextInt(alfabeto.length());
            char letraNueva = alfabeto.charAt(posicionNueva);
            if(letra != letraNueva){
                mensaje = mensaje.substring(0, posicion) + letraNueva + mensaje.substring(posicion + 1);
                letraCambiada = true;
            }
            
        }
        return mensaje;
    }
    
    
    public void borrarPizarraPequeña() {
        pizarraPequeña.borrar();
    }
    public String mostrarPizarraPequeña() {
        return pizarraPequeña.leer();
    }
}

