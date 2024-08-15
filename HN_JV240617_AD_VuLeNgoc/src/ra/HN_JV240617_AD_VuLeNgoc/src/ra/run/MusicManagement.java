package ra.run;

import ra.model.Singer;
import ra.model.Song;
import ra.service.SingerService;
import ra.service.SongService;

import java.util.Arrays;
import java.util.Scanner;

public class MusicManagement {
    private static SingerService singerService = new SingerService(100);
    private static SongService songService = new SongService(100);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("************************MUSIC-MANAGEMENT*************************");
            System.out.println("1. Quản lý ca sĩ ");
            System.out.println("2. Quản lý bài hát ");
            System.out.println("3. Tìm kiếm bài hát ");
            System.out.println("4. Thoát ");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    singerManagementMenu();
                    break;
                case 2:
                    songManagementMenu();
                    break;
                case 3:
                    searchManagementMenu();
                    break;
                case 4:
                    System.out.println("Thoát khỏi chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 4);
    }

    private static void singerManagementMenu() {
        int choice;
        do {
            System.out.println("**********************SINGER-MANAGEMENT*************************");
            System.out.println("1. Nhập vào số lượng ca sĩ cần thêm ");
            System.out.println("2. Hiển thị danh sách tất cả ca sĩ đã lưu trữ ");
            System.out.println("3. Thay đổi thông tin ca sĩ theo mã id");
            System.out.println("4. Xóa ca sĩ theo mã id ");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addSingers();
                    break;
                case 2:
                    singerService.displayAllSingers();
                    break;
                case 3:
                    updateSinger();
                    break;
                case 4:
                    deleteSinger();
                    break;
                case 5:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 5);
    }

    private static void addSingers() {
        System.out.print("Nhập số lượng ca sĩ cần thêm: ");
        int numSingers = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numSingers; i++) {
            Singer singer = new Singer();
            System.out.println("Nhập thông tin của ca sĩ thứ " + (i+1));
            singer.inputData();
            singerService.addSinger(singer);
        }
    }

    private static void updateSinger() {
        System.out.print("Nhập mã ca sĩ cần thay đổi thông tin: ");
        int singerId = scanner.nextInt();
        scanner.nextLine();
        Singer updatedSinger = new Singer();
        updatedSinger.inputData();
        singerService.updateSinger(singerId, updatedSinger);
    }

    private static void deleteSinger() {
        System.out.print("Nhập mã ca sĩ cần xóa: ");
        int singerId = scanner.nextInt();
        scanner.nextLine();
        singerService.deleteSinger(singerId);
    }

    private static void songManagementMenu() {
        int choice;
        do {
            System.out.println("**********************SONG-MANAGEMENT*************************");
            System.out.println("1. Nhập vào số lượng bài hát cần thêm ");
            System.out.println("2. Hiển thị danh sách tất cả bài hát đã lưu trữ");
            System.out.println("3. Thay đổi thông tin bài hát theo mã id");
            System.out.println("4. Xóa bài hát theo mã id");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addSongs();
                    break;
                case 2:
                    songService.displayAllSongs();
                    break;
                case 3:
                    updateSong();
                    break;
                case 4:
                    deleteSong();
                    break;
                case 5:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 5);
    }

    private static void addSongs() {
        System.out.print("Nhập số lượng bài hát cần thêm: ");
        int numSongs = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numSongs; i++) {
            Song song = new Song();
            song.inputData(singerService.singers);
            songService.addSong(song);
        }
    }

    private static void updateSong() {
        System.out.print("Nhập mã bài hát cần thay đổi thông tin: ");
        String songId = scanner.nextLine();
        Song updatedSong = new Song();
        updatedSong.inputData(singerService.singers);
        songService.updateSong(songId, updatedSong);
    }

    private static void deleteSong() {
        System.out.print("Nhập mã bài hát cần xóa: ");
        String songId = scanner.nextLine();
        songService.deleteSong(songId);
    }

    private static void searchManagementMenu() {
        int choice;
        do {
            System.out.println("*********************SEARCH-MANAGEMENT************************");
            System.out.println("1. Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại ");
            System.out.println("2. Tìm kiếm ca sĩ theo tên hoặc thể loại ");
            System.out.println("3. Hiển thị danh sách bài hát theo thứ tự tên tăng dần");
            System.out.println("4. Hiển thị 10 bài hát được đăng mới nhất ");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    searchSongsBySingerOrGenre();
                    break;
                case 2:
                    searchSingersByNameOrGenre();
                    break;
                case 3:
                    displaySongsByNameAscending();
                    break;
                case 4:
                    displayTop10NewestSongs();
                    break;
                case 5:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 5);
    }

    private static void searchSongsBySingerOrGenre() {
        System.out.print("Nhập tên ca sĩ hoặc thể loại để tìm kiếm: ");
        String keyword = scanner.nextLine();
        boolean found = false;
        for (Song song : songService.songs) {
            if (song != null) {
                if (song.getSinger().getSingerName().equalsIgnoreCase(keyword) || song.getGenre().equalsIgnoreCase(keyword)) {
                    song.displayData();
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy bài hát nào với tên ca sĩ hoặc thể loại: " + keyword);
        }
    }

    private static void searchSingersByNameOrGenre() {
        System.out.print("Nhập tên ca sĩ hoặc thể loại để tìm kiếm: ");
        String keyword = scanner.nextLine();
        boolean found = false;
        for (Singer singer : singerService.singers) {
            if (singer != null) {
                if (singer.getSingerName().equalsIgnoreCase(keyword) || singer.getGenre().equalsIgnoreCase(keyword)) {
                    singer.displayData();
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy ca sĩ nào với tên hoặc thể loại: " + keyword);
        }
    }

    private static void displaySongsByNameAscending() {
        Song[] sortedSongs = songService.songs.clone();

        Arrays.sort(sortedSongs, (s1, s2) -> {
            if (s1 != null && s2 != null) {
                return s1.getSongName().compareToIgnoreCase(s2.getSongName());
            }
            return 0;
        });

        System.out.println("Danh sách bài hát theo thứ tự tên tăng dần:");
        for (Song song : sortedSongs) {
            if (song != null) {
                song.displayData();
                System.out.println("-------------------");
            }
        }
    }

    private static void displayTop10NewestSongs() {
        Song[] newestSongs = songService.songs.clone();

        Arrays.sort(newestSongs, (s1, s2) -> {
            if (s1 != null && s2 != null) {
                return s2.getCreatedDate().compareTo(s1.getCreatedDate());
            }
            return 0;
        });

        System.out.println("10 bài hát mới nhất:");
        for (int i = 0; i < Math.min(10, newestSongs.length); i++) {
            if (newestSongs[i] != null) {
                newestSongs[i].displayData();
                System.out.println("-------------------");
            }
        }
    }

}
