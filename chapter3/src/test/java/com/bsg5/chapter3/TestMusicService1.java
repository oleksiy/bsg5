package com.bsg5.chapter3;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import com.bsg5.chapter3.model.Song;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

@ContextConfiguration(locations = "/config-01.xml")
public class TestMusicService1 extends AbstractMusicService {
    @Autowired
    ApplicationContext context;
    @Autowired
    MusicService service;

    @Test
    public void testConfiguration() {
        assertNotNull(context);
        Set<String> definitions = new HashSet<>(Arrays.asList(context.getBeanDefinitionNames()));

        //entire set of defined beans
        for(String d: definitions) {
            System.out.println(d);
        }
    }

    @Test
    public void testMusicService() {
        Song song = service.getSong(
                "Threadable Loaf", "Someone Stole the Flour"
        );
        assertEquals(song.getVotes(), 0);
    }
}
