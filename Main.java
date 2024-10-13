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
        System.out.println("\n >>>  The Art Gallery  <<<");

        while (running) {
            System.out.println("\nPlease choose this command");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Show Item");
            System.out.println("4. Exit");
            System.out.print("Enter number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (choice) {
                case 1:
                    System.out.print("\nArt Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Number of Product: ");
                    int galleryNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("The Artist: ");
                    String author = scanner.nextLine();
                    System.out.print("The Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Masukkan jumlah item: ");
                    int jumlah = scanner.nextInt();
                    scanner.nextLine();
                    ArtItem newItem = new ArtItem(title, galleryNumber, author, price);
                    inventory.tambahItem(newItem, jumlah);
                    break;
                case 2:
                    System.out.print("Number of Product you want to remove: ");
                    String titleToRemove = scanner.nextLine();
                    inventory.hapusItem(titleToRemove);
                    break;
                case 3:
                    inventory.tampilkanItem();
                    break;
                case 4:
                    System.out.println("\nThank you! Have a nice day!");
                    running = false;
                    break;
                default:
                    System.out.println("The number is invalid. Try to input another number.");
            }
        }

        scanner.close();
    }
}
