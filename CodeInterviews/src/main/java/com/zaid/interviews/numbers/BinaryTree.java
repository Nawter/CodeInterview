package com.zaid.interviews.numbers;

public class BinaryTree
{
    Node root; 
    Node findLCA(int n1, int n2)
    {
        return findLCA(root, n1, n2);
    }
 
    Node findLCA(Node node, int n1, int n2)
    {
       
        if (node == null)
            return null; 
       
        if (node.data == n1 || node.data == n2)
            return node;
 
        
        Node l = findLCA(node.left, n1, n2);
        Node r = findLCA(node.right, n1, n2);
 
        
        if (l!=null && r!=null)
            return node; 
        
        return (l != null) ? l : r;
    }
}
 
