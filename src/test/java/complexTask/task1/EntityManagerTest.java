package complexTask.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тест кейсы:
 *
 * Добавление элементов:
 *  доб 1 элемент в пустой массив
 *  доб 1 элемент в не пустой массив
 *  доб 1 элемент неск потокам
 *
 */
public class EntityManagerTest {

    @Test
    public void addEntityTest(){
        EntityManager<Student> manager = new EntityManager<>();

        Entity entity = new Student("Коля", 17, true);



    }
}
