/**
 * Assignment: Program 6 | Tech Items
 * Instructions: Follow the uml diagram
 * Design Notes: Follow the uml diagram
 * Version: 1.0, 10/23/2025
 * Author: Christian Tampus
 * Class: CIS-315
 **/
package com.acme;
import java.lang.Comparable;
public class TechItem extends Item implements Comparable<TechItem> {
	private String orderNumber;
	private String company;
	private int quantity;
	public TechItem(int sku, String onum, String comp, int quantity) {
		super(sku);
		this.orderNumber = onum;
		this.company = comp;
		this.quantity = quantity;
	}
	public String getOrderNumber() {
		return this.orderNumber;
	}
	public void setCompany(String comp) {
		this.company = comp;
	}
	public String getCompany() {
		return this.company;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return this.quantity;
	}
	@Override
	public int compareTo(TechItem other) {
		return this.orderNumber.compareTo(other.orderNumber);
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (obj instanceof Item) {
			TechItem other = (TechItem) obj;
			return this.orderNumber.equals(other.orderNumber);
		}
		return false;
	}
	@Override
	public int hashCode() {
		return this.orderNumber.hashCode();
	}
	@Override
	public String toString() {
		return this.getSkuNumber() + " " + this.orderNumber + " " + this.company + " " + this.quantity;
	}
}