//package ru.vilensky.tree;
import java.util.*;

public class TreeNode<T, N extends TreeNode<T,N>>{
	
	N parent;
	ArrayList<N> children;
	T data;

	public TreeNode(){}

	public TreeNode(T data, ArrayList<N> children, N parent){
		this.data = data;
		this.children = children;
		this.parent = parent;
	}


}
