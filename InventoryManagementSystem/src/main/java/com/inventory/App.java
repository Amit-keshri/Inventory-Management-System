package com.inventory;

import com.inventory.model.*;
import com.inventory.service.*;
import com.inventory.config.HibernateUtil;
import java.util.Scanner;
import java.util.Date;

public class App {
    private static CustomerService customerService = new CustomerService();
    private static ProductService productService = new ProductService();
    private static OrderService orderService = new OrderService();
    private static CategoryService categoryService = new CategoryService();
    private static SupplierService supplierService = new SupplierService();
    private static InventoryService inventoryService = new InventoryService();
    private static OrderDetailService orderDetailService = new OrderDetailService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Inventory Management System");
        while (true) {
            System.out.println("\nChoose an entity to operate on:");
            System.out.println("1. Customer");
            System.out.println("2. Product");
            System.out.println("3. Order");
            System.out.println("4. Category");
            System.out.println("5. Supplier");
            System.out.println("6. Inventory");
            System.out.println("7. OrderDetails");

            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleCustomerOperations(scanner);
                    break;
                case 2:
                    handleProductOperations(scanner);
                    break;
                case 3:
                    handleOrderOperations(scanner);
                    break;
                case 4:
                    handleCategoryOperations(scanner);
                    break;
                case 5:
                    handleSupplierOperations(scanner);
                    break;
                case 6:
                    handleInventoryOperations(scanner);
                    break;
                case 7:
                	handleOrderDetailOperations(scanner);

                case 8:
                    HibernateUtil.shutdown();
                    System.out.println("Exiting the system.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // CRUD Operations for Customer
    private static void handleCustomerOperations(Scanner scanner) {
        System.out.println("\nCustomer Operations:");
        System.out.println("1. Create Customer");
        System.out.println("2. View All Customers");
        System.out.println("3. Update Customer");
        System.out.println("4. Delete Customer");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter customer name: ");
                String name = scanner.next();
                System.out.print("Enter customer email: ");
                String email = scanner.next();
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(email);
                customerService.createCustomer(customer);
                System.out.println("Customer created successfully.");
                break;
            case 2:
                customerService.getAllCustomers().forEach(c -> 
                    System.out.println("ID: " + c.getId() + ", Name: " + c.getName() + ", Email: " + c.getEmail())
                );
                break;
            case 3:
                System.out.print("Enter customer ID to update: ");
                int customerId = scanner.nextInt();
                Customer existingCustomer = customerService.getCustomerById(customerId);
                if (existingCustomer != null) {
                    System.out.print("Enter new name: ");
                    existingCustomer.setName(scanner.next());
                    System.out.print("Enter new email: ");
                    existingCustomer.setEmail(scanner.next());
                    customerService.updateCustomer(existingCustomer);
                    System.out.println("Customer updated successfully.");
                } else {
                    System.out.println("Customer not found.");
                }
                break;
            case 4:
                System.out.print("Enter customer ID to delete: ");
                customerService.deleteCustomer(scanner.nextInt());
                System.out.println("Customer deleted successfully.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // CRUD Operations for Product
    private static void handleProductOperations(Scanner scanner) {
        System.out.println("\nProduct Operations:");
        System.out.println("1. Create Product");
        System.out.println("2. View All Products");
        System.out.println("3. Update Product");
        System.out.println("4. Delete Product");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter product name: ");
                String name = scanner.next();
                System.out.print("Enter product price: ");
                double price = scanner.nextDouble();
//                Product product = new Product();
//                product.setName(name);
//                product.setPrice(price);
                System.out.print("Enter category ID for the product: ");
                int categoryId = scanner.nextInt();
                Category category = categoryService.getCategoryById(categoryId);
                if (category == null) {
                    System.out.println("Invalid category ID.");
                    return;
                }

                System.out.print("Enter supplier ID for the product: ");
                int supplierId = scanner.nextInt();
                Supplier supplier = supplierService.getSupplierById(supplierId);
                if (supplier == null) {
                    System.out.println("Invalid supplier ID.");
                    return;
                }

                Product product = new Product();
                product.setName(name);
                product.setPrice(price);
                product.setCategory(category);
                product.setSupplier(supplier);

                productService.createProduct(product);

//                productService.createProduct(product);
                System.out.println("Product created successfully.");
                break;
            case 2:
                productService.getAllProducts().forEach(p ->
                    System.out.println("ID: " + p.getId() + ", Name: " + p.getName() + ", Price: " + p.getPrice())
                );
                break;
            case 3:
                System.out.print("Enter product ID to update: ");
                int productId = scanner.nextInt();
                Product existingProduct = productService.getProductById(productId);
                if (existingProduct != null) {
                    System.out.print("Enter new name: ");
                    existingProduct.setName(scanner.next());
                    System.out.print("Enter new price: ");
                    existingProduct.setPrice(scanner.nextDouble());
                    productService.updateProduct(existingProduct);
                    System.out.println("Product updated successfully.");
                } else {
                    System.out.println("Product not found.");
                }
                break;
            case 4:
                System.out.print("Enter product ID to delete: ");
                productService.deleteProduct(scanner.nextInt());
                System.out.println("Product deleted successfully.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // CRUD Operations for Order
    private static void handleOrderOperations(Scanner scanner) {
        System.out.println("\nOrder Operations:");
        System.out.println("1. Create Order");
        System.out.println("2. View All Orders");
        System.out.println("3. Update Order");
        System.out.println("4. Delete Order");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter customer ID for the order: ");
                int customerId = scanner.nextInt();
                Customer customer = customerService.getCustomerById(customerId);
                if (customer != null) {
                    Order order = new Order();
                    order.setCustomer(customer);
                    order.setOrderDate(new Date());
                    orderService.createOrder(order);
                    System.out.println("Order created successfully.");
                } else {
                    System.out.println("Customer not found.");
                }
                break;
            case 2:
                orderService.getAllOrders().forEach(o ->
                    System.out.println("Order ID: " + o.getId() + ", Customer ID: " + o.getCustomer().getId() +
                            ", Order Date: " + o.getOrderDate())
                );
                break;
            case 3:
                System.out.print("Enter order ID to update: ");
                int orderId = scanner.nextInt();
                Order existingOrder = orderService.getOrderById(orderId);
                if (existingOrder != null) {
                    System.out.print("Enter new customer ID: ");
                    Customer newCustomer = customerService.getCustomerById(scanner.nextInt());
                    if (newCustomer != null) {
                        existingOrder.setCustomer(newCustomer);
                        orderService.updateOrder(existingOrder);
                        System.out.println("Order updated successfully.");
                    } else {
                        System.out.println("Customer not found.");
                    }
                } else {
                    System.out.println("Order not found.");
                }
                break;
            case 4:
                System.out.print("Enter order ID to delete: ");
                orderService.deleteOrder(scanner.nextInt());
                System.out.println("Order deleted successfully.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
 // CRUD Operations for Category
    private static void handleCategoryOperations(Scanner scanner) {
        System.out.println("\nCategory Operations:");
        System.out.println("1. Create Category");
        System.out.println("2. View All Categories");
        System.out.println("3. Update Category");
        System.out.println("4. Delete Category");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter category name: ");
                String name = scanner.next();
                Category category = new Category();
                category.setName(name);
                categoryService.createCategory(category);
                System.out.println("Category created successfully.");
                break;
            case 2:
                categoryService.getAllCategories().forEach(c ->
                    System.out.println("ID: " + c.getId() + ", Name: " + c.getName())
                );
                break;
            case 3:
                System.out.print("Enter category ID to update: ");
                int categoryId = scanner.nextInt();
                Category existingCategory = categoryService.getCategoryById(categoryId);
                if (existingCategory != null) {
                    System.out.print("Enter new name: ");
                    existingCategory.setName(scanner.next());
                    categoryService.updateCategory(existingCategory);
                    System.out.println("Category updated successfully.");
                } else {
                    System.out.println("Category not found.");
                }
                break;
            case 4:
                System.out.print("Enter category ID to delete: ");
                categoryService.deleteCategory(scanner.nextInt());
                System.out.println("Category deleted successfully.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

 // CRUD Operations for Supplier
    private static void handleSupplierOperations(Scanner scanner) {
        System.out.println("\nSupplier Operations:");
        System.out.println("1. Create Supplier");
        System.out.println("2. View All Suppliers");
        System.out.println("3. Update Supplier");
        System.out.println("4. Delete Supplier");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter supplier name: ");
                String name = scanner.next();
                System.out.print("Enter supplier contact: ");
                String contact = scanner.next();
                Supplier supplier = new Supplier();
                supplier.setName(name);
                supplier.setContactInfo(contact);
                supplierService.createSupplier(supplier);
                System.out.println("Supplier created successfully.");
                break;
            case 2:
                supplierService.getAllSuppliers().forEach(s ->
                    System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", Contact: " + s.getContactInfo())
                );
                break;
            case 3:
                System.out.print("Enter supplier ID to update: ");
                int supplierId = scanner.nextInt();
                Supplier existingSupplier = supplierService.getSupplierById(supplierId);
                if (existingSupplier != null) {
                    System.out.print("Enter new name: ");
                    existingSupplier.setName(scanner.next());
                    System.out.print("Enter new contact: ");
                    existingSupplier.setContactInfo(scanner.next());
                    supplierService.updateSupplier(existingSupplier);
                    System.out.println("Supplier updated successfully.");
                } else {
                    System.out.println("Supplier not found.");
                }
                break;
            case 4:
                System.out.print("Enter supplier ID to delete: ");
                supplierService.deleteSupplier(scanner.nextInt());
                System.out.println("Supplier deleted successfully.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
   


    private static void handleInventoryOperations(Scanner scanner) {
        System.out.println("\nInventory Operations:");
        System.out.println("1. Create Inventory");
        System.out.println("2. View Inventory");
        System.out.println("3. Update Inventory Quantity");
        System.out.println("4. Delete Inventory");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 2:
                // View Inventory
                inventoryService.getAllInventories().forEach(inventory -> {
                    if (inventory != null && inventory.getProduct() != null) {
                        System.out.println("Product ID: " + inventory.getProduct().getId() +
                                           ", Product Name: " + inventory.getProduct().getName() +
                                           ", Quantity: " + inventory.getQuantity());
                    } else {
                        System.out.println("Inventory or Product details are missing.");
                    }
                });
                break;

            case 1:
                // Create Inventory
                System.out.print("Enter Product ID to create inventory: ");
                int productId = scanner.nextInt();
                Product product = productService.getProductById(productId);

                if (product != null) {
                    System.out.print("Enter initial quantity: ");
                    int initialQuantity = scanner.nextInt();

                    if (initialQuantity < 0) {
                        System.out.println("Quantity cannot be negative.");
                    } else {
                        Inventory inventory = new Inventory();
                        inventory.setProduct(product);
                        inventory.setQuantity(initialQuantity);
                        inventoryService.saveOrUpdateInventory(inventory);
                        System.out.println("Inventory created successfully for Product ID: " + productId);
                    }
                } else {
                    System.out.println("Product not found for the given ID.");
                }
                break;

            case 3:
                // Update Inventory
                System.out.print("Enter Product ID to update inventory: ");
                productId = scanner.nextInt();
                Inventory inventory = inventoryService.getInventoryByProductId(productId);

                if (inventory != null) {
                    System.out.println("Current Quantity: " + inventory.getQuantity());
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();

                    if (newQuantity < 0) {
                        System.out.println("Quantity cannot be negative.");
                    } else {
                        inventory.setQuantity(newQuantity);
                        inventoryService.saveOrUpdateInventory(inventory);
                        System.out.println("Inventory updated successfully.");
                    }
                } else {
                    System.out.println("No inventory found for the specified Product ID.");
                }
                break;

            case 4:
                // Delete Inventory
                System.out.print("Enter Inventory ID to delete: ");
                int inventoryId = scanner.nextInt();
                inventoryService.deleteInventoryById(inventoryId);
                System.out.println("Inventory deleted successfully.");
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

   
    
 // CRUD Operations for OrderDetail
//    private static void handleOrderDetailOperations(Scanner scanner) {
//        System.out.println("\nOrderDetail Operations:");
//        System.out.println("1. Create OrderDetail");
//        System.out.println("2. View All OrderDetails");
//        System.out.println("3. Update OrderDetail");
//        System.out.println("4. Delete OrderDetail");
//        System.out.print("Enter your choice: ");
//        int choice = scanner.nextInt();
//
//        switch (choice) {
//            case 1:
//                // Creating a new OrderDetail
//                System.out.print("Enter Order ID: ");
//                int orderId = scanner.nextInt();
//                Order order = orderService.getOrderById(orderId); // Ensure orderService is initialized
//
//                if (order != null) {
//                    System.out.print("Enter Product ID: ");
//                    int productId = scanner.nextInt();
//                    Product product = productService.getProductById(productId); // Ensure productService is initialized
//
//                    if (product != null) {
//                        System.out.print("Enter Quantity: ");
//                        int quantity = scanner.nextInt();
//
//                        System.out.print("Enter Price per unit: ");
//                        double price = scanner.nextDouble();
//
//                        OrderDetail orderDetail = new OrderDetail();
//                        orderDetail.setOrder(order);
//                        orderDetail.setProduct(product);
//                        orderDetail.setQuantity(quantity);
//                        orderDetail.setPrice(price);
//                        orderDetailService.createOrderDetail(orderDetail); // Ensure orderDetailService is initialized
//
//                        System.out.println("OrderDetail created successfully.");
//                    } else {
//                        System.out.println("Product not found.");
//                    }
//                } else {
//                    System.out.println("Order not found.");
//                }
//                break;
//
//            case 2:
//                // Viewing all OrderDetails
//                orderDetailService.getAllOrderDetails().forEach(od -> 
//                    System.out.println("OrderDetail ID: " + od.getId() +
//                                       ", Order ID: " + od.getOrder().getId() +
//                                       ", Product ID: " + od.getProduct().getId() +
//                                       ", Quantity: " + od.getQuantity() +
//                                       ", Price: " + od.getPrice())
//                );
//                break;
//
//            case 3:
//                // Updating an existing OrderDetail
//                System.out.print("Enter OrderDetail ID to update: ");
//                int orderDetailId = scanner.nextInt();
//                OrderDetail existingOrderDetail = orderDetailService.getOrderDetailById(orderDetailId);
//
//                if (existingOrderDetail != null) {
//                    System.out.print("Enter new Quantity: ");
//                    existingOrderDetail.setQuantity(scanner.nextInt());
//
//                    System.out.print("Enter new Price per unit: ");
//                    existingOrderDetail.setPrice(scanner.nextDouble());
//
//                    orderDetailService.updateOrderDetail(existingOrderDetail);
//                    System.out.println("OrderDetail updated successfully.");
//                } else {
//                    System.out.println("OrderDetail not found.");
//                }
//                break;
//
//            case 4:
//                // Deleting an OrderDetail
//                System.out.print("Enter OrderDetail ID to delete: ");
//                orderDetailService.deleteOrderDetail(scanner.nextInt());
//                System.out.println("OrderDetail deleted successfully.");
//                break;
//
//            default:
//                System.out.println("Invalid choice.");
//        }
//    }
    
    private static void handleOrderDetailOperations(Scanner scanner) {
        System.out.println("\nOrderDetail Operations:");
        System.out.println("1. Create OrderDetail");
        System.out.println("2. View All OrderDetails");
        System.out.println("3. Update OrderDetail");
        System.out.println("4. Delete OrderDetail");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter Order ID: ");
                int orderId = scanner.nextInt();
                Order order = orderService.getOrderById(orderId);

                if (order != null) {
                    System.out.print("Enter Product ID: ");
                    int productId = scanner.nextInt();
                    Product product = productService.getProductById(productId);

                    if (product != null) {
                        System.out.print("Enter Quantity: ");
                        int quantity = scanner.nextInt();

                        System.out.print("Enter Price per unit: ");
                        double price = scanner.nextDouble();

                        OrderDetail orderDetail = new OrderDetail();
                        orderDetail.setOrder(order);
                        orderDetail.setProduct(product);
                        orderDetail.setQuantity(quantity);
                        orderDetail.setPrice(quantity*price);
                        orderDetailService.createOrderDetail(orderDetail);

                        System.out.println("OrderDetail created successfully.");
                    } else {
                        System.out.println("Product not found.");
                    }
                } else {
                    System.out.println("Order not found.");
                }
                break;

            case 2:
                orderDetailService.getAllOrderDetails().forEach(od -> 
                    System.out.println("OrderDetail ID: " + od.getId() +
                                       ", Order ID: " + od.getOrder().getId() +
                                       ", Product ID: " + od.getProduct().getId() +
                                       ", Quantity: " + od.getQuantity() +
                                       ", Price: " + od.getPrice())
                );
                break;

            case 3:
                System.out.print("Enter OrderDetail ID to update: ");
                int orderDetailId = scanner.nextInt();
                OrderDetail existingOrderDetail = orderDetailService.getOrderDetailById(orderDetailId);

                if (existingOrderDetail != null) {
                    System.out.print("Enter new Quantity: ");
                    existingOrderDetail.setQuantity(scanner.nextInt());

                    System.out.print("Enter new Price per unit: ");
                    existingOrderDetail.setPrice(scanner.nextDouble());

                    orderDetailService.updateOrderDetail(existingOrderDetail);
                    System.out.println("OrderDetail updated successfully.");
                } else {
                    System.out.println("OrderDetail not found.");
                }
                break;

            case 4:
                System.out.print("Enter OrderDetail ID to delete: ");
                orderDetailService.deleteOrderDetail(scanner.nextInt());
                System.out.println("OrderDetail deleted successfully.");
                break;

            default:
                System.out.println("Invalid choice.");
                break;
        }
    }


}
