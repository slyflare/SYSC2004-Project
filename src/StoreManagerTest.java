package storetest;

import org.junit.*;
import org.junit.jupiter.api.Assertions;
import store.Product;
import store.StoreManager;
import store.ShoppingCart;
import store.Inventory;

import java.util.ArrayList;

public class StoreManagerTest {
    StoreManager sm;
    ShoppingCart cart;

    @Before
    public void init(){
        sm = new StoreManager();
    }

    @Test
    public void checkStock(){
        assert sm.checkStock("Durian") == 1 : "checkStock didn't return the correct amount";
    }

    @Test
    public void getInventory(){
        ArrayList<Product> test = new ArrayList<>();
        assert sm.getInventory().getStock(1) == 10 : "Inventory was not returned";
        assert sm.getInventory().getStock(2) == 15 : "Inventory was not returned";
        assert sm.getInventory().getStock(3) == 20 : "Inventory was not returned";
        assert sm.getInventory().getStock(4) == 50 : "Inventory was not returned";
        assert sm.getInventory().getStock(5) == 1 : "Inventory was not returned";

    }

    @Test
    public void verifyCheckOut(){
        cart = new ShoppingCart(1);
        cart.addToCart(1,5);
        assert sm.verifyCheckOut(cart) : "verifyCheckout didn't properly check through the Inventory of StoreManager";
    }

    @Test
    public void checkOut(){
        cart = new ShoppingCart(1);
        String test = "Total price: $100.0";
        cart.addToCart(1,5);
        assert test.compareTo(sm.checkOut(cart)) == 0 : "Checkout statement was wrong";
    }

    @Test
    public void newCart(){
        cart = sm.newCart();
        assert cart.getCartID() == 1 : "newCart returned ShoppingCart with wrong id";
    }
}
