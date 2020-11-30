package tests;

import model.ContactData;
import model.Contacts;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

  @Test
  public void testCreationNewContact() {
    app.goTo().gotohomePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/zefir.png");
    ContactData contact = new ContactData().withFirstname("Anton").withLastname("ivanov").withPhoto(photo);
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertEquals(app.contact().count(), before.size() + 1);
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

}
