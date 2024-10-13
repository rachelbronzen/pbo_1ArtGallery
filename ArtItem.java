public class ArtItem {
    private String title;
    private int galleryNumber;
    private String author;
    private double price;

    public ArtItem(String title, int galleryNumber, String author, double price) {
        this.title = title;
        this.galleryNumber = galleryNumber;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getGalleryNumber() {
        return galleryNumber;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Judul: " + title + ", Nomor Gallery: " + galleryNumber + ", Penulis: " + author + ", Harga: " + price;
    }
}