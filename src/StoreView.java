import java.util.Scanner;

public class StoreView {

    private ShoppingCart cart;

    public StoreView(ShoppingCart cart){
        this.cart = cart;
    }

    //delet_this
    public ShoppingCart getCart() {
        return cart;
    }

    public static void main(String[] args) {

        StoreManager sm = new StoreManager();
        ShoppingCart cart1 = sm.initialiseCart();
        ShoppingCart cart2 = sm.initialiseCart();
        ShoppingCart cart3 = sm.initialiseCart();
        StoreView sv1 = new StoreView(cart1);
        StoreView sv2 = new StoreView(cart2);
        StoreView sv3 = new StoreView(cart3);
        StoreView[] users = {sv1,sv2,sv3};

        System.out.println("test");
        System.out.println(sv1.getCart().getCartID());
        System.out.println(sv2.getCart().getCartID());
        System.out.println(sv3.getCart().getCartID());

        //scanner example
        Scanner s = new Scanner(System.in);
        System.out.println("Name?");
        String name = s.nextLine();
        System.out.println("Name is " + name);
    }
}


