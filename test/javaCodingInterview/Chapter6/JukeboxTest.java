package javaCodingInterview.Chapter6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JukeboxTest {

    private Jukebox jukebox;

    @BeforeEach
    public void setCDs(){
        List<Song> songs1 = new ArrayList<>();
        songs1.add(new Song("CD1-1"));
        songs1.add(new Song("CD1-2"));
        songs1.add(new Song("CD1-3"));
        songs1.add(new Song("CD1-4"));
        CD cd1 = new CD(songs1);

        List<Song> songs2 = new ArrayList<>();
        songs2.add(new Song("CD2-1"));
        songs2.add(new Song("CD2-2"));
        songs2.add(new Song("CD2-3"));
        songs2.add(new Song("CD2-4"));
        CD cd2 = new CD(songs2);

        Set<CD> cds = new HashSet<>();
        cds.add(cd1);
        cds.add(cd2);

        jukebox = new Jukebox(cds);
    }

    @Test
    public void addCDTest() {
        assertEquals(jukebox.getPlayListSize(), 8);

        List<Song> songs3 = new ArrayList<>();
        songs3.add(new Song("CD3-1"));
        songs3.add(new Song("CD3-2"));
        songs3.add(new Song("CD3-3"));
        songs3.add(new Song("CD3-4"));
        CD cd3 = new CD(songs3);

        jukebox.addCD(cd3);
        assertEquals(jukebox.getPlayListSize(), 12);
    }

    @Test
    public void playTest() {
        assertEquals(jukebox.playBtn(), 0);
        assertEquals(jukebox.nextBtn(), 1);
        assertEquals(jukebox.nextBtn(), 2);
        assertEquals(jukebox.nextBtn(), 3);
        assertEquals(jukebox.prevBtn(), 2);
    }

    @Test
    public void 재생목록에서_곡_삭제_테스트() {
        assertEquals(jukebox.playBtn(), 0);
        assertEquals(jukebox.nextBtn(), 1);
        assertEquals(jukebox.nextBtn(), 2);
        assertEquals(jukebox.nextBtn(), 3);
        assertEquals(jukebox.removeCurrentSongFromPlayList(), 2);
        assertEquals(jukebox.playBtn(), 2);
        assertEquals(jukebox.getPlayListSize(), 7);
    }

}