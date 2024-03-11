package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.LoginModel;
import java.io.IOException;

import controllers.LoginController;


/**
 * Servlet implementation class LoginServlet
 */
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		LoginModel lm=new LoginModel();
		lm.setName(request.getParameter("uname"));
		lm.setPass( request.getParameter("pass"));
		//System.out.println(lm.getName()));
		LoginController sc = new LoginController(lm);
//		System.out.println(lm.getName()+lm.getPass());
		if (sc.toStore()) {
		    String uname = lm.getName();
		    String pass = lm.getPass();
		    
		    if (uname.equals("Rithika.Mano") && pass.equals("94")) {
		        response.sendRedirect("rithikaportfolio.jsp");
		    } else if (uname.equals("Mallu.Kerala") && pass.equals("05")) {
		        response.sendRedirect("malluportfolio.jsp");
		    } else if (uname.equals("ammu") && pass.equals("04")) {
		        response.sendRedirect("ammuportfolio.jsp");
		    } else {
		        System.err.println("error");
		        // Redirect to an error page or handle the error accordingly
		    }
		} else {
		    System.err.println("error");
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
