package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("Custom");
        Custom test_custom;
        test_custom = new Custom("Tomatoes", "Pizza", "Chicken Pan Pizza", 20.99f, true);
        test_custom.display();
        System.out.println();
        test_custom.update();

        System.out.println();
        System.out.println("Spicy");
        Spicy test_spicy;
        test_spicy = new Spicy(5, "Habanero", "Super Spicy Dry Sauce", "Wings", "8 Piece Boneless Wings", 10.99f, true);
        test_spicy.display();
        System.out.println();
        test_spicy.update();
        test_spicy.display();

        System.out.println();
        System.out.println("Cook Style");

        CookStyle test_cook_style;
        test_cook_style = new CookStyle("Well Done", 145, "New York Steak", "Delicious Fresh Steak",  40.99f, true);
        test_cook_style.display();
        System.out.println();
        test_cook_style.update();
        test_cook_style.display();
    }
}
