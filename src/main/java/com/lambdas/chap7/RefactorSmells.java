package com.lambdas.chap7;

import com.lambdas.chap2.Album;
import com.lambdas.chap2.Track;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by josgar on 25/05/2017.
 */
public class RefactorSmells {

    private List<Album> albums;

    public RefactorSmells(List<Album> albums) {
        this.albums = albums;
    }

    public long countRunningTime() {
        return albums.stream()
                .flatMap(Album::getTracks)
                .mapToInt(Track::getLength)
                .sum();
    }

    public long countMusicians() {
        return albums.stream()
                .flatMap(Album::getMusicians)
                .count();
    }

    public long countTracks() {
        return  albums.stream()
                .flatMap(Album::getTracks)
                .count();
    }

    public long countFeature(Function function){
        return  albums.stream()
                .flatMap(function)
                .count();
    }
}
