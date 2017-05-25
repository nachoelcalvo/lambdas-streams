package com.lambdas.chap7;

import com.lambdas.chap2.SampleData;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by josgar on 25/05/2017.
 */
public class RefactorSmellsTest {

    @Test
    public void shouldCountRunningTime() throws Exception {

        RefactorSmells refactorSmells = new RefactorSmells(Arrays.asList(SampleData.aLoveSupreme,
                SampleData.manyTrackAlbum,
                SampleData.sampleShortAlbum));

        assertEquals(refactorSmells.countMusicians(), 3L);
        assertEquals(refactorSmells.countRunningTime(), 1089L);
        assertEquals(refactorSmells.countTracks(), 8L);
    }

    @Test
    public void shouldPrintIntermediateSteps() throws Exception {
        List<String> versions = new ArrayList<>();
        versions.add("Lollipop");
        versions.add("KitKat");
        versions.add("Jelly Bean");
        versions.add("Ice Cream Sandwidch");
        versions.add("Ice Cubs with Jelly");
        versions.add("Honeycomb");
        versions.add("Gingerbread");

        // filtering all vaersion which are longer than 7 characters
        Set<String> words = versions.stream()
                .filter(s -> s.length() > 7)
                .filter(s -> s.startsWith("I"))
                .peek(s -> System.out.println("After second filter: " + s))
                .collect(Collectors.toSet());

        assertEquals(words.size(), 2);
    }
}