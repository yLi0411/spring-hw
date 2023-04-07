package com.example.springhw.service;

import com.example.springhw.dao.ItemDao;
import com.example.springhw.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ItemViewService {
    private ItemDao itemDao;
    @Autowired
    public ItemViewService(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public List<Product> getAllProduct() {
        return itemDao.getAllProduct();
    }
    public Product getProduct(Integer product_sequence, String sourceId, String logloc) {
        return itemDao.getProduct(product_sequence, sourceId, logloc);
    }

    public Product saveProduct(Product product, Integer product_sequence, String sourceId, String logloc) {
        return itemDao.saveProduct(product, product_sequence, sourceId, logloc);
    }

    public Product updateProduct(Product product, Integer product_sequence, String sourceId, String logloc) {
        return itemDao.updateProduct(product, product_sequence, sourceId, logloc);
    }

    public Product deleteProduct(Integer product_sequence, String sourceId, String logloc) {
        return itemDao.deleteProduct(product_sequence, sourceId, logloc);
    }

}
