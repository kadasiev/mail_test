package util;

import static java.util.ResourceBundle.getBundle;

import java.util.ResourceBundle;

public class TestDataReader {

  private final static ResourceBundle resourceBundle = getBundle(System.getProperty("env"));

  public static String getTestData(String key) {
    return resourceBundle.getString(key);
  }
}
