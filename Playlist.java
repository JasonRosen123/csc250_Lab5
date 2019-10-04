import java.util.Scanner;

public class Playlist {
    private SongEntry headNode;
    private SongEntry tailNode;
    private int x;

    public Playlist() {
        this.headNode = null;
        this.tailNode = null;
        this.x = 0;
    }

    boolean isEmpty() {

        return (headNode == null);
    }

    void outputPlaylist(String title) {
        SongEntry song = this.headNode;
        int i = 1;

        System.out.println(title + " - OUTPUT FULL PLAYLIST");

        while (song != null) {
            System.out.println(i + ".");
            song.printPlaylistSongs();
            song = song.getNext();
            i += 1;
        }
    }

    boolean songExists(String songID) {
        SongEntry song = this.headNode;

        while (song != null) {
            if (song.getID().equalsIgnoreCase(songID)) {
                return true;
            }
            song = song.getNext();
        }
        return false;
    }

    void addSong(String uniqueID, String songName, String artistName, int songLength) {

        SongEntry newSong = new SongEntry(uniqueID, songName, artistName, songLength);

        if (headNode == null) {
            headNode = newSong;
            tailNode = headNode;
            x += 1;

        } else {
            if (!songExists(uniqueID)) {
                tailNode.setNext(newSong);
                tailNode = newSong;
                x += 1;

            } else
                System.out.println("Song ID: " + uniqueID + " is already in the playlist.");
        }
    }

    String removeSong(String uniqueID) {
        SongEntry song = this.headNode;
        String title = null;

        if (headNode.getID().equalsIgnoreCase(uniqueID)) {
            title = headNode.getSongName();
            headNode = headNode.getNext();
            x -= 1;

        } else {

            while (song.getNext() != null) {

                if (song.getNext().getID().equalsIgnoreCase(uniqueID)) {
                    title = song.getNext().getSongName();
                    if (song.getNext().getNext() == null)
                        tailNode = song;

                    song.setNext(song.getNext().getNext());
                    x -= 1;
                    break;
                }
                song = song.getNext();
            }
        }

        return title;
    }

    String getSong(int index) {
        SongEntry song = this.headNode;
        String title = null;
        int i = 1;

        while (i != index) {
            song = song.getNext();
            i += 1;
        }
        return song.getSongName();
    }

    int changeSongPos(int currPos, int newPos) {
        int actualPos = -1;
        if (currPos != newPos) {
            int pos = 1;
            SongEntry song = this.headNode;
            SongEntry target = null;

            if (currPos == 1) {
                target = headNode;
                headNode = headNode.getNext();

            } else {
                while (pos != (currPos - 1)) {
                    song = song.getNext();
                    pos += 1;
                }

                target = song.getNext();
                song.setNext(target.getNext());

                if (currPos == x)
                    tailNode = song;
            }

            if (newPos <= 1) {
                target.setNext(headNode);

                headNode = target;

                actualPos = 1;

            } else if (newPos >= x) {
                tailNode.setNext(target);

                tailNode = target;
                target.setNext(null);

                actualPos = x;

            } else {
                song = this.headNode;
                pos = 1;

                while (pos != (newPos - 1)) {
                    song = song.getNext();
                    pos += 1;
                }

                target.setNext(song.getNext());
                song.setNext(target);

                actualPos = newPos;
            }
        }

        return actualPos;
    }

    void songByArtist(String artistName) {
        SongEntry song = this.headNode;

        while (song != null) {
            if (song.getArtistName().equalsIgnoreCase(artistName))
                song.printPlaylistSongs();
            song = song.getNext();
        }
    }

    int totalPlaylistTime() {
        int time = 0;
        SongEntry song = this.headNode;

        while (song != null) {
            time += song.getSongLength();
            song = song.getNext();
        }

        return time;
    }

