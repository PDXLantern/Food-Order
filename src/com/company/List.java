package com.company;

public class List {
    List()
    {
        head = null;
        list_tags = null;
        list_tags_size = 0;
        list_tags = new String[100];
    }
    public boolean copy(List rhs){
        if(rhs != null)
        {
            copy_list_items(rhs.head);
        }
        return false;
    }
    public boolean copy_list_items(Node current){
        if(current == null){
            return true;
        }
        insert(current);
        return copy_list_items(current.go_next());
    }
    public boolean display(){
        if(head != null)
        {
            return display(head);
        }
        System.out.println("No List Data");
        return false;
    }
    protected boolean display(Node rhs){
        if(rhs == null)
        {
            return true;
        }
        System.out.println();
        rhs.display();
        return display(rhs.go_next());
    }
    public boolean insert(Node rhs){
        if(rhs == null)
            return false;
        if(head == null)
            head = new Node(rhs);
        else {
            Node Temp = head;
            insert(Temp, rhs);
        }
        return true;
    }
    protected boolean insert(Node current, Node rhs){
        if(current.go_next() == null){
            Node Temp = new Node(rhs);
            current.link_next(Temp);
            return true;
        }
        return insert(current.go_next(), rhs);
    }
    public boolean remove(String rhs){
        if(head != null)
        {
            if(head.compare(rhs))
            {
                head = head.go_next();
                return true;
            }
            return remove(head, rhs);
        }
        return false;
    }
    protected boolean remove(Node current, String rhs){
        if(current.go_next() == null){
            if(current.compare(rhs))
            {
                current = null;
            }
            return false;
        }
        if(current.go_next().compare(rhs)){
            Node Temp = current.go_next();
            current.link_next(Temp.go_next());
            Temp = null;
            return true;
        }
        return remove(current.go_next(), rhs);
    }
    public Node search(String rhs){
        if(head != null)
        {
            return search(head, rhs);
        }
        return null;
    }
    protected Node search(Node rhs, String rhs_string){
        if(rhs == null)
        {
            return null;
        }
        if(rhs.compare(rhs_string))
        {
            return rhs;
        }
        return search(rhs.go_next(), rhs_string);
    }
    public boolean update(String rhs)
    {
        Node update_item = search(rhs);
        if(update_item != null){
            return update_item.update();
        }
        return false;
    }
    public boolean compare(){
        return true;
    }
    public String [] list_tags ()
    {
        if(head != null) {
            return list_all_tags(head);
        }
        return null;
    }
    public String [] list_all_tags(Node rhs){
        if(rhs == null)
        {
            return list_tags;
        }
        list_copy_tags(list_tags, rhs.node_tags(), 0);
        return list_all_tags(rhs.go_next());
    }
    public boolean list_copy_tags(String [] lhs, String [] rhs, int count)
    {
        if(rhs.length == count){
            return true;
        }
        lhs[list_tags_size] = rhs[count];
        list_tags_size += 1;
        return list_copy_tags(lhs, rhs, count + 1);
    }
    // List vars
    protected Node head;
    protected String [] list_tags;
    protected int list_tags_size;
}
