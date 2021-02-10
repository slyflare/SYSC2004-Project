import java.util.ArrayList;

public class Inventory {
    private int[][] stock;
    private ArrayList<Product> productList = new ArrayList<>();

    public Inventory(int[][] baseInventory, ArrayList<Product> list){
        this.stock = baseInventory;
        this.productList = list;
    }

    //Getters
    public int getStock(int id){
        for( int[] i: stock){
            if(i[0] == id){
                return i[1];
            }
        }
        System.out.println("Item does not exist in inventory");
        return 0;
    }

    public String getProductInfo(int id){
        for(Product p: productList) {
            if (p.getItemID() == id) {
                return "Name: " + p.getItemName() + " Price: " + p.getItemCost();
            }
        }
        return "Product does not exist";
    }

    /**Might not be used*/
    public int[][] getArrayStock() {
        return stock;
    }
    /**Might not be used*/
    public ArrayList<Product> getProductList() {
        return productList;
    }

    //Setters

    public void addStock(int id, int amount){
        for(int[] i: stock){
            if(i[0] == id){
                i[1] += amount;
            }
        }
    }

    public void sellStock(int id, int amount){
        for(int[] i: stock){
            if(i[0] == id){
                i[1] -= amount;
            }
        }
    }

    public void setStock(int[][] stock) {
        this.stock = stock;
    }

    public void addProduct(Product p){
        this.productList.add(p);
    }

    public void removeProduct(Product p){
        this.productList.remove(p);
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
}
