// Vimal Gunasegaran 101155249 //
// Nikita Volochay 101162520 //

// Coded by Vimal. Reviewed and refactored by Nikita //

import java.util.ArrayList;

public class StoreManager {
    private Inventory inventory;
    private ArrayList<ShoppingCart> cartList;

    public StoreManager() {
        this.inventory = new Inventory();
        this.cartList = new ArrayList<>();
    }


    /*  public int checkStock(String name) {
            int id = 0;
            for (Product p : inventory.getProductList()) {
                if (p.getItemName().equals(name)) {
                    id = p.getItemID();
                }
            }
            return inventory.getStock(id);
        } */

    // Code above replaced with code below so that item id is not returned as 0 by default if item name not found.

    public int checkStock(String name) {
        for (Product p : inventory.getProductList()) {
            if (p.getItemName().equals(name)) {
                return inventory.getStock(p.getItemID());
            }
        }
        return -1;
    }


    public Inventory getInventory(){
        return this.inventory;
    }

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

        /* Changed code
        for (int[] c : cart) {
            for (Product p1 : inventory.getProductList()) {
                if (c[0] == p1.getItemID()) {
                    assert (c[1] < p1.getItemStock()) : "Not enough " + inventory.getProductInfo(p1.getItemID()) + " in stock";
                    inventory.sellStock(c[0], c[1]);
                    totalPrice += p1.getItemCost() * c[1];
                }
            }
        }*/

        return "Total price: $" + totalPrice;
    }

    //Shopping cart methods

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