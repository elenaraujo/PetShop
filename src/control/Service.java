package control;

import java.util.Comparator;

import model.domain.Product;

public class Service implements Comparator<Product> {

    @Override
    public int compare(Product other1, Product other2) {
        if (other1.getCodigo() > other2.getCodigo()) {
            return 1;
        } else if (other1.getCodigo() < other2.getCodigo()) {
            return -1;
        }
        return 0;
    }
}
