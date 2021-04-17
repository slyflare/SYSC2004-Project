package myStore;
// Nikita Volochay 101162520 //
// Vimal Gunasegaran 101155249//

// Coded by Nikita. Reviewed and refactored by Vimal//

/**
* store.Inventory class object, contains all the Products that the store can sell.
*/

import java.util.ArrayList;

public class Inventory implements ProductStockContainer{
    private ArrayList<Product> productList = new ArrayList<>();

    /**
    * Default store.Inventory constructor
    */
    public Inventory(){
        this.productList.add(new Product(1,"Apple", 1.00,100));
        this.productList.add(new Product(2,"Orange", 2.50,150));
        this.productList.add(new Product(3,"Banana",1.25,200));
        this.productList.add(new Product(4,"Papaya", 5.00,500));
        this.productList.add(new Product(5,"Durian",100.00,100));
    }

    //Getters

    /**
    *Gets the stock of a store.Product with a specified ID
    *@param product product
    */
    @Override
    public int getProductQuantity(Product product){
        for(Product p: productList){
            if(p.getItemID() == product.getItemID()){
                return p.getItemStock();
            }
        }
        System.out.println("Item does not exist in inventory");
        return -1;
    }

    /**
    *Gets a Products information
    *@param product product, the product your are trying to get info on
    *@return String, the product information
    */
    public String getProductInfo(Product product){
        for(Product p: productList) {
            if (p.getItemID() == product.getItemID()) {
                return "ID:" + p.getItemID() + ", Name: " + p.getItemName() + " , Price: " + p.getItemCost() + ", Stock: " + getProductQuantity(p);
            }
        }
        return "store.Product does not exist";
    }
    
    /**
    *Gets a product given an ID
    *@param id int, the id of the product you are trying to find
    *@return store.Product the product of the given ID if it exists otherwise returns an empty product
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
    *@return ArrayList<store.Product> the list of products
    */
    public ArrayList<Product> getProductList() {
        return productList;
    }

    //Setters
    
    /**
    *Adds stock to the product list
    *@param product store.Product, the product to be added
    *@param amount int, the amount of product to be added
    */
    @Override
    public void addProductQuantity(Product product, int amount){
        if(!(this.productList.contains(product))){
            addProduct(product);
        }
        product.setItemStock(product.getItemStock() + amount);
    }
    
    /**
    *Sells an amount of stock given an id
    *@param product int, the id of the product
    *@param amount in, the amount to be sold
    */
    @Override
    public void removeProductQuantity(Product product, int amount) {
        for (Product p : productList) {
            if (p.getItemID() == product.getItemID()) {
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
     * Returns the number of products in inventory
     * @return int: number of products
     */
    @Override
    public int getNumOfProducts(){
        return this.productList.size();
    }

    /**
    *Add product to the productList
    *@param p store.Product, the product to be added
    */
    public void addProduct(Product p){
        this.productList.add(p);
    }

    /**
    *Removes product from the productList
    *@param p store.Product, the product to be removed
    */
    public void removeProduct(Product p){
        this.productList.remove(p);
    }
}
