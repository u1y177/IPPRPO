package by.gstu.project.model;

public class Customer {
    private int id;
    private String name;
    private double totalPurchases;

    public Customer(int id, String name, double totalPurchases) {
        this.id = id;
        this.name = name;
        this.totalPurchases = totalPurchases;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getTotalPurchases() { return totalPurchases; }
    public void setTotalPurchases(double totalPurchases) { this.totalPurchases = totalPurchases; }
}