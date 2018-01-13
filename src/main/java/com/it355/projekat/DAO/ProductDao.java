package com.it355.projekat.DAO;

import com.it355.projekat.Models.Product;

import java.util.List;

public interface ProductDao {

    public Product addProduct(Product product);
    public void editProduct(Product product);
    public void deleteProduct(Product product);

    public List<Product> getProducts();
    public Product getProductById(int id);
    public int countProds();
}
