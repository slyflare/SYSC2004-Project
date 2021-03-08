import java.util.Scanner;
import java.util.ArrayList;


public class StoreView {

    private ShoppingCart cart;
   // public static ArrayList<ShoppingCart> cartList;

    public StoreView(ShoppingCart cart){
        this.cart = cart;
    }

    //delet_this
    public ShoppingCart getCart() {
        return cart;
    }

    public static void main(String[] args) {
        StoreManager sm = new StoreManager();
        sm.initializeCart();


        boolean done = false;
        while(done == false) {
            System.out.println("What would you like your new cart ID to be?");
            Scanner s = new Scanner(System.in);
            int newID = Integer.parseInt(s.nextLine());

            sm.cartList.add(sm.newCart(newID));

            System.out.println("Would you like to add another cart?");
            System.out.println("Type y for yes and n for no");

            Scanner b = new Scanner(System.in);
            String choice = b.nextLine();
            if(choice.compareTo("n") == 0){
                done = true;
            }


        }
        System.out.print("Your current cart(s) are: ");
        for (ShoppingCart c : sm.cartList) {
            int cartID = c.getCartID();
            System.out.print(cartID + " ");
        }


        // StoreView[] users = {sv1,sv2,sv3};


        /*scanner example
        Scanner s = new Scanner(System.in);
        System.out.println("Name?");
        String name = s.nextLine();
        System.out.println("Name is " + name);

         */
    }
}

// THIS PART GOES IN STORE MANAGER

  //Shopping cart methods
    public void initializeCart(){
        this.cartList = new ArrayList<>();

    }
    public ShoppingCart newCart(int newID){
        ShoppingCart cart = new ShoppingCart(newID);
        return cart;
    }





