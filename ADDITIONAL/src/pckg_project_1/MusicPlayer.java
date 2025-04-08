package pckg_project_1;

import java.util.Arrays;

public class MusicPlayer extends MediaDevice{

    private int currentSong;
    private PlayList playList;

    protected MusicPlayer(String brand, String model) {
        super(brand, model);
        this.currentSong = 0;
        this.playList = new PlayList();
    }

    public void addNewSongToPlayList(Song song){
        playList.addSong(song);
    }

    private class PlayList{

        Song[] songs;
        static final int CAPACITY = 10;

        public PlayList(){
            songs = new Song[CAPACITY];
        }

        public void addSong(Song song){
            if(checkFreeSlots() >= 0){
                songs[checkFreeSlots()] = song;
                System.out.println("New song added to playlist!");
            }else{
                System.out.println("Playlist is full, unable to add new song! :(");
            }
        }

        private int checkFreeSlots(){
            int idx = 0;
            for(Song song:songs){
                if(song == null){
                    return idx;
                }else{
                    idx++;

                }
            }
            return -1;
        }

        @Override
        public String toString() {
            return "PlayList{" +
                    "songs=" + Arrays.toString(songs) +
                    '}';
        }
    }

    @Override
    public void turnONDevice() {

    }

    @Override
    public void play() {
        System.out.println("Playing song in playlist: " + currentSong);
    }

    @Override
    public void pause() {
        System.out.println("Pause on the song: " + currentSong);
    }

    @Override
    public void stop() {
        System.out.println("Stop playing playlist on: " + this.getClass().getSimpleName());
    }

    @Override
    public void next() {
        if(currentSong == this.playList.getSongsFromPlaylist().length-1){
            this.currentSong = 1;
            System.out.println("Going to the first song!");
        }else{
            this.currentSong++;
        }
    }

    @Override
    public void previous() {
        if(currentSong == 1){
            this.currentSong = playList.getSongsFromPlaylist().length-1;
            System.out.println("Going to the last song!");
        }else{
            this.currentSong--;
            System.out.println("Going to the previous song!");
        }
    }

    @Override
    public String toString() {
        return "MusicPlayer{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                "currentSong=" + currentSong +
                ", playList=" + playList +
                '}';
    }
}
