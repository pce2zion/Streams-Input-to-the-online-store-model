package Modules;

public class Product {

    private Integer id;

    private String name;

    private Integer amount;

    private String category;


    private Integer numberOfProducts;

    public Product() {
    }

    public Product(Integer id, String name, Integer amount, String category, Integer numberOfProducts) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.category = category;
        this.numberOfProducts = numberOfProducts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(Integer numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", category='" + category + '\'' +
                ", numberOfProducts=" + numberOfProducts +
                "}\n";
    }
}
