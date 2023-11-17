package core;

public class Juego {
    private Cola miCola;
    private Pizarra miPizarra;
    private boolean enJuego;
    public Juego(Cola cola){
        this.miCola = cola;
        this.miPizarra = new Pizarra("");
        this.enJuego = false;
    }
    public void empiezaElJuego() {
        if((miCola.tamañoDeCola() >= 5) && (miPizarra.estaEnJuego() == false)){
            miPizarra.recibeNiños(miCola);
            aJugar();
            setEnJuego(true);
            System.out.println("El juego ha empezado");
        }else if(enJuego == true) {
            System.out.println("El juego continua");
            aJugar();
        } else {
            System.out.println("El juego no ha empezado");
        }

    }
    private void aJugar() {
        miPizarra.borrarPizarra();
        Niños niño;
        String palabra;
        niño = miCola.removeNiño();
        niño.setPizarrin("Caminante");
        niño.errorDeEscucha();
        palabra = niño.getPizarrin();

        if(miCola.tieneNiños() ==  true){
            Niños siguienteNiño = miCola.getPrimerNiño();
            siguienteNiño.setPizarrin(palabra);
            System.out.println("Niños por jugar " + miCola.tamañoDeCola());
        } else{
            System.out.println("Se ha acabado el juego. La palabra final ha sido: " + palabra);
            miPizarra.setPalabra(palabra);
            miPizarra.terminaJuego();
            setEnJuego(false);
        }
    }
    public boolean estaEnJuego() {
        return enJuego;
    }
    public void setEnJuego(boolean enJuego) {
        this.enJuego = enJuego;
    }

    public void setMiCola(Cola miCola) {
        this.miCola = miCola;
    }


    private String palabraAleatoria() {
    String[] nombres = { "colorín", "arroz", "comida", "clases", "trabajo", "nariz" };
        return nombres[(int) (Math.random() * nombres.length)];
    }
}
