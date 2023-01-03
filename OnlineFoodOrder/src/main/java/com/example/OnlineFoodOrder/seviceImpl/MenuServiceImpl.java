package com.example.OnlineFoodOrder.seviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineFoodOrder.model.Menu;
import com.example.OnlineFoodOrder.repository.MenuRepository;
import com.example.OnlineFoodOrder.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepo;

	@Override
	public Menu createMenu(Menu menu) {
		Menu mnu = menuRepo.save(menu);
		return mnu;
	}

	@Override
	public List<Menu> getAllMenu() {
		List<Menu> menu1 = menuRepo.findAll();
		return menu1;
	}

	@Override
	public Menu getById(Long menu_id) {
		Menu menu1 = menuRepo.findById(menu_id).get();
		return menu1;
	}

	@Override
	public Menu updateMenu(Menu menu) {
		Menu menu1 = new Menu();
		menu1.setMenu_id(menu.getMenu_id());
		menu1.setMenu_name(menu.getMenu_name());
		menu1.setMenu_price(menu.getMenu_price());

		return menuRepo.save(menu1);
	}

	@Override
	public void deleteById(Long menu_id) {

		menuRepo.deleteById(menu_id);
	}

}
