package com.bsg5.chapter6;

public class ArtistNotFoundException extends RuntimeException {
    private static long serialVersionUID = 1462190646166272903L;

    public ArtistNotFoundException(String message) {
        super(message);
    }
}
