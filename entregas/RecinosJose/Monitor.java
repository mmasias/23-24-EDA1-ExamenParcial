import java.util.Random;

class Monitor {
    private String nombre;
    private Cola colaNiños;
    private boolean estaJugando;
    Node<Niño> niñoTurno;

    public Monitor(String nombre) {
        this.nombre = nombre;
        this.colaNiños = new Cola();
        estaJugando = false;
    }

    public void recibeNiño(Niño niño) {
        colaNiños.addNiño(niño);
    }

    public boolean tieneNiños() {
        return colaNiños.hayNiños();
    }

    public boolean puedeJugar() {
        return colaNiños.size() >= 5;
    }

    public boolean estaJugando() {
        return estaJugando;
    }

    public void mostrarListaNiños() {
        if (tieneNiños()) {
            System.out.print("> " + this.nombre + " ---> "); //Acá si Lydia no tiene ningun niño no aparece ningun mensaje 
            // como "> Lydia --->" esto sirve para que cuando ya no lleguen niños no se este mostrando Lydia y algo vacio
            //Perdon Masias , se que no te gustan comentarios jaja, pero debia especificar esto
            colaNiños.listaNiños();
            System.out.println();
        }
    }

    private void recibeNiño(Niño niño, Pizarra pizarrin) {
        niño.recibirPizarrin(pizarrin);
        colaNiños.addNiño(niño);
    }

    public void entregaNiños(Monitor otroMonitor) {
        while (colaNiños.hayNiños()) {
            System.out.println(" >  " + this.nombre + " ENTREGA NIÑO");
            Niño unNiño = colaNiños.removeNiño();
            otroMonitor.recibeNiño(unNiño, new Pizarra());
        }
    }

    public void jugar() {
        if (!estaJugando) {
            estaJugando = true;
            limpiarPizarrines();
            niñoTurno = colaNiños.getNiños().getFirst();
            niñoTurno.getData().recibirMensaje(generarMensajeAleatorio());
        } else {
            Node<Niño> niño = colaNiños.getNiños().getFirst();
            while (niño != niñoTurno) {
                niño = niño.getNext();
            }
            if (niño.getNext() == null) {
                estaJugando = false;
                niñoTurno = colaNiños.getNiños().getFirst();
            } else {
                Niño niñoActual = niño.getData();
                Niño siguienteNiño = niño.getNext().getData();
                siguienteNiño.recibirMensaje(niñoActual.mostrarMensaje());
                niñoTurno = niño.getNext();
            }
        }
    }
    private String generarMensajeAleatorio() {
        Random random = new Random();
        String word = generarPalabraAleatorio(random);

        while (word.length() <= 10) {
            word = generarPalabraAleatorio(random);
        }
    
        return word;
    }

    private String generarPalabraAleatorio(Random random) {
        String words[] = {"aberrantes", "maravillosa", "fantástico", "espléndido", "extraordinario", "sorprendente", "increíble", "fabuloso", "formidable", "asombroso",
                "excepcional", "impresionante", "incomparable", "indescriptible", "insólito", "espectacular", "deslumbrante", "deslumbrador", "inigualable",
                "inimaginable", "sofisticado", "especialísimo", "inconcebible", "asombroso", "desconcertante", "desconcertador", "estupendo", "inolvidable",
                "prodigioso", "excelente", "magnífico", "sensacional", "extrañamente", "asombroso", "formidable", "inolvidable", "sorprendentemente", "sensacional"};
        int randomIndex = random.nextInt(words.length);
        return words[randomIndex];
    }
    private void limpiarPizarrines() {
        Node<Niño> niño = colaNiños.getNiños().getFirst();
        while (niño != null) {
            niño.getData().limpiarPizarrin();
            niño = niño.getNext();
        }
    }
}
