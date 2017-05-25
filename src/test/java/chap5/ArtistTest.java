package chap5;

import com.lambdas.chap2.Artist;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.Assert.assertEquals;

/**
 * Created by josgar on 25/05/2017.
 */
public class ArtistTest {

    private List<Artist> artists;
    HashMap<Integer, Long> cache;

    @Before
    public void setUp() throws Exception {

        artists = Arrays.asList(new Artist("Pete", "English"),
                new Artist("Pete", "Italian"),
                new Artist("John", "French"),
                new Artist("Anthony", "English"),
                new Artist("Richards", "Australian"),
                new Artist("Martin", "Belgian"));

        cache = new HashMap<>();
    }

    @Test
    public void shouldReturnArtistWithLongestName() throws Exception {

        List<String> names = Arrays.asList("John Lennon", "Paul McCartney",
                "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");

        String longestName = names.stream()
                .max(Comparator.comparing(String::length)).orElse("");

        assertEquals(longestName, "Stuart Sutcliffe");

        Optional<Artist> longestNameArtist = artists.stream()
                .max(Comparator.comparing(artist -> artist.getName().length()));

        assertEquals(longestNameArtist.get().getName(), "Richards");
    }

    @Test
    public void shouldReturnNumberOfAppearences() throws Exception {
        List<String> names = Arrays.asList("John", "Paul", "George", "John",
                "Paul", "John");

        Map<String, Long> counts = names.stream()
                .collect(groupingBy(Function.identity(), counting()));

    }

    @Test
    public void calculateFibonacci() throws Exception {
        cache.put(0, 0L);
        cache.put(1, 1L);

        calculateFibonacci(5);

        assertEquals(cache.get(5), Long.valueOf(5L));
    }

    private long calculateFibonacci(int position){
        return cache.computeIfAbsent(position, k -> calculateFibonacci(k-1) + calculateFibonacci(k-2));
    }
}
