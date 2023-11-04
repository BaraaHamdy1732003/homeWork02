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
@WebServlet("/Login")
public class ServerLogin  extends HttpServlet implements UserDAO{
    private static final long serialVersionUID = 1L;
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



    public ServerLogin() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = new ArrayList<>();
        String uname=request.getParameter("uname");
        String password=request.getParameter("password");
        System.out.println("Username: " + uname);
        System.out.println("Password: " + password);
        request.setAttribute("users", users);
        request.getRequestDispatcher("src/main/webapp/login.jsp").forward(request, response);
    }


public boolean checkLogin(String uname, String password) throws ServletException {
    init("org.postgresql.Driver");
    Connection con = getConnection();
    String sql = "SELECT * FROM \"user_accounts\" WHERE uname=? AND password=?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, uname);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        boolean isValid = rs.next();
        rs.close();
        ps.close();
        con.close();
        return isValid;
    } catch (SQLException e) {
        e.printStackTrace();
    }
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


