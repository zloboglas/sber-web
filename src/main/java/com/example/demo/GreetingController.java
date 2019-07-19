package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class GreetingController {
    @GetMapping("/")
    public String showAll(Model model) {

        return "greeting";
    }
    
    @PostMapping
    public String add(@RequestParam("action") String action, @RequestParam String article, @RequestParam String name, @RequestParam Integer amount, Model model) throws IOException {
        if (action.equals("add")){
            Order order = new Order(article, name, amount);
            OrderCreation orderCreation = new OrderCreation();
            orderCreation.fill();
            orderCreation.addOrder(order);

            model.addAttribute("orders", orderCreation.getOrders());

        }
        if (action.equals("clear")){
            FileWriter fileWriter = new FileWriter("src\\main\\resources\\list");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            printWriter.printf("");
            printWriter.close();
        }
       return "greeting";
    }
}
