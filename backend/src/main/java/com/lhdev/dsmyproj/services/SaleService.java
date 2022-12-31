package com.lhdev.dsmyproj.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lhdev.dsmyproj.entities.Sale;
import com.lhdev.dsmyproj.repositories.SaleRepository;

@Service
public class SaleService {
	
	private SaleRepository repository;
	
	public SaleService(SaleRepository repository) {
		this.repository = repository;
	}


	public List<Sale> findSales() {
		return  repository.findAll();
	}

}
