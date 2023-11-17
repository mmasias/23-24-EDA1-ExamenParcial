package entregas.joseRasilla;

import java.util.Random;

public class Monitor {
    
    
    //Recibe la llegada de niños
        //Si el reloj es menor de 10 mins
            //Entre 0 y 2 niños
        //Mayor que 10 y menor que 30
            //cada 3 mins
                //50% de que llegue un niño

    public static void main(String[] args) {
        Ludotec ludotec = new Ludotec();
        ludotec.openLudotec();
        do{
            if(ludotec.clock<=10){
                openDoor("early",ludotec);
            } else{
                openDoor("late",ludotec);
            }
            ludotec.passMinute();
        }while (ludotec.clock<30);
    }


    public static void openDoor(String shift, Ludotec ludotec){
        Random rd = new Random();
        double x = rd.nextDouble();
        switch (shift) {
            case "early":
                if (x<0.3) {
                    System.out.println("No new child arrives");
                }else if(x>=0.3||x<=0.6){
                    System.out.println("One new child arrives");
                    ludotec.newChild();
                }else if(x>0.6){System.out.println("Two new children");}
                break;
            case "late":
                if((ludotec.clock-10)%3 == 0){
                    System.out.println("Three mins passed");
                    if (x>0.5) {
                        System.out.println("Two new children arrive");
                        ludotec.newChild();
                        ludotec.newChild();
                    }
                }
                break;
            default:
                break;
        }
    }

}
