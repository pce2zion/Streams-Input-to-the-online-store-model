package Interface;

import Modules.Customer;
import Modules.Product;
import Modules.Receipts;
import Modules.Store;

import java.io.IOException;
import java.util.List;

public interface CashierInterface {
    String sellProducts(Product product, Customer customer);

    String dispenseReceipts(Receipts receipts, Product product, Customer customer);

    String isProductAvailable(Product product,  Store store, Customer customer) throws IOException;

}
