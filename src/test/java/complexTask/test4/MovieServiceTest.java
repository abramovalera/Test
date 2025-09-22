package complexTask.test4;

import complexTask.task4.Movie;
import complexTask.task4.MovieService;
import complexTask.task4.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MovieServiceTest {

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

    /**
     * Проверка: добавление рейтинга Integer и Double → среднее должно считаться корректно
     */
    @Test
    void testAddAndAvgRating() {
        movieService.addRating(movie1, new Rating<>(8));
        movieService.addRating(movie1, new Rating<>(9.5));

        double avg = movieService.calculateAverageRating(movie1);

        assertEquals(8.75, avg, 0.001);
    }

    /**
     * Проверка: если у фильма нет оценок → возвращается 0.0
     */
    @Test
    void testAverageRatingWhenNoRatings() {
        double avg = movieService.calculateAverageRating(movie2);
        assertEquals(0.0, avg);
    }

    /**
     * Проверка: фильмы сортируются по убыванию среднего рейтинга
     */
    @Test
    void testMoviesSortedByRating() {
        movieService.addRating(movie1, new Rating<>(7));
        movieService.addRating(movie2, new Rating<>(9));
        movieService.addRating(movie3, new Rating<>(5));
        movieService.addRating(movie3, new Rating<>(6));

        List<Movie> sorted = movieService.getMoviesSortedByRating();

        assertEquals(movie2, sorted.get(0));
        assertEquals(movie1, sorted.get(1));
        assertEquals(movie3, sorted.get(2));
    }

    /**
     * Проверка: корректные значения рейтинга
     */
    @ParameterizedTest
    @ValueSource(doubles = {1, 5, 10, 7.5})
    void testValidRatings(double value) {
        Rating<Double> rating = new Rating<>(value);
        assertEquals(value, rating.doubleValue(), 0.001);
    }

    /**
     * Проверка: значения меньше 1 → исключение
     */
    @ParameterizedTest
    @ValueSource(doubles = {0, -5, -0.1})
    void testInvalidRatingsTooLow(double value) {
        assertThrows(IllegalArgumentException.class, () -> new Rating<>(value));
    }

    /**
     * Проверка: значения больше 10 → исключение
     */
    @ParameterizedTest
    @ValueSource(doubles = {10.1, 15, 100})
    void testInvalidRatingsTooHigh(double value) {
        assertThrows(IllegalArgumentException.class, () -> new Rating<>(value));
    }

    /**
     * Проверка: создание объекта Movie
     */
    @Test
    void testMovieCreation() {
        Movie movie = new Movie("Matrix", 136);

        assertEquals("Matrix", movie.getMovieName());
        assertEquals(136, movie.getMovieTime());
    }
}
