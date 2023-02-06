package com.example.repository;

import com.example.model.Products;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository

public class ProductRepository implements IProductRepository {
    @PersistenceContext
    EntityManager entityManager;
    private static final Map<Integer, Products> productsMap = new HashMap<>();

    static {
        productsMap.put(1, new Products(1, "cake", 12000, "good", "vn"));
        productsMap.put(2, new Products(2, "candy", 10000, "very good", "USA"));
        productsMap.put(3, new Products(3, "snack", 32000, "oke", "china"));
        productsMap.put(4, new Products(4, "chocolate", 45000, "good", "Italy"));
    }

    @Override
    public List<Products> findAll() {
        List<Products> list = null;
        list = entityManager.createQuery("select p from  Products as p").getResultList();
        return list;
    }

    @Transactional
    @Override
    public boolean save(Products products) {
        if (products != null) {
            entityManager.persist(products);
            return true;
        }
        return false;
    }
    @Transactional
    @Override
    public boolean update( Products products) {
        if (products != null) {
            Products products1=findByID(products.getId());
            products1.setDescription(products.getDescription());
            products1.setName(products.getName());
            products1.setPrices(products.getPrices());
            products1.setProducer(products.getProducer());
            entityManager.merge(products1);
            return true;
        }
        return false;
    }

    @Override
    public Products findByID(int id) {
        return entityManager.find(Products.class,id);
    }
@Transactional
    @Override
    public void delete(int id) {
        Products products1=findByID(id);
        entityManager.remove(products1);
    }

    @Override
    public List<Products> search(String name1) {
        List<Products> list =null;
        list = entityManager.createQuery("select p from  Products as p where p.name like :name1").setParameter("name1","%"+name1+"%").getResultList();
        return list;
    }

}
