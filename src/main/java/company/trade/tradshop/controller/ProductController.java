package company.trade.tradshop.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import company.trade.tradshop.service.ProductService;
import company.trade.tradshop.model.Member;
import company.trade.tradshop.model.Poster;
import company.trade.tradshop.model.Product;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @GetMapping("")
    public ResponseEntity<Object> getAllProduct(){
        List<Product> products = productService.getProducts();
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Search Success!");
        map.put("data", products);
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    };

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable String id){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Search By Id Success!");
        map.put("data", productService.findProductById(id));
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    };

    @GetMapping("/name/{name}")
    public ResponseEntity<Object> getProductByName(@PathVariable String name){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Search By Id Success!");
        map.put("data", productService.findProductByName(name));
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    };


    @PostMapping("")
    public ResponseEntity<Object> addProduct(@RequestBody Product product){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Add Product Success!");
        map.put("data", productService.addProduct(product));
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    };

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable String id, @RequestBody Product product){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "Update Product Success!");
        map.put("data", productService.updateProduct(id, product));
        return new ResponseEntity<Object>(map,HttpStatus.OK);
    }

    // @PatchMapping("/{id}")
    // public ResponseEntity<Object> addPosters(@PathVariable String id, @RequestBody Poster poster){
    //     HashMap<String, Object> map = new HashMap<>();
    //     map.put("msg", "Add Poster Success!");
    //     map.put("data", productService.addPosters(id, poster));
    //     return new ResponseEntity<Object>(map,HttpStatus.OK);
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable String id){
        HashMap<String, Object> map = new HashMap<>();
        if(!productService.deleteProduct(id)){
            map.put("msg", "Error delete");
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            map.put("msg", "Delete success");
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }
    }
    
}
