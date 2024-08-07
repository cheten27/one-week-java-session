import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

class Customer {
    private int id;
    private String name;
    private String email;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer ID: " + id + ", Name: " + name + ", Email: " + email;
    }
}

public class CustomerManagementSystem {
    private static LinkedList<Customer> customerList = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nCustomer Management System");
            System.out.println("1. Add a Customer");
            System.out.println("2. Remove a Customer");
            System.out.println("3. Search for a Customer");
            System.out.println("4. List All Customers");
            System.out.println("5. Sort Customers by Name");
            System.out.println("6. Sort Customers by ID");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    removeCustomer();
                    break;
                case 3:
                    searchCustomer();
                    break;
                case 4:
                    listAllCustomers();
                    break;
                case 5:
                    sortCustomersByName();
                    break;
                case 6:
                    sortCustomersById();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addCustomer() {
        System.out.print("Enter Customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Customer Email: ");
        String email = scanner.nextLine();

        Customer newCustomer = new Customer(id, name, email);
        customerList.add(newCustomer);
        System.out.println("Customer added successfully.");
    }

    private static void removeCustomer() {
        System.out.print("Enter Customer ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        boolean removed = customerList.removeIf(customer -> customer.getId() == id);
        if (removed) {
            System.out.println("Customer removed successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void searchCustomer() {
        System.out.print("Enter Customer ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                System.out.println(customer);
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    private static void listAllCustomers() {
        if (customerList.isEmpty()) {
            System.out.println("No customers to display.");
        } else {
            for (Customer customer : customerList) {
                System.out.println(customer);
            }
        }
    }

    private static void sortCustomersByName() {
        ArrayList<Customer> sortedList = new ArrayList<>(customerList);
        sortedList.sort(Comparator.comparing(Customer::getName));
        customerList = new LinkedList<>(sortedList);
        System.out.println("Customers sorted by name.");
    }

    private static void sortCustomersById() {
        ArrayList<Customer> sortedList = new ArrayList<>(customerList);
        sortedList.sort(Comparator.comparingInt(Customer::getId));
        customerList = new LinkedList<>(sortedList);
        System.out.println("Customers sorted by ID.");
    }
}