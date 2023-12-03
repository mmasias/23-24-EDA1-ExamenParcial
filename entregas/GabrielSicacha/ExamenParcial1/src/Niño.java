public class Niño {
    private Pizarra pizarrin;

    private Niño next;

    public Niño() {
    }

    public void recibirPizarrin(Pizarra pizarrin) {
        this.pizarrin =  pizarrin;
    }

    public void escribirMensaje(String mensaje){
        pizarrin.setMensaje(mensaje);
        System.out.println();
    }

    public String mostrarPizarrin(){
        return  pizarrin.getMensaje();
    }

    public void limpiarPizarrin(){
        pizarrin.limpiar();
    }

    public Niño getNext() {
        return next;
    }

    public void setNext(Niño next) {
        this.next = next;
    }

    public void getFirst(){

    }
}
