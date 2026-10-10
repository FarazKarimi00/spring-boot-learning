package in.strikes.profileDemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"dev", "default", "staging"})
public class DummyNotificationServiceImpl implements NotificationService{
    @Override
    public String send() {
        // dummy notification (no real notification is sent )
        return "Here is the dummy notification";
    }
}
