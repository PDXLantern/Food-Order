package com.company;

public class Spicy extends Item {
    // public
    Spicy()
    {
        spicy_level = 0;
        spicy_name = null;
        spicy_des = null;
    }
    Spicy(Spicy rhs){
        super(rhs.item_name, rhs.item_des, rhs.item_price, rhs.item_status);
        spicy_level = rhs.spicy_level;
        spicy_name = rhs.spicy_name;
        spicy_des = rhs.spicy_des;
    }
    Spicy(int rhs_spicy_level, String rhs_spicy_name, String rhs_spicy_des, String rhs_item_name, String rhs_item_des, float rhs_item_price, boolean rhs_item_status)
    {
        super(rhs_item_name, rhs_item_des, rhs_item_price, rhs_item_status);
        spicy_level = rhs_spicy_level;
        spicy_name = rhs_spicy_name;
        spicy_des = rhs_spicy_des;
    }
    public boolean display()
    {
        if(item_display())
        {
            if (spicy_name != null || spicy_des != null)
            {
                System.out.println("Spicy Level:\t\t\t\t" + spicy_level);
                System.out.println("Spicy Name:\t\t\t\t\t" + spicy_name);
                System.out.println("Spicy Description:\t\t\t" + spicy_des);
                return true;
            }
        }
        return false;
    }
    public boolean update()
    {
        if(item_update_menu())
        {
            if (spicy_name != null || spicy_des != null)
            {
                // display spicy vars
                System.out.println("5: Spicy Level");
                System.out.println("6: Spicy Name");
                System.out.println("7: Spicy Description");
                return update_input();
            }
        }
        return false;
    }
    protected boolean update_input()
    {
        int user_num = valid_int_input();
        if(user_num < 8) {
            System.out.println("Selected:\t\t\t\t\t" + user_num);
            if (user_num <= 4) {
                return item_update(user_num);
            } else {
                System.out.println("Custom Base");
                return update_spicy(user_num);
            }
        }
        else {
            System.out.println("Error:\t\t\t\t\t\tOut of Range");
            return update_input();
        }
    }
    protected boolean update_spicy(int rhs)
    {
        if(spicy_name != null || spicy_des != null)
        {
            switch (rhs) {
                case 5 -> {
                    System.out.println("Current Spicy Level:\t\t\t" + spicy_level);
                    System.out.println("Enter New Spicy Level:\t\t\t");
                    spicy_level = valid_int_input();
                    System.out.println("New Spicy Level:\t\t\t" + spicy_level);
                    return true;
                }
                case 6 -> {
                    System.out.println("Current Spicy Name:\t\t\t" + spicy_name);
                    System.out.println("Enter New Spicy Name:\t\t\t");
                    spicy_name = valid_string_input();
                    System.out.println("New Spicy Name:\t\t\t" + spicy_name);
                    return true;
                }
                case 7 -> {
                    System.out.println("Current Spicy Des:\t\t\t" + spicy_des);
                    System.out.println("Enter New Spicy Des:\t\t\t");
                    spicy_des = valid_string_input();
                    System.out.println("New Spicy Des:\t\t\t" + spicy_des);
                    return true;
                }
            }
        }
        return false;
    }
    // protected
    // spicy vars
    protected int spicy_level;
    protected String spicy_name;
    protected String spicy_des;
}
