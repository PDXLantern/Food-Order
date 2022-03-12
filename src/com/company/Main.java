package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Welcome to Northwest Food Carts!");
        Menu pizza_place = new Menu();
        pizza_place.load_file("Pizza.txt");
        pizza_place.display();
        /**
        Menu wings_place = new Menu();
        wings_place.load_file("Wings.txt");
        Menu steaks_place = new Menu();
        steaks_place.load_file("Steaks.txt");
         **/
        //Order user = new Order();


    }
}
