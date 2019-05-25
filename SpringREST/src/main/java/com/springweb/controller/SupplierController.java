package com.springweb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.springweb.dao.SupplierDAO;
import com.springweb.model.Supplier;

@RestController
@RequestMapping("/ecommerceSup")
public class SupplierController {

	@Autowired

	SupplierDAO supplierDAO;

	/* to save a supplier */

	@PostMapping("/supplier")
	public Supplier createSupplier(@Valid @RequestBody Supplier sup) {
		return supplierDAO.save(sup);
	}

	/* get all suppliers */

	@GetMapping("/supplier")
	public List<Supplier> getAllSuppliers() {
		return supplierDAO.findAll();
	}

	/* get supplier by supplier id*/

	@GetMapping("/supplier/{id}")
	public ResponseEntity<Supplier> getSupplierById(@PathVariable(value = "id") Long supid) {

		Supplier sup = supplierDAO.findone(supid);

		if (sup == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(sup);

	}

	/*
	 * update a supplier by id
	 * 
	 */

	@PutMapping("/supplier/{id}")
	public ResponseEntity<Supplier> updateSupplier(@PathVariable(value = "id") Long supid,
			@Valid @RequestBody Supplier supDetails) {

		Supplier sup = supplierDAO.findone(supid);

		if (sup == null) {
			return ResponseEntity.notFound().build();
		}

		
		 sup.setName(supDetails.getName());
		 sup.setAddress(supDetails.getAddress());
		 sup.setQuantity(supDetails.getQuantity());
		 sup.setCategory(supDetails.getCategory());
	
		 
		Supplier updateSupplier = supplierDAO.save(sup);
		return ResponseEntity.ok().body(sup);

	}

	/* Delete a supplier */
	@DeleteMapping("/supplier/{id}")
	public ResponseEntity<Supplier> deleteSupplier(@PathVariable(value = "id") Long supid) {
		Supplier sup = supplierDAO.findone(supid);

		if (sup == null) {
			return ResponseEntity.notFound().build();
		}
		supplierDAO.delete(sup);
		return ResponseEntity.ok().build();

	}


	
}
