package chap2;

import com.lambdas.chap2.Album;
import com.lambdas.chap2.Artist;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;


/**
 * Created by josgar on 17/05/2017.
 */
public class StreamsTest {

    private List<Artist> members;
    private List<Artist> artists;

    @Before
    public void setUp() throws Exception {

        members = Arrays.asList(new Artist("Peter", "Spanish"), new Artist("Marco", "Italian"),
                new Artist("John", "English"));
        artists = Arrays.asList(new Artist("Peter", members, "Spanish"), new Artist("Marco", members, "Italian"),
                new Artist("John", members, "English"));

    }

    @Test
    public void shouldReturnDoubled(){
        Map<Integer, String> map = new HashMap<>();
        map.putIfAbsent(1, "Nacho");
        map.put(2, "Marta");
        map.computeIfAbsent(3, x -> "Pero bueno");

        map.replaceAll((id, nombre) -> id + ":" + nombre);
    }


    @Test
    public void shouldAddNumbers() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(addUp(nums), 15);

    }

    @Test
    public void shouldReturnNamesAndOrigins(){
        List<Artist> artists = Arrays.asList(new Artist("Peter", members, "Spanish"), new Artist("Marco", members, "Italian"),
                new Artist("John", members, "English"));

        List<String> artistOrigins = getNameOrigin(artists);

        assertEquals(artistOrigins.size(), 3);

        assertEquals(artistOrigins.get(0), "Peter - Spanish");
        assertEquals(artistOrigins.get(1), "Marco - Italian");
        assertEquals(artistOrigins.get(2), "John - English");

    }

    @Test
    public void shouldReturnNumberOfMembers(){
        assertEquals(numberOfMembers(artists), 9);
    }

    @Test
    public void shouldCountNumberLowerCaseLetters(){
        assertEquals(countLowercase("ElPErroDeRamonESGrande"), 14);
    }


    @Test
    public void shouldReturnWordWithMostLowerCaseLetters(){
        assertEquals(mostLoweCases(Arrays.asList("EEE", "ELLkk", "elele")).get(), "elele");
        assertEquals(mostLoweCases(Arrays.asList("elele", "E")).get(), "elele");
    }

    public static int addUp(List<Integer> numbers){
        return numbers.stream()
                .reduce(0, (x , y) -> x + y);
    }

    public static List<String> getNameOrigin(List<Artist> artists) {
        return artists.stream()
                .map(artist -> artist.getName() + " - "+ artist.getNationality())
                .collect(Collectors.toList());
    }

    public static List<Album> atMost3Tracks(List<Album> albums){
        return albums.stream()
                .filter(album -> album.getTrackList().size() <= 3)
                .collect(Collectors.toList());
    }

    public static long numberOfMembers(List<Artist> artists){
        return artists.stream()
                .flatMap(Artist::getMembers)
                .count();
    }

    public static int countLowercase(String word) {
        return (int) word.chars()
                .filter(x -> Character.isLowerCase(x))
                .count();

    }

    public static Optional<String> mostLoweCases(List<String> words) {
        return words.stream()
                .max(Comparator.comparing(StreamsTest::countLowercase));
    }
}
