package mylab.order.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {

    @Autowired
    ShoppingCart shoppingCart;

    @Resource(name = "orderService")
    OrderService orderService;

    @Test
    void testShoppingCartBean() {
        assertNotNull(shoppingCart);
        assertEquals(2, shoppingCart.getProducts().size());

        // 상품 이름 확인
        assertEquals("Notebook", shoppingCart.getProducts().get(0).getName());
        assertEquals("Pen", shoppingCart.getProducts().get(1).getName());

        System.out.println("ShoppingCart Products: " + shoppingCart.getProducts());
    }

    @Test
    @Disabled
    void testOrderServiceBean() {
        assertNotNull(orderService);

        double total = orderService.calculateOrderTotal();
        System.out.println("Order Total Price: " + total);

        // Notebook 1500.0 + Pen 3.0 = 1503.0
        assertEquals(1503.0, total, 0.01);
    }
}
