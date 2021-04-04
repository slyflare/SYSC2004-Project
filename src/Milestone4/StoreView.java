package store;
// Nikita Volochay 101162520 //
// Vimal Gunasegaran 101155249//

// Coded by Nikita. Reviewed and refactored by Vimal//

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class StoreView {

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
    private final JPanel bottomPanel;
    private final JPanel cartDisplay;
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
        this.item1 = new JPanel(new BorderLayout());
        this.item2 = new JPanel(new BorderLayout());
        this.item3 = new JPanel(new BorderLayout());
        this.item4 = new JPanel(new BorderLayout());
        this.item5 = new JPanel(new BorderLayout());
        this.item1ButtonPanel = new JPanel(new GridLayout());
        this.item2ButtonPanel = new JPanel(new GridLayout());
        this.item3ButtonPanel = new JPanel(new GridLayout());
        this.item4ButtonPanel = new JPanel(new GridLayout());
        this.item5ButtonPanel = new JPanel(new GridLayout());
        this.bottomPanel = new JPanel();
        this.cartDisplay = new JPanel();
        this.checkOutDisplay = new JPanel();
    }

    /**
     *Gets the shopping cart attached to store view
     *@return ShoppingCart, the cart for this storeview
     */
    public ShoppingCart getCart() {
        return cart;
    }

    public void displayGUI() {
        frame.setTitle("「Fruit Stand」");

        //Fruit display building
        JLabel headerLabel = new JLabel("Fruits for sale!");
        headerPanel.add(headerLabel, BorderLayout.PAGE_START);
        //maybe play with margin later
        itemPanel.setPreferredSize(new Dimension(1120,286));
        //delet_this later
        itemPanel.setBackground(Color.BLACK);

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

        //addFive button
        item1ButtonPanel.add(addFive(1));
        item2ButtonPanel.add(addFive(2));
        item3ButtonPanel.add(addFive(3));
        item4ButtonPanel.add(addFive(4));
        item5ButtonPanel.add(addFive(5));

        //addOne button
        item1ButtonPanel.add(addOne(1));
        item2ButtonPanel.add(addOne(2));
        item3ButtonPanel.add(addOne(3));
        item4ButtonPanel.add(addOne(4));
        item5ButtonPanel.add(addOne(5));

        //removeOne button
        item1ButtonPanel.add(removeOne(1));
        item2ButtonPanel.add(removeOne(2));
        item3ButtonPanel.add(removeOne(3));
        item4ButtonPanel.add(removeOne(4));
        item5ButtonPanel.add(removeOne(5));

        //removeFive button;
        item1ButtonPanel.add(removeFive(1));
        item2ButtonPanel.add(removeFive(2));
        item3ButtonPanel.add(removeFive(3));
        item4ButtonPanel.add(removeFive(4));
        item5ButtonPanel.add(removeFive(5));

        item1.add(item1ButtonPanel, BorderLayout.SOUTH);
        item2.add(item2ButtonPanel, BorderLayout.SOUTH);
        item3.add(item3ButtonPanel, BorderLayout.SOUTH);
        item4.add(item4ButtonPanel, BorderLayout.SOUTH);
        item5.add(item5ButtonPanel, BorderLayout.SOUTH);

        itemPanel.add(item1);
        itemPanel.add(item2);
        itemPanel.add(item3);
        itemPanel.add(item4);
        itemPanel.add(item5);

        //cartDisplay
        JLabel cartDisplayLabel = new JLabel("Your Cart");
        cartDisplay.add(cartDisplayLabel);
        cartDisplay.setPreferredSize(new Dimension(507,280));
        //delet_this later
        cartDisplay.setBackground(Color.RED);

        //checkoutDisplay
        JLabel checkOutDisplayLabel = new JLabel("Checkout");
        checkOutDisplay.add(checkOutDisplayLabel);
        checkOutDisplay.setPreferredSize(new Dimension(507,280));
        //delet_this later
        checkOutDisplay.setBackground(Color.GREEN);

        bottomPanel.add(cartDisplay, BorderLayout.EAST);
        bottomPanel.add(checkOutDisplay, BorderLayout.WEST);
        bottomPanel.setBackground(Color.BLACK);

        mainPanel.setPreferredSize(new Dimension(1120,653));
        mainPanel.add(headerPanel, BorderLayout.PAGE_START);
        mainPanel.add(itemPanel);
        mainPanel.add(bottomPanel);
        mainPanel.setBackground(Color.BLACK);

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

    private JButton addOne(int id){
        JButton addOneButton = new JButton("+1");
        addOneButton.addActionListener(ae -> {
            this.cart.addToCart(1,id);
                });
        return addOneButton;
    }

    private JButton addFive(int id){
        JButton addFiveButton = new JButton("+5");
        addFiveButton.addActionListener(ae -> {
            this.cart.addToCart(5,id);
        });
        return addFiveButton;
    }

    private JButton removeOne(int id){
        JButton removeOneButton = new JButton("-1");
        removeOneButton.addActionListener(ae -> {
            this.cart.removeFromCart(1,id);
        });
        return removeOneButton;
    }

    private JButton removeFive(int id){
        JButton removeFiveButton = new JButton("-5");
        removeFiveButton.addActionListener(ae -> {
            this.cart.removeFromCart(5,id);
        });
        return removeFiveButton;
    }

    private JButton checkOutButton(){
        JButton coButton = new JButton("Check Out");
        coButton.addActionListener(ae ->{
            String text = this.storeMan.checkOut(this.cart);

        });
        return coButton;
    }

    public static void main(String[] args) {
        StoreManager sm = new StoreManager();
        StoreView sv = new StoreView(sm);
        sv.displayGUI();
    }
}
