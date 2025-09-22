package complexTask.task4;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class MovieService {

    private final Map<Movie, List<Rating<? extends Number>>> ratingsMap;

    public MovieService() {
        this.ratingsMap = new ConcurrentHashMap<>();
    }

    public <T extends Number> void addRating(Movie movie, Rating<T> rating) {
        ratingsMap.computeIfAbsent(movie, k -> new CopyOnWriteArrayList<>()).add(rating);
    }

    public double calculateAverageRating(Movie movie) {
        return ratingsMap.getOrDefault(movie, Collections.emptyList())
                .stream()
                .mapToDouble(Rating::doubleValue)
                .average()
                .orElse(0.0); // Если оценок нет, возвращаем 0.0
    }

    public List<Movie> getMoviesSortedByRating() {
        return ratingsMap.keySet().stream()
                .sorted((m1, m2) -> Double.compare(
                        calculateAverageRating(m2),
                        calculateAverageRating(m1)
                ))
                .collect(Collectors.toList());
    }
}
