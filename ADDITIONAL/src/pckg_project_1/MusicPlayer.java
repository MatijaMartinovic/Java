package pckg_project_1;

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
    }

    @Override
    public void turnONDevice() {

    }

    @Override
    public void play() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void next() {

    }

    @Override
    public void previous() {

    }
}
