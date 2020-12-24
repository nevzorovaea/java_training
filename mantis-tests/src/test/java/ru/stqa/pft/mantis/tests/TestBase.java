package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;
import ru.stqa.pft.mantis.model.Issue;

import javax.xml.rpc.ServiceException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class TestBase {

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));


  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
    app.ftp().upload(new File("src/test/resources/config_inc.php"), "config_inc.php", "config_inc.php.bak");
    app.mail().start();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws IOException {
    app.ftp().restore("config_inc.php.bak", "config_inc.php");
    app.mail().stop();
    app.stop();
  }

  boolean isIssueOpen(int issueId) throws RemoteException, ServiceException, MalformedURLException {
    Issue issue = app.soap().getIssueById(issueId);
    if ((issue.getStatus().equals("resolved")) || (issue.getStatus().equals("closed")) ||
            (issue.getResolution().equals("fixed"))) {
      return true;
    } else {
      return false;
    }
  }
    public void skipIfNotFixed(int issueId) throws RemoteException, ServiceException, MalformedURLException {
      if (isIssueOpen(issueId)) {
        throw new SkipException("Ignored because of issue " + issueId);
      }
  }
  public boolean isIssueOpenRest(int issueId) throws IOException, ServiceException {
    String issueStatus = app.rest().getIssueForBugifyById(issueId);
    if ((issueStatus.equals("Resolved")) || (issueStatus.equals("Closed")) ||
            (issueStatus.equals("Fixed"))) {
      return false;
    }
    return true;
  }

  public void skipIfNotFixedRest(int issueId) throws IOException, ServiceException {
    if (isIssueOpenRest(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

}