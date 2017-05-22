package com.lambdas.chap2;

import java.util.stream.Stream;

public interface Performance {

    String getName();

    Stream<Artist> getMusicians();

    Stream<Artist> getAllMusicians();
}