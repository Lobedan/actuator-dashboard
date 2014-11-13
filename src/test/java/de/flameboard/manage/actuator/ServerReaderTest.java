package de.flameboard.manage.actuator;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author svenklemmer
 * @since 1.0.0
 */
@RunWith(JUnit4.class)
public class ServerReaderTest {
  private static final Logger LOGGER = Logger.getLogger(ServerReaderTest.class);

  private static final String TEST_CONTENT = "{\n"
                                             + "  \"ui\": [\n"
                                             + "    \"http://mosaic4cap.de\",\n"
                                             + "    \"http://mosaic4cap.de:81\",\n"
                                             + "    \"http://mosaic4cap.de:82\"\n"
                                             + "  ],\n"
                                             + "  \"backend\": [\n"
                                             + "    \"http://mosaic4cap.de:83\",\n"
                                             + "    \"http://mosaic4cap.de:84\"\n"
                                             + "  ],\n"
                                             + "  \"services\": [\n"
                                             + "    \"http://mosaic4cap.de:85\",\n"
                                             + "    \"http://mosaic4cap.de:86\"\n"
                                             + "  ]\n"
                                             + "}";

  @Test
  public void canGetContentOfFile() throws Exception {
    ServerReader sr = new ServerReader();
    String content = sr.openFile("server.json");
    LOGGER.debug(content);
    assertThat(content.length(), is(TEST_CONTENT.length()));
    assertThat(content, is(TEST_CONTENT));
  }

  @Test(expected = IOException.class)
  public void canNotFindFileAndThrowsException() throws Exception {
    ServerReader sr = new ServerReader();
    sr.openFile("server2.json");
  }

  @Test
  public void canDecodeFileContent() throws Exception {
    ServerReader sr = new ServerReader();
    String content = sr.openFile("server.json");
    LOGGER.debug(content);

    Server s = new Server();
    s.addUiService("http://mosaic4cap.de");
    s.addUiService("http://mosaic4cap.de:81");
    s.addUiService("http://mosaic4cap.de:82");

    s.addBackendService("http://mosaic4cap.de:83");
    s.addBackendService("http://mosaic4cap.de:84");

    s.addOtherService("http://mosaic4cap.de:85");
    s.addOtherService("http://mosaic4cap.de:86");

    String sString = new ObjectMapper().writeValueAsString(s);
    LOGGER.debug(sString);

    Server server = sr.decode(content, Server.class);
    assertThat(server, is(notNullValue()));
    assertThat(server.getUiServices().size(), is(3));
    assertThat(server.getBackendServices().size(), is(2));
    assertThat(server.getOtherServices().size(), is(2));
  }
}
