package tests;

import model.ContactData;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {

  @Test
  public void testContactAddress() {
    app.contact().returnToHomePageContact();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().InfoFromEditForm(contact);
    assertThat(contact.getAddress(), equalTo(editAddress(contactInfoFromEditForm)));
  }

  private String editAddress(ContactData contact) {

    return contact.getAddress();
  }

}
