package thesis.app.entity;

import java.util.ArrayList;

public class Questionaire {

	private ArrayList<Item> ItemList;

	public ArrayList<Item> getItemList() {
		return ItemList;
	}

	public void setItemList(ArrayList<Item> itemsList) {
		ItemList = itemsList;
	}

	public Questionaire() {
		ItemList = new ArrayList<Item>();
	}
}
