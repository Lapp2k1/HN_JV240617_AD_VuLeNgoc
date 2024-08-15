package ra.model;

import java.util.Scanner;

public class Singer {

    private static int idCounter = 1;
    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;


    public Singer() {
        this.singerId = idCounter++;
    }

    public Singer(int singerId, String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }


    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Singer.idCounter = idCounter;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên ca sĩ: ");
        setSingerName(scanner.nextLine());

        System.out.print("Nhập tuổi: ");
        setAge(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Nhập quốc tịch: ");
        setNationality(scanner.nextLine());

        System.out.print("Nhập giới tính (true: Nam, false: Nữ): ");
        setGender(scanner.nextBoolean());
        scanner.nextLine();

        System.out.print("Nhập thể loại: ");
        setGenre(scanner.nextLine());
    }


    public void displayData() {
        System.out.println("ID Ca sĩ: " + singerId);
        System.out.println("Tên ca sĩ: " + singerName);
        System.out.println("Tuổi: " + age);
        System.out.println("Quốc tịch: " + nationality);
        System.out.println("Giới tính: " + (gender ? "Nam" : "Nữ"));
        System.out.println("Thể loại: " + genre);
    }
}
