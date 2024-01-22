package Servlet;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CancellazioneProfilo")
public class CancellazioneProfiloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession();

        String username = request.getParameter("username");
        UtenteDAO utenteDAO = new UtenteDAO();
        utenteDAO.doDelete(username);

        String messaggio = "Account eliminato con successo";

        RequestDispatcher requestDispatcher=request.getRequestDispatcher("WEB-INF/jsp/Messaggio.jsp");
        session.invalidate(); // Invalida la sessione
        request.getSession().setAttribute("messaggio", messaggio);
        requestDispatcher.forward(request,response);
    }
}