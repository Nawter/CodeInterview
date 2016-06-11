package com.zaid.interviews.strings;

public class BinaryTree
{
    Node root; 
    Node findManager(String n1, String n2)
    {
        return findManager(root, n1, n2);
    }
 
    Node findManager(Node node, String n1, String n2)
    {
       
        if (node == null)
            return null; 
       
        if (node.data == n1 || node.data == n2)
            return node;
 
        
        Node l = findManager(node.left, n1, n2);
        Node r = findManager(node.right, n1, n2);
 
        
        if (l!=null && r!=null)
            return node; 
        
        return (l != null) ? l : r;
    }
}
 
