// Nikita Volochay 101162520 //
// Vimal Gunasegaran 101155249//

// Coded by Nikita. Reviewed and refactored by Vimal//

import java.util.Scanner;
import java.util.ArrayList;

public class StoreView {

    private ShoppingCart cart;
    private StoreManager storeMan;

    /**
     *Default StoreView constructor
     */
    public StoreView(StoreManager storeMan) {
        this.storeMan = storeMan;
        this.cart = storeMan.newCart();
    }

    /**
     * Input verification exception handling method that ensures user input is a valid integer.
     * @return Returns user input in the form of an int.
     */
    public int verifyNumInput(){
        boolean correctInput = false;
        int output = 0;
        while(!correctInput) {
            try {
                Scanner newItem = new Scanner(System.in);

                output = Integer.parseInt(newItem.nextLine());
                correctInput = true;
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid input integer");
            }
        }
        return output;
    }


    /**
     *Gets the shopping cart attached to store view
     *@return ShoppingCart, the cart for this storeview
     */
    public ShoppingCart getCart() {
        return cart;
    }

    public static void main(String[] args) {
        StoreManager sm = new StoreManager();
        ArrayList<StoreView> viewList = new ArrayList<>();
        StoreView sv = new StoreView(sm);

        System.out.println("\n");
        System.out.println("Welcome to our store!");
        System.out.println("Your new cart ID is: " + sv.getCart().getCartID());


        System.out.println("\n");
        System.out.println("Our current inventory contains:");
        for (Product p : sm.getInventory().getProductList()) {
            System.out.println(sm.getInventory().getProductInfo(p));
        }

        boolean done = false;
        while (!done) {
            System.out.println("------------------------------------------------------");
            System.out.println("To add an item to your cart, type add");
            System.out.println("To remove an item from your cart, type remove");
            System.out.println("To view our inventory again, type view");
            System.out.println("To view your cart, type cart");
            System.out.println("To check out, type out");
            System.out.println("To exit the store, type exit");

            Scanner x = new Scanner(System.in);
            String storeChoice = x.nextLine();

            if (storeChoice.compareTo("add") == 0) {
                System.out.println("------------------------------------------------------");
                System.out.println("Enter the item ID of the item you would like to add");

                    int itemChoice = sv.verifyNumInput();

                    if (sm.getInventory().getStock(itemChoice) != -1) {

                        System.out.println("There are currently " + sm.getInventory().getStock(itemChoice) + " " + sm.getInventory().getProduct(itemChoice).getItemName() + " in stock.");
                        System.out.println("How many would you like to add to your cart?");

                        int addItems = sv.verifyNumInput();

                        sv.getCart().addToCart(addItems, itemChoice);
                    }

            } else if (storeChoice.compareTo("remove") == 0) {
                System.out.println("------------------------------------------------------");
                System.out.println("Enter the item ID of the item you would like to remove");
                int itemChoice = sv.verifyNumInput();

                if(sv.getCart().getCartAmount(itemChoice) != 0) {
                    System.out.println("You currently have " + sv.getCart().getCartAmount(itemChoice) + " in your cart.");
                    System.out.println("How many would you like to remove?");
                    System.out.println("Please note that removing any more than you have will fully remove the item.");

                    int removeItems = sv.verifyNumInput();
                    sv.getCart().removeFromCart(removeItems, itemChoice);
                }
                else{
                    System.out.println("There is no item(s) with such an id currently in your cart.");
                }

            } else if (storeChoice.compareTo("view") == 0) {
                System.out.println("------------------------------------------------------");
                for (Product p : sm.getInventory().getProductList()) {
                    System.out.println(sm.getInventory().getProductInfo(p));
                }
            } else if (storeChoice.compareTo("cart") == 0) {
                System.out.println("------------------------------------------------------");
                if (sv.getCart().getCartInfo().compareTo("") == 0) {
                    System.out.println("Your cart is currently empty");
                } else {
                    System.out.println("Your cart currently contains:");
                    System.out.println(sv.getCart().getCartInfo());
                }
            } else if (storeChoice.compareTo("out") == 0) {
                System.out.println("------------------------------------------------------");
                boolean verification = false;
                verification = sm.verifyCheckOut(sv.getCart());
                if (verification == true) {
                    System.out.println(sm.checkOut(sv.getCart()));
                    System.out.println("Thank you for shopping with us today!");
                    sv.getCart().clearCart();
                    done = true;
                }
            } else if (storeChoice.compareTo("exit") == 0) {
                done = true;
            } else {
                System.out.println("Please enter a valid command");
            }

        }
    }
}
