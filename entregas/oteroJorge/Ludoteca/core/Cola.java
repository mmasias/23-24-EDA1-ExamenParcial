package core;

import core.utils.List;

public class Cola {
    private List<Niño> niños;
    private int niñosEnCola;

    public Cola() {
        niños = new List<Niño>();
        niñosEnCola = 0;
    }

    public void addNiño(Niño niño) {
        niños.insert(niño, -1);
        niñosEnCola++;
    }

    public Niño removeNiño() {
        if (!niños.isEmpty()) {
            Niño saliente = niños.getFirst().getData();
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

    public List<Niño> getNiños() {
        return niños;
    }


    @Override
    public String toString() {
        return "Hay " + tamañoDeCola()
                + " niños en el aula";
    }
}
