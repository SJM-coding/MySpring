package mylab.customer;

import mylab.customer.service.CustomerService;
import mylab.customer.vo.CustomerVO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class CustomerSpringTest {

    @Autowired
    CustomerService service;

    @Test
    void testInsertAndSelect() {
        CustomerVO customer = new CustomerVO();
        customer.setEmail("kim@test.com");
        customer.setName("김자바");
        customer.setAge(25);

        service.insertCustomer(customer);

        List<CustomerVO> list = service.getAllCustomerList();
        assertFalse(list.isEmpty());

        CustomerVO c = service.getCustomerInfo(list.get(0).getId());
        System.out.println(c);
    }
}
