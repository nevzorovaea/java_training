package ru.stqa.pft.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.UserData;

import javax.mail.MessagingException;
import java.io.IOException;


public class ChangePasswordTest extends TestBase {


  @Test
  public void testRegistration() throws IOException, MessagingException, IOException {
    app.getChangePasswordHelper().loginToPage();
    app.getChangePasswordHelper().goTopage();
    UserData userTest = new UserData();
    userTest = app.getChangePasswordHelper().changePassword();
    Assert.assertTrue(app.newSession().login(userTest.getUsername(), userTest.getPassword()));
  }


}