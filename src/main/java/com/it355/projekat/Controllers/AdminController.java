package com.it355.projekat.Controllers;

import com.it355.projekat.Models.Customer;
import com.it355.projekat.Models.Product;
import com.it355.projekat.Services.CustomerService;
import com.it355.projekat.Services.ProductService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.omg.CORBA.Environment;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.IOUtils;


@Controller
@RequestMapping("/administrator")
public class AdminController {

    @RequestMapping
    public String administratorPage() {
        return "administratorMain";
    }

    //org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private static String upload_location = "C:\\Users\\darko\\IdeaProjects\\projekat\\src\\main\\resources\\images";
    private static String delete_location = "C:\\Users\\darko\\IdeaProjects\\projekat\\src\\main\\resources\\";

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    private Path path;

    @Autowired
    private org.springframework.core.env.Environment environment;

    @RequestMapping("/dodajProizvod")
    public ModelAndView dodajProizvod(ModelMap model, Product product) {
        model.addAttribute("product", new Product());

        return new ModelAndView("noviProizvod", "command", new Product());
    }

    @RequestMapping(value = "/dodajProizvod", method = RequestMethod.POST)
    public ModelAndView dodajProizvod(@ModelAttribute("product") Product product, ModelAndView model, @RequestParam("file") MultipartFile file,
                                      HttpServletResponse response) throws Exception {

        try {
            String filename = file.getOriginalFilename();
            String path = Paths.get(upload_location, filename).toString();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path)));
            stream.write(file.getBytes());
            stream.close();
        } catch (IOException e){
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
            product.setSlika("/images/" + file.getOriginalFilename());
            model.addObject("object", product);
            product.setProizvodId(productService.countProds() + 1);
            productService.addProduct(product);
            model.setViewName("redirect:/administrator/inventarProizvoda");
            return model;

    }

    @RequestMapping("/proizvod/editProizvod/{id}")
    public String editProizvod(@PathVariable("id") int id, Model model){
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "editProizvod";
    }
    @RequestMapping(value = "/proizvod/editProizvod", method = RequestMethod.POST)
    public String editProizvodPostMetod(@Valid @ModelAttribute("product") Product product, BindingResult result, @RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "editProizvod";
        }
        //if (product.getSlika() != "/images/" + file.getOriginalFilename()) {
            try {
                String filename = file.getOriginalFilename();
                String path = Paths.get(upload_location, filename).toString();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(path)));
                stream.write(file.getBytes());
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
       // }
        product.setSlika("/images/" + file.getOriginalFilename());
        productService.editProduct(product);
        return "redirect:/administrator/inventarProizvoda";
    }
    @RequestMapping("/proizvod/obrisiProizvod/{id}")
    public String obrisiProizvod(@PathVariable int id, Model model, HttpServletRequest request) {
        Product product = productService.getProductById(id);

        String nazivfajla = product.getSlika();
        path = Paths.get(delete_location + nazivfajla);
        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        productService.deleteProduct(product);



        return "redirect:/administrator/inventarProizvoda";
    }

    @RequestMapping("/inventarProizvoda")
    public String productInventory(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);

        return "inventarProizvoda";
    }

    @RequestMapping("/customers")
    public String customerManagerment(Model model) {

        List<Customer> customerList = customerService.getAllCustomers();
        model.addAttribute("customerList", customerList);

        return "customers";
    }
}
