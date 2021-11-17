package apap.tutorial.pergipergi.service;

import java.util.List;

import apap.tutorial.pergipergi.model.UserModel;

public interface UserService {
  UserModel addUser(UserModel user);
  String encrypt(String password);
  List<UserModel> getListUser();
  void deleteUser(UserModel user);
    UserModel getUserByUsername(String username);
    boolean isMatch(String newPassword, String oldPassword);
    void setPassword(UserModel myUser, String newPassword);
}