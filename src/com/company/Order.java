package com.company;

public class Order {
    Order(){
        order_name = null;
        order_list = new List();
    }
    public boolean display(){
        if(order_list != null)
        {
            System.out.println("Current Order:");
            return order_list.display();
        }
        return false;
    }
    public boolean add(List rhs){
        copy_list(order_list, rhs);
        return false;
    }
    public boolean remove(){

        return false;
    }
    protected boolean copy_list(List lhs, List rhs){
        return lhs.copy(rhs);
    }
    protected String order_name;
    protected List order_list;
}
