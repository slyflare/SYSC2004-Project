// Vimal Gunasegaran 101155249 //
// Nikita Volochay 101162520 //

// Coded by Vimal. Reviewed and refactored by Nikita //

import java.util.ArrayList;
import java.util.HashMap;

/**
*ShoppingCart subclass of Inventory
*/

public class ShoppingCart extends Inventory{

    private int cartID;
    private HashMap<Product, Integer> cartItems;

    /**
    *Default constructor for ShoppingCart
    */
    public ShoppingCart(int cartID){
        this.cartID = cartID;
        this.cartItems = new HashMap<>();
    }

    //Getters
    
    /**
    *Gets cart id
    *@return int, the cart id 
    */
    public int getCartID() {
        return cartID;
    }

    /**
    *Returns an arraylist of all the products in the cart
    *@return ArrayList<Product> all the products in the cart
    */
    public ArrayList<Product> getItems(){
        return new ArrayList<>(cartItems.keySet());
    }

    /**
    *Gets the amount of a certain product in the cart
    *@param pID int, the product id
    *@return int, the amount of that product in the cart
    */
    public int getCartAmount(int pID){
        for(Product p: cartItems.keySet()){
            if(p.getItemID() == pID){
                return cartItems.get(p);
            }
        }
        return 0;
    }

    /**
    *Gets all the cart products along with their id and amount
    *@return String, cart info
    */
    public String getCartInfo(){
        StringBuilder s = new StringBuilder();
        for(Product p : this.cartItems.keySet()){
            s.append(p.getItemName()).append(", ").append(this.cartItems.get(p)).append(", ID: ").append(p.getItemID()).append("\n");
        }
        return s.toString();
    }

    //Setters
    
    /**
    * Sets the cart's id
    *@param newID int, the new cart id
    */
    public void setCartID(int newID){
        this.cartID = newID;
    }

    //Other Methods

    /**
    *Adds product and its amount to cart
    *@param amount, int the amount of product to be added
    *@param ID int, the id of the specified product
    */
    public void addToCart(int amount, int ID){
            if (getProduct(ID).getItemID() != 0) {
                if(cartItems.get(getProduct(ID)) != null){
                    int total = amount + cartItems.get(getProduct(ID));
                    this.cartItems.put(getProduct(ID), total);
                } else {
                        this.cartItems.put(getProduct(ID), amount);
                }
                System.out.println("Item(s) successfully added to cart");
            } else {
                System.out.println("Item does not exist in inventory.");
            }
    }

    /**
    *Removes product and its amount to cart
    *@param amount, int the amount of product to be removed
    *@param ID int, the id of the specified product
    */
    public void removeFromCart(int amount, int ID){
        for(Product p: this.cartItems.keySet()){
            if (p.getItemID() == ID){
                int total = cartItems.get(getProduct(ID)) - amount;
                if(total > 0) {
                    this.cartItems.put(getProduct(ID), total);
                }
                else{
                    this.cartItems.remove(p);
                }
                System.out.println("Item(s) successfully removed from cart");
            }
        }

    }

    /**
    *Clears all the contents of cart
    */
    public void clearCart(){
        for(Product p: this.cartItems.keySet()){
            this.cartItems.remove(p);
        }
    }

}
