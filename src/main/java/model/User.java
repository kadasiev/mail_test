package model;

public record User(String accountName, String password) {

  @Override
  public String toString() {
    return "User (" +
        "accountName = '" + accountName + '\'' +
        ", password= '" + password + '\'' +
        ')';
  }
}
