package com.example.products.repository;

import com.example.products.model.Products;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ProductRepository implements IProductRepository{
   private static final Map<Integer,Products> productsMap=new HashMap<>();
   static {
       productsMap.put(1,new Products(1,"cake",12000,"good","vn"));
       productsMap.put(2,new Products(2,"candy",10000,"very good","USA"));
       productsMap.put(3,new Products(3,"snack",32000,"oke","china"));
       productsMap.put(4,new Products(4,"chocolate",45000,"good","Italy"));
   }
    @Override
    public List<Products> findAll() {
        return new ArrayList<>(productsMap.values());
    }

    @Override
    public boolean save(Products products) {
        if(products!=null){
            productsMap.put(products.getId(),products);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(int id, Products products) {
        if (products!=null){
            productsMap.put(id,products);
            return true;
        }
        return false;
    }

    @Override
    public Products findByID(int id) {
        return productsMap.get(id);
    }

    @Override
    public void delete(int id) {
        productsMap.remove(id);
    }

    @Override
    public List<Products> search(String name) {
       List<Products> list=new ArrayList<>(productsMap.values());
       List<Products> listProduct=new ArrayList<>();
        for (Products p:list) {
            if(p.getName().contains(name)){
                listProduct.add(p);
            }
        }
        return listProduct;
    }

}
