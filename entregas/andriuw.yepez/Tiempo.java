public class Tiempo {
    private int hora;
    private int minuto;
    public Tiempo(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }

    public int getHora(){
        return hora;
    }

    public int getMinuto(){
        return minuto;
    }

    public void subeTiempo(){
        if (minuto == 59) {
            minuto = 0;
            hora += 1;
        }
        if (hora == 24) {
            minuto = 0;
            hora = 0;
        }
        minuto += 1;
    }

    public boolean estaAbierto(int horaInicioJornada, int horaFinalJornada){
        if (this.getHora() >= horaInicioJornada && this.getHora() < horaFinalJornada){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("%d:%02d", hora, minuto);
    }
}