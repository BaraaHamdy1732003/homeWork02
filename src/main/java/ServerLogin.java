import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Login")
public class ServerLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServerLogin() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
      //  Register register = new Register();
       // register.ViewAllUsers();

      /*  Register register1 = new Register();
        List<User> userList = register1.ViewAllUsers();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("ViewAll.jsp").forward(request, response);*/
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname=request.getParameter("uname");
        String password=request.getParameter("password");
//        User user = new User(uname, password);
        Login login=new Login ();
        if (login.checkLogin(uname, password)) {
           // System.out.println("good");
            response.sendRedirect("success-login.jsp");
        } else {
            response.getWriter().println("Invalid login credentials");
        }

        System.out.println("Username: " + uname);
        System.out.println("Password: " + password);
        response.getWriter().println(login);


    }


}