package mylab.notification.di.annot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NotificationConfigTest {

    @Test
    void testNotificationManager() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(NotificationConfig.class);

        NotificationManager manager = context.getBean(NotificationManager.class);
        assertNotNull(manager);
        assertNotNull(manager.getEmailService());
        assertNotNull(manager.getSmsService());

        manager.sendNotificationByEmail("이메일 테스트 메시지");
        manager.sendNotificationBySms("SMS 테스트 메시지");

        context.close();
    }
}
