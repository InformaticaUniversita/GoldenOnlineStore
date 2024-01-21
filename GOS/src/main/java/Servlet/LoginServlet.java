package Servlet;

import model.Utente;
import model.UtenteDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private final UtenteDAO utenteDAO= new UtenteDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Utente utente=null;
        if(username != null && password != null){
            utente = utenteDAO.doRetrieveByUsernamePassword(username,password);
        }
        if(utente == null){
            String messaggio = "Username e/o password non validi!";
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("WEB-INF/jsp/Messaggio.jsp");
            request.getSession().setAttribute("messaggio", messaggio);
            requestDispatcher.forward(request,response);
        }
        request.getSession().setAttribute("utente",utente);

        RequestDispatcher requestDispatcher= request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
        requestDispatcher.forward(request,response);
    }
}
