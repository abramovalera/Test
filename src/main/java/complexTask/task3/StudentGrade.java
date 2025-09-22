package complexTask.task3;

public class StudentGrade <T extends  Number> {

    private String nameStudent;
    private String subject;
    private T count;

    public StudentGrade(String nameStudent, String subject, T count) {
        this.nameStudent = nameStudent;
        this.subject = subject;
        this.count = count;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public String getSubject() {
        return subject;
    }

    public T getCount() {
        return count;
    }
}
