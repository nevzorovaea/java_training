package model;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String company;
  private final String address;
  private final String homephone;
  private final String mobile;
  private final String workphone;
  private final String email;
  private final String bday;
  private final String byear;
  private final String bmonth;
  private String group;

  public ContactData(String firstname, String middlename, String lastname, String nickname, String company, String address, String homephone, String mobile, String workphone, String email, String bday, String byear, String bmonth, String group) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.homephone = homephone;
    this.mobile = mobile;
    this.workphone = workphone;
    this.email = email;
    this.bday = bday;
    this.byear = byear;
    this.bmonth = bmonth;
    this.group = group;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHomephone() {
    return homephone;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWorkphone() {
    return workphone;
  }

  public String getEmail() {
    return email;
  }

  public String getBday() {
    return bday;
  }

  public String getByear() { return byear;  }

  public String getBmonth() {
    return bmonth;
  }
  public String getGroup() { return group; }
}
