package com.good.patterns.challenges.service;

public class Main {
    public static void main(String[] args) {

        User user = new User(1L, "Leon Lok", "leon.lok@example.com");
        Product product = new Product(1L, "Video game", 59.99);

        InformationService informationService = new EmailInformationService();
        OrderService orderService = new SimpleOrderService();
        OrderRepository orderRepository = new InMemoryOrderRepository();

        ProductOrderService productOrderService = new ProductOrderService(informationService, orderService, orderRepository);

        ProductOrderRequest orderRequest = new ProductOrderRequest(user, product, 1);

        OrderDTO orderResult = productOrderService.process(orderRequest);

        System.out.println("Order processing result for user " + orderResult.getUser().getName() + ": " + (orderResult.isOrdered() ? "Success" : "Failure"));
    }
}

