package com.SandS.API.Controller;

import com.SandS.API.Model.ss_category;
import com.SandS.API.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryCont {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(path="/add/{cname}")
    public ss_category addCategory(@PathVariable String cname){
        return categoryService.addCategory(new ss_category(cname));
    }

    @GetMapping(path="/")
    public List<ss_category> FindAll(){
        return categoryService.FindAll();
    }
}
