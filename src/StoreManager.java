// Vimal Gunasegaran 101155249 //
// Nikita Volochay 101162520 //

// Coded by Vimal. Reviewed and refactored by Nikita //

/**
 *Manages most of what happens in the store
 */

import java.util.ArrayList;

public class StoreManager {
    private Inventory inventory;
    private ArrayList<ShoppingCart> cartList;

    /**
     *Default constructor of StoreManager
     */
    public StoreManager() {
        this.inventory = new Inventory();
        this.cartList = new ArrayList<>();
    }

    /**
     *checks the amount of stock given a product name
     *@param name String, the product name
     *@return int, the amount of stock of the given product, returns -1 if product doesn't exist
     */
    public int checkStock(String name) {
        for (Product p : inventory.getProductList()) {
            if (p.getItemName().compareTo(name) == 0) {
                return inventory.getStock(p.getItemID());
            }
        }
        return -1;
    }


    /**
     *Gets the StoreManagers inventory
     *@return Inventory, the StoreManagers inventory
     */
    public Inventory getInventory(){
        return this.inventory;
    }

    /**
     *Verifies if all the product amounts in a shoppingcart can be validly be deducted from products stock
     *@param cartCheck ShoppingCart, the shopping cart that is being checked
     *@return boolean, true if checkout is possible
     */
    public boolean verifyCheckOut(ShoppingCart cartCheck) {
        boolean checkStatus = true;
        for (Product c : cartCheck.getItems()) {
            if (cartCheck.getCartAmount(c.getItemID()) > inventory.getStock(c.getItemID())) {
                System.out.println("There is an insufficient amount of " + c.getItemName());
                System.out.println("Current stock: " + inventory.getStock(c.getItemID()) + ", Your request: " + cartCheck.getCartAmount(c.getItemID()));
                checkStatus = false;
            }
        }
        return checkStatus;
    }

    /**
     *Returns the total cost of a shopping cart
     *@param cart ShoppingCart, the cart to be checked
     *@return String, a string that say "Total price: $" + totalPrice
     */
    public String checkOut(ShoppingCart cart) {
        double totalPrice = 0;
        for (Product c: cart.getItems()) {
            for (Product p : inventory.getProductList()) {
                if (c.getItemID() == p.getItemID() && c.getItemName().equals(p.getItemName())){
                    inventory.sellStock(c.getItemID(), cart.getCartAmount(c.getItemID()));
                    totalPrice += c.getItemCost() * cart.getCartAmount(c.getItemID());
                }
            }
        }

        return "Total price: $" + totalPrice;
    }

    //Shopping cart methods

    /**
     *Initializes a new ShoppingCart and gives it a uniqueID
     *@return ShoppingCart, the new shopping cart
     */
    public ShoppingCart newCart(){
        int max = 0;
        for(ShoppingCart c : cartList){
            if(max < c.getCartID()){
                max = c.getCartID();
            }
        }
        int newID = max +1;
        ShoppingCart cart = new ShoppingCart(newID);
        cartList.add(cart);
        cart.setCartID(newID);
        return cart;
    }




}