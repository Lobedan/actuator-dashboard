package de.flameboard.manage.actuator;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Passes information from services to thymeleaf frontend
 *
 * @author svenklemmer
 * @since 1.0.0
 */
@ControllerAdvice
public class DashboardDefinition {
  private static final Logger LOGGER = Logger.getLogger(DashboardDefinition.class);

  @Autowired
  private ServerReaderService readerService;

  @ModelAttribute(value = "services")
  public Server getServices() throws IOException {
    return readerService.getServiceServers();
  }
}
