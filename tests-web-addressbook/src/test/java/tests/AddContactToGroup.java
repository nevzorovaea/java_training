package tests;

import model.ContactData;
import model.Contacts;
import model.GroupData;
import model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroup extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {

    app.goTo().gotohomePage();
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Contact").withLastname("Added"));
      app.contact().returnToHomePageContact();
    }

    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("Group"));
      app.contact().returnToHomePageContact();
    }
  }

  @Test
  public void testAddContactToGroup() {

    Contacts beforeContacts = app.db().contacts();
    ContactData contactAdded = beforeContacts.iterator().next();
    Groups beforeGroups = app.db().groups();
    GroupData modifiedGroup = beforeGroups.iterator().next();

    app.goTo().gotohomePage();
    if (!contactAdded.getGroups().isEmpty() && contactAdded.getGroups().contains(modifiedGroup)) {
      app.contact().removeContactFromGroup(contactAdded, modifiedGroup);
      assertThat(contactAdded.getGroups().without(modifiedGroup), equalTo(app.db().contacts().stream()
              .filter((c) -> c.getId() == contactAdded.getId()).collect(Collectors.toList()).get(0).getGroups()));

      app.contact().returnToHomePageContact();
    }
    app.contact().selectDisplayGroup("[all]");
    app.contact().addContacToGroup(contactAdded, modifiedGroup);
    app.contact().returnToHomePageContact();
    assertThat(contactAdded.getGroups().withAdded(modifiedGroup), equalTo(app.db().contacts().stream()
            .filter((c) -> c.getId() == contactAdded.getId()).collect(Collectors.toList()).get(0).getGroups()));

    // System.out.println(contactAdded);
    // System.out.println(contactAdded.getGroups());

  }
}
