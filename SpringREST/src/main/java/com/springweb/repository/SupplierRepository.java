package com.springweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springweb.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
	
	
}
