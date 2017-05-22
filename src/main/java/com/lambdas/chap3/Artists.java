package com.lambdas.chap3;

import com.lambdas.chap2.Artist;

import java.util.List;
import java.util.Optional;

/**
 * Created by josgar on 22/05/2017.
 */
public class Artists {

    private List<Artist> artists;

    public Artists(List<Artist> artists) {
        this.artists = artists;
    }

    public Optional<Artist> getArtist(int index) {
        if (index < 0 || index >= artists.size()) {
            Optional.empty();
        }
        return Optional.of(artists.get(index));
    }

    public String getArtistName(int index) {
        return getArtist(index)
                .map(artist -> artist.getName())
                .orElse("unknown");
    }
}
