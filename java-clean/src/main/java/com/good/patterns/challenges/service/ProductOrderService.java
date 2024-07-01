package com.good.patterns.challenges.service;

public class ProductOrderService {
    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public ProductOrderService(InformationService informationService, OrderService orderService, OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDTO process(final ProductOrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getQuantity());
        if (isOrdered) {
            informationService.inform(orderRequest.getUser(), true);
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getQuantity());
            return new OrderDTO(orderRequest.getUser(), true);
        } else {
            informationService.inform(orderRequest.getUser(), false);
            return new OrderDTO(orderRequest.getUser(), false);
        }
    }
}
