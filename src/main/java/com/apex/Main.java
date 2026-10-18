package com.apex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Application started");
        OrderService orderService = new OrderService();
        // normal order
        orderService.processOrder("ORDER-1001", 100.0);
        // Scenario 2: Large order
        orderService.processOrder("ORDER-1002", 1500.0);

        // Scenario 3: Invalid order
        orderService.processOrder("ORDER-1003", -50.0);

        logger.info("Application finished");
    }
}