package myStore;
// Nikita Volochay 101162520 //
// Vimal Gunasegaran 101155249//

// Main GUI coded by Vimal //
// Update Methods and Buttons coded by Nikita //

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class StoreView {

    private HashMap<Integer,Integer> tempItems;
    private ShoppingCart cart;
    private StoreManager storeMan;
    private final JFrame frame;
    private final JPanel mainPanel;
    private final JPanel headerPanel;
    private final JPanel itemPanel;
    private final JPanel item1;
    private final JPanel item2;
    private final JPanel item3;
    private final JPanel item4;
    private final JPanel item5;
    private final JPanel item1ButtonPanel;
    private final JPanel item2ButtonPanel;
    private final JPanel item3ButtonPanel;
    private final JPanel item4ButtonPanel;
    private final JPanel item5ButtonPanel;
    private final JTextPane item1Pane;
    private final JTextPane item2Pane;
    private final JTextPane item3Pane;
    private final JTextPane item4Pane;
    private final JTextPane item5Pane;
    private final JPanel bottomPanel;
    private final JPanel cartPanel;
    private final JPanel cartHeader;
    private final JPanel cartDisplayPanel;
    private final JTextPane cartDisplay;
    private final JPanel checkOutDisplay;


    /**
     *Default StoreView constructor
     */
    public StoreView(StoreManager storeMan) {
        this.storeMan = storeMan;
        this.cart = storeMan.newCart();

        //gui
        this.frame = new JFrame();
        this.headerPanel = new JPanel();
        this.mainPanel = new JPanel();
        this.itemPanel = new JPanel();
        this.item1 = new JPanel(new GridLayout(4,0));
        this.item2 = new JPanel(new GridLayout(4,0));
        this.item3 = new JPanel(new GridLayout(4,0));
        this.item4 = new JPanel(new GridLayout(4,0));
        this.item5 = new JPanel(new GridLayout(4,0));
        this.item1ButtonPanel = new JPanel(new GridLayout());
        this.item2ButtonPanel = new JPanel(new GridLayout());
        this.item3ButtonPanel = new JPanel(new GridLayout());
        this.item4ButtonPanel = new JPanel(new GridLayout());
        this.item5ButtonPanel = new JPanel(new GridLayout());
        this.item1Pane = new JTextPane();
        this.item2Pane = new JTextPane();
        this.item3Pane = new JTextPane();
        this.item4Pane = new JTextPane();
        this.item5Pane = new JTextPane();
        this.bottomPanel = new JPanel();
        this.cartDisplayPanel = new JPanel();
        this.cartDisplay = new JTextPane();
        this.cartPanel = new JPanel(new BorderLayout());
        this.cartHeader = new JPanel();
        this.checkOutDisplay = new JPanel();
        this.tempItems = new HashMap<>();
        this.tempItems.put(1,storeMan.getInventory().getProductQuantity(storeMan.getInventory().getProduct(1)));
        this.tempItems.put(2,storeMan.getInventory().getProductQuantity(storeMan.getInventory().getProduct(2)));
        this.tempItems.put(3,storeMan.getInventory().getProductQuantity(storeMan.getInventory().getProduct(3)));
        this.tempItems.put(4,storeMan.getInventory().getProductQuantity(storeMan.getInventory().getProduct(4)));
        this.tempItems.put(5,storeMan.getInventory().getProductQuantity(storeMan.getInventory().getProduct(5)));
    }

    /**
     * Displays the GUI
     */
    public void displayGUI() {
        frame.setTitle("「Fruit Stand」");

        //Fruit display building
        JLabel headerLabel = new JLabel("Fruits for sale! Cart ID: " + this.cart.getCartID());
        headerPanel.add(headerLabel, BorderLayout.PAGE_START);
        headerPanel.setBackground(Color.GRAY);
        //maybe play with margin later
        itemPanel.setPreferredSize(new Dimension(1120,286));
        //delet_this later
        itemPanel.setBackground(Color.GRAY);

        item1.setPreferredSize(new Dimension(200,280));
        item2.setPreferredSize(new Dimension(200,280));
        item3.setPreferredSize(new Dimension(200,280));
        item4.setPreferredSize(new Dimension(200,280));
        item5.setPreferredSize(new Dimension(200,280));

        item1ButtonPanel.setPreferredSize(new Dimension(170,20));
        item2ButtonPanel.setPreferredSize(new Dimension(170,20));
        item3ButtonPanel.setPreferredSize(new Dimension(170,20));
        item4ButtonPanel.setPreferredSize(new Dimension(170,20));
        item5ButtonPanel.setPreferredSize(new Dimension(170,20));

        //removeFive button;
        item1ButtonPanel.add(removeFive(1));
        item2ButtonPanel.add(removeFive(2));
        item3ButtonPanel.add(removeFive(3));
        item4ButtonPanel.add(removeFive(4));
        item5ButtonPanel.add(removeFive(5));

        //removeOne button
        item1ButtonPanel.add(removeOne(1));
        item2ButtonPanel.add(removeOne(2));
        item3ButtonPanel.add(removeOne(3));
        item4ButtonPanel.add(removeOne(4));
        item5ButtonPanel.add(removeOne(5));

        //addOne button
        item1ButtonPanel.add(addOne(1));
        item2ButtonPanel.add(addOne(2));
        item3ButtonPanel.add(addOne(3));
        item4ButtonPanel.add(addOne(4));
        item5ButtonPanel.add(addOne(5));

        //addFive button
        item1ButtonPanel.add(addFive(1));
        item2ButtonPanel.add(addFive(2));
        item3ButtonPanel.add(addFive(3));
        item4ButtonPanel.add(addFive(4));
        item5ButtonPanel.add(addFive(5));

        JLabel item1Name = new JLabel("Apple $1.00", SwingConstants.CENTER);
        JLabel item2Name = new JLabel("Orange $2.50", SwingConstants.CENTER);
        JLabel item3Name = new JLabel("Banana $1.25", SwingConstants.CENTER);
        JLabel item4Name = new JLabel("Papaya $5.00", SwingConstants.CENTER);
        JLabel item5Name = new JLabel("Durian $100.00", SwingConstants.CENTER);

        JPanel item1Pic = new JPanel();
        item1Pic.add(new JLabel(new ImageIcon("src/myStore/Images/Apple.jpg")));
        item1Pic.setPreferredSize(new Dimension(170,50));
        JPanel item2Pic = new JPanel();
        item2Pic.add(new JLabel(new ImageIcon("src/myStore/Images/Orange.jpg")));
        JPanel item3Pic = new JPanel();
        item3Pic.add(new JLabel(new ImageIcon("src/myStore/Images/Banana.jpg")));
        JPanel item4Pic = new JPanel();
        item4Pic.add(new JLabel(new ImageIcon("src/myStore/Images/Papaya.jpg")));
        JPanel item5Pic = new JPanel();
        item5Pic.add(new JLabel(new ImageIcon("src/myStore/Images/Durian.jpg")));

        item1Pane.setPreferredSize(new Dimension(170,20));
        item2Pane.setPreferredSize(new Dimension(170,20));
        item3Pane.setPreferredSize(new Dimension(170,20));
        item4Pane.setPreferredSize(new Dimension(170,20));
        item5Pane.setPreferredSize(new Dimension(170,20));

        item1Pane.setText(String.format("Stock: " + this.tempItems.get(1)));
        item2Pane.setText(String.format("Stock: " + this.tempItems.get(2)));
        item3Pane.setText(String.format("Stock: " + this.tempItems.get(3)));
        item4Pane.setText(String.format("Stock: " + this.tempItems.get(4)));
        item5Pane.setText(String.format("Stock: " + this.tempItems.get(5)));
        item1Pane.setEditable(false);
        item2Pane.setEditable(false);
        item3Pane.setEditable(false);
        item4Pane.setEditable(false);
        item5Pane.setEditable(false);


        item1.add(item1Name);
        item1.add(item1Pic);
        item1.add(item1Pane);
        item1.add(item1ButtonPanel);
        item2.add(item2Name);
        item2.add(item2Pic);
        item2.add(item2Pane);
        item2.add(item2ButtonPanel);
        item3.add(item3Name);
        item3.add(item3Pic);
        item3.add(item3Pane);
        item3.add(item3ButtonPanel);
        item4.add(item4Name);
        item4.add(item4Pic);
        item4.add(item4Pane);
        item4.add(item4ButtonPanel);
        item5.add(item5Name);
        item5.add(item5Pic);
        item5.add(item5Pane);
        item5.add(item5ButtonPanel);

        itemPanel.add(item1);
        itemPanel.add(item2);
        itemPanel.add(item3);
        itemPanel.add(item4);
        itemPanel.add(item5);

        //cartDisplay
        JLabel cartDisplayLabel = new JLabel("Your Cart");
        cartHeader.add(cartDisplayLabel);
        cartPanel.setPreferredSize(new Dimension(707,280));
        cartDisplay.setText("Your cart is empty");
        cartDisplay.setEditable(false);
        cartDisplayPanel.setBackground(Color.WHITE);
        cartDisplayPanel.add(cartDisplay);
        cartPanel.add(cartHeader, BorderLayout.PAGE_START);
        cartPanel.add(cartDisplayPanel);

        //checkoutDisplay
        checkOutDisplay.setPreferredSize(new Dimension(307,280));
        JButton coButton = checkOutButton();
        coButton.setPreferredSize(new Dimension(307,280));
        coButton.setBackground(Color.GREEN);
        checkOutDisplay.add(coButton);
        checkOutDisplay.setBackground(Color.GRAY);
        checkOutDisplay.setAlignmentY(0);

        bottomPanel.add(cartPanel, BorderLayout.EAST);
        bottomPanel.add(checkOutDisplay, BorderLayout.WEST);
        bottomPanel.setBackground(Color.GRAY);

        mainPanel.setPreferredSize(new Dimension(1120,653));
        mainPanel.add(headerPanel, BorderLayout.PAGE_START);
        mainPanel.add(itemPanel);
        mainPanel.add(bottomPanel);
        mainPanel.setBackground(Color.GRAY);

        frame.setResizable(false);
        frame.add(mainPanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to quit?")
                        == JOptionPane.OK_OPTION) {
                    frame.setVisible(false);
                    frame.dispose();
                }
            }
        });

        frame.setVisible(true);
    }

    /**
     * Creates a button that adds one item
     * @param id id, product id
     * @return JButton, button
     */
    private JButton addOne(int id){
        JButton addOneButton = new JButton("+1");
        addOneButton.addActionListener(ae -> {
            if (tempItems.get(id) > 0) {
                updateTempStock(id, 1);
                this.cart.addToCart(1, id);
                this.updateCart();
            }
        });
        return addOneButton;
    }

    /**
     * Creates a button that adds five of one item
     * @param id id, product id
     * @return JButton, button
     */
    private JButton addFive(int id){
        JButton addFiveButton = new JButton("+5");
        addFiveButton.addActionListener(ae -> {
            if (tempItems.get(id) >= 5) {
                updateTempStock(id, 2);
                this.cart.addToCart(5, id);
                this.updateCart();
            }
            else if (tempItems.get(id) < 5 && tempItems.get(id) > 0){
                this.cart.addToCart(tempItems.get(id), id);
                updateTempStock(id, 2);
                this.updateCart();
            }
        });
        return addFiveButton;
    }

    /**
     * Creates a button that removes one item
     * @param id id, product id
     * @return JButton, button
     */
    private JButton removeOne(int id){
        JButton removeOneButton = new JButton("-1");
        removeOneButton.addActionListener(ae -> {
            updateTempStock(id, 3);
            this.cart.removeFromCart(1,id);
            this.updateCart();
        });
        return removeOneButton;
    }

    /**
     * Creates a button that removes five of one item
     * @param id id, product id
     * @return JButton, button
     */
    private JButton removeFive(int id){
        JButton removeFiveButton = new JButton("-5");
        removeFiveButton.addActionListener(ae -> {
            updateTempStock(id, 4);
            this.cart.removeFromCart(5,id);
            this.updateCart();
        });
        return removeFiveButton;
    }

    /**
     * creates a button for checkout
     * @return JButton, checkoutButton
     */
    private JButton checkOutButton(){
        JButton coButton = new JButton("Check Out");
        coButton.addActionListener(ae ->{
            double totalPrice = 0;
            for (Product c: cart.getItems()) {
                for (Product p : storeMan.getInventory().getProductList()) {
                    if (c.getItemID() == p.getItemID() && c.getItemName().equals(p.getItemName())){
                        totalPrice += c.getItemCost() * cart.getCartAmount(c.getItemID());
                    }
                }
            }
            if (JOptionPane.showConfirmDialog(this.frame, "Total price: $" + totalPrice)
                    == JOptionPane.OK_OPTION) {
                this.storeMan.checkOut(this.cart);
                frame.setVisible(false);
                frame.dispose();
            }
            updateCart();
        });
        return coButton;
    }

    // Verification and Updates

    /**
     * Updates the stock in the store GUI in real time
     * @param id id, Product id
     * @param command, command from 1-4 depicting add 1, add5, remove 1, remove 5 in that respective order
     */
    private void updateTempStock(int id, int command){

        for(int ID: this.tempItems.keySet()){
            if (ID == id){
                int total = 0;
                if(command == 1) {
                    if(this.tempItems.get(ID) >= 1) {
                        total = tempItems.get(ID) - 1;
                        this.tempItems.put(ID, total);
                    }
                }
                else if(command == 2){
                    if(this.tempItems.get(ID) >= 5) {
                        total = tempItems.get(ID) - 5;
                        this.tempItems.put(ID, total);
                    }
                    else if((this.tempItems.get(ID) - 5) < 0){
                        total = 0;
                        this.tempItems.put(ID, total);
                    }
                }
                else if(command == 3){
                    if(this.cart.getCartAmount(ID) >= 1) {
                        total = tempItems.get(ID) + 1;
                        this.tempItems.put(ID, total);
                    }
                }
                else if(command == 4){
                    if(this.cart.getCartAmount(ID) >= 5) {
                        total = tempItems.get(ID) + 5;
                        this.tempItems.put(ID, total);
                    }
                    else if(this.cart.getCartAmount(ID) < 5 && this.cart.getCartAmount(ID) > 0){
                        total = tempItems.get(ID) + this.cart.getCartAmount(ID);
                        this.tempItems.put(ID, total);
                    }
                }
            }
        }
        item1Pane.setText(String.format("Stock: " + this.tempItems.get(1)));
        item2Pane.setText(String.format("Stock: " + this.tempItems.get(2)));
        item3Pane.setText(String.format("Stock: " + this.tempItems.get(3)));
        item4Pane.setText(String.format("Stock: " + this.tempItems.get(4)));
        item5Pane.setText(String.format("Stock: " + this.tempItems.get(5)));
    }

    /**
     * Updates cartDisplayPane in real time
     */
    private void updateCart(){
        if (this.cart.getItems().size() == 0){
            this.cartDisplay.setText("Your cart is empty");
        }
        else{
            this.cartDisplay.setText(this.cart.getCartInfo());
        }
    }

    public static void main(String[] args) {
        StoreManager sm = new StoreManager();
        StoreView sv = new StoreView(sm);
        sv.displayGUI();
    }
}
