package pl.danceclub.app.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    //dodana stała
    public static final String NOTIFICATION_ATTRIBUTE = "notification";

    @GetMapping("/admin")
    public String getAdminPanel() {
        return "admin/admin";
    }
}
