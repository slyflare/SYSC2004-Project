// Nikita Volochay 101162520 //
// Vimal Gunasegaran 101155249//

// Coded by Nikita. Reviewed and refactored by Vimal//

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> productList = new ArrayList<>();

    public Inventory(ArrayList<Product> list){
        this.productList = list;
    }

    //Getters

    public int getStock(int id){
        for(Product p: productList){
            if(p.getItemID() == id){
                return p.getItemStock();
            }
        }
        System.out.println("Item does not exist in inventory");
        return -1;
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
    public ArrayList<Product> getProductList() {
        return productList;
    }

    //Setters
    
    /*
    public void addStock(int id, int amount){
        for(Product p: productList){
            if(p.getItemID() == id){
                p.setItemStock(p.getItemStock()+amount);
            }
        }
    } */
    
    // Code above replace with code below to account for non existent products.
    
  public void addStock(Product product, int amount){
        if(!(this.productList.contains(product))){
            addProduct(product);
        }
        product.setItemStock(product.getItemStock() + amount);
    }
    
    /*
    public void sellStock(int id, int amount){
        for(Product p: productList){
            if(p.getItemID() == id){
                p.setItemStock(p.getItemStock()-amount);
            }
        }
    } */
    
    // Code above replaced with code below to account for oversell.
    
    public void sellStock(int id, int amount) {
        for (Product p : productList) {
            if (p.getItemID() == id) {
                if (!((p.getItemStock() - amount) < 0)) {
                    p.setItemStock(p.getItemStock() - amount);
                }
                else{
                    System.out.println("Insufficient stock of " + p.getItemName());
                }
            }
        }
    }


    public void addProduct(Product p){
        this.productList.add(p);
    }

    public void removeProduct(Product p){
        this.productList.remove(p);
    }

    /**Might not be used*/
    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
}
