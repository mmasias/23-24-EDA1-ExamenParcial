package core;

import core.utils.List;

public class Cola {
    private List<Niños> niños;
    private int niñosEnCola;
    private int totalNiñosJugando; // Nueva variable para el seguimiento acumulativo

    public Cola() {
        niños = new List<Niños>();
        niñosEnCola = 0;
        totalNiñosJugando = 0;
    }

    public void addNiño(Niños niño) {
        niños.insert(niño, -1);
        niñosEnCola++;
        totalNiñosJugando++; // Incrementa el total acumulativo
    }

    public Niños removeNiño() {
        if (!niños.isEmpty()) {
            Niños saliente = niños.getFirst().getData();
            niños.remove(0);
            niñosEnCola--;
            return saliente;
        } else {
            return null;
        }
    }

    public boolean tieneNiños() {
        return !niños.isEmpty();
    }

    public int tamañoDeCola() {
        return niñosEnCola;
    }

    public int getTotalNiñosJugando() {
        return totalNiñosJugando;
    }

    public Niños getPrimerNiño() {
        return niños.getFirst().getData();
    }

    @Override
    public String toString() {
        return "Hay " + getTotalNiñosJugando()
                + " niños en el aula";
    }
}
