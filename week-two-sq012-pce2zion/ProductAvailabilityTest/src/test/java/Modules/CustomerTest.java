package Modules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class CustomerTest {

    @Test
    void buyProducts() throws IOException {

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
        Product productList1 = new Product();
        Product productList5 = new Product();



        productList1.setName(productss.get(0).getName());
        productList1.setCategory(productss.get(0).getCategory());
        productList1.setId(productss.get(0).getId());
        productList1.setAmount(productss.get(0).getAmount());
        productList1.setNumberOfProducts(productss.get(0).getNumberOfProducts());

        productList5.setName(productss.get(5).getName());
        productList5.setCategory(productss.get(5).getCategory());
        productList5.setId(productss.get(5).getId());
        productList5.setAmount(productss.get(5).getAmount());
        productList5.setNumberOfProducts(productss.get(5).getNumberOfProducts());


        Customer customer1 = new Customer(1, "Lilian", "Ike", "lily@gmail.com", 1000, 1);
        Customer customer2 = new Customer(2, "Tobi", "Akin", "tobbie@gmail.com", 300, 1);



        String productBought = customer1.buyProducts(productList1);
        String productBought2 = customer2.buyProducts(productList1);
        String productBought3 = customer2.buyProducts(productList5);


        String success = "Your product: " + productList1.getNumberOfProducts()+ " " + productList1.getName() +
                " is ready.";

        String fail = "Your product: " + productList1.getNumberOfProducts() + " " +
                productList1.getName() + ". Sorry your money is not enough.";

        String noBalanceButSuccess = "Your product: " + productList5.getNumberOfProducts()+ " " + productList5.getName() +
                " is ready. Thank you for shopping with us.";

       Assertions.assertEquals(success, productBought);
       Assertions.assertEquals(fail, productBought2);
       Assertions.assertEquals(noBalanceButSuccess, productBought3);




    }
}