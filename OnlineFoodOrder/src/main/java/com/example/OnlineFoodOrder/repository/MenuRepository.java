package com.example.OnlineFoodOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OnlineFoodOrder.model.Menu;

public interface MenuRepository extends JpaRepository<Menu,Long>{

	
}
