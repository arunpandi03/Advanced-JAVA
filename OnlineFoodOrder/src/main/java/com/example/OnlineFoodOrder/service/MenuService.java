package com.example.OnlineFoodOrder.service;

import java.util.List;

import com.example.OnlineFoodOrder.model.Menu;

public interface MenuService {

	public Menu createMenu(Menu menu);

	public List<Menu> getAllMenu();

	public Menu getById(Long menu_id);

	public Menu updateMenu(Menu menu);

	public void deleteById(Long menu_id);
	

	
	
}
