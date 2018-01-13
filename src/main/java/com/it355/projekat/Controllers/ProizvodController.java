package com.it355.projekat.Controllers;

import com.it355.projekat.Models.Product;
import com.it355.projekat.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/proizvod")
public class ProizvodController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/listaProizvoda/sviProizvodi")
    public String getProducts(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);

        return "listaProizvoda";
    }

    @RequestMapping("/pregledProizvoda/{productId}")
    public String viewProduct(@PathVariable int productId, Model model) throws IOException {
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);

        return "pregledProizvoda";
    }

}
