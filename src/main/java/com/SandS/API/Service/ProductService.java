package com.SandS.API.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SandS.API.Model.ss_product;
import com.SandS.API.Repository.ProductRepo;

@Service
public class ProductService {
	
	@Autowired 
	private ProductRepo productRepo;
	
	public ss_product addProduct(ss_product product) {
		return productRepo.save(product);
	}
	
	public  List<ss_product> FindAll() {
		return productRepo.findAll();
	}
	
	public ss_product updateProduct(ss_product product) {
		return productRepo.save(product);
	}
	
	public void deleteProduct(int id) {
		productRepo.deleteById(id);
	}
	
	public ss_product findByName(String pname) {
		return productRepo.FindByName(pname);
	}
}
