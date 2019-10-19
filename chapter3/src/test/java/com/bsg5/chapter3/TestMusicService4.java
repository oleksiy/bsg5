package com.bsg5.chapter3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations = "/config-04.xml")
public class TestMusicService4 extends AbstractTestNGSpringContextTests {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    MusicService service; //gives a warning, because there's several music services
    @Autowired
    MusicServiceTests tests;

    @Test
    public void testSongVoting() {
        tests.testSongVoting(service);
    }

    @Test
    public void testGetMatchingArtistNames() {
        tests.testMatchingArtistNames(service);
    }
    @Test
    public void testGetSongsForArtist() {
        tests.testSongsForArtist(service);
    }
    @Test
    public void testMatchingSongNamesForArtist() {
        tests.testMatchingSongNamesForArtist(service);
    }
}