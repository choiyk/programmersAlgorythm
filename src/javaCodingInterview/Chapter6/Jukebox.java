package javaCodingInterview.Chapter6;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Jukebox implements Selector {

    private CDPlayer cdPlayer;

    public Jukebox(Set<CD> cds) {
        this.cdPlayer = new CDPlayer(cds);
    }

    @Override
    public int playBtn() {
        Song currentSong = cdPlayer.getCurrentSong();
        System.out.println("음악이 재생 중입니다. : " + currentSong.getName());
        return cdPlayer.getSongIndex();
    }

    @Override
    public void stopBtn() {
        System.out.println("재생을 멈췄습니다.");
    }

    @Override
    public int nextBtn() {
        Song nextSong = cdPlayer.getNextSong();
        System.out.println("다음 곡을 재생합니다. : " + nextSong.getName());
        return cdPlayer.getSongIndex();
    }

    @Override
    public int prevBtn() {
        Song prevSong = cdPlayer.getPrevSong();
        System.out.println("이전 곡을 재생합니다. : " + prevSong.getName());
        return cdPlayer.getSongIndex();
    }

    @Override
    public int shuffleBtn() {
        cdPlayer.shuffle();
        Song currentSong = cdPlayer.getCurrentSong();
        System.out.println("재생 목록을 셔플 후 재생합니다. : " + currentSong.getName());
        return cdPlayer.getSongIndex();
    }

    @Override
    public int addCD(CD cd) {
        cdPlayer.addCD(cd);
        System.out.println("CD가 삽입되었습니다.");
        return cdPlayer.getPlayListSize();
    }

    @Override
    public int removeCurrentSongFromPlayList() {
        cdPlayer.removeSong();
        System.out.println("현재 곡이 재생목록에서 삭제되었습니다.");
        return cdPlayer.getSongIndex();
    }

    public int getPlayListSize() {
        return cdPlayer.getPlayListSize();
    }
}

class CDPlayer {
    private final Set<CD> cds;
    private final PlayList playList;
    private int songIndex;

    public CDPlayer(Set<CD> cds) {
        this.cds = cds;
        this.playList = new PlayList(cds);
        songIndex = 0;
    }

    public void addCD(CD cd) {
        playList.addCD(cd);
    }

    public void removeSong() {
        playList.removeSong(songIndex--);
    }

    public void shuffle() {
        playList.shuffle();
        this.songIndex = 0;
    }

    public Song getCurrentSong() {
        return playList.getSong(songIndex);
    }

    public Song getNextSong() {
        songIndex++;
        if(songIndex >= playList.size()) {
            songIndex = songIndex % playList.size();
        }

        return playList.getSong(songIndex);
    }

    public Song getPrevSong() {
        songIndex--;
        if(songIndex < 0) {
            songIndex = playList.size()-1;
        }

        return playList.getSong(songIndex);
    }

    public int getSongIndex() {
        return songIndex;
    }

    public int getPlayListSize() {
        return playList.size();
    }
}

interface Selector {
    int playBtn(); //재생 버튼
    void stopBtn(); //멈춤 버튼
    int nextBtn(); //다음 곡 재생 버튼
    int prevBtn(); //이전 곡 재생 버튼
    int shuffleBtn();  //셔플 재생 버튼
    int addCD(CD cd);   //CD 삽입
    int removeCurrentSongFromPlayList();  //재생목록에서 현재 곡 삭제
}

class PlayList {
    private final List<Song> songs;

    public PlayList(Set<CD> cds) {
        this.songs = new ArrayList<>();
        for(CD cd : cds){
            addCD(cd);
        }
    }

    public int size() {
        return songs.size();
    }

    public void addCD(CD cd) {
        songs.addAll(cd.getSongs());
    }

    public void removeSong(int index) {
        songs.remove(index);
    }

    public void shuffle() {
        //TODO 셔플 구현
    }

    public Song getSong(int index) {
        return songs.get(index);
    }
}

class CD {
    private final List<Song> songs;
    private int pointer;

    public CD(List<Song> songs) {
        this.songs = songs;
        this.pointer = 0;
    }

    public List<Song> getSongs() {
        return songs;
    }
}

class Song {
    private String name;

    public Song(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

