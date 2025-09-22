package complexTask.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EntityManagerTest {
    private EntityManager<Student> manager;
    private Student s1;
    private Student s2;
    private Student s3;

    @BeforeEach
    void setUp() {
        manager = new EntityManager<>();
        s1 = new Student("Alice", 20, true);
        s2 = new Student("Bob", 25, false);
        s3 = new Student("Alice", 30, true);

        // Для тестов добавляем сущности
        manager.add(s1);
        manager.add(s2);
        manager.add(s3);
    }

    @Test
    void testAddEntities() {
        List<Student> all = manager.getAll();
        assertEquals(3, all.size()); // проверяем количество
        assertTrue(all.contains(s1)); // проверяем что добавлен
    }

    @Test
    void testRemoveEntity() {
        boolean removed = manager.remove(s2);
        assertTrue(removed); // успешно удалён
        assertFalse(manager.getAll().contains(s2)); // коллекция не содержит
    }

    @Test
    void testRemoveNonExistingEntity() {
        Student ghost = new Student("Ghost", 99, true);
        boolean removed = manager.remove(ghost);
        assertFalse(removed); // нечего удалять
    }

    @Test
    void testGetAllReturnsCopy() {
        List<Student> copy = manager.getAll();
        assertThrows(UnsupportedOperationException.class, () -> copy.add(new Student("X", 18, true)));
    }

    @Test
    void testFilterByAge() {
        List<Student> filtered = manager.filterByAge(18, 25);
        assertEquals(2, filtered.size()); // Alice(20) и Bob(25)
        assertTrue(filtered.contains(s1));
        assertTrue(filtered.contains(s2));
    }

    @Test
    void testFilterByName() {
        List<Student> filtered = manager.filterByName("Alice");
        assertEquals(2, filtered.size()); // Alice(20), Alice(30)
        assertTrue(filtered.contains(s1));
        assertTrue(filtered.contains(s3));
    }

    @Test
    void testFilterByActiveTrue() {
        List<Student> active = manager.filterByActive(true);
        assertEquals(2, active.size()); // Alice(20), Alice(30)
        assertTrue(active.contains(s1));
        assertTrue(active.contains(s3));
    }

    @Test
    void testFilterByActiveFalse() {
        List<Student> inactive = manager.filterByActive(false);
        assertEquals(1, inactive.size()); // только Bob
        assertTrue(inactive.contains(s2));
    }
}
