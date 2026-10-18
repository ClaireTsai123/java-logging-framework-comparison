package com.apex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {
    private final OrderService orderService = new OrderService();

    //1.Normal order
    @Test
    void testSuccessfulOrder() {
        boolean result = orderService.processOrder("ORDER-1001", 100.0);
        assertTrue(result);

    }
    //2.Invalid amount
    @Test
    void testInvalidAmount() {
        boolean result = orderService.processOrder("ORDER-1002", -50.0);
        assertFalse(result);
    }
    //3.Invalid order ID
    @Test
    void testInvalidOrderId() {
        boolean result = orderService.processOrder("", 100.0);
        assertFalse(result);
    }

}
