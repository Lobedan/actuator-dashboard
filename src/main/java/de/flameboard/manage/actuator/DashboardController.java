package de.flameboard.manage.actuator;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Entrypoint to dashboard
 *
 * @author svenklemmer
 * @since 1.0.0
 */
@Controller
public class DashboardController {
  private static final Logger LOGGER = Logger.getLogger(DashboardController.class);

  @RequestMapping("/")
  public String main() {
    return "dashboard";
  }
}
