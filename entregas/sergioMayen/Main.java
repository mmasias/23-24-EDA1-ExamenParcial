import java.util.Random;
import java.util.Scanner;

public class Main {
    private static List childrenList = new List();
    private static List aishaList = new List();
    private static Scanner scanner = new Scanner(System.in);
    private static int hour = 0;

    public static void main(String[] args) {
        simulateDay();
    }

    private static void simulateDay() {
        while (hour <= 8) {
            printHour();
            printMargin();
            lidiaWaitAChild();
            printMargin();
            childrenList.printList();
            aishaStartGame();
            hour++;
        }
    }

    private static void lidiaWaitAChild() {
        int probability = childProbability(hour);
    
        if (probability > 0) {
            for (int i = 0; i < probability; i++) {
                String childName = lidiaGetChild();
                childrenList.insert(childName);
            }
    
            if (childrenList.hasMoreThanFiveChildren()) {
                System.out.println("¡Lidia tiene más de 5 niños!");
            }
        } else {
            System.out.println("No ha llegado un niño.");
        }
    }

    private static void transferChildrenToAisha() {
        int childrenToTransfer = 5;
        String[] transferredChildren = new String[childrenToTransfer];
    
        if (childrenList.size() >= childrenToTransfer) {
            for (int i = 0; i < childrenToTransfer; i++) {
                transferredChildren[i] = childrenList.listAll()[i];
            }
    
            for (String child : transferredChildren) {
                aishaReceiveChild(child);
            }
    
            for (int i = 0; i < childrenToTransfer; i++) {
                childrenList.delete();
            }
        }
    }
    
    private static void aishaReceiveChild(String childName) {
        System.out.println("Aisha los niños para poder jugar: " + childName);
    }

    private static int childProbability(int hour) {
        Random random = new Random();
        if (hour < 10) {
            int child = random.nextInt(3);
            System.out.println("Han llegado " + child + " niños");
            return child;
        } else if (hour < 30) {
            int child = (hour % 3 == 0) ? (random.nextDouble() < 0.5 ? random.nextInt(2) + 1 : 0) : 0;
            System.out.println("Han llegado " + child + " niños");
            return child;
        } else {
            return 0;
        }
    }

    private static boolean aishaStartGame() {
        boolean isGameStarted = false;
        
        if (childrenList.size() > 5) {
            transferChildrenToAisha();
            System.out.println("Ingrese la frase para jugar");
            String message = getInputUser();
    
            if (isValidMessage(message)) {
                for (String child : aishaList.listAll()) {
                    System.out.println(child + " Ecribio en su pizarra el siguiente mensaje : " + message);
                }
                
                passMessageAmongChildren();
                isGameStarted = true;
            }
        }
    
        while (isGameStarted) {
            lidiaWaitAChild();
            isGameStarted = aishaStartGame();
        }
        
        return isGameStarted;
    }
    
    

    private static void passMessageAmongChildren() {
        String[] children = aishaList.listAll();
    
        for (int i = 0; i < children.length - 1; i++) {
            String currentChild = children[i];
            String nextChild = children[i + 1];
    
            System.out.println(currentChild + " pasa el mensaje a " + getMessage());
            hour++;
        }
    
        String lastChild = children[children.length - 1];
        System.out.println(lastChild + " escribe el mensaje final.");
    }
    
    private static String getMessage() {
        System.out.println("El último niño escriba el mensaje que ha recibido:");
        return getInputUser();
    }

    private static boolean isValidMessage(String message) {
        return message.length() == 10;
    }
    
    
    private static String lidiaGetChild(){
        System.out.println("Ingrese el nombre del niño");
        return getInputUser();
    }

    private static String getInputUser() {
        while (!scanner.hasNextLine()) {
            System.out.println("Error. Ingrese una cadena válida:");
            scanner.next();
        }
        return scanner.nextLine();
    }

    private static void printHour(){
        System.out.println("Horas transcurridas " + hour);
    }

    private static void printMargin(){
        System.out.println("===".repeat(12));
    }
}