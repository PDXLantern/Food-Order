package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Custom test_custom;
        test_custom = new Custom("Tomatoes", "Pizza", "Chicken Pan Pizza", 20.99f, true);
        test_custom.display();
        Node test_node = new Node();
        test_node.insert(test_custom);
        test_node.display();
    }
}
