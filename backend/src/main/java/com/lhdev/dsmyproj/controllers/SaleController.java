package com.lhdev.dsmyproj.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lhdev.dsmyproj.entities.Sale;
import com.lhdev.dsmyproj.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	
	private SaleService service;
	
	public SaleController(SaleService service) {
		this.service = service;
	}

	@GetMapping
	public Page<Sale> findSales(
			@RequestParam(value="minDate", defaultValue = "") String minDate, 
			@RequestParam(value="maxDate", defaultValue = "") String maxDate, 
			Pageable pageable) {
		return service.findSales(minDate, maxDate, pageable);
	}
	

	

}
