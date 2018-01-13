package com.it355.projekat.Services;

import com.it355.projekat.Models.Product;

import java.util.List;

public interface ProductService {
    public Product addProduct(Product product);
    public void editProduct(Product product);
    public void deleteProduct(Product product);

    public List<Product> getProducts();
    public Product getProductById(int id);
    public int countProds();
}
