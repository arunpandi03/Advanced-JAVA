package com.example.OnlineFoodOrder.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.al.LoggerCheckApplication;
import com.example.OnlineFoodOrder.OnlineFoodOrderApplication;
import com.example.OnlineFoodOrder.model.Menu;
import com.example.OnlineFoodOrder.service.MenuService;
import com.example.OnlineFoodOrder.util.PDFGenerator;
import com.lowagie.text.DocumentException;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api")

public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	
	
	static final Logger log = LoggerFactory.getLogger(OnlineFoodOrderApplication.class);
	
	
	@PostMapping("/save")
	public ResponseEntity<Menu> createMenu( @RequestBody Menu menu){
		Menu menu1 = menuService.createMenu(menu);
		log.debug("testAPI started: " + menu1);
		log.info("testAPI started: " + menu1);
		return new ResponseEntity<Menu>(menu1,HttpStatus.CREATED);
	}
	
	@GetMapping("/menu")
	public ResponseEntity<List<Menu>> getAllMenu(){
		List<Menu> menu1 =  menuService.getAllMenu();
		
		return new ResponseEntity<>(menu1,HttpStatus.OK);
	}

	@GetMapping("/menu/id")
	public ResponseEntity<Menu> getById(@RequestParam Long menu_id){
	Menu menu1 = menuService.getById(menu_id);
		return new ResponseEntity<Menu>(menu1,HttpStatus.OK);
	}
	
	
	
	 @GetMapping("/pdf")
	    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
	         
	        List<Menu> menuList = menuService.getAllMenu();
	        
	       PDFGenerator generator = new PDFGenerator(menuList);
	        generator.exportpdf(response);
	        
	         
	    }

	@PutMapping("/menu/update")
	public ResponseEntity<Menu> updateMenu(@RequestBody Menu menu){
		Menu menu1 = menuService.updateMenu(menu);
		return new ResponseEntity<Menu>(menu1,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/menu/id")
	public ResponseEntity<Void> deleteById(@RequestParam Long menu_id){
		menuService.deleteById(menu_id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		
	}
	
	
}