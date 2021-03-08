// Nikita Volochay 101162520 // 
// Vimal Gunasegaran 101155249 //

// Coded by Nikita. Reviewed and refactored by Vimal//

public class Product {

    private int itemID;
    private String itemName;
    private double itemCost;
    private int itemStock;

    /**
    *Override constructor for Product
    */
    public Product(){
        this.itemID = 0;
        this.itemName = "";
        this.itemCost = 0;
        this.itemStock = 0;
    }

    /**
    *Default constructor for Product
    *@param ID int, the product id
    *@param name String, the product name
    *@param cost double, the cost of the product
    *@param stock int, the stock of the product
    */
    public Product(int ID, String name, double cost, int stock){
        this.itemID = ID;
        this.itemName = name;
        this.itemCost = cost;
        this.itemStock = stock;

    }

    /**
    *Gets the product id
    *@return int, the product id
    */
    public int getItemID(){
        return itemID;
    }

   /**
    *Gets the product name
    *@return String, product name
    */
   public String getItemName(){
        return itemName;
   }

    /**
    *Gets the product cost
    *@return double, product cost
    */
    public double getItemCost(){
        return itemCost;

    }

    /**
    *Gets the product stock
    *@return int, product stock
    */
    public int getItemStock(){
        return itemStock;
    }
    
    /**
    *Sets product ID
    *@param newId int, new product id
    */
    public void setItemID(int newID){
        this.itemID = newID;

    }

    /**
    *Sets product name
    *@param newName String, new product name
    */
    public void setItemName(String newName){
        this.itemName = newName;

    }

    /**
    *Sets product cost
    *@param newCost double, new product cost
    */
    public void setItemCost(double newCost){
        this.itemCost = newCost;

    }
    
    /**
    *Sets product stock
    *@param itemStock int, new product stock
    */
    public void setItemStock(int itemStock) {
        this.itemStock = itemStock;
    }
}
