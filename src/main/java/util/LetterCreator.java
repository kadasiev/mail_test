package util;

import static util.RandomStringGenerator.generateRandomString;

import model.Letter;

public class LetterCreator {

  public static Letter newLetter(String sender, String receiver) {
    return new Letter(sender, receiver, generateRandomString(10),
        generateRandomString(500));
  }
}
