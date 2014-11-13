package de.flameboard.manage.actuator;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * @author svenklemmer
 * @since 1.0.0
 */
public class CustomAssert extends Assert {
  private static final Logger LOGGER = Logger.getLogger(CustomAssert.class);

  /**
   * Assert that the given text does contain the given substring.
   * <pre class="code">Assert.doesContain(name, "rod", "Name must contain 'rod'");</pre>
   * @param textToSearch the text to search
   * @param substring the substring to find within the text
   * @param message the exception message to use if the assertion fails
   */
  public static void doesContain(String textToSearch, String substring, String message) {
    if (StringUtils.hasLength(textToSearch) && StringUtils.hasLength(substring) &&
        !textToSearch.contains(substring)) {
      throw new IllegalArgumentException(message);
    }
  }

  /**
   * Assert that the given text does contain the given substring.
   * <pre class="code">Assert.doesContain(name, "rod");</pre>
   * @param textToSearch the text to search
   * @param substring the substring to find within the text
   */
  public static void doesContain(String textToSearch, String substring) {
    doesNotContain(textToSearch, substring,
                   "[Assertion failed] - this String argument must contain the substring [" + substring + "]");
  }
}
