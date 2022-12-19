package Modules;

import Interface.CustomerInterface;

public class Customer extends Person  implements CustomerInterface{


    private Integer cashAtHand;

    private Integer numberToBuy;


    public Customer() {
    }



    public Customer(Integer id, String firstName, String lastName, String email, Integer cashAtHand, Integer numberToBuy) {
        super(id, firstName, lastName, email);
        this.cashAtHand = cashAtHand;
        this.numberToBuy = numberToBuy;
    }

    public Integer getCashAtHand() {
        return cashAtHand;
    }

    public void setCashAtHand(Integer cashAtHand) {
        this.cashAtHand = cashAtHand;
    }

    public Integer getNumberToBuy() {
        return numberToBuy;
    }

    public void setNumberToBuy(Integer numberToBuy) {
        this.numberToBuy = numberToBuy;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cashAtHand=" + cashAtHand +
                ", numberToBuy=" + numberToBuy +
                "} " + super.toString();
    }

    @Override
    public String buyProducts(Product product) {
        String msg = "";
        if (this.cashAtHand > product.getAmount() * this.getNumberToBuy()) {
            msg= "Your product: " + product.getNumberOfProducts()+ " " + product.getName() +
                    " is ready.";
        } else if (this.cashAtHand < product.getAmount() * this.getNumberToBuy()) {
            return "Your product: " + product.getNumberOfProducts()+ " " + product.getName() + ". Sorry your money is not enough.";
        } else if (this.cashAtHand.equals(product.getAmount() * this.getNumberToBuy())) {
            msg= "Your product: " + product.getNumberOfProducts()+ " " + product.getName() +
                    " is ready. Thank you for shopping with us.";
        }
        return msg;
    }


}

