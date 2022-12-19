package Modules;

import Exceptions.InsufficientFundException;
import Exceptions.OutofStockException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Modules.Cashier;
import static org.junit.jupiter.api.Assertions.*;

class CashierTest {


    @Test
    void sellProducts() throws IOException {

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
        Product productList14 = new Product();

        productList1.setName(productss.get(0).getName());
        productList1.setCategory(productss.get(0).getCategory());
        productList1.setId(productss.get(0).getId());
        productList1.setAmount(productss.get(0).getAmount());
        productList1.setNumberOfProducts(productss.get(0).getNumberOfProducts());

        productList14.setName(productss.get(14).getName());
        productList14.setCategory(productss.get(14).getCategory());
        productList14.setId(productss.get(14).getId());
        productList14.setAmount(productss.get(14).getAmount());
        productList14.setNumberOfProducts(productss.get(14).getNumberOfProducts());



        Customer customer1 = new Customer(1, "Lilian", "Ike", "lily@gmail.com", 1000, 1);
        Customer customer2 = new Customer(2, "Tobi", "Akin", "tobbie@gmail.com", 200, 1);


        Cashier cashier1 = new Cashier(1, "Peace", "Obute", "pce@gmail.com", 1);

        String success = cashier1.getFirstName() + " sold " + productList1.getNumberOfProducts() + " " + productList1.getName() +
                " to " + customer1.getFirstName() + " today.";

        String successButFinishedProduct = "Oops! unavailable product";
        String fail = "You do not have enough cash to purchase this product";

        String productSold = cashier1.sellProducts(productList1, customer1);
        String productSold2 = cashier1.sellProducts(productList14,customer2);
        String productSold3 = cashier1.sellProducts(productList1,customer2);

        Assertions.assertEquals(success, productSold);
        Assertions.assertEquals(successButFinishedProduct, productSold2);
        Assertions.assertEquals(fail, productSold3);
    }

   @Test
   void dispenseReceipts() throws IOException {

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
    Product productList14 = new Product();

        productList1.setName(productss.get(0).getName());
        productList1.setCategory(productss.get(0).getCategory());
        productList1.setId(productss.get(0).getId());
        productList1.setAmount(productss.get(0).getAmount());
        productList1.setNumberOfProducts(productss.get(0).getNumberOfProducts());

        productList14.setName(productss.get(14).getName());
        productList14.setCategory(productss.get(14).getCategory());
        productList14.setId(productss.get(14).getId());
        productList14.setAmount(productss.get(14).getAmount());
        productList14.setNumberOfProducts(productss.get(14).getNumberOfProducts());



       Customer customer1 = new Customer(1, "Lilian", "Ike", "lily@gmail.com", 1000, 1);
        Receipts receipt2 = new Receipts(2, 600, "Transaction receipt", productList1);
        Cashier cashier1 = new Cashier(1, "Peace", "Obute", "pce@gmail.com", 1);


        String successful = "Here is your statement: \n" + receipt2.getTypeOfReceipt() + ": " + receipt2.getReceiptAmount() +
                " \n Product name: " + productList1.getName() + " no of products: " + productList1.getNumberOfProducts();

        String receiptDispensed = cashier1.dispenseReceipts(receipt2, productList1, customer1);


        Assertions.assertEquals(successful, receiptDispensed);

    }

    @Test
    void isProductAvailable() throws IOException {

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

        Cashier cashier1 = new Cashier(1, "Peace", "Obute", "pce@gmail.com", 1);


        Product productList10 = new Product();
        Product productList9 = new Product();
        Product productList6 = new Product();

        productList9.setName(productss.get(9).getName());
        productList9.setCategory(productss.get(9).getCategory());
        productList9.setId(productss.get(9).getId());
        productList9.setAmount(productss.get(9).getAmount());
        productList9.setNumberOfProducts(productss.get(9).getNumberOfProducts());

        productList6.setName(productss.get(6).getName());
        productList6.setCategory(productss.get(6).getCategory());
        productList6.setId(productss.get(6).getId());
        productList6.setAmount(productss.get(6).getAmount());
        productList6.setNumberOfProducts(productss.get(6).getNumberOfProducts());

        productList10.setName(productss.get(10).getName());
        productList10.setCategory(productss.get(10).getCategory());
        productList10.setId(productss.get(10).getId());
        productList10.setAmount(productss.get(10).getAmount());
        productList10.setNumberOfProducts(productss.get(10).getNumberOfProducts());


        Store store = new Store();
        store.setName("EveryDays");
        store.setAddress("14c Abakaliki Rd GRA Enugu");
        store.setAllProducts(productss);

        Customer customer1 = new Customer(1, "Lilian", "Ike", "lily@gmail.com", 100000, 1);
        Customer customer2 = new Customer(1, "Lilian", "Ike", "lily@gmail.com", 1000, 2);


        String successful = "There are " + (productList9.getNumberOfProducts() -1) + " units  of " +
                productList9.getName() + " remaining in the store";


         String isProductAvailable = cashier1.isProductAvailable(productList9, store, customer1);

        Assertions.assertEquals(successful, isProductAvailable);
        Assertions.assertThrows(OutofStockException.class, () -> cashier1.isProductAvailable(productList6, store, customer1));
       Assertions.assertThrows(InsufficientFundException.class, ()-> cashier1.isProductAvailable(productList10, store, customer2));


    }

}


