package com.SandS.API.Service;

import com.SandS.API.Model.ss_product;
import com.SandS.API.Repository.ProductRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public boolean addProduct(ss_product product)
    {
        return (productRepo.save(product)!=null)? true : false;
    }

    public Optional<ss_product> findById(int id) {
        return productRepo.findById(id);
    }

    public boolean updateProduct(ss_product product) {
        productRepo.save(product);
        return true;
    }

    public boolean deleteProduct(int product) {

        ss_product p=productRepo.getOne(product);
        if(p!=null)
        {
            productRepo.delete(p);
            return true;
        }
        else
        {
            return false;
        }

    }
}
