package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
	String authRole();
    UserModel getUserByUsername(String username);
    String stringUsername();
    boolean passwordMatch(String oldPassword, UserModel user);
}
