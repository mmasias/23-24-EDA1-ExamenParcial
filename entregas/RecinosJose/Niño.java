import java.util.Random;

public class niño {
    private String nombre;
    private String mensaje;

    public niño(String nombre) {
        this.nombre = nombre;
        this.mensaje = "";
    }

    public String getNombre() {
        return nombre;
    }

    public String getMensaje() {
        return mensaje;
    }

   public void recibirMensaje(String mensajeOriginal) {
       
        StringBuilder mensajeEscrito = new StringBuilder(mensajeOriginal);
        Random random = new Random();

        for (int i = 0; i < 2; i++) {  
            int indiceCambio = random.nextInt(10);
            char nuevaLetra = (char) ('A' + random.nextInt(26));
            mensajeEscrito.setCharAt(indiceCambio, nuevaLetra);
        }

        this.mensaje = mensajeEscrito.toString();
        System.out.println(nombre + " escribe en su pizarrín: " + mensaje);
    }public void correYEscribeEnPizarraSalon(String mensajeOriginal, pizarra pizarra) {
     
        System.out.println(nombre + " corre hacia la pizarra del salón y escribe lo que escribio en su pizarrin."+mensaje);
}
}

