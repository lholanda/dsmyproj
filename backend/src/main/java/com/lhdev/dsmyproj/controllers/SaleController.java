package com.lhdev.dsmyproj.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lhdev.dsmyproj.entities.Sale;
import com.lhdev.dsmyproj.services.SaleService;
import com.lhdev.dsmyproj.services.SmsService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	
	private SaleService service;
	private SmsService smsService;
	
	public SaleController(SaleService service, SmsService smsService) {
		this.service = service;
		this.smsService = smsService;
	}

	@GetMapping
	public Page<Sale> findSales(
			@RequestParam(value="minDate", defaultValue = "") String minDate, 
			@RequestParam(value="maxDate", defaultValue = "") String maxDate, 
			Pageable pageable) {
		return service.findSales(minDate, maxDate, pageable);
	}
	
	@GetMapping("/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}
	

}
