package utils;

import java.util.ArrayList;
import java.util.List;
import wherehows.models.table.User;


public class Dataset {

  private Dataset() {
  }

  public static List<User> fillDatasetOwnerList(String[] owners, String[] ownerNames, String[] ownerEmails) {
    List<User> users = new ArrayList<>();

    if (owners != null && ownerNames != null && ownerEmails != null && owners.length == ownerNames.length
        && owners.length == ownerEmails.length) {
      for (int i = 0; i < owners.length; i++) {
        User user = new User();
        user.setUserName(owners[i]);
        user.setName(ownerNames[i]);
        user.setEmail(ownerEmails[i]);
        users.add(user);
      }
    }
    return users;
  }
}
