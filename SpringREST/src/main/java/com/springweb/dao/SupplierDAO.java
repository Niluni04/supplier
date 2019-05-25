package com.springweb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springweb.model.Product;
import com.springweb.model.Supplier;
import com.springweb.repository.ProductRepository;
import com.springweb.repository.SupplierRepository;

@Service
public class SupplierDAO {
	
	
	@Autowired
	SupplierRepository supplierRepository;
	

	/*to save supplier */
	
	public Supplier save(Supplier sup) {
		return supplierRepository.save(sup);
	}
	
	/* search all suppliers*/
	public List<Supplier> findAll(){
		return supplierRepository.findAll();
	}

	/*get a supplier by id*/
	public Supplier findone(Long supid) {
		return supplierRepository.findOne(supid);
	}
	
	/*delete a supplier*/
	
	public void delete (Supplier sup) {
		supplierRepository.delete(sup);
	}
	

}
