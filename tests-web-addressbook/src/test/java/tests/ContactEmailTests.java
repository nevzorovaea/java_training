package tests;

import model.ContactData;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {

  @Test
  public void testContactEmail() {
    app.contact().returnToHomePageContact();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().InfoFromEditForm(contact);

    assertThat(contact.getAllEmail(), equalTo(mergeEmail(contactInfoFromEditForm)));
  }

  private String mergeEmail(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals("")).collect(Collectors.joining("\n"));

  }


}

