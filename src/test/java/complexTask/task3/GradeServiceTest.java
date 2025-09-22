package complexTask.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GradeServiceTest {

    /**
     * Добавление оценок:
     *  валдиная оценка
     *  не валидная оценка
     *  Расчет среднего:
     *   для 1 предмета с 1 оценкой
     *   для 1 предмета с несколькими оценками
     *   среднее с несколькими предметами и оценками
     */

    private GradeService<Integer> gradeService;

    @BeforeEach
    public void setUp() {
        gradeService = new GradeService<>();
    }

    @Test
    public void addGradeTest() {
        StudentGrade<Integer> grade = new StudentGrade<>("Ваня", "Русский", 2);
        gradeService.addGrade(grade);
        assertEquals(1, gradeService.getAllGrades().size());
    }

    @Test
    public void addGradeNegativeTest() throws InvalidGradeException {
        StudentGrade<Integer> negativeGrade = new StudentGrade<>("Ваня", "Русский", -1);
        assertThrows(InvalidGradeException.class, () -> gradeService.addGrade(negativeGrade));
    }

    @Test
    public void addSubjectAvgTest(){
        gradeService.addGrade(new StudentGrade<>("Ваня", "Русский", 5));
        gradeService.addGrade(new StudentGrade<>("Маша", "Русский", 3));
        gradeService.addGrade(new StudentGrade<>("Петя", "Русский", 4));
        gradeService.addGrade(new StudentGrade<>("Оля", "Математика", 4));
        gradeService.addGrade(new StudentGrade<>("Оля", "Математика", 3));
        gradeService.addGrade(new StudentGrade<>("Катя", "Физика", 3));
        assertEquals(4.0, gradeService.subjectAvg("Русский"));
        assertEquals(3.5, gradeService.subjectAvg("Математика"));
        assertEquals(3.0, gradeService.subjectAvg("Физика"));
    }
}
