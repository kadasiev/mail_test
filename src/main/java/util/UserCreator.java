package util;

import static util.TestDataReader.getValue;

import model.User;

public class UserCreator {

  public static User getMailUser() {
    return new User(getValue("mailAccountName"),
        getValue("mailPassword"));
  }

  public static User getOutlookUser() {
    return new User(getValue("outLookAccountName"),
        getValue("outLookPassword"));
  }
}
