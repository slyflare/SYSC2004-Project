//Vimal Gunasegaran 101155249//

public class Product {


    private int itemID;
    private String itemName;
    private double itemCost;

    public Product(int ID, String name, int cost){
        this.itemID = ID;
        this.itemName = name;
        this.itemCost = cost;

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

    public void setItemID(int newID){
        this.itemID = newID;

    }

    public void setItemName(String newName){
        this.itemName = newName;

    }

    public void setItemCost(int newCost){
        this.itemCost = newCost;

    }



}
