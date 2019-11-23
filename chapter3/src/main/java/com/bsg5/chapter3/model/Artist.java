package com.bsg5.chapter3.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

public class Artist {
    private String name;
    private Map<String, Song> songs = new HashMap<>();

    public Artist() {

    }

    public Artist(final String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Map<String, Song> getSongs() {
        return songs;
    }

    public void setSongs(final Map<String, Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Artist.class.getSimpleName() + "[", "]")
        .add("name='" + name + "'")
        .add("songs=" + songs)
        .toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Artist artist = (Artist) o;
        return getName().equals(artist.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
