package com.simplilearn.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.webapp.model.Product;

@RestController
public class ProductController {
	
	List<Product> products = new ArrayList<Product>();
	
    private List<Product>getDefaultProduct(){
    	products.add(new Product(1001,"Iphone 11 Pro", "It is a smart phone",70000));
    	products.add(new Product(1002,"Lenovo Laptop XYZ series", "It is a Laptop",80000));
    	products.add(new Product(1003,"Ferari", "It is a racing car",280000));
    	products.add(new Product(1004,"Dell Laptop ABC seris", "It is a Laptop",60000));
    	products.add(new Product(1005,"Dimpond Ring", "It is a ring",70000));
    	products.add(new Product(1006,"Luminous Pro", "It is a smart phone",70000));
    	
    	return products;
    }
    
    //Product CRUD Operation
    
    /*
     * URI | Method | Description  |

      1-> localhost:8080/products | GET | list all products | 
      2-> localhost:8080/product/{id}| GET | list one Product |
      3-> localhost:8080/products?name=""|GET |get one product by name|
      4-> localhost:8080/products|POST |add one product to product list 
      5-> localhost:8080/products|PUT| update one product
      6-> localhost:8080/products|Delete| delete one product 

     * 
     * Do check in POSTMAN App
     */
    
    
    //Get list of all products   
    //Remember :: Both @GetMapping and @RequestMapping perform same operation 
    @GetMapping("/product")
    //@RequestMapping(value="/products", method=RequestMethod.GET)
    public List<Product>getAllProducts(){
    	return getDefaultProduct();
    }
    
    //Get product by id
    @GetMapping("/product/{id}")
    public Product getOneProducts(@PathVariable("id") int id){
    	
    	//Enhanced For Loop
    	for(Product product : products) {
    		
    		if(product.getId()==id) {
    			
    			return product;
    		}
    		
    	}
    	return null;
    }
    
    
    //Get product by name ----> Not working for me this method
    @GetMapping("/products")
    public Product getOneProductsByName(@PathParam("name") String name){
    	
    	//Enhanced For Loop
    	for(Product product : products) {
    		
    		if(name.equals(product.getName())) {
    			
    			return  product;
    		}
    		
    	}
    	return null;
    }
    
    //Add a product 
    @PostMapping("/products")
    public List<Product> addProduct(@RequestBody Product product) {
    	
        products.add(product);
        return products;
    	
    }
    
    
    //Update One product by id
    @PutMapping("/product")
    public List<Product> updateOneProducts(@RequestBody Product product){
    	
    	//Enhanced For Loop
    	for(int i=0; i<products.size(); i++) {
    		
    		if(products.get(i).getId()==product.getId()) {
    			
    			products.set(i,product);
    			
    			return products;
    			
    		}
    		
    	}
    	return null;
    }
    
    //Delete one product------> Not working 
    
    @PutMapping("/product/{id}")
    public List<Product> removeOneProducts(@PathVariable("id") int id){
    	
    	//Enhanced For Loop
    	for(int i=0; i<products.size(); i++) {
    		
    		if(products.get(i).getId()==id) {
    			
    			products.remove(i);
    			
    			return products;
    		}
    		
    	}
    	return null;
    }
    
}
