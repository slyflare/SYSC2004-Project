// Nikita Volochay 101162520 //
// Vimal Gunasegaran 101155249//

// Coded by Nikita. Reviewed and refactored by Vimal//

/**
* Inventory class object, contains all the Products that the store can sell.
*/

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> productList = new ArrayList<>();

    /**
    * Default Inventory constructor
    */
    public Inventory(){
        this.productList.add(new Product(1,"Apple", 1.00,10));
        this.productList.add(new Product(2,"Orange", 2.50,15));
        this.productList.add(new Product(3,"Banana",1.25,20));
        this.productList.add(new Product(4,"Papaya", 5.00,50));
        this.productList.add(new Product(5,"Durian",100.00,1));
    }

    //Getters

    /**
    *Gets the stock of a Product with a specified ID
    *@param id int, 
    */
    public int getStock(int id){
        for(Product p: productList){
            if(p.getItemID() == id){
                return p.getItemStock();
            }
        }
        System.out.println("Item does not exist in inventory");
        return -1;
    }

    /**
    *Gets a Products information
    *@param Product product, the product your are trying to get info on
    *@return String, the product information
    */
    public String getProductInfo(Product product){
        for(Product p: productList) {
            if (p.equals(product)) {
                return "ID:" + p.getItemID() + ", Name: " + p.getItemName() + " , Price: " + p.getItemCost() + ", Stock: " + getStock(p.getItemID());
            }
        }
        return "Product does not exist";
    }
    
    /**
    *Gets a product given an ID
    *@param id int, the id of the product you are trying to find
    *@return Product the product of the given ID if it exists otherwise returns an empty product
    */
    public Product getProduct(int id){
        Product product = new Product();
        for(Product p: productList){
            if(p.getItemID() == id){
                product = p;
            }
        }
        return product;
    }

    /**
    *Gets the list of products
    *@return ArrayList<Product> the list of products
    */
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
    
    /**
    *Adds stock to the product list
    *@param product Product, the product to be added
    *@param amount int, the amount of product to be added
    */
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
    
    /**
    *Sells an amount of stock given an id
    *@param id int, the id of the product
    *@param amount in, the amount to be sold
    */
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

    /**
    *Add product to the productList
    *@param p Product, the product to be added
    */
    public void addProduct(Product p){
        this.productList.add(p);
    }

    /**
    *Removes product from the productList
    *@param p Product, the product to be removed
    */
    public void removeProduct(Product p){
        this.productList.remove(p);
    }
}
