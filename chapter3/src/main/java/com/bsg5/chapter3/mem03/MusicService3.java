package com.bsg5.chapter3.mem03;

import com.bsg5.chapter3.AbstractMusicService;
import com.bsg5.chapter3.Normalizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope()
public class MusicService3 extends AbstractMusicService {
    @Autowired
    @Qualifier("bar")
    Normalizer artistNormalizer;

    @Autowired
    @Qualifier("foo")
    Normalizer songNormalizer;

    public Normalizer getArtistNormalizer() {
        return this.artistNormalizer;
    }

    public void setArtistNormalizer(Normalizer normalizer) {
        this.artistNormalizer = normalizer;
    }

    public Normalizer getSongNormalizer() {
        return this.songNormalizer;
    }

    public void setSongNormalizer(Normalizer normalizer) {
        this.songNormalizer = normalizer;
    }

    @Override
    protected String transformArtist(String input) {
        return artistNormalizer.transform(input);
    }

    @Override
    protected String transformSong(String input) {
        return songNormalizer.transform(input);
    }
}
