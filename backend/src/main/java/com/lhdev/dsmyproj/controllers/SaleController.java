package com.lhdev.dsmyproj.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhdev.dsmyproj.entities.Sale;
import com.lhdev.dsmyproj.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	private SaleService saleService;

	public SaleController(SaleService saleService) {
		this.saleService = saleService;
	}
	
	@GetMapping
	public List<Sale> findSales() {
		return saleService.findSales();
	}
	
	

}
