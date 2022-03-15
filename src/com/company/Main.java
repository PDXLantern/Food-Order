package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Welcome to Northwest Food Carts!");
        BST all_menus = new BST();
        all_menus.load_menus();

        Order user = new Order();
        System.out.println("0. Exit Program");
        System.out.println("1. Display Menus");
        System.out.println("2. Display Current Order");
        System.out.println("3. Add to Order");
        System.out.println("4. Remove Order");
        System.out.println("5. Search for Food");
        System.out.println("6. Checkout");

        int cmd = valid_int_input();

        while(cmd != 0 && cmd != 6)
        {
            switch (cmd) {
                case 1 -> {
                    System.out.println("Display Menus");
                    all_menus.display();
                }
                case 2 -> {
                    System.out.println("Current Order");
                    user.display();
                }
                case 3 -> {
                    System.out.println("Add to Order");
                    System.out.println("Which Menu would you like to Select from?");
                    System.out.println("1. Pizza Place");
                    System.out.println("2. Wings Place");
                    System.out.println("3. Steak Place");
                    int menu_cmd = valid_int_input();
                    switch (menu_cmd) {
                        case 1 -> {
                            user.add(all_menus.select("Pizza Palace"));
                        }
                        case 2 -> {
                            user.add(all_menus.select("Blaze Wings"));
                        }
                        case 3 -> {
                            user.add(all_menus.select("Fancy Steaks"));
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Enter the Item Name to Remove from Order:");
                    String item_remove = valid_string_input();
                    if(user.remove(item_remove))
                        System.out.println("Item Removed");
                    else
                        System.out.println("Item Not Found");
                }
                case 5 -> {
                    System.out.println("What are you in the Mood for?:");
                    String item_remove = valid_string_input();
                }
            }
            System.out.println();
            System.out.println("0. Exit Program");
            System.out.println("1. Display Menus");
            System.out.println("2. Display Current Order");
            System.out.println("3. Add to Order");
            System.out.println("4. Remove Order");
            System.out.println("5. Checkout");
            System.out.println();
            cmd = valid_int_input();
        };
        if(cmd == 5){
            System.out.println("Final Order");
            user.display();
        }
        System.out.println("Exiting Program...");

    }
    public static int valid_int_input()
    {
        // custom update input
        Scanner input = new Scanner(System.in);
        int user_int;
        try {
            System.out.println("Enter Command:");
            user_int = input.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Error:\t\t\t\t\t\tInvalid Input!");
            return valid_int_input();
        }
        return user_int;
    }
    public static String valid_string_input()
    {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}

