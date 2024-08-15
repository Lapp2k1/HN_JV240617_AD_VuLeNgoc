package ra.service;

import ra.model.Singer;

public class SingerService {
    public Singer[] singers;
    private int count;

    public SingerService(int capacity) {
        singers = new Singer[capacity];
        count = 0;
    }


    public void addSinger(Singer singer) {
        if (count < singers.length) {
            singers[count++] = singer;
        } else {
            System.out.println("Danh sách ca sĩ đã đầy.");
        }
    }


    public void updateSinger(int singerId, Singer updatedSinger) {
        for (int i = 0; i < count; i++) {
            if (singers[i].getSingerId() == singerId) {
                singers[i] = updatedSinger;
                return;
            }
        }
        System.out.println("Không tìm thấy ca sĩ với ID: " + singerId);
    }


    public void deleteSinger(int singerId) {
        for (int i = 0; i < count; i++) {
            if (singers[i].getSingerId() == singerId) {
                singers[i] = singers[count - 1];
                singers[count - 1] = null;
                count--;
                return;
            }
        }
        System.out.println("Không tìm thấy ca sĩ với ID: " + singerId);
    }

    public Singer findSinger(int singerId) {
        for (int i = 0; i < count; i++) {
            if (singers[i].getSingerId() == singerId) {
                return singers[i];
            }
        }
        return null;
    }


    public void displayAllSingers() {
        if (count == 0) {
            System.out.println("Không có ca sĩ nào.");
            return;
        }
        for (int i = 0; i < count; i++) {
            singers[i].displayData();
            System.out.println("-------------------");
        }
    }
}
