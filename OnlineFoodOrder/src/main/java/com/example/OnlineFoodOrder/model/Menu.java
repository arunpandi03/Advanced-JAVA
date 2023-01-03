package com.example.OnlineFoodOrder.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "menu")
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long menu_id;
	private String menu_name;
	private String menu_price;

	public Long getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(Long menu_id) {
		this.menu_id = menu_id;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getMenu_price() {
		return menu_price;
	}

	public void setMenu_price(String menu_price) {
		this.menu_price = menu_price;
	}

	public Menu(Long menu_id, String menu_name, String menu_price) {
		super();
		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.menu_price = menu_price;
	}

	public Menu() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", menu_name=" + menu_name + ", menu_price=" + menu_price + "]";
	}

}
