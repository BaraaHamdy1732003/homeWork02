package servlets;

import models.User;

import javax.servlet.ServletException;
import java.util.List;

public interface UserDAO {
    boolean checkLogin(String uname, String password) throws ServletException;
    String insert(User user);
    List<User>ViewAllUsers();

}
