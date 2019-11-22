package com.SandS.API.Service;

import com.SandS.API.Model.ss_category;
import com.SandS.API.Model.ss_product;
import com.SandS.API.Repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public ss_category addCategory(ss_category category){
        return categoryRepo.save(category);
    }

    public List<ss_category> FindAll(){
        return categoryRepo.findAll();
    }

    public List<ss_product> FindAllProducts(String c_name) {
        return categoryRepo.findByName(c_name).getProductList();
    }
}
