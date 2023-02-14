package com.example.cart.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> mapProduct = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<ProductDto, Integer> mapProduct) {
        this.mapProduct = mapProduct;
    }

    public Map<ProductDto, Integer> getMapProduct() {
        return mapProduct;
    }

    public void setMapProduct(Map<ProductDto, Integer> mapProduct) {
        this.mapProduct = mapProduct;
    }

    public boolean checkCart(ProductDto productDto) {
        for (Map.Entry<ProductDto, Integer> entry : mapProduct.entrySet()) {
            if (entry.getKey().getId() == productDto.getId()) {
                return true;
            }
        }
        return false;
    }

    public void addProduct(ProductDto productDto) {
        if (checkCart(productDto)) {
            Map.Entry<ProductDto, Integer> map=selectItemInCart(productDto);
            Integer newValue = map.getValue()+1;
            mapProduct.replace(map.getKey(), newValue);
        } else {
            mapProduct.put(productDto, 1);
        }

    }
    public void subtraction(ProductDto productDto) {
        Map.Entry<ProductDto, Integer> map=selectItemInCart(productDto);
        if(map.getValue()>1) {
            Integer newValue = map.getValue() - 1;
            mapProduct.replace(map.getKey(), newValue);
        }
    }
    public void delete(ProductDto productDto){
        Map.Entry<ProductDto,Integer> map=selectItemInCart(productDto);
                mapProduct.remove(map.getKey());
    }

    public Integer countItems() {
        return mapProduct.size();
    }

    public int countProducts() {
        int count = 0;
        for (Map.Entry<ProductDto, Integer> entry : mapProduct.entrySet()) {
            count += entry.getValue();
        }
        return count;
    }
    public Float totalPrices(){
       float total =  0;
        for(Map.Entry<ProductDto,Integer> entry: mapProduct.entrySet()){
            total += entry.getValue()*entry.getKey().getPrices();
        }return total;
    }
    public Map.Entry<ProductDto, Integer> selectItemInCart(ProductDto product){
        for (Map.Entry<ProductDto, Integer> entry :mapProduct.entrySet()) {
            if(entry.getKey().getId()==(product.getId())){
                return entry;
            }
        }
        return null;
    }
}
