public class SongEntry {
    private String uniqueID;
    private String songName;
    private String artistName;
    private int songLength;
    private SongEntry nextNode;

    public SongEntry() {
        uniqueID = "none";
        songName = "none";
        artistName = "none";
        songLength = 0;
        nextNode = null;
    }

    public SongEntry(String uniqueID, String songName, String artistName, int songLength) {
        this.uniqueID = uniqueID;
        this.songName = songName;
        this.artistName = artistName;
        this.songLength = songLength;
    }

    public void insertAfter(SongEntry currNode) {
        if (currNode == null) {
            return;
        }
            currNode.setNext(nextNode);
            nextNode = currNode;
    }

    public void setNext(SongEntry nextNode) {

        this.nextNode = nextNode;
    }

    public SongEntry getNext() {

        return this.nextNode;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setSongLength(int songLength) {
        this.songLength = songLength;
    }

    public String getID() {
        return this.uniqueID;
    }

    public String getSongName() {
        return this.songName;
    }

    public String getArtistName() {
        return this.artistName;
    }

    public int getSongLength() {
        return this.songLength;
    }

    public void printPlaylistSongs() {
      System.out.println("Unique ID: " + getID());
      System.out.println("Song Name: " + getSongName());
      System.out.println("Artist Name: " + getArtistName());
      System.out.println("Song Length (in seconds): " + getSongLength());
      System.out.println("");
    }
}