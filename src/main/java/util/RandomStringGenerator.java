package util;

import java.util.Random;

public class RandomStringGenerator {

  private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

  public static String generateRandomString(int length) {
    Random random = new Random();
    StringBuilder sb = new StringBuilder(length);

    for (int i = 0; i < length; i++) {
      sb.append(LETTERS.charAt(random.nextInt(LETTERS.length())));
    }
    return sb.toString();
  }
}
