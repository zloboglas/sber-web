package com.example.demo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderCreation {
    private List<Order> orders;

    public OrderCreation(List<Order> orders) {
        this.orders = orders;
    }

    public OrderCreation() {
        orders = new ArrayList<Order>();
    }

    public void fill() throws IOException {
        File f1 = new File("src\\main\\resources\\list");
        FileReader fr = new FileReader(f1);
        BufferedReader br = new BufferedReader(fr);
        String s = new String();
        String[] words = null;
        while((s=br.readLine())!=null)
        {
            words = s.split(" ");
            Order order = new Order(words[0], words[1], Integer.parseInt(words[2]));
            this.orders.add(order);
        }
    }

    public void addOrder(Order order) throws IOException {
        FileWriter fileWriter = new FileWriter("src\\main\\resources\\list", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        printWriter.printf("%s %s %d\n", order.getArticle(), order.getName(), order.getAmount());
        printWriter.close();

        this.orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}
