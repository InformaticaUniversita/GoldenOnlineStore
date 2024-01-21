package Servlet;

import model.Prodotto;
import model.ProdottoDAO;
import model.Utente;
import model.UtenteDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/PaginaProfilo")
public class PaginaProfiloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

    }
    private final UtenteDAO utenteDAO = new UtenteDAO();
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        HttpSession session = request.getSession();
        String username;
        Utente utente = (Utente) session.getAttribute("utente");
        if(utente != null)
            username = utente.getUsername();
        else throw new MyServletException("Nessun utente loggato");

        request.setAttribute("utente",utente);

        RequestDispatcher requestDispatcher= request.getRequestDispatcher("WEB-INF/jsp/profilo.jsp");
        requestDispatcher.forward(request,response);
    }
}
