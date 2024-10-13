import java.util.HashMap;
import java.util.Map;

public class Inventory implements Storable{
    private Map<String, DataArt> itemMap;
    private int totalItem;

    public Inventory(){
        itemMap = new HashMap<>();
        totalItem = 0;
    }

    @Override
    public void tambahItem(String judulArt, String nomorProduk, String namaPenulis, double harga){
        if(itemMap.containsKey(nomorProduk)){
            System.out.println("Number of product '" + nomorProduk + "' already inserted. Please enter a different number");
        } 
        else {
            DataArt item = new DataArt(nomorProduk, namaPenulis, harga, judulArt);
            item.setJudulArt(judulArt);
            itemMap.put(nomorProduk, item);
            totalItem++;
            System.out.println("The '" + judulArt + "' succesfully added.");
        }
    }

    @Override
    public void hapusItem(String nomorProduk){
        if(itemMap.containsKey(nomorProduk)){
            DataArt removedItem = itemMap.remove(nomorProduk);
            totalItem--;
            System.out.println("The '" + removedItem.getJudulArt() + "' already removed.");
        } else{
            System.out.println("The '" + nomorProduk + "' Number of Product is not found.");
        }
    }

    @Override
    public void tampilkanItem(){
        if(itemMap.isEmpty()){
            System.out.println("There is no item in the Art Gallery.");
        } else {
            System.out.println("Item in the Art Gallery:\n");
            for(Map.Entry<String, DataArt> entry : itemMap.entrySet()){
                System.out.println("Number of Product: " + entry.getKey() + ", " + entry.getValue());
            }
        }
        System.out.println("Total item : " + totalItem);
    }
}
