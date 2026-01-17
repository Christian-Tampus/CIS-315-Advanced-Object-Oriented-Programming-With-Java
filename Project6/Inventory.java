/**
 * Assignment: Program 6 | Tech Items
 * Instructions: Follow the uml diagram
 * Design Notes: Follow the uml diagram
 * Version: 1.0, 10/23/2025
 * Author: Christian Tampus
 * Class: CIS-315
 **/
package com.acme;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
public class Inventory {
	private List<TechItem> items;
	public Inventory(TechItem[] technologyItems) {
		this.items = new LinkedList<TechItem>();
		for (TechItem item : technologyItems) {
			this.items.add(item);
		}
	}
	public void sort() {
		Collections.sort(this.items);
		return;
	}
	public int getInventorySize() {
		return this.items.size();
	}
	public void displayInventory() {
		for (int index = 0; index < this.items.size(); index++) {
			System.out.println(this.items.get(index).toString());
		}
		return;
	}
}