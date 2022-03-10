package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /**
        Custom test_custom;
        test_custom = new Custom("Tomatoes", "Pizza", "Chicken Pan Pizza", 20.99f, true);
        test_custom.display();
        Node test_node = new Node();
        test_node.insert(test_custom);
        test_node.display();
        test_node.custom_data.update();
        test_node.display();
         **/
        /**
        Spicy test_spicy;
        test_spicy = new Spicy(5, "Habanero", "Super Spicy Dry Sauce", "Wings", "8 Piece Boneless Wings", 10.99f, true);
        test_spicy.display();
        Node test_node2 = new Node();
        test_node2.insert(test_spicy);
        test_node2.display();
         **/
        CookStyle test_cook_style;
        test_cook_style = new CookStyle("Well Done", 145, "New York Steak", "Delicious Fresh Steak",  40.99f, true);
        test_cook_style.display();
        Node test_node3 = new Node();
        test_node3.insert(test_cook_style);
        test_node3.display();
        test_node3.remove();
        System.out.println("Display After Remove");
        test_node3.display();

    }
}
