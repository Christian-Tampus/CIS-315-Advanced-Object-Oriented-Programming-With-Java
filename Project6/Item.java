/**
 * Assignment: Program 6 | Tech Items
 * Instructions: Follow the uml diagram
 * Design Notes: Follow the uml diagram
 * Version: 1.0, 10/23/2025
 * Author: Christian Tampus
 * Class: CIS-315
 **/
package com.acme;
public abstract class Item {
	private int skuNumber;
	public Item(int sku) {
		this.skuNumber = sku;
	}
	public int getSkuNumber() {
		return this.skuNumber;
	}
	public void setSkuNumber(int sku) {
		this.skuNumber = sku;
		return;
	}
}