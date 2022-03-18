package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Menu {
    Menu(){
        main_menu = new List();
        main_menu_size = 0;
        menu_tags_size = 0;
        menu_tags = new String[100];
        menu_name = null;
    }
    Menu(String rhs_menu_name){
        main_menu = new List();
        main_menu_size = 0;
        menu_tags_size = 0;
        menu_tags = new String[100];
        menu_name = rhs_menu_name;
    }

    Menu(Menu rhs)
    {
        main_menu = new List();
        menu_tags = new String[100];
        menu_name = rhs.menu_name;
        // copy LLL
        main_menu.copy(rhs.main_menu);
        // copy string array
        menu_copy_tags(menu_tags, rhs.menu_tags, 0);
    }
    public void load_file(String data_file_name)
    {
        try {
            File myObj = new File(data_file_name);
            Scanner myReader = new Scanner(myObj);
            int class_type = myReader.nextInt();
            switch (class_type) {
                case 1 -> {
                    myReader.nextLine();
                    create_custom_menu(myReader);
                }
                case 2 -> {
                    myReader.nextLine();
                    create_spicy_menu(myReader);
                }
                case 3 -> {
                    myReader.nextLine();
                    create_cookstyle_menu(myReader);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public boolean create_custom_menu(Scanner data_reader){
        if (!data_reader.hasNextLine()) {
            return true;
        }
        String temp_item_name = null;
        if(data_reader.hasNextLine()) {
            temp_item_name = data_reader.nextLine();
        }
        String temp_item_des = null;
        if(data_reader.hasNextLine()) {
            temp_item_des = data_reader.nextLine();
        }
        float temp_item_price = 0;
        if(data_reader.hasNextLine()) {
            temp_item_price = Float.parseFloat(data_reader.nextLine());
        }
        boolean temp_item_status = false;
        if(data_reader.hasNextLine()) {
            temp_item_status = Boolean.parseBoolean((data_reader.nextLine()));
        }
        Custom temp_custom= new Custom(temp_item_name, temp_item_des, temp_item_price, temp_item_status);
        Node temp_node = new Node();
        temp_node.insert(temp_custom);
        main_menu.insert(temp_node);
        main_menu_size +=1;
        if(data_reader.hasNextLine()){
            create_custom_menu(data_reader);
        }
        return true;
    }
    public boolean create_spicy_menu(Scanner data_reader){
        if (!data_reader.hasNextLine()) {
            return true;
        }
        int temp_spicy_level = 0;
        if(data_reader.hasNextLine()) {
            temp_spicy_level = data_reader.nextInt();
        }
        data_reader.nextLine();
        String temp_spicy_name = null;
        if(data_reader.hasNextLine()) {
            temp_spicy_name = data_reader.nextLine();
        }
        String temp_spicy_des = null;
        if(data_reader.hasNextLine()) {
            temp_spicy_des = data_reader.nextLine();
        }
        String temp_item_name = null;
        if(data_reader.hasNextLine()) {
            temp_item_name = data_reader.nextLine();
        }
        String temp_item_des = null;
        if(data_reader.hasNextLine()) {
            temp_item_des = data_reader.nextLine();
        }
        float temp_item_price = 0;
        if(data_reader.hasNextLine()) {
            temp_item_price = Float.parseFloat(data_reader.nextLine());
        }
        boolean temp_item_status = false;
        if(data_reader.hasNextLine()) {
            temp_item_status = Boolean.parseBoolean((data_reader.nextLine()));
        }
        Spicy temp_spicy= new Spicy(temp_spicy_level, temp_spicy_name, temp_spicy_des, temp_item_name, temp_item_des, temp_item_price, temp_item_status);
        Node temp_node = new Node();
        temp_node.insert(temp_spicy);
        main_menu.insert(temp_node);
        main_menu_size +=1;
        if(data_reader.hasNextLine()){
            create_spicy_menu(data_reader);
        }
        return true;
    }
    public boolean create_cookstyle_menu(Scanner data_reader){
        if (!data_reader.hasNextLine()) {
            return true;
        }
        String temp_style_name = null;
        if(data_reader.hasNextLine()) {
            temp_style_name = data_reader.nextLine();
        }
        int temp_temp = 0;
        if(data_reader.hasNextLine()) {
            temp_temp = data_reader.nextInt();
        }
        data_reader.nextLine();
        String temp_item_name = null;
        if(data_reader.hasNextLine()) {
            temp_item_name = data_reader.nextLine();
        }
        String temp_item_des = null;
        if(data_reader.hasNextLine()) {
            temp_item_des = data_reader.nextLine();
        }
        float temp_item_price = 0;
        if(data_reader.hasNextLine()) {
            temp_item_price = Float.parseFloat(data_reader.nextLine());
        }
        boolean temp_item_status = false;
        if(data_reader.hasNextLine()) {
            temp_item_status = Boolean.parseBoolean((data_reader.nextLine()));
        }
        CookStyle temp_cook_style= new CookStyle(temp_style_name, temp_temp, temp_item_name, temp_item_des, temp_item_price, temp_item_status);
        Node temp_node = new Node();
        temp_node.insert(temp_cook_style);
        main_menu.insert(temp_node);
        main_menu_size +=1;
        if(data_reader.hasNextLine()){
            create_cookstyle_menu(data_reader);
        }
        return true;
    }
    public boolean display(){
        if(main_menu != null)
        {
            System.out.println();
            System.out.println("Menu:\t\t\t\t\t\t" + menu_name);
            main_menu.display();
            return true;
        }
        System.out.println("No Menu Data");
        return false;
    }
    public boolean insert(List rhs){
        main_menu.copy(rhs);
        return true;
    }
    public boolean remove(String rhs){
        if(main_menu != null)
        {
            return main_menu.remove(rhs);
        }
        return false;
    }
    public boolean search(String rhs){
        return search_tags(rhs);
    }
    public boolean compare(String rhs){
        if(menu_name != null){
            if(rhs != null){
                String rhs_lower_case = rhs.toLowerCase(Locale.ROOT);
                String rhs_no_spaces = rhs_lower_case.replaceAll("\\s+","");

                String menu_name_lower_case = menu_name.toLowerCase(Locale.ROOT);
                String menu_name_no_spaces = menu_name_lower_case.replaceAll("\\s+", "");

                return menu_name_no_spaces.equals(rhs_no_spaces);
            }
        }
        return true;
    }
    public boolean tags()
    {
        if(main_menu != null) {
            String[] temp = main_menu.list_tags();
            return menu_copy_tags(menu_tags, temp, 0);
        }
        return false;
    }
    public boolean search_tags(String rhs){
        if(menu_tags != null){
            String rhs_lower_case = rhs.toLowerCase(Locale.ROOT);
            String rhs_no_spaces = rhs_lower_case.replaceAll("\\s+","");
            return search_tags(rhs_no_spaces, 0);
        }
        return false;
    }
    public boolean search_tags(String rhs, int count){
        if(menu_tags_size == count)
            return false;
        String new_tag = menu_tags[count];
        String tag_lower_case = new_tag.toLowerCase(Locale.ROOT);
        String tag_no_spaces = tag_lower_case.replaceAll("\\s+", "");
        if(tag_no_spaces.equals(rhs)){
            display();
            return true;
        }
        return search_tags(rhs, count + 1);
    }
    public boolean menu_copy_tags(String [] lhs, String [] rhs, int count)
    {
        if(rhs[count] == null){
            return true;
        }
        if(rhs.length == count){
            return true;
        }
        lhs[menu_tags_size] = rhs[count];
        menu_tags_size += 1;
        return menu_copy_tags(lhs, rhs, count + 1);
    }
    public boolean menu_display_tags(int count)
    {
        if(count == menu_tags_size && count != 0)
        {
            return true;
        }
        if(menu_tags != null){
            System.out.println(menu_tags[count]);
            return menu_display_tags(count + 1);
        }
        return false;
    }
    public List select_menu_items(){
        main_menu.display();
        System.out.println();
        System.out.println("Enter the Full Item Name from Menu");
        List select_from_menu = new List();

        Scanner input = new Scanner(System.in);
        String menu_input = input.nextLine();
        Node Temp = main_menu.search(menu_input);
        if(Temp != null) {
            System.out.println("Would you like Edit the Item? (Y/N)");
            String edit_cmd = input.nextLine();

            if(edit_cmd.equals("Y") || edit_cmd.equals("y") || edit_cmd.equals("Yes"))
                Temp.update();
            select_from_menu.insert(Temp);
        }
        else
            System.out.println("Item was not found on the Menu");

        return select_from_menu;
    }

    // Menu vars
    protected String menu_name;
    protected List main_menu;
    protected int main_menu_size;
    protected String[] menu_tags;
    protected int menu_tags_size;
}
