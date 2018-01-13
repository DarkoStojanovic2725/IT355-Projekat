package com.it355.projekat.Controllers;

import com.it355.projekat.Models.OrderDetails;
import com.it355.projekat.Models.Orders;
import com.it355.projekat.Models.ProizvodZaKorpu;
import com.it355.projekat.Services.CustomerService;
import com.it355.projekat.Services.PorudzbineDetaljiService;
import com.it355.projekat.Services.PorudzbineService;
import com.it355.projekat.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/customer/korpa")
public class KorpaController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PorudzbineService porudzbineService;

    @Autowired
    private PorudzbineDetaljiService porudzbineDetaljiService;

    @RequestMapping(method = RequestMethod.GET)
    public String korpa(ModelMap model) {
        model.put("title", "Korpa");
        model.put("action", "korpa");
        return "korpa";

    }

    @RequestMapping(value = "/kupi/{id}", method = RequestMethod.GET)
    public String kupi(@PathVariable("id") int id, HttpSession session, ModelMap model) {
        model.put("title", "Korpa");
        if (session.getAttribute("korpa") == null) {
            List<ProizvodZaKorpu> korpa = new ArrayList<ProizvodZaKorpu>();
            korpa.add(new ProizvodZaKorpu(productService.getProductById(id), 1));
            session.setAttribute("korpa", korpa);

        } else {
            List<ProizvodZaKorpu> korpa = (List<ProizvodZaKorpu>) session.getAttribute("korpa");
            int index = dodatUKorpu(id, session);
            if (index == -1) {
                korpa.add(new ProizvodZaKorpu(productService.getProductById(id), 1));
            } else {
                int kolicina = korpa.get(index).getKolicina() + 1;
                korpa.get(index).setKolicina(kolicina);
                session.setAttribute("korpa", korpa);
            }

        }
        return "korpa";
    }

    private int dodatUKorpu(int id, HttpSession session) {
        List<ProizvodZaKorpu> korpa = (List<ProizvodZaKorpu>) session.getAttribute("korpa");
        for (int i = 0; i < korpa.size(); i++) {
            if (korpa.get(i).getProduct().getProizvodId() == id) {
                return i;
            }

        }
        return -1;
    }

    @RequestMapping(value = "/ukloni/{index}", method = RequestMethod.GET)
    public String ukloni(@PathVariable("index") int index, HttpSession session) {
        List<ProizvodZaKorpu> korpa = (List<ProizvodZaKorpu>) session.getAttribute("korpa");
        korpa.remove(index);
        return "redirect:/customer/korpa";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String checkout(HttpSession session, ModelMap model, Principal principal) {
        model.put("title", "Korpa");

        if (session.getAttribute("korpa") == null) {
            model.addAttribute("error", "Please insert products to cart");
            return "korpa";
        } else {
            Orders orders = new Orders();
            orders.setUsername(principal.getName());
            orders.setDatum(new Date());
            orders.setNaziv("New Order 01");

            Orders newOrder = porudzbineService.newOrders(orders);
            List<ProizvodZaKorpu> korpa = (List<ProizvodZaKorpu>) session.getAttribute("korpa");
            for(ProizvodZaKorpu pr : korpa){
                OrderDetails orderDetails = new OrderDetails();
                orderDetails.setProizvodId(pr.getProduct().getProizvodId());
                orderDetails.setPorudzbinaId(newOrder.getPorudzbinaId());
                orderDetails.setCena(pr.getProduct().getCena());
                orderDetails.setKolicina(pr.getKolicina());
                porudzbineDetaljiService.newOrderDetails(orderDetails);
            }

            session.removeAttribute("korpa");

            return "index";
        }

    }

}
