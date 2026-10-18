package com.apex;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderService {

    private static final Logger logger =
            LoggerFactory.getLogger(OrderService.class);

    public boolean processOrder(String orderId, double amount) {

        logger.info("Processing order: {}", orderId);

        logger.debug("Validating order: {}", orderId);

        if (orderId == null || orderId.isBlank()) {
            logger.error("Order ID is invalid");
            return false;
        }

        if (amount <= 0) {
            logger.error("Invalid amount for order: {}", orderId);
            return false;
        }

        if (amount > 1000) {
            logger.warn("Large order detected: {}, amount: {}",
                    orderId, amount);
        }

        logger.info("Payment successful for order: {}", orderId);

        logger.info("Order completed successfully: {}", orderId);

        return true;
    }
}
