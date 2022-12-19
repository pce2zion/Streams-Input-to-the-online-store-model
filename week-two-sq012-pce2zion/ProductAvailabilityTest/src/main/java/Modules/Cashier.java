package Modules;

import Exceptions.InsufficientFundException;
import Exceptions.OutofStockException;
import Interface.CashierInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cashier extends Staff implements CashierInterface {
    public Cashier() {
    }

    public Cashier(Integer id, String firstName, String lastName, String email, Integer staffId) {
        super(id, firstName, lastName, email, staffId);
    }

    @Override
    public String toString() {
        return "Cashier{} " + super.toString();
    }


    @Override
    public String sellProducts(Product product, Customer customer) {
        String balanceStatement = "";
        if (customer.getCashAtHand() >= product.getAmount() && product.getNumberOfProducts() >= 1) {

            balanceStatement = this.getFirstName() + " sold " + product.getNumberOfProducts() + " " + product.getName() +
                    " to " + customer.getFirstName() + " today.";

            product.setNumberOfProducts(product.getNumberOfProducts() - 1);


        }  else if (customer.getCashAtHand() < product.getAmount() && product.getNumberOfProducts() >= 1) {
          balanceStatement = "You do not have enough cash to purchase this product";

        } else if (customer.getCashAtHand() >= product.getAmount() && product.getNumberOfProducts() < 1) {
            balanceStatement = "Oops! unavailable product";
        }
        return balanceStatement;
    }



    @Override
    public String dispenseReceipts(Receipts receipts, Product product, Customer customer) {
        Integer txn = (customer.getCashAtHand() - product.getAmount());
        String receiptName = "";

        if (txn == customer.getCashAtHand() - product.getAmount()) {
            receiptName = "Here is your statement: \n" + receipts.getTypeOfReceipt() + ": " + receipts.getReceiptAmount() +
                    " \n Product name: " + product.getName() + " no of products: " + product.getNumberOfProducts();
        }

        return receiptName;

    }


    @Override
    public String isProductAvailable(Product product, Store store, Customer customer) throws IOException {



        String file = "/Users/home/IdeaProjects/week-two-sq012-pce2zion/ProductAvailabilityTest/src/main/java/csv/Store Sheet - Sheet1.csv";
        String line = "";
        List<Product> productss =new ArrayList<>();

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




        String msg = "";
        List<Product> productsList = store.getAllProducts();
        for(int i = 0; i < productsList.size(); i++){
            if(productsList.get(i).getId() == product.getId()){
                if(customer.getCashAtHand() >= productsList.get(i).getAmount() * customer.getNumberToBuy() && productsList.get(i).getNumberOfProducts() > 1){
                    productsList.get(i).setNumberOfProducts(productsList.get(i).getNumberOfProducts() - customer.getNumberToBuy());
                    msg = "There are " + productsList.get(i).getNumberOfProducts() + " units  of " + productsList.get(i).getName() + " remaining in the store";
                    return msg;
                }else if (customer.getCashAtHand() >= productsList.get(i).getAmount()* customer.getNumberToBuy() && productsList.get(i).getNumberOfProducts() == 1){
                    productsList.get(i).setNumberOfProducts(0);
                  msg = productsList.get(i).getName() + " out of stock. ";
                    throw new OutofStockException(msg);

                }else if (customer.getCashAtHand() >= productsList.get(i).getAmount() * customer.getNumberToBuy() && productsList.get(i).getNumberOfProducts() < 1){
                      msg = productsList.get(i).getName() + " out of stock. ";
                   throw new OutofStockException(msg);


                }else if (customer.getCashAtHand() < productsList.get(i).getAmount() * customer.getNumberToBuy() && productsList.get(i).getNumberOfProducts() >= 1){
                    msg =  "Insufficient cash";
                    throw  new InsufficientFundException(msg);

                }
            } else {
            }
            msg = "We don't sell this product here";

        }
        return msg;
    }


}

