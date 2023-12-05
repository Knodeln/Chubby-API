package dev.knodeln.chuddy.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FakeUsers {
  private static List<ChuddyUser> users = Arrays.asList(
      new ChuddyUser(
          "Max",
          20,
          Arrays.asList(18, 19, 20, 21, 22, 23, 24, 25),
          Programme.IT,
          Arrays.asList(Programme.IT),
          1,
          Arrays.asList(1, 2, 3),
          Gender.MALE,
          Arrays.asList(Interest.SPORTS, Interest.ALCOHOL)),
      new ChuddyUser(
          "August",
          27,
          Arrays.asList(18, 19, 20, 21, 22),
          Programme.IT,
          Arrays.asList(Programme.MT),
          4,
          Arrays.asList(3, 4, 5),
          Gender.MALE,
          Arrays.asList(Interest.SPORTS, Interest.STUDYING, Interest.HÅKAN)),
      new ChuddyUser(
          "Emilia",
          20,
          Arrays.asList(18, 19),
          Programme.MT,
          Arrays.asList(Programme.D, Programme.IT),
          2,
          Arrays.asList(1, 2),
          Gender.OTHER,
          Arrays.asList(Interest.SPORTS, Interest.ALCOHOL)),
      new ChuddyUser(
          "Ella",
          21,
          Arrays.asList(20, 21, 22),
          Programme.D,
          Arrays.asList(Programme.D, Programme.IT, Programme.MT),
          2,
          Arrays.asList(2, 3),
          Gender.FEMALE,
          Arrays.asList(Interest.SPORTS, Interest.STUDYING)),
      new ChuddyUser(
          "Philip",
          25,
          Arrays.asList(22, 23, 24, 25, 26, 27, 28, 29),
          Programme.MT,
          Arrays.asList(Programme.IT, Programme.D),
          3,
          Arrays.asList(2, 3, 4),
          Gender.MALE,
          Arrays.asList(Interest.SPORTS, Interest.STUDYING, Interest.HÅKAN)));

  private static ChuddyUser user = new ChuddyUser(
      "Sne",
      20,
      Arrays.asList(18, 19, 20, 21, 22, 23),
      Programme.IT,
      Arrays.asList(Programme.IT),
      2,
      Arrays.asList(1, 2, 3),
      Gender.MALE,
      Arrays.asList(Interest.SPORTS, Interest.STUDYING));

  public static List<ChuddyUser> getUsers() {
    return users;
  }

  public static ChuddyUser getUser() {
    return user;
  }
}
