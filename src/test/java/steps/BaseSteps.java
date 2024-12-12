package steps;

import pages.MailMailboxPage;
import pages.MailSignInPage;
import pages.OutlookMailboxPage;
import pages.OutlookSignInPage;

public class BaseSteps {

  public MailMailboxPage mailMailboxPage = new MailMailboxPage();
  public MailSignInPage mailSignInPage = new MailSignInPage();
  public OutlookMailboxPage outlookMailboxPage = new OutlookMailboxPage();
  public OutlookSignInPage outlookSignInPage = new OutlookSignInPage();
}
