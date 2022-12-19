package Modules;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private String name;

    private String address;

    private List<Product> allProducts;
    // ArrayList<Product> productss =new ArrayList<>();

    public Store() {
    }

    public Store(String name, String address, ArrayList<Product> allProducts) {
        this.name = name;
        this.address = address;
        this.allProducts = allProducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(List<Product> allProducts) {
        this.allProducts = allProducts;
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", allProducts=" + allProducts +
                '}';
    }
}
