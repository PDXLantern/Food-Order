package com.company;

public class TreeNode {
    TreeNode()
    {
        left = null;
        right = null;
    }
    TreeNode(TreeNode rhs)
    {
        if(rhs != null)
        {
            if(rhs.menu_data != null)
                menu_data = new Menu(rhs.menu_data);
            left = null;
            right = null;
        }
    }
    public boolean link_left(TreeNode left_node)
    {
        left = (left_node);
        return true;
    }
    public boolean link_right(TreeNode right_node)
    {
        right = (right_node);
        return true;
    }
    public TreeNode go_left()
    {
        if(left != null)
            return left;
        return null;
    }
    public TreeNode go_right()
    {
        if(right != null)
            return right;
        return null;
    }
    public boolean display()
    {
        if(menu_data != null)
        {
            return menu_data.display();
        }
        return false;
    }
    public boolean insert(Menu rhs){
        if(menu_data == null){
            menu_data = new Menu(rhs);
            return true;
        }
        return false;
    }
    public boolean remove(){
        if(menu_data != null)
        {
            menu_data = null;
        }
        return false;
    }
    public boolean compare(TreeNode rhs){
        return false;
    }
    public boolean compare(String rhs){
        if(rhs != null){
            return menu_data.compare(rhs);
        }
        return false;
    }
    public  String [] node_tags (){
        return null;
    }
    public boolean update()
    {
        return false;
    }
    public List select()
    {
        return menu_data.select_menu_items();
    }
    // Node Var
    protected TreeNode left;
    protected TreeNode right;
    protected Menu menu_data;
}
