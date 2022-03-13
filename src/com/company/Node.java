package com.company;

import java.util.Locale;

public class Node {
    Node()
    {
        next = null;
    }
    Node(Node rhs)
    {
        if(rhs != null)
        {
            if(rhs.custom_data != null)
                custom_data = new Custom(rhs.custom_data);
            if(rhs.spicy_data != null)
                spicy_data = new Spicy(rhs.spicy_data);
            if(rhs.cook_style_data != null)
                cook_style_data = new CookStyle(rhs.cook_style_data);
            next = null;
        }
    }
    public boolean link_next(Node rhs)
    {
        next = (rhs);
        return true;
    }
    public Node go_next()
    {
        if(next != null)
            return next;
        return null;
    }
    public boolean display()
    {
        if(custom_data != null || spicy_data != null || cook_style_data != null)
        {
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
    public boolean insert(Spicy rhs){
        if(spicy_data == null)
        {
            spicy_data = new Spicy(rhs);
            return true;
        }
        return false;
    }
    public boolean insert(CookStyle rhs){
        if(cook_style_data == null)
        {
            cook_style_data = new CookStyle(rhs);
            return true;
        }
        return false;
    }
    public boolean remove(){
        if(custom_data != null || spicy_data != null || cook_style_data != null)
        {
            custom_data = null;
            spicy_data = null;
            cook_style_data = null;
        }
        return false;
    }
    public boolean compare(Node rhs){
        if(custom_data != null & spicy_data != null & cook_style_data != null)
        {
            if(rhs.custom_data != null)
            {
                //return (custom_data.compare(rhs.custom_data));
            }
            if(rhs.spicy_data != null)
            {
                //return (spicy_data.compare(rhs.spicy_data));
            }
            if(rhs.cook_style_data != null)
            {
                //return (cook_style_data.compare(rhs.cook_style_data));
            }
        }
        return false;
    }
    public boolean compare(String rhs){
        if(custom_data != null)
        {
            return custom_data.compare(rhs);
        }
        if(spicy_data != null)
        {
            return spicy_data.compare(rhs);
        }
        if(cook_style_data != null)
        {
            return cook_style_data.compare(rhs);
        }
        return false;
    }
    public  String [] node_tags (){
        if(custom_data != null)
        {
            return custom_data.item_tag();
        }
        if(spicy_data != null)
        {
            return spicy_data.item_tag();
        }
        if(cook_style_data != null)
        {
            return cook_style_data.item_tag();
        }
        return null;
    }
    public boolean update()
    {
        if(custom_data != null)
        {
            return custom_data.update();
        }
        if(spicy_data != null)
        {
            return spicy_data.update();
        }
        if(cook_style_data != null)
        {
            return cook_style_data.update();
        }
        return false;
    }
    // Node Var
    protected Node next;
    protected Custom custom_data;
    protected Spicy spicy_data;
    protected CookStyle cook_style_data;
}
