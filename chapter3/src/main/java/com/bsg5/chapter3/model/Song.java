package com.bsg5.chapter3.model;

import java.util.Objects;
import java.util.StringJoiner;

public class Song implements Comparable<Song> {
    private String name;
    private int votes = 0;

    public Song() {

    }

    public Song(final String name) {
        this.name = name;
    }

    public Song(final String name, int votes) {
        setName(name);
        setVotes(votes);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(final int votes) {
        this.votes = votes;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Song song = (Song) o;
        return getName().equals(song.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Song.class.getSimpleName() + "[", "]")
                .add("name='" + this.name + "'")
                .add("votes='" + this.votes)
                .toString();
    }

    @Override
    public int compareTo(final Song o) {
        int value = Integer.compare(o.getVotes(), this.getVotes());
        if (value == 0) {
            value = getName().compareTo(o.getName());
        }
        return value;
    }
}