package com.company;

public class CookStyle extends Item {
    // public
    CookStyle()
    {
        cooking_style = null;
        cooking_temp = 0;
    }
    CookStyle(CookStyle rhs){
        super(rhs.item_name, rhs.item_des, rhs.item_price, rhs.item_status);
        cooking_style = rhs.cooking_style;
        cooking_temp = rhs.cooking_temp;
    }
    CookStyle(String rhs_cooking_style, int rhs_cooking_temp, String rhs_item_name, String rhs_item_des, float rhs_item_price, boolean rhs_item_status)
    {
        super(rhs_item_name, rhs_item_des, rhs_item_price, rhs_item_status);
        cooking_style = rhs_cooking_style;
        cooking_temp = rhs_cooking_temp;
    }
    public boolean display() {
        if(item_display())
        {
            if (cooking_style != null || cooking_temp != 0)
            {
                System.out.println("Cooking Style:\t\t\t\t" + cooking_style);
                System.out.println("Cooking Temp:\t\t\t\t" + cooking_temp);
                return true;
            }
        }
        return false;
    }
    public boolean update()
    {
        if(item_update_menu()) {
            if (cooking_style != null || cooking_temp != 0) {
                // display cooking style vars
                System.out.println("5: Cooking Style");
                System.out.println("6: Cooking Temperature");
                return update_input();
            }
        }
        return false;
    }
    protected boolean update_input()
    {
        int user_num = valid_int_input();
        if(user_num < 7) {
            System.out.println("Selected:\t\t\t\t\t" + user_num);
            if (user_num <= 4) {
                return item_update(user_num);
            } else {
                System.out.println("Custom Base");
                return update_cook_style(user_num);
            }
        }
        else {
            System.out.println("Error:\t\t\t\t\t\tOut of Range");
            return update_input();
        }
    }
    protected boolean update_cook_style(int rhs)
    {
        if(cooking_style != null & cooking_temp != 0)
        {
            switch (rhs) {
                case 5 -> {
                    System.out.println("Current Cook Style:\t\t\t" + cooking_style);
                    System.out.println("Enter New Cook Style:");
                    cooking_style = valid_string_input();
                    System.out.println("New Cook Style:\t\t\t\t" + cooking_style);
                    return true;
                }
                case 6 -> {
                    System.out.println("Current Cook Temp:\t\t\t" + cooking_temp);
                    System.out.println("Enter New Cook Temp:");
                    cooking_temp = valid_int_input();
                    System.out.println("New Cook Temp:\t\t\t\t" + cooking_temp);
                    return true;
                }
            }
        }
        return false;
    }
    // cook style vars
    protected String cooking_style;
    protected int cooking_temp;
}
