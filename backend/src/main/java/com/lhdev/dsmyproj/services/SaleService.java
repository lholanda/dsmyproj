package com.lhdev.dsmyproj.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lhdev.dsmyproj.entities.Sale;
import com.lhdev.dsmyproj.repositories.SaleRepository;

@Service
public class SaleService {

	
	private SaleRepository repository;

	public SaleService(SaleRepository repository) {
		this.repository = repository;
	}



	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {

		// data de hoje
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);

		return repository.findSales(min, max, pageable);
		
	}
	
	
	

}
