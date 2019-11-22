package com.SandS.API.Controller;

import com.SandS.API.Model.ss_product;
import com.SandS.API.Model.ss_users;
import com.SandS.API.Service.ProductService;
import com.SandS.API.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductCont {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @PostMapping(path="/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addProduct( @RequestParam String email, @RequestParam String password, @RequestBody ss_product product){

        ss_users user = userService.validateUser(email,password);
        if(user != null)
        {
            product.setUser(user);
            return (productService.addProduct(product))? new ResponseEntity<>(null, HttpStatus.OK)
                    :new ResponseEntity<>("cann't add product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }

    @PutMapping(path="/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProduct( @RequestParam String email, @RequestParam String password, @RequestBody ss_product product){

        ss_users user = userService.validateUser(email,password);
        if(user != null)
        {

            return (productService.updateProduct(product))? new ResponseEntity<>(null, HttpStatus.OK)
                    :new ResponseEntity<>("cann't add product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<?> deleteProduct( @RequestParam String email, @RequestParam String password,@PathVariable int id){

        ss_users user = userService.validateUser(email,password);
        if(user != null)
        {

            return (productService.deleteProduct(id))? new ResponseEntity<>(null, HttpStatus.OK)
                    :new ResponseEntity<>("cann't add product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }



    @GetMapping(path="/find/{id}")
    public Optional<ss_product> findById(@PathVariable int id){
        return productService.findById(id);
    }
}
