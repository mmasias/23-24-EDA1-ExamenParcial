public class Kid {

    int playTimer = 0;

    boolean playing = false;

    String message = "justiciero";

    public void play(){

        if (playTimer >= 5) {
            playing = false;
            message = "justiciero";
        }
    
        if (playing) {
            double rand = Math.random();
            if (rand < 0.33) {
                // Take a random letter from the message string and deform it to a random letter
                int index = (int) (Math.random() * message.length());
                char[] chars = message.toCharArray();
                chars[index] = (char) ('a' + Math.random() * ('z' - 'a' + 1));
                message = new String(chars);
                playTimer++;
            }
            else if (rand < 0.66) {
                // Take a random letter from the message string and deform it to a random letter
                int index = (int) (Math.random() * message.length());
                char[] chars = message.toCharArray();
                chars[index] = (char) ('a' + Math.random() * ('z' - 'a' + 1));
                message = new String(chars);
                playTimer++;
            }
            if (playTimer == 5) {
                System.out.println("Los niños han completado la cadena de mensajes!");
                System.out.println("El mensaje original era 'justiciero', y el mensaje final a sido '" + message + "'.");
            }
        }
        else {
            playTimer = 0;
        }
    }
}
