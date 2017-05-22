import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;


/**
 * Created by josgar on 17/05/2017.
 */
public class StreamsTest {



    @Test
    public void shouldReturnDoubled(){
        Map<Integer, String> map = new HashMap<>();
        map.putIfAbsent(1, "Nacho");
        map.put(2, "Marta");
        map.computeIfAbsent(3, x -> "Pero bueno");

        map.replaceAll((id, nombre) -> id + ":" + nombre);
    }

}
