package de.flameboard.manage.actuator;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

/**
 * Reads the server.json file, which holds all server which should be shown in the dashboard split by backend-service,
 * ui-service and other services like email, database services
 *
 * @author svenklemmer
 * @since 1.0.0
 */
public class ServerReader {
  private static final Logger LOGGER = Logger.getLogger(ServerReader.class);
  private static final String FILE_NAME = "/config/server.json";

  private ResourceLoader loader = new DefaultResourceLoader();

  /**
   * openes the file specified under {@link #FILE_NAME}
   *
   * @return content of file
   * @throws IOException
   */
  public String openFile() throws IOException {
    return openFile(loader.getResource(FILE_NAME).getFile());
  }

  /**
   * opens a file and gets it content
   *
   * @param s file name of file to open
   * @return content of file
   * @throws IOException
   */
  public String openFile(String s) throws IOException {
    return openFile(loader.getResource(s).getFile());
  }

  /**
   * opens a file and gets it content
   *
   * @param f file to open
   * @return content
   * @throws IOException
   */
  public String openFile(File f) throws IOException {
    LOGGER.debug("Open file @ " + f.getAbsolutePath() + " returning content");
    return FileUtils.readFileToString(f);
  }

  /**
   * decodes the json in a useable object
   * uses {@link #openFile(File f)} to get its content
   *
   * @param str content to decode
   * @return server object
   */
  public <T> T decode(String str, Class<T> c) {
    T obj = null;
    try {
      ObjectMapper objMapper = new ObjectMapper();
      LOGGER.debug("mapping content to " + c.getClass().getName());
      obj = objMapper.readValue(str, c);
    } catch (IOException e) {
      LOGGER.error(e);
    }
    return obj;
  }

  /**
   * decodes content from {@link #FILE_NAME}
   * @return server object
   * @throws IOException
   */
  public Server decode() throws IOException {
    Server s = decode(openFile(), Server.class);
    LOGGER.debug("returning server object instance");
    return s;
  }

}
