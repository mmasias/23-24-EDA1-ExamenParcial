public class Monitoras {
private String nombre;
private boolean estaJugando;
private Fila niñosASuCuidado;
private Niño niñoEnTurno;

    public Monitoras(String nombre) {
        this.nombre = nombre;
        this.estaJugando = false;
        this.niñosASuCuidado = new Fila();
    }

    public void recibirNiño(){
        niñosASuCuidado.añadirNiño(new Niño());
    }

    private void darPizarrin(Niño niño, Pizarra pizarrin){
        niño.recibirPizarrin(pizarrin);
    }

    public void pasarNiño(Monitoras monitorReceptor){
        while(niñosASuCuidado.getSize()>0)
        System.out.println(" > " + this.nombre + " entrega un niño a " + monitorReceptor.nombre);
        niñosASuCuidado.removerNiño();
        monitorReceptor.recibirNiño();
    }

    public boolean puedeJugar(){
        return niñosASuCuidado.getSize() >=5;
    }

    public boolean estaJugando() {
        return estaJugando;
    }

    public void setEstaJugando(boolean estaJugando) {
        this.estaJugando = estaJugando;
    }

    public void juego(){
        if (!estaJugando) {
            estaJugando = true;
            limpiarPizarrines();
            niñoEnTurno = niñosASuCuidado.getFirst();
            niñoEnTurno.escribirMensaje("ABCDEFGHIJKLM");
        } else {
            Niño i = niñosASuCuidado.getFirst();
            while (i != niñoEnTurno) {
                i = i.getNext();
            }
            if(i.getNext()==null){
                estaJugando = false;
                niñoEnTurno = niñosASuCuidado.getFirst();
            } else {
                Niño niñoActual = i;
                Niño niñoSiguiente = i.getNext();
                niñoSiguiente.escribirMensaje(niñoActual.mostrarPizarrin());
                niñoEnTurno = i.getNext();
            }
        }
    }

    private void limpiarPizarrines(){
        Niño i = niñosASuCuidado.getFirst();
        while(i != null) {
            i.limpiarPizarrin();
            i = i.getNext();
        }
    }

    public boolean tieneNiños(){
        if(niñosASuCuidado.getSize()!=0){
            return true;
        } else {
            return false;
        }
    }
}
