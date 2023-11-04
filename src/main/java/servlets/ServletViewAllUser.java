package servlets;

import models.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// TODO: 09.10.2023 method INIT;in every servlet

@WebServlet("/getUsers")
public class ServletViewAllUser extends HttpServlet implements UserDAO {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "171070";
    public void init ()throws ServletException{
        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM \"user_accounts\"");

            while (rs.next()) {
                String uname = rs.getString("uname");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                users.add(new User(uname, password, email, phone));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        request.setAttribute("users", users);
        request.getRequestDispatcher("ViewAll.jsp").forward(request, response);
    }

    @Override
    public boolean checkLogin(String uname, String password) {
        return false;
    }

    @Override
    public String insert(User user) {
        return null;
    }

    @Override
    public List<User> ViewAllUsers() {
        return null;
    }
}
