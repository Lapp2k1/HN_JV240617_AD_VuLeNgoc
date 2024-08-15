package ra.model;

import java.util.Date;
import java.util.Scanner;

public class Song {

    private String songId;
    private String songName;
    private String descriptions;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;
private String genre;

    public Song() {
        this.createdDate = new Date();
    }


    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        if (songId.length() != 4 || !songId.startsWith("S")) {
            System.out.println("Mã bài hát phải có 4 ký tự và bắt đầu bằng 'S'");
        }
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setSongName(String songName) {
        if (songName == null || songName.trim().isEmpty()) {
            System.out.println("Tên bài hát không được để trống");
        }
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        if (singer == null) {
            System.out.println("Ca sĩ không được null");
        }
        this.singer = singer;
        this.genre = singer.getGenre();
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        if (songWriter == null || songWriter.trim().isEmpty()) {
            System.out.println("Người sáng tác không được để trống");
        }
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    public void inputData(Singer[] singers) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã bài hát (4 ký tự, bắt đầu bằng 'S'): ");
        setSongId(scanner.nextLine());

        System.out.print("Nhập tên bài hát: ");
        setSongName(scanner.nextLine());

        System.out.print("Nhập mô tả bài hát: ");
        setDescriptions(scanner.nextLine());


        System.out.println("Danh sách ca sĩ:");
        for (Singer s : singers) {
            if (s != null) {
                System.out.println(s.getSingerId() + ": " + s.getSingerName());
            }
        }


        System.out.print("Chọn ca sĩ theo ID: ");
        int selectedSingerId = scanner.nextInt();
        for (Singer s : singers) {
            if (s != null && s.getSingerId() == selectedSingerId) {
                setSinger(s);
                break;
            }
        }


        if (this.singer == null) {
            System.out.println("Ca sĩ không tồn tại, vui lòng thêm ca sĩ trước");
        }

        scanner.nextLine();
        System.out.print("Nhập người sáng tác: ");
        setSongWriter(scanner.nextLine());

        System.out.print("Nhập trạng thái bài hát (true: phát hành, false: chưa phát hành): ");
        setSongStatus(scanner.nextBoolean());
    }


    public void displayData() {
        System.out.println("Mã bài hát: " + songId);
        System.out.println("Tên bài hát: " + songName);
        System.out.println("Mô tả: " + descriptions);
        System.out.println("Ca sĩ: " + (singer != null ? singer.getSingerName() : "Chưa có ca sĩ"));
        System.out.println("Người sáng tác: " + songWriter);
        System.out.println("Ngày tạo: " + createdDate);
        System.out.println("Trạng thái: " + (songStatus ? "Phát hành" : "Chưa phát hành"));
    }


}
