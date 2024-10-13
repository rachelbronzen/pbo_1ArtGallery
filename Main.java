import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface Storable {
    void tambahItem(ArtItem item, int jumlah);

    void hapusItem(String title);

    void tampilkanItem();
}

class Inventory implements Storable {
    private Map<ArtItem, Integer> itemMap;
    private int totalItem;

    public Inventory() {
        itemMap = new HashMap<>();
        totalItem = 0;
    }

    @Override
    public void tambahItem(ArtItem item, int jumlah) {
        itemMap.put(item, itemMap.getOrDefault(item, 0) + jumlah);
        totalItem += jumlah;
    }

    @Override
    public void hapusItem(String title) {
        ArtItem itemToRemove = null;
        for (ArtItem item : itemMap.keySet()) {
            if (item.getTitle().equals(title)) {
                itemToRemove = item;
                break;
            }
        }
        if (itemToRemove != null) {
            totalItem -= itemMap.get(itemToRemove);
            itemMap.remove(itemToRemove);
        } else {
            System.out.println("Item tidak ditemukan.");
        }
    }

    @Override
    public void tampilkanItem() {
        System.out.println("Daftar Item di Galeri Seni:");
        for (Map.Entry<ArtItem, Integer> entry : itemMap.entrySet()) {
            System.out.println(entry.getKey() + ", Jumlah: " + entry.getValue());
        }
        System.out.println("Total Item: " + totalItem);
    }
}

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nPilih opsi:");
            System.out.println("1. Tambah Item");
            System.out.println("2. Hapus Item");
            System.out.println("3. Tampilkan Item");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (choice) {
                case 1:
                    System.out.print("Masukkan judul art: ");
                    String title = scanner.nextLine();
                    System.out.print("Masukkan nomor gallery: ");
                    int galleryNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan nama penulis: ");
                    String author = scanner.nextLine();
                    System.out.print("Masukkan harga: ");
                    double price = scanner.nextDouble();
                    System.out.print("Masukkan jumlah item: ");
                    int jumlah = scanner.nextInt();
                    scanner.nextLine();
                    ArtItem newItem = new ArtItem(title, galleryNumber, author, price);
                    inventory.tambahItem(newItem, jumlah);
                    break;
                case 2:
                    System.out.print("Masukkan judul art yang akan dihapus: ");
                    String titleToRemove = scanner.nextLine();
                    inventory.hapusItem(titleToRemove);
                    break;
                case 3:
                    inventory.tampilkanItem();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}