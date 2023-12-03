package entregas.mejoraClase;

public class Niño {
    private String nombre;

    public Niño(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void recibirMensaje(Pizarra pizarra) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String mensaje = pizarra.deformarMensaje(pizarra.getMensaje());
        System.out.println("Niño " + nombre + " recibe mensaje: " + mensaje);
    }
}
