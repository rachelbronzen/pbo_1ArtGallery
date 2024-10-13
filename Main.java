import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        System.out.println("\n >> The Art Gallery <<");
        
        do {
            System.out.println("\nPlease choose this command");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Show Item");
            System.out.println("4. Exit");
            System.out.print("Enter number: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("\nArt Title: ");
                    String judulArt = scanner.nextLine();
                    System.out.print("Number of Product: ");
                    String nomorProduk = scanner.nextLine();
                    System.out.print("The Artist: ");
                    String namaPenulis = scanner.nextLine();
                    System.out.print("The Price: ");
                    double harga = scanner.nextDouble();
                    scanner.nextLine();

                    inventory.tambahItem(judulArt, nomorProduk, namaPenulis, harga);
                    break;

                case 2:
                    System.out.print("Number of Product you want to remove: ");
                    String nomorProdukHapus = scanner.nextLine();
                    inventory.hapusItem(nomorProdukHapus);
                    break;

                case 3:
                    inventory.tampilkanItem();
                    break;

                case 4:
                    System.out.println("\nThank you! Have a nice day!");
                    break;

                default:
                    System.out.println("The number is invalid. Try to input another number.");
            }
        } while (pilihan != 4);

        scanner.close();
    }
}
