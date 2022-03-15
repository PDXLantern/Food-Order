package com.company;

public class BST {
    BST(){
        root = null;
    }
    public void load_menus()
    {
        Menu pizza_place = new Menu("Pizza Palace");
        pizza_place.load_file("src/com/company/Pizza.txt");
        pizza_place.tags();
        insert(pizza_place);

        Menu wings_place = new Menu("Blaze Wings");
        wings_place.load_file("src/com/company/Wings.txt");
        wings_place.tags();
        insert(wings_place);

        Menu steaks_place = new Menu("Fancy Steaks");
        steaks_place.load_file("src/com/company/Steaks.txt");
        steaks_place.tags();
        insert(steaks_place);
    }
    public List select(String rhs_string){
        if(root != null){
            if(root.compare(rhs_string))
                return root.select();

            List temp_left = select(root.go_left(), rhs_string);
            if(temp_left != null)
                return temp_left;

            List temp_right = select(root.go_right(), rhs_string);
            if(temp_right != null)
                return temp_right;
        }
        return null;
    }
    public List select(TreeNode rhs, String rhs_string){
        if(rhs == null){
            return null;
        }
        if(rhs.compare(rhs_string)){
            return rhs.select();
        }
        return null;
    }
    public boolean insert(Menu rhs){
        if(root == null){
            root = new TreeNode();
            BST_size++;
            return root.insert(rhs);
        }
        if(root.go_left() == null){
            TreeNode temp_left = new TreeNode();
            temp_left.insert(rhs);
            BST_size++;
            return root.link_left(temp_left);
        }
        if(root.go_right() == null){
            TreeNode temp_right = new TreeNode();
            temp_right.insert(rhs);
            BST_size++;
            return root.link_right(temp_right);
        }
        return false;
    }
    public boolean display()
    {
        if(root != null){
            root.display();
            display(root.go_left());
            display(root.go_right());
            return true;
        }
        return false;
    }
    public boolean display(TreeNode rhs){
        if(rhs == null){
            return false;
        }
        rhs.display();
        display(rhs.go_left());
        display(rhs.go_right());
        return true;
    }
    // BST Vars
    TreeNode root;
    protected int BST_size;
    protected int BST_height;
}
