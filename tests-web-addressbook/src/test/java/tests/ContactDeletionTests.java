package tests;

import model.ContactData;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {
  protected FirefoxDriver wd;

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Vladimir", null, "Pirogov", null, null, null, null, null, null, null, null, null, null, null));
    }
  }

  @Test
  public void testContactDeletion()  {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().returnToHomePageContact();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
      Assert.assertEquals(before, after);
  }

}
