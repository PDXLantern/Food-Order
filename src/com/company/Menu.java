package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {
    Menu(){
        main_menu = null;
        menu_tags_size = 0;
        menu_tags = new String[100];
    }
    Menu(Menu rhs)
    {
        // copy LLL
        // copy string array
    }
    public boolean load_file(String data_file_name)
    {
        try {
            File myObj = new File(data_file_name);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return true;
    }
    public boolean display(){
        if(main_menu != null)
        {
            System.out.println("Menu");
            main_menu.display();
            System.out.println();
            System.out.println("Menu Tags");
            menu_display_tags(0);
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
        return true;
    }
    public boolean compare(){
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
        System.out.println("Select Items from Menu");
        List select_from_menu = new List();

        Scanner input = new Scanner(System.in);
        String menu_input = input.nextLine();

        if(select_from_menu.insert(main_menu.search(menu_input)))
            select_from_menu.display();
        else
            System.out.println("Item was not found on the Menu");
        return select_from_menu;
    }

    // Menu vars
    protected List main_menu;
    protected String[] menu_tags;
    protected int menu_tags_size;
}
