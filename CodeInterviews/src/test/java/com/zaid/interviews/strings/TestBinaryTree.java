package com.zaid.interviews.strings;

import org.junit.Test;

public class TestBinaryTree 
{
	@Test
	public void testBinaryTree_One()
	{
		 BinaryTree tree = new BinaryTree();
	        tree.root = new Node("Sarah");
	        tree.root.left = new Node("Fred");
	        tree.root.right = new Node("Raul");
	        tree.root.left.left = new Node("Hilary");
	        tree.root.left.right = new Node("Jenny");
	        tree.root.left.right.left = new Node("James");	        
	        System.out.println(tree.findManager("Hilary","James").data);	        
	}
	@Test
	public void testBinaryTree_Two()
	{
		 BinaryTree tree = new BinaryTree();
	        tree.root = new Node("Sarah");
	        tree.root.left = new Node("Claudiu");
	        tree.root.right = new Node("Paul");
	        tree.root.left.left = new Node("Simon");	               
	        System.out.println(tree.findManager("Claudiu","Simon").data);	        
	}
	@Test
	public void testBinaryTree_Three()
	{
		 BinaryTree tree = new BinaryTree();
	        tree.root = new Node("June");
	        tree.root.left = new Node("Alex");
	        tree.root.right = new Node("Qing");
	        tree.root.right.left = new Node("Paul");
	        tree.root.right.right = new Node("Gareth");	        	        
	        System.out.println(tree.findManager("Gareth","Alex").data);	        
	}
}
