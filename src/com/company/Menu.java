package com.company;

public class Menu {
    Menu(){
        main_menu = null;
        cuisine = null;
    }
    public boolean display(){
        return true;
    }
    public boolean remove(){
        return true;
    }
    public boolean search(String rhs){
        return true;
    }
    public boolean compare(){
        return true;
    }
    // Menu vars
    protected List main_menu;
    protected String[] cuisine;
}
