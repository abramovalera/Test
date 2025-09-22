package complexTask.test4;

import complexTask.task4.Movie;
import complexTask.task4.MovieService;
import complexTask.task4.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieServiceTest {
    /**
     * + рейтинг
     * среднее значение
     * среднее значение если 0.0
     * Сортировка по убыванию
     */

    private MovieService movieService;
    private Movie movie1;
    private Movie movie2;
    private Movie movie3;

    @BeforeEach
    void setUp() {
        movieService = new MovieService();
        movie1 = new Movie("Inception", 148);
        movie2 = new Movie("Interstellar", 169);
        movie3 = new Movie("Tenet", 150);
    }

    @Test
    public void testAddAvgRating() {
        movieService.addRating(movie1, new Rating<>(8));
        movieService.addRating(movie1, new Rating<>(9.5));

        double avg = movieService.calculateAverageRating(movie1);

        assertEquals(8.75, avg, 0.001, "Средний рейтинг рассчитан коррекно");
    }
}


