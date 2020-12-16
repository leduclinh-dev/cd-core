package dev.leduclinh.cdbusiness.controllers.admin;

import dev.leduclinh.cdbusiness.domain.requests.admin.CreateProductRequest;
import dev.leduclinh.cdbusiness.domain.requests.admin.CreateProductTitleRequest;
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

    @PostMapping("/createProductTitle")
    public ResponseEntity<?> createProductTitle(@RequestBody CreateProductTitleRequest productRequest) {
        return new ResponseEntity<>(productService.createProductTitle(productRequest),HttpStatus.OK);
    }

    @PostMapping("/createProduct")
    public ResponseEntity<?> createProduct(@RequestBody CreateProductRequest productRequest) throws Exception {
        return new ResponseEntity<>(productService.createProduct(productRequest), HttpStatus.OK);
    }
    @GetMapping("/getListProduct")
    public ResponseEntity<?> getListProduct() {
        return new ResponseEntity<>(productService.getListProduct(), HttpStatus.OK);
    }
    @PostMapping("/deleteProduct")
    public ResponseEntity<?> deleteProduct(@RequestParam(name = "id")Long id) {
         return new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.OK);
    }
    @PostMapping("/deleteProductTitle")
    public ResponseEntity<?> deleteProductTitle(@RequestParam(name = "id")Long id) {
        return new ResponseEntity<>(productService.deleteProductTitle(id),HttpStatus.OK);
    }

}
