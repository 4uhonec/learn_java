//package ru.vilensky.tree;
import java.util.*;

public class TreeNode<T, N extends TreeNode<T,N>>{

	T data;
	ArrayList<N> children;
	N parent;

	public TreeNode(){}

	public TreeNode(T data, ArrayList<N> children, N parent){
		this.data = data;
		this.children = children;
		this.parent = parent;
	}

	public interface TypeAdapter<T, N>{
		N newInstance();
		boolean isChildOf(T parentNodeData, T childNodeData);
		boolean isTopLevelItem(T data);
	}
}
