package com.example.springhw.dao;

import com.example.springhw.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemDao {
    //search by product sequence(list index), sourceID(1st map key), logloc(2nd map key)
    public static Map<Integer, Map<String, Map<String, Product>>> productList = new HashMap<>();

    public List<Product> getAllProduct() {
        List<Product> res = new ArrayList<>();
        for (Map.Entry<Integer, Map<String, Map<String, Product>>> product : productList.entrySet()) {
            Integer product_sequence = product.getKey();
            Map<String, Map<String, Product>> map1 = product.getValue();
            for (String key : map1.keySet()) {
                Map<String, Product> map2 = map1.get(key);
                for (Map.Entry<String, Product> entry : map2.entrySet()) {
                    res.add(entry.getValue());
                }
            }
        }
        return res;
    }

    public Product getProduct(Integer product_sequence, String sourceId, String logloc) {
        Map<String, Map<String, Product>> productMap1 = productList.get(product_sequence);
        Map<String, Product> productMap2 = productMap1.get(sourceId);
        return productMap2.get(logloc);
    }

    public Product saveProduct(Product product, Integer product_sequence, String sourceId, String logloc) {
        if (!productList.containsKey(product_sequence)) {
            productList.put(product_sequence, new HashMap<>());
        }
        Map<String, Map<String, Product>> productMap1 = productList.get(product_sequence);
        if (!productMap1.containsKey(sourceId)) {
            productMap1.put(sourceId, new HashMap<>());
        }
        Map<String, Product> productMap2 = productMap1.get(sourceId);
        productMap2.put(logloc, product);
        return product;
    }

    public Product updateProduct(Product product, Integer product_sequence, String sourceId, String logloc) {
        Map<String, Map<String, Product>> productMap1 = productList.get(product_sequence);
        Map<String, Product> productMap2 = productMap1.get(sourceId);
        productMap2.put(logloc, product);
        return product;
    }

    public Product deleteProduct(Integer product_sequence, String sourceId, String logloc) {
        Map<String, Map<String, Product>> productMap1 = productList.get(product_sequence);
        Map<String, Product> productMap2 = productMap1.get(sourceId);
        Product deleted = productMap2.get(logloc);
        productMap2.remove(logloc);
        return deleted;
    }
}
