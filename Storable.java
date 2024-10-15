public interface Storable {
    void tambahItem(String judulArt, String nomorProduk, String namaPenulis, double harga);
    void hapusItem(String nomorProduk);
    void tampilkanItem();
}
