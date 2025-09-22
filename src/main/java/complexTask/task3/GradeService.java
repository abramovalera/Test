package complexTask.task3;

import java.util.ArrayList;
import java.util.List;

public class GradeService<T extends Number> {

    private List<StudentGrade<T>> grades = new ArrayList<>();


    //добавь эту оценку (studentGrade) в список grades, который хранит все оценки.
    public synchronized void addGrade(StudentGrade<T> studentGrade) throws InvalidGradeException {
        if (studentGrade.getCount().doubleValue() < 0) {
            throw new InvalidGradeException("Оценка не может быть отрицательной");
        }
        grades.add(studentGrade);
    }

    public double subjectAvg(String subject) {
        return grades.stream()
                .filter(g -> g.getSubject().equals(subject)) // фильтруем по предмету
                .mapToDouble(g -> g.getCount().doubleValue()) // превращаем оценку в double
                .average()
                .orElse(0.0); // если оценок нет, вернуть 0


    }

    public List<StudentGrade<T>> getAllGrades() {
        return new ArrayList<>(grades); // возвращаем копию для безопасности
    }
}
