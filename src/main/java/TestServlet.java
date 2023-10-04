//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import static java.sql.DriverManager.getConnection;
//
//@WebServlet("/profile")
//public class TestServlet extends HttpServlet {
//    private static final String DB_USERNAME = "postgres";
//    private static final String DB_PASSWORD = "171070";
//    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
//
//    private void loadDriver(String s) {
//        try {
//            Class.forName("org.postgresql.Driver"); // Fixed typo in "Driver"
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//    public Connection getConnection() {
//        Connection con = null;
//        try {
//            con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return con;
//    }
//
////    public void init() throws ServletException {
////        try {
////            Class.forName("org.postgresql.Driver"); // Fixed typo in "Driver"
////        } catch (ClassNotFoundException e) {
////            throw new RuntimeException(e);
////        }
////        try {
////            Connection connection = getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
////        } catch (SQLException e) {
////            throw new RuntimeException(e);
////        }
////    }
//
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("/html/profile.html").forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String firstName = request.getParameter("first_name");
//        String secondName = request.getParameter("second_name");
//        String age = request.getParameter("age");
//        System.out.println(firstName + " " + secondName + " " + age);
//        accounts acc = new accounts(firstName, secondName, age);
//
//        String result = insert(acc);
//        System.out.println(result);
//
//
//    }
//    public String insert(accounts acc) {
//        loadDriver("org.postgresql.Driver");
//        Connection con = getConnection();
//        String sql = "insert into \"accounts\" values(?,?,?)";
//        String result="Data Entered Successfully";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, acc.getFirst_name());
//            ps.setString(2, acc.getSecond_name());
//            ps.setString(3, acc.getAge());
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            result="Data Not Entered Successfully";
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//
//
//}

//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//@WebServlet("/profile")
//public class TestServlet extends HttpServlet {
//    private static final String DB_USERNAME = "postgres";
//    private static final String DB_PASSWORD = "171070";
//    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
//
//
//    private void loadDriver(String s) {
//        try {
//            Class.forName("org.postgresql.Driver"); // Fixed typo in "Driver"
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//    private Connection getConnection() {
//        Connection con = null;
//        try {
//            con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return con;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("/html/profile.html").forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String firstName = request.getParameter("first_name");
//        String secondName = request.getParameter("second_name");
//        String age = request.getParameter("age");
//        System.out.println(firstName + " " + secondName + " " + age);
//        accounts acc = new accounts(firstName, secondName, age);
//
//        String result = insert(acc);
//        System.out.println(result);
//    }
//
//    public String insert(accounts acc) {
//        Connection con = getConnection();
//        String sql = "INSERT INTO accounts (first_name, second_name, age) VALUES (?, ?, ?)";
//        String result = "Data Entered Successfully";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, acc.getFirst_name());
//            ps.setString(2, acc.getSecond_name());
//            ps.setString(3, acc.getAge());
//            ps.e (SQLException e) {
//            result = "Data Not Entered Successfully";
//            e.printStackTrace();
//            try {
//                if (con != null) {
//                    con.rollback(); // Rollback the transaction on error
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        } finally {
//            try {
//                if (con != null) {
//                    con.close(); // Close the connection
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return result;
//    }
//}
