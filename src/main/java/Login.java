import java.sql.*;

public class Login {
    private String dburl = "jdbc:postgresql://localhost:5432/postgres";
    private String dbuname = "postgres";
    private String dbpassword = "171070";
    private String dbdriver = "org.postgresql.Driver";
    public void loadDriver(String dbDriver)
    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(dburl, dbuname, dbpassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public boolean checkLogin(String uname, String password) {
        loadDriver("org.postgresql.Driver");
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
}
