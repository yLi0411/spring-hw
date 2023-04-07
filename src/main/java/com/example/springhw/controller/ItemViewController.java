package com.example.springhw.controller;

import com.example.springhw.entity.Product;
import com.example.springhw.service.ItemViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/es-service")
public class ItemViewController {
    private final ItemViewService itemViewService;

    @Autowired
    public ItemViewController(ItemViewService productService) {
        this.itemViewService = productService;
    }


    @GetMapping("/product/{product_sequence}/search")
    public Product getProduct(@PathVariable Integer product_sequence,
                                    @RequestParam String sourceId,
                                    @RequestParam String logloc) {
        // do we need to process separately for "all"?
        return itemViewService.getProduct(product_sequence, sourceId, logloc);
    }

    @GetMapping("/products")
    public List<Product> getAllProduct() {
        return itemViewService.getAllProduct();
    }

    @PutMapping("/product/{product_sequence}/search")
    public Product saveProduct(@RequestBody Product newProduct,
                               @PathVariable Integer product_sequence,
                               @RequestParam String sourceId,
                               @RequestParam String logloc) {

        return itemViewService.updateProduct(newProduct, product_sequence, sourceId, logloc);
    }
    @PostMapping("/product/{product_sequence}/search")
    public Product getAllProduct(@RequestBody Product newProduct,
                                 @PathVariable Integer product_sequence,
                                 @RequestParam String sourceId,
                                 @RequestParam String logloc) {

        return itemViewService.saveProduct(newProduct, product_sequence, sourceId, logloc);
    }
    @DeleteMapping("/product/{product_sequence}/search")
    public Product getAllProduct(@PathVariable Integer product_sequence,
                                       @RequestParam String sourceId,
                                       @RequestParam String logloc) {

        return itemViewService.deleteProduct(product_sequence, sourceId, logloc);
    }

}
