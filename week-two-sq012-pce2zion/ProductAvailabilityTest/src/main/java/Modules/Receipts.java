package Modules;

public class Receipts {

    private  Integer id;

    private Integer receiptAmount;

    private String typeOfReceipt;

    private String Product;



    public Receipts() {
    }

    public Receipts(Integer id, Integer receiptAmount, String typeOfReceipt, Product product) {
        this.id = id;
        this.receiptAmount = receiptAmount;
        this.typeOfReceipt = typeOfReceipt;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(Integer receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public String getTypeOfReceipt() {
        return typeOfReceipt;
    }

    public void setTypeOfReceipt(String typeOfReceipt) {
        this.typeOfReceipt = typeOfReceipt;
    }


    @Override
    public String toString() {
        return "Receipts{" +
                "id=" + id +
                ", receiptAmount=" + receiptAmount +
                ", typeOfReceipt='" + typeOfReceipt + '\'' +
                '}';

    }
}
