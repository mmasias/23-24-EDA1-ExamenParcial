import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ludoteca {

	private Queue<Nino> colaDeNinos = new LinkedList<>();
	private Queue<Nino> colaDeEspera = new LinkedList<>();
	
	private static final int TIEMPO_TOTAL = 120; 
	
	private static String MENSAJE_INICIAL = "ABCDEFGHIJ"; 
	
	private static boolean partidaEnCurso = false;
	private static int partidasJugadas = 0;

	/**
	 * Implementa la gestion de la ludoteca, tanto la entrada y salida de niños como
	 * el transcurso de los juegos
	 */
	public void gestionLudoteca() {

		int tiempoTranscurrido = 0;
		
		while (tiempoTranscurrido < TIEMPO_TOTAL) {

			System.out.println("Tiempo: " + tiempoTranscurrido);
			System.out.println("Cola niños: " + colaDeNinos.size());
			System.out.println("Cola niños espera : " + colaDeEspera.size());
			System.out.println("Partida en curso: " +  partidaEnCurso);
			System.out.println("Número de partidas jugadas " + partidasJugadas);

			Nino nino = null;

			if (partidasJugadas > 0 && colaDeNinos.size() == 0 && colaDeEspera.size() > 0) {
				
				System.out.println("Se ha jugado una partida por lo menos y se vuelcan los de espera");
				
				colaDeNinos.addAll(colaDeEspera);
				colaDeEspera.clear();

			}

			// Entrada de 0-2 niños/min
			if (tiempoTranscurrido < 10) {

				int ninosNuevos = (int) (Math.random() * 3);
				System.out.println("Han entrado " + ninosNuevos + " a la ludoteca en int 0-10");
				
				for (int i = 0; i < ninosNuevos; i++) {

					nino = new Nino();
					nino.setPizarra(MENSAJE_INICIAL);

					if (partidaEnCurso== true && colaDeNinos.size() > 5) {
						
						System.out.println("Se añade a espera niño int 0-10");
						colaDeEspera.offer(nino);

					} else {
						
						System.out.println("Se añade niño int 0-10");
						colaDeNinos.offer(nino);
					}

				}

				// Entrada de 1 niño cada 3 min
			} else if (tiempoTranscurrido >= 10 && tiempoTranscurrido <= 30 && (tiempoTranscurrido % 3 == 0)) {

				if (Math.random() < 0.5) {
					
					System.out.println("Se añade niño int 10-30");
					nino = new Nino();
					nino.setPizarra(MENSAJE_INICIAL);

					if (partidaEnCurso== true) {
						
						System.out.println("Se añade a espera niño int 10-30");
						colaDeEspera.offer(nino);

					} else {
						colaDeNinos.offer(nino);
					}
				}
			}

			// Cola contiene más de 5 ñiños --> comienza el juego.
			if (colaDeNinos.size() > 5 && partidaEnCurso == false) {
				
				System.out.println("Se inicia una nueva partida");

				partidaEnCurso = true;
				comenzarJuego();

			}

			// Cola contiene más de 5 ñiños --> comienza el juego.
			if (partidaEnCurso == true) {
				
				System.out.println("Se continua con una partida en curso");

				comenzarJuego();
			}

			tiempoTranscurrido++;
			
			System.out.println("------------------------------------------------------");
		}
	}

	/**
	 * Permite al usuario introducir el contenido del mensaje inicial 
	 * que será utilizado durante la partida
	 * 
	 * @return
	 */
	public String solicitarMensajeInicial() {

		System.out.println("Introduzca el contenido del mensaje inicial: ");
		Scanner scanner = new Scanner(System.in);

		return scanner.nextLine();
	}

	/**
	 * Simula el turno de juego de un niño que participe en 
	 * una partida del juego.
	 */
	public void comenzarJuego() {

		if (colaDeNinos.size() == 0) {
			
			partidaEnCurso = false;
			partidasJugadas++;
			
		} else {
			Nino nino = colaDeNinos.poll();
			String mensaje = nino.getPizarra();

			// Un niño puede cambiar una o dos letras del mensaje

			int indice = (int) (Math.random() * mensaje.length());
			char letraAleatoria = (char) ('A' + Math.random() * ('Z' - 'A' + 1));

			mensaje = mensaje.substring(0, indice) + letraAleatoria + mensaje.substring(indice + 1);

			if (Math.random() < 0.5) {

				indice = (int) (Math.random() * mensaje.length());
				letraAleatoria = (char) ('A' + Math.random() * ('Z' - 'A' + 1));
				mensaje = mensaje.substring(0, indice) + letraAleatoria + mensaje.substring(indice + 1);
			}

			System.out.println("Mensaje final: " + mensaje);
		}



	}

	public static void main(String[] args) {

		Ludoteca ludoteca = new Ludoteca();
		MENSAJE_INICIAL = ludoteca.solicitarMensajeInicial();
		ludoteca.gestionLudoteca();

	}
}