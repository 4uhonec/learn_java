package ru.vilensky.tree;
import java.util.*;

public class Main{
	public static void main(String[] args){
		ArrayList<Data> items = new ArrayList<>();
		items.add(new Data(1, "Juices", 0));
		items.add(new Data(2, "Mango", 1));
		items.add(new Data(3, "Grape", 1));
		items.add(new Data(4, "Apple", 0));
		items.add(new Data(5, "Sparkling", 5));
		items.add(new Data(6, "Cola", 5));
		items.add(new Data(7, "Cola 0.5l", 6));
		items.add(new Data(8, "Cola 1.5l", 6));
		items.add(new Data(9, "Carbonised water", 5));
		items.add(new Data(10, "Lemonade", 5));
	}

	public static class Data{

		int id;
		String name;
		int parentId;

		public Data(){}

		public Data(int id, String name, int parentId){
			this.id = id;
			this.name = name;
			this.parentId = parentId;
		}
	}
}
