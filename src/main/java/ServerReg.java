import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Register")
public class ServerReg extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServerReg() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname=request.getParameter("uname");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");
        User user = new User(uname, password, email, phone);
        Register registerAuth=new Register();
        String result=registerAuth.insert(user);

        System.out.println("Username: " + uname);
        System.out.println("Password: " + password);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        response.getWriter().println(result);


    }
}