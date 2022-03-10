package com.company;
import java.util.Locale;

public class Custom extends Item {
    // public
    Custom()
    {
        custom_fields = new String[fields_max];
        fields_size = 0;
        fields_max = 100;
    }
    Custom(String rhs_custom, String rhs_item_name, String rhs_item_des, float rhs_item_price, boolean rhs_item_status)
    {
        super(rhs_item_name, rhs_item_des, rhs_item_price, rhs_item_status);
        fields_size = 0;
        fields_max = 10;
        custom_fields = new String[fields_max];
        insert(rhs_custom);
    }
    Custom(Custom rhs)
    {
        super(rhs.item_name, rhs.item_des, rhs.item_price, rhs.item_status);
        fields_size = 0;
        fields_max = 0;
        custom_fields = new String[fields_max];
        copy_custom_fields(rhs.custom_fields, rhs.fields_size, 0);
    }
    // display
    public boolean display()
    {
        if(item_display())
        {
            if (fields_size != 0)
            {
                System.out.println("Custom Ingredients");
                return display(0);
            }
        }
        return false;
    }
    // custom display
    private boolean display(int count)
    {
        // check custom string array
        if(fields_size == 0)
            return false;
        if(count == fields_size)
            return true;
        System.out.println("Include:\t\t\t\t\t" + custom_fields[count]);
        return display(count + 1);
    }
    public boolean update()
    {
        if (item_update_menu())
        {
            // display cooking style vars
            if(fields_size != 0)
            {
                // custom update menu
                System.out.println("5: Add Ingredient");
                System.out.println("6: Remove Ingredient");
                // custom update input
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
                return update_custom(user_num);
            }
        }
        else {
            System.out.println("Error:\t\t\t\t\t\tOut of Range");
            return update_input();
        }
    }
    protected boolean update_custom(int rhs)
    {
        if(fields_size != 0)
        {
            switch (rhs) {
                case 5 -> {
                    System.out.println("Current Ingredients:");
                    display(0);
                    System.out.println("Enter New Ingredient:");
                    String new_custom_string = valid_string_input();
                    insert(new_custom_string);
                    System.out.println("Updated Ingredients:");
                    display(0);
                    return true;
                }
                case 6 -> {
                    System.out.println("Current Ingredients:");
                    display(0);
                    System.out.println("Enter Ingredient to Remove:");
                    String remove_custom_string = valid_string_input();
                    if (remove(remove_custom_string, 0)) {
                        System.out.println("Updated Ingredients:");
                        display(0);
                        return true;
                    }
                    System.out.println("Error:\t\t\t\tIngredient Not Found. Try Again.");
                    return update_custom(rhs);
                }
            }
        }
        return false;
    }
    public boolean insert(String rhs_custom)
    {
        if(fields_size > fields_max)
            return false;
        custom_fields[fields_size] = new String(rhs_custom);
        fields_size = fields_size + 1;
        return true;
    }
    public boolean remove(String rhs_custom, int count)
    {
        if(fields_size == 0)
            return false;
        if(fields_size == count)
            return false;
        if(count == 0)
        {
            rhs_custom.replaceAll("\\s+","");
        }
        String custom_string = custom_fields[count].toLowerCase(Locale.ROOT);
        rhs_custom.toLowerCase(Locale.ROOT);
        custom_string.replaceAll("\\s+","");
        if (custom_string.equals(rhs_custom))
        {
            custom_fields[count] = null;
            shift_custom_fields(count);
        } else {
            return remove(rhs_custom, count + 1);
        }
        return true;
    }
    protected boolean shift_custom_fields(int index)
    {
        if(index == fields_size) {
            fields_size = fields_size - 1;
            return true;
        }
        custom_fields[index] = custom_fields[index + 1];
        return shift_custom_fields(index + 1);
    }
    protected  boolean copy_custom_fields(String [] rhs, int rhs_fields_size, int count){
        if(count > rhs_fields_size)
        {
           return true;
        }
        insert(rhs[count]);
        count = count + 1;
        return copy_custom_fields(rhs, rhs_fields_size, count);
    }
    // custom vars
    protected String[] custom_fields;
    protected int fields_size;
    protected int fields_max;
}
