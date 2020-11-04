package tests;

import appmanager.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase extends ApplicationManager{

  protected final ApplicationManager app = new ApplicationManager();
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() {
    app.init();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }


}
