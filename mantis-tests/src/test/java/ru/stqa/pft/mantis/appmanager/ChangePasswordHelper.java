package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChangePasswordHelper extends HelperBase {

  public ChangePasswordHelper(ApplicationManager app) {
    super(app);
    wd = app.getDriver();
  }

  public void loginToPage() {
    type(By.name("username"), "administrator");
    click(By.cssSelector("input[type='submit']"));
    type(By.name("password"), "root");
    click(By.cssSelector("input[type='submit']"));
  }

  public void goTopage() {
    wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
  }

  public UserData changePassword() throws MessagingException, IOException {

    //выбираем список пользователей

    List<UserData> users = new ArrayList<UserData>();
    users = getUserList();

    //кликаем по пользователю  + отловить эксепшн

    UserData randomContact = users.iterator().next();
    String randomName = randomContact.getUsername();
    click(By.linkText(randomName));

    //нажимаем сбросить пароль
    click(By.cssSelector("form#manage-user-reset-form > fieldset > span > input[type='submit']"));

    //Список пользователей и паролей до
    //Отправляем email и ссылку подтверждения
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, randomContact.getEmail());
    app.registration().finish(confirmationLink, "kz5tQN");

    //авторизация через http, заходим с новыми логином и паролем
    HttpSession session = app.newSession();
    UserData userTest = new UserData();
    userTest.setUsername(randomName).setPassword("kz5tQN");
    return userTest;
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  private List<UserData> getUserList() {
    List<UserData> users = new ArrayList<UserData>();

    List<WebElement> elements = wd.findElements(By.cssSelector("table.table-striped > tbody >tr"));
    for (WebElement element : elements) {//перебор строки
      List<WebElement> cells = element.findElements(By.cssSelector("td"));
      String username = cells.get(0).getText();
      String email = cells.get(2).getText();
      //проверяем, что не ломаем админа
      if (!(username.equals("administrator"))) {
        UserData user = new UserData().setUsername(username).setEmail(email);
        users.add(user);
      }

    }
    return users;
  }

}

