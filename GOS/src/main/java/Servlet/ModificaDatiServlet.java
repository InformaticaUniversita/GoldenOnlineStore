package Servlet;

import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet( "/ModificaDati")
public class ModificaDatiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username;
        Utente utente = (Utente) session.getAttribute("utente");
        if(utente != null)
            username = utente.getUsername();
        else throw new MyServletException("Nessun utente loggato");


        String username1 = request.getParameter("username");
        Utente u = utenteDAO.doRetrieveByUsername(username1);
        if (!(username1 != null && username1.matches("([0-9a-zA-Z]{6,30})"))) {
            request.setAttribute("username", "Username non valido!");
            request.getRequestDispatcher("WEB-INF/jsp/Profilo.jsp").forward(request, response);
            return;
        } else if (u != null) {
            request.setAttribute("username", "Username già usato!");
            request.getRequestDispatcher("WEB-INF/jsp/Profilo.jsp").forward(request, response);
            return;
        }

        String password = request.getParameter("password");
        if (!(password != null && password.length() >= 8 && !password.toUpperCase().equals(password)
                && !password.toLowerCase().equals(password) && password.matches(".*[0-9].*"))) {
            request.setAttribute("password", "Password non valida!");
            request.getRequestDispatcher("WEB-INF/jsp/Profilo.jsp").forward(request, response);
            return;
        }

        String passwordConferma = request.getParameter("passwordConferma");
        if (!password.equals(passwordConferma)) {
            request.setAttribute("confermaPassword", "Le password non corrispondono!");
            request.getRequestDispatcher("WEB-INF/jsp/Profilo.jsp").forward(request, response);
            return;
        }

        String email = request.getParameter("email");
        Utente u1 = utenteDAO.doRetrieveByEmail(email);
        if (!(email != null && email.matches("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w+)"))) {
            request.setAttribute("email", "Email non valida!");
            request.getRequestDispatcher("WEB-INF/jsp/Profilo.jsp").forward(request, response);
            return;
        } else if (u1 != null) {
            request.setAttribute("email", "Email già usata!");
            request.getRequestDispatcher("WEB-INF/jsp/Profilo.jsp").forward(request, response);
            return;
        }
        Utente utenteAggiornato = new Utente();
        utenteAggiornato.setPassword(password);
        utenteAggiornato.setCognome(utente.getCognome());
        utenteAggiornato.setNome(utente.getNome());
        utenteAggiornato.setEmail(email);
        utenteAggiornato.setUsername(username1);
        utenteDAO.doUpdateCredenziali(utenteAggiornato, username);
        String messaggio = "Modifica dati avvenuta con successo!";

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/Messaggio.jsp");
        request.getSession().setAttribute("utente", utenteAggiornato);
        request.getSession().setAttribute("messaggio", messaggio);
        requestDispatcher.forward(request,response);
    }
    private final UtenteDAO utenteDAO = new UtenteDAO();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