    private static void printMenu(String title, Scanner scnr) {

        Playlist list = new Playlist();
        String menuOption;

        do {

            System.out.println(title + " PLAYLIST MENU" + "\na - Add song" + "\nd - Remove song"
                    + "\nc - Change position of song" + "\ns - Output songs by specific artist"
                    + "\nt - Output total time of playlist (in seconds)" + "\no - Output full playlist" + "\nq - Quit");
            System.out.println();
            System.out.println("Choose an option:");
            
            menuOption = scnr.nextLine();


            switch(menuOption) {

                case "q":
                case "Q":

                    break;

                case "a":
                case "A":

                    System.out.println("ADD SONG");
                    System.out.println("Enter song's unique ID:");
                    String songID = scnr.nextLine();

                    System.out.println("Enter song's name:");
                    String songName = scnr.nextLine();

                    System.out.println("Enter artist's name:");
                    String artistName = scnr.nextLine();

                    System.out.println("Enter song's length (in seconds):");
                    int songLength = scnr.nextInt();

                    list.addSong(songID, songName, artistName, songLength);
                    System.out.println("");

                    break;

                case "d":
                case "D":

                    System.out.println("REMOVE SONG");
                    if (!list.isEmpty()) {
                        System.out.println("Enter song's unique ID:");
                        songID = scnr.nextLine();

                        String removedSong = list.removeSong(songID);
                        System.out.println((removedSong == null) ? ("Cannot find the song with id " + songID)
                                : ("\"" + removedSong + "\"" + " " + "removed."));
                    } else

                        System.out.println("Playlist is empty");
                        System.out.println();

                    break;

                case "c":
                case "C":

                    if (!list.isEmpty()) {
                        System.out.println("CHANGE POSITION OF SONG");

                        int currPos = -1;

                        do {

                            System.out.println("Enter song's current position:");
                            currPos = scnr.nextInt();

                            if ((currPos < 1) || (currPos > list.x))
                                System.out.println("Invalid current position. Please try again.");

                        } while ((currPos < 1 || currPos > list.x));

                        System.out.println("Enter new position for song:");
                        int newPos = scnr.nextInt();

                        newPos = (newPos < 1) ? 1 : ((newPos > list.x) ? list.x : newPos);
                        newPos = list.changeSongPos(currPos, newPos);

                        if (newPos != -1)
                            System.out.println("\"" + list.getSong(newPos) + "\"" + " moved to position " + newPos);

                        else
                            System.out.println("No change");

                    } else

                        System.out.println("Playlist is empty");
                        System.out.println();

                    break;

                case "s":
                case "S":
                     int i = 1;
                    if (!list.isEmpty()) {
                        System.out.println("OUTPUT SONGS BY SPECIFIC ARTIST");
                        System.out.println("Enter artist's name:");
                        
                        artistName = scnr.nextLine();
                                 
                        
                         SongEntry song = list.headNode;

                        while (song != null) {
                          if (song.getArtistName().equals(artistName)){
                              System.out.println(i + ".");
                              song.printPlaylistSongs();
                          }
                          
                          song = song.getNext();
                          i++;
                        }
                    }
           
         
                    else
                        System.out.println("\nPlaylist is empty");

                    break;

                case "t":
                case "T":

                    if (!list.isEmpty()) {
                        System.out.println("OUTPUT TOTAL TIME OF PLAYLIST (IN SECONDS)");
                        System.out.println("Total time: " + list.totalPlaylistTime() + " seconds\n");
                    } else {
                        System.out.println(title);
                        System.out.println("\nPlaylist is empty");
                    }
                    break;

                case "o":
                case "O":

                    if (!list.isEmpty()) {
                        list.outputPlaylist(title);
                    } else {
                        System.out.println(title + " - OUTPUT FULL PLAYLIST" + "\nPlaylist is empty");
                        System.out.println();
                    }
                    break;
            }

        } while (!menuOption.equalsIgnoreCase("q"));
    }

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        System.out.println("Enter playlist's title:");
        String title = scnr.nextLine();
        System.out.println();
        printMenu(title, scnr);

    }
}