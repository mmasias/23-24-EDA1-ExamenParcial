import java.util.ArrayList;
import java.util.List;

public class Ludoteca {
    double probabilidadLlegada;
    double Minuto = 1.0 / 60.0;
    double HoraAbrir, HoraCerrar;
    boolean Abierto;
    double hora;

    Ludoteca() {
        HoraAbrir = 0.0;
        HoraCerrar = 2.0;
        hora = HoraAbrir;
        Abierto = hora <= HoraCerrar;
    }

    public void Recibe() {
        Lidia lidia = new Lidia();
        Aisha aisha = new Aisha();
        List<Nino> fila = new ArrayList<>();

        System.out.println("Se abre la ludoteca.");
        while (Abierto) {
            System.out.println("Hora: " + hora);
            if (hora <= (1.0 / 6.0)) {
                probabilidadLlegada = 1;
            } else if (hora > (1.0 / 6.0) && hora < (2.0 / 6.0)) {
                probabilidadLlegada = 0.5;
            } else if (hora > 2.0 / 6.0) {
                probabilidadLlegada = 0;
            }

            boolean lleganNinos = Math.random() < probabilidadLlegada;
            if (lleganNinos && hora <= (1.0 / 6.0)) {
                int numeroNinosLlegan = (int) (Math.random() * 2) + 1;
                for (int i = 0; i < numeroNinosLlegan; i++) {
                    fila.add(new Nino(nombresNinos()));
                    System.out.println("Llega el niño " + fila.get(fila.size() - 1).getNombre());
                }
            } else if (lleganNinos && (hora > (1.0 / 6.0) && hora < (2.0 / 6.0))) {
                if (hora % (3.0 / 6.0) == 0) {
                    fila.add(new Nino(nombresNinos()));
                    System.out.println("Llega el niño " + fila.get(fila.size() - 1).getNombre());
                }
            } else if (hora > (2.0 / 6.0)) {
                System.out.println("No llegan más niños.");
            }

            hora += Minuto;
            Abierto = hora <= HoraCerrar;

            if (Abierto && fila.size() >= 5) {
                List<Nino> ninosEnJuego = new ArrayList<>(fila.subList(0, 5));
                aisha.jugar(ninosEnJuego);
                fila.removeAll(ninosEnJuego);
            }
        }
        System.out.println("Se cierra la ludoteca.");
    }

    private String nombresNinos() {
        String[] nombres = {"Zarco Aldunate", "Electra Natchios", "Orion Pax", "Magnus Robot Fighter", "Indiana Solo",
                "Carmen Sandiego", "Mario Bros", "Lara Craft", "Tyrion Spacewalker", "Leia Organa", "Apollo Creed",
                "Han Skywalker", "Marty McFly", "Ellen Ripley", "Sarah Connor", "Tony Stark", "Bruce Wayne",
                "Clark Kent", "Peter Parker", "Logan Howlett", "Natasha Romanoff", "Scott Summers", "Jean Grey",
                "Charles Xavier", "Bruce Banner", "Diana Prince", "Arthur Curry", "Barry Allen", "Hal Jordan",
                "Billy Batson", "Stephen Strange", "Wade Wilson", "Matt Murdock", "Jessica Jones", "Luke Cage",
                "Danny Rand", "Frank Castle", "Reed Richards", "Sue Storm", "Johnny Storm", "Ben Grimm",
                "Victor Von Doom", "Groot Rocket", "Gamora Zen", "Drax Destroyer", "Poe Dameron", "Finn Trooper",
                "Rey Skywalker", "Kylo Ren", "Shuri Panther", "Zelda Windrunner", "Max Power", "Indiana Stones",
                "Cosmo Quantum", "Aria Stardust", "Neo Matrix", "Katniss Evergreen", "Sherlock Combs", "Loki Mischief",
                "Dante Inferno", "Vito Corleone", "Anakin Skydancer", "Bruce Vain", "Ellie Sattler", "Korben Dallas",
                "Selina Moon", "Ripley Alien", "Tony Clank", "Peter Parquagh", "Logan Wolverine", "Selene Underworld",
                "Arthur King", "Merlin Wizard", "Gandalf White", "Frodo Baggins", "Aragorn Ranger", "Legolas Greenleaf",
                "Gimli SonofGloin", "Bilbo Baggins", "Sauron Darklord", "Eowyn Shieldmaiden", "Galadriel Lothlorien",
                "Pippin Took", "Merry Brandybuck", "Samwise Gamgee", "Arwen Evenstar", "Boromir Gondor",
                "Faramir Ithilien", "Elrond Halfelven", "Tauriel Woodland", "Thranduil King", "Bard Bowman",
                "Dwalin Dwarf", "Balin Dwarf", "Kili Dwarf", "Fili Dwarf", "Dori Dwarf", "Nori Dwarf", "Ori Dwarf",
                "Bifur Dwarf", "Bofur Dwarf", "Bombur Dwarf", "Thorin Oakenshield", "Azog Defiler", "Bolg SonofAzog",
                "Smaug Dragon", "Tauron Bull", "Celeborn Silver", "Haldir Lórien", "Lurtz Uruk", "Grishnákh Orc",
                "Gollum Precious", "Saruman White", "Radagast Brown", "Gothmog Lieutenant", "Gil-galad Elvenking",
                "Elendil Highking", "Isildur Heir", "Anárion Sunlord", "Círdan Shipwright", "Eärnur Lastking",
                "Ecthelion Lord", "Feanor Spiritoffire", "Fingolfin Highking", "Finrod Faithful", "Glorfindel Golden",
                "Maedhros Tall", "Maglor Singer", "Celebrimbor Silverhand", "Théoden King", "Théodred Prince",
                "Éomer Marshal", "Éowyn Lady", "Gríma Wormtongue", "Háma Guard", "Ioreth Healer", "Imrahil Prince",
                "Denethor Steward", "Beregond Guard", "Damrod Ranger"};
                return nombres[(int) (Math.random() * nombres.length)];
    }

    public static void main(String[] args) {
        new Ludoteca().Recibe();
    }
}
