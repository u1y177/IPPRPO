package by.gstu.project.cli;

import by.gstu.project.core.model.Category;
import by.gstu.project.core.model.Customer;
import by.gstu.project.core.model.Product;
import by.gstu.project.core.service.ShopService;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Category electronics = new Category(1, "Электроника");
        Category books = new Category(2, "Книги");
        Category clothes = new Category(3, "Одежда");

        List<Product> products = Arrays.asList(
                new Product(1, "Смартфон", electronics, 500),
                new Product(2, "Ноутбук", electronics, 1200),
                new Product(3, "Java. Полное руководство", books, 50),
                new Product(4, "Футболка", clothes, 20)
        );

        List<Customer> customers = Arrays.asList(
                new Customer(1, "Иван", 1500),
                new Customer(2, "Мария", 300),
                new Customer(3, "Пётр", 800),
                new Customer(4, "Анна", 50)
        );

        ShopService service = new ShopService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Интернет-магазин ===");
            System.out.println("1. Показать все товары");
            System.out.println("2. Найти товары по категории");
            System.out.println("3. Показать всех покупателей");
            System.out.println("4. Отфильтровать покупателей по сумме покупок");
            System.out.println("0. Выход");
            System.out.print("Выбор: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    products.forEach(p -> System.out.println(p.getId() + " | " + p.getName() + " | " + p.getCategory().getName() + " | " + p.getPrice()));
                    break;
                case 2:
                    System.out.print("Введите название категории: ");
                    String catName = scanner.nextLine();
                    Category foundCat = null;
                    for (Category c : Arrays.asList(electronics, books, clothes)) {
                        if (c.getName().equalsIgnoreCase(catName)) { foundCat = c; break; }
                    }
                    if (foundCat == null) {
                        System.out.println("Категория не найдена.");
                    } else {
                        List<Product> result = service.findProductsByCategory(products, foundCat);
                        if (result.isEmpty()) System.out.println("Товары не найдены.");
                        else result.forEach(p -> System.out.println(p.getId() + " | " + p.getName() + " | " + p.getPrice()));
                    }
                    break;
                case 3:
                    customers.forEach(c -> System.out.println(c.getId() + " | " + c.getName() + " | " + c.getTotalPurchases()));
                    break;
                case 4:
                    System.out.print("Введите минимальную сумму покупок: ");
                    double minSum = scanner.nextDouble();
                    List<Customer> filtered = service.filterCustomersByTotalPurchases(customers, minSum);
                    if (filtered.isEmpty()) System.out.println("Покупатели не найдены.");
                    else filtered.forEach(c -> System.out.println(c.getId() + " | " + c.getName() + " | " + c.getTotalPurchases()));
                    break;
                case 0:
                    System.out.println("Выход.");
                    return;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }
}