public class Main {
    public static void main(String[] args) {
        int classroomDuration = 120;

        Classroom classroom = new Classroom(classroomDuration);
        Simulation simulation = new Simulation(classroom);

        simulation.runSimulation();
    }
}