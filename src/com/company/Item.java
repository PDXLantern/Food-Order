package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;

abstract class Item {
    // public
    Item()
    {
        item_name = null;
        item_des = null;
        item_price = 0.00f;
        item_status = false;
    }
    Item(String rhs_item_name, String rhs_item_des, float rhs_item_price, boolean rhs_item_status)
    {
        item_name = rhs_item_name;
        item_des = rhs_item_des;
        item_price = rhs_item_price;
        item_status = rhs_item_status;
    }
    // virtual functions
    abstract boolean display();
    abstract boolean update();
    protected boolean item_display()
    {
        if(item_name == null || item_des == null || item_price == 0.00f || !item_status)
            return false;
        System.out.println("Item Name:" + "\t\t\t\t\t" + item_name);
        System.out.println("Item Description:" + "\t\t\t" + item_des);
        System.out.println("Item Price:" + "\t\t\t\t\t" + item_price);
        if(item_status)
            System.out.println("Item Status:\t\t\t\tAvailable");
        else
            System.out.println("Item Status:\t\t\t\tOut of Stock");
        return true;
    }
    protected boolean item_update_menu()
    {
        if(item_name == null || item_des == null || item_price == 0.00f || !item_status)
        {
            return false;
        }
        // display base vars
        System.out.println("What would you like to Update: ");
        System.out.println("1: Item Name");
        System.out.println("2: Item Description");
        System.out.println("3: Item Price");
        System.out.println("4: Item Status");
        return true;
    }
    protected boolean item_update(int rhs)
    {
        System.out.println("Modifying Base");
        switch (rhs) {
            case 1 -> {
                System.out.println("Old Item Name:\t\t\t\t" + item_name);
                System.out.println("Enter New Item Name:\t\t\t\t");
                item_name = valid_string_input();
                System.out.println("New Item Name:\t\t\t\t" + item_name);
                return true;
            }
            case 2 -> {
                System.out.println("Old Item Des:\t\t\t\t" + item_des);
                System.out.println("Enter New Item Des:\t\t\t\t");
                item_des = valid_string_input();
                System.out.println("New Item Description:\t\t" + item_des);
                return true;
            }
            case 3 -> {
                System.out.println("Old Item Price:\t\t\t\t" + item_price);
                System.out.println("Enter New Item Price:\t\t\t\t");
                item_price = valid_float_input();
                System.out.println("New Item Price:\t\t\t\t" + item_price);
                return true;
            }
            case 4 -> {
                System.out.println("Old Item Status:\t\t\t" + item_status);
                System.out.println("Enter New Item Status (FALSE OR TRUE):\t\t\t");
                item_status = valid_boolean_input();
                System.out.println("New Item Status:\t\t\t" + item_status);
                return true;
            }
        }
        return false;
    }

    public int valid_int_input()
    {
        // custom update input
        Scanner input = new Scanner(System.in);
        int user_int;
        try {
            System.out.println("Enter Number:");
            user_int = input.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Error:\t\t\t\t\t\tInvalid Input!");
            return valid_int_input();
        }
        return user_int;
    }
    public float valid_float_input()
    {
        // custom update input
        Scanner input = new Scanner(System.in);
        float user_float;
        try {
            System.out.println("Enter Valid Price:");
            user_float = input.nextFloat();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Error:\t\t\t\t\t\tInvalid Input!");
            return valid_float_input();
        }
        return user_float;
    }
    public String valid_string_input()
    {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
    public boolean valid_boolean_input()
    {
        boolean user_boolean;
        try{
            Scanner input = new Scanner(System.in);
            user_boolean = input.nextBoolean();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Error:\t\t\t\t\t\tInvalid Input.");
            return valid_boolean_input();
        }
        return user_boolean;
    }
    // item vars
    protected String item_name;
    protected String item_des;
    protected float item_price;
    protected boolean item_status;
}

