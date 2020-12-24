package ru.stqa.pft.mantis.tests;

import org.testng.SkipException;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.HttpSession;

import javax.xml.rpc.ServiceException;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase {


  @Test

  public void testLogin() throws IOException, ServiceException {
      try {
       //skipIfNotFixed(1);
       skipIfNotFixedRest(1);
      } catch (SkipException e) {
        e.printStackTrace();
      }
    HttpSession session = app.newSession();
    session.login("administrator", "root");
    assertTrue(session.login("administrator", "root"));
    assertTrue(session.isLoggedInAs("administrator"));
  }
}
