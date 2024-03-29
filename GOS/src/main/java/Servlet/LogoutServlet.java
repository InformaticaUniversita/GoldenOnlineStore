package Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("utente")!= null)
            request.getSession().removeAttribute("utente");
        else
            request.getSession().removeAttribute("amministratore");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/Index.jsp");
        requestDispatcher.forward(request,response);
    }
}
