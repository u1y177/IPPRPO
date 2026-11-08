package by.gstu.project.core.service;

import by.gstu.project.core.model.Category;
import by.gstu.project.core.model.Customer;
import by.gstu.project.core.model.Product;
import java.util.List;
import java.util.stream.Collectors;

public class ShopService {
    public List<Product> findProductsByCategory(List<Product> products, Category category) {
        return products.stream()
                .filter(p -> p.getCategory().getId() == category.getId())
                .collect(Collectors.toList());
    }

    public List<Customer> filterCustomersByTotalPurchases(List<Customer> customers, double minSum) {
        return customers.stream()
                .filter(c -> c.getTotalPurchases() >= minSum)
                .collect(Collectors.toList());
    }
}