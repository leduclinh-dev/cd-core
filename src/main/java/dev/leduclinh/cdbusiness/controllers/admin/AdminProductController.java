package dev.leduclinh.cdbusiness.controllers.admin;

import dev.leduclinh.cdbusiness.domain.requests.admin.CreateProductRequest;
import dev.leduclinh.cdbusiness.domain.requests.admin.ProductRequest;
import dev.leduclinh.cdbusiness.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@Controller
@RequestMapping("/admin/product")
public class AdminProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/createProduct")
    public ResponseEntity<?> createProduct(@RequestBody CreateProductRequest productRequest) {
        return new ResponseEntity<>(productService.createProduct(productRequest),HttpStatus.OK);
    }
    @GetMapping("/getListProduct")
    public ResponseEntity<?> getListProduct() {
        return new ResponseEntity<>(productService.getListProduct(), HttpStatus.OK);
    }
    @PostMapping("/deleteProduct")
    public ResponseEntity<?> deleteProduct(@RequestParam(name = "productId")Long productId) {
         productService.deleteProduct(productId);
         return new ResponseEntity<>(HttpStatus.OK);
    }

}
