package servlets;

import jdk.vm.ci.code.Register;
import models.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Register")
public class ServletRegister extends HttpServlet  implements UserDAO{
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "171070";
    public void init (String dbDriver)throws ServletException{
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
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = new ArrayList<>();
        init("org.postgresql.Driver");
        Connection con =getConnection();
        String sql = "INSERT INTO user_accounts(uname, password, email,phone) VALUES (?,?,?,?)";
        String uname=request.getParameter("uname");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");
      /*  User user = new User (uname, password, email, phone);
        Register registerAuth=new Register();
        String result=registerAuth.insert(user);*/

        System.out.println("Username: " + uname);
        System.out.println("Password: " + password);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
       // response.getWriter().println(result);

        request.setAttribute("users", users);
        request.getRequestDispatcher("src/main/webapp/regester.jsp").forward(request, response);
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
