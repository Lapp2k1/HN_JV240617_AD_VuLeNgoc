package ra.service;

import ra.model.Song;

public class SongService {
    public Song[] songs;
    private int count;

    public SongService(int capacity) {
        songs = new Song[capacity];
        count = 0;
    }


    public void addSong(Song song) {
        if (count < songs.length) {
            songs[count++] = song;
        } else {
            System.out.println("Danh sách bài hát đã đầy.");
        }
    }

    public void updateSong(String songId, Song updatedSong) {
        for (int i = 0; i < count; i++) {
            if (songs[i].getSongId().equals(songId)) {
                songs[i] = updatedSong;
                return;
            }
        }
        System.out.println("Không tìm thấy bài hát với ID: " + songId);
    }

    public void deleteSong(String songId) {
        for (int i = 0; i < count; i++) {
            if (songs[i].getSongId().equals(songId)) {
                songs[i] = songs[count - 1];
                songs[count - 1] = null;
                count--;
                return;
            }
        }
        System.out.println("Không tìm thấy bài hát với ID: " + songId);
    }


    public Song findSong(String songId) {
        for (int i = 0; i < count; i++) {
            if (songs[i].getSongId().equals(songId)) {
                return songs[i];
            }
        }
        return null;
    }


    public void displayAllSongs() {
        if (count == 0) {
            System.out.println("Không có bài hát nào.");
            return;
        }
        for (int i = 0; i < count; i++) {
            songs[i].displayData();
            System.out.println("-------------------");
        }
    }
}
