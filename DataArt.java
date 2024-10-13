public class DataArt {
    private String nomorProduk;
    private String namaPenulis;
    private double harga;
    private String judulArt;

    public DataArt(String nomorProduk, String namaPenulis, double harga, String judulArt) {
        this.nomorProduk = nomorProduk;
        this.namaPenulis = namaPenulis;
        this.harga = harga;
        this.judulArt = judulArt;
    }

    public String getNomorProduk(){
        return nomorProduk;
    }

    public String getNamaPenulis(){
        return namaPenulis;
    }

    public double getHarga(){
        return harga;
    }
    
    public String getJudulArt(){
        return judulArt;
    }

    public void setJudulArt(String judulArt){
        this.judulArt = judulArt;
    }

    @Override
    public String toString(){
        return "Art Title: " + judulArt + ", The Artist: " + namaPenulis + ", The Price: " + harga;
    }
}
