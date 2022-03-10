package com.company;

public class Node {
    Node()
    {
        next = null;
    }
    public boolean display()
    {
        if(custom_data != null || spicy_data != null || cook_style_data != null)
        {
            System.out.println("Node Data:");
            if(custom_data != null)
                return custom_data.display();
            if(spicy_data != null)
                return spicy_data.display();
            if(cook_style_data != null)
                return cook_style_data.display();;
        }
        return false;
    }
    public boolean insert(Custom rhs){
        if(custom_data == null)
        {
            custom_data = new Custom(rhs);
            return true;
        }
        return false;
    }
    // Node Var
    Node next;
    Custom custom_data;
    Spicy spicy_data;
    CookStyle cook_style_data;
}
