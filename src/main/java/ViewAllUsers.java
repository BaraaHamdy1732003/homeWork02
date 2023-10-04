//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ViewAllUsers {
//    private String dburl = "jdbc:postgresql://localhost:5432/postgres";
//    private String dbuname = "postgres";
//    private String dbpassword = "171070";
//    private String dbdriver = "org.postgresql.Driver";
//
//    public void loadDriver(String dbDriver) {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public Connection getConnection() {
//        Connection con = null;
//        try {
//            con = DriverManager.getConnection(dburl, dbuname, dbpassword);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return con;
//    }
//
//    public List<User> viewAllUsers() { // Changed method name
//        loadDriver("org.postgresql.Driver");
//        Connection con = getConnection();
//        String sql = "SELECT * FROM \"user_accounts\"";
//        List<User> userList = new ArrayList<>();
//
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                String uname = rs.getString("uname");
//                String password = rs.getString("password");
//                String email = rs.getString("email");
//                String phone = rs.getString("phone");
//
//                User user = new User(uname, password, email, phone);
//                userList.add(user);
//            }
//
//            rs.close();
//            ps.close();
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return userList;
//    }
//}
