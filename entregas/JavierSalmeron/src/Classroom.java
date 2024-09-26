public class Classroom {
    private int timeLimit;
    private int timeNow;
    private List<Teacher> teachers;
    private List<Kid> kids;

    public Classroom(int timeLimit) {
        this.timeLimit = timeLimit;
        this.timeNow = 0;
        this.teachers = new List<>();
        this.kids = new List<>();
    }

    public boolean isClosed() {
        return (timeLimit - timeNow) <= 0;
    }

    public void timeAdvance() {
        timeNow++;
    }

    public int getTime() {
        return timeNow;
    }

    public void addTeacher(Teacher teacher) {
        teachers.insert(teacher, -1);
    }

    public void addKid(Kid kid) {
        kids.insert(kid, -1);
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Kid> getKids() {
        return kids;
    }
}
