package com.store.products;

import Modules.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        String file = "/Users/home/IdeaProjects/week-two-sq012-pce2zion/ProductAvailabilityTest/src/main/java/csv/Store Sheet - Sheet1.csv";
        String line = "";
        List<Product> productss =new ArrayList<>();//Creating arraylist

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] prod = line.split(",");

                if(prod[0].equals("Product ID"))
                    continue;
                productss.add(new Product(Integer.valueOf(prod[0]),prod[1], Integer.valueOf(prod[2]), prod[3], Integer.valueOf(prod[4])));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
        System.out.println( productss);
        System.out.println();

        Cashier cashier1 = new Cashier(1, "Peace", "Obute", "pce@gmail.com", 1);

        Customer customer1 = new Customer(1, "Lilian", "Ike", "lily@gmail.com", 1000, 1);
        Customer customer2 = new Customer(2, "Tobi", "Akin", "tobbie@gmail.com", 60000, 5);
        Customer customer3 = new Customer(3, "THalima", "Abu", "hallie@gmail.com", 4000, 1);

        Store store = new Store();
        store.setName("EveryDays");
        store.setAddress("14c Abakaliki Rd GRA Enugu");
        store.setAllProducts(productss);

        Product productList1 = new Product();
        Product productList2 = new Product();
        Product productList3 = new Product();

        productList1.setName(productss.get(0).getName());
        productList1.setCategory(productss.get(0).getCategory());
        productList1.setId(productss.get(0).getId());
        productList1.setAmount(productss.get(0).getAmount());
        productList1.setNumberOfProducts(productss.get(0).getNumberOfProducts());

        productList2.setName(productss.get(3).getName());
        productList2.setCategory(productss.get(3).getCategory());
        productList2.setId(productss.get(3).getId());
        productList2.setAmount(productss.get(3).getAmount());
        productList2.setNumberOfProducts(productss.get(3).getNumberOfProducts());

        productList3.setName(productss.get(6).getName());
        productList3.setCategory(productss.get(6).getCategory());
        productList3.setId(productss.get(6).getId());
        productList3.setAmount(productss.get(6).getAmount());
        productList3.setNumberOfProducts(productss.get(6).getNumberOfProducts());


        System.out.println(productList1);
        System.out.println(productList2);

        System.out.println();


       // System.out.println(cashier1.isProductAvailable(productList2, store, customer2));
       // System.out.println(cashier1.isProductAvailable(productList1, store, customer1));
       // System.out.println(cashier1.isProductAvailable(productList3, store, customer3));
       // System.out.println(cashier1.isProductAvailable(productList3, store, customer3));



    }
}




