package de.flameboard.manage.actuator;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * service gets services adresses from server.json
 *
 * =======IDEE=======
 *
 * bei starten der anwendung lesen der server.json
 * speichern der adressen in h2 datenbank (evtl. mysql wegen langzeitauswertung)
 *
 * --*-- ScheduledTask --*--
 * holden der /info route jedes servers
 * holden der /health route jedes servers
 * speichern der daten in h2 (bzw. mysql)
 * --*-- ScheduledTask ende --*--
 *
 * --*-- Frontend auto task --*--
 * holen der daten mittels crudservice
 * --> siehe unten
 * --*-- Frontend auto task end --*--
 *
 * --*-- backend step --*--
 * holen der daten mit service aus datenbank
 * object in service erstellen
 * an controller zurückgeben
 * --*-- backend step ende --*--
 *
 * @author svenklemmer
 * @since 1.0.0
 */
@Service
public class ServerReaderService {
  private static final Logger LOGGER = Logger.getLogger(ServerReaderService.class);

  public Server getServiceServers() throws IOException {
    return new ServerReader().decode();
  }
}
