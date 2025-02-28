package steps;

public class NavigationSteps extends BaseSteps {

  public void openFolderInMail(String folder) {
    String folderName;

    switch (folder) {
      case "Sent" -> folderName = "Отправленные";
      default -> throw new IllegalArgumentException("Unknown folder: " + folder);
    }
    mailMailboxPage.openFolder(folderName);
  }
}
