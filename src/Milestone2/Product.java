// Nikita Volochay 101162520 // 
// Vimal Gunasegaran 101155249 //

// Coded by Nikita. Reviewed and refactored by Vimal//

public class Product {

    private int itemID;
    private String itemName;
    private double itemCost;
    private int itemStock;

    public Product(){
        this.itemID = 0;
        this.itemName = "";
        this.itemCost = 0;
        this.itemStock = 0;
    }

    public Product(int ID, String name, double cost, int stock){
        this.itemID = ID;
        this.itemName = name;
        this.itemCost = cost;
        this.itemStock = stock;

    }

    public int getItemID(){
        return itemID;
    }

   public String getItemName(){
        return itemName;
   }

    public double getItemCost(){
        return itemCost;

    }

    public int getItemStock(){
        return itemStock;
    }

    public void setItemID(int newID){
        this.itemID = newID;

    }

    public void setItemName(String newName){
        this.itemName = newName;

    }

    public void setItemCost(int newCost){
        this.itemCost = newCost;

    }

    public void setItemStock(int itemStock) {
        this.itemStock = itemStock;
    }
}
