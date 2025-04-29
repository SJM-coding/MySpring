package mylab.notification.di.annot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Bean
    public EmailNotificationService emailNotificationService() {
        return new EmailNotificationService("smtp.example.com", 587);
    }

    @Bean
    public SmsNotificationService smsNotificationService() {
        return new SmsNotificationService("CoolSMS");
    }

    @Bean
    public NotificationManager notificationManager() {
        return new NotificationManager(emailNotificationService(), smsNotificationService());
    }
}
