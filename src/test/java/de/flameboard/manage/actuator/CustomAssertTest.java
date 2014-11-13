package de.flameboard.manage.actuator;

/**
 * @author svenklemmer
 * @since 1.0.0
 */
//@RunWith(JUnit4.class)
public class CustomAssertTest {

//  @Test
  public void throwsNoExceptionIfContain() throws Exception {
    String testString = "hi i am";
    String toSearch = "am";
    CustomAssert.doesContain(testString, toSearch);
  }

//  @Test(expected = IllegalArgumentException.class)
  public void throwsExceptionIfContain() throws Exception {
    String testString = "hi i am";
    String toSearch = "allo";
    CustomAssert.doesContain(testString, toSearch);
  }
}
