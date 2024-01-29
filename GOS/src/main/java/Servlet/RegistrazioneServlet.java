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

@WebServlet("/Registrazione")
public class RegistrazioneServlet extends HttpServlet {

    private UtenteDAO utenteDAO = new UtenteDAO();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("utente") != null){
            request.setAttribute("errore", "Sei già loggato!");
            request.getRequestDispatcher("WEB-INF/jsp/Registrazione.jsp").forward(request, response);
            return;
        }
        String username = request.getParameter("username");
        Utente u = utenteDAO.doRetrieveByUsername(username);
        if (!(username != null && username.matches("([0-9a-zA-Z]{6,30})"))) {
            request.setAttribute("username", "Username non valido!");
            request.getRequestDispatcher("WEB-INF/jsp/Registrazione.jsp").forward(request, response);
            return;
        } else if (u != null) {
            request.setAttribute("username", "Username già usato!");
            request.getRequestDispatcher("WEB-INF/jsp/Registrazione.jsp").forward(request, response);
            return;
        }

        String password = request.getParameter("password");
        if (!(password != null && password.length() >= 8 && !password.toUpperCase().equals(password)
                && !password.toLowerCase().equals(password) && password.matches(".*[0-9].*"))) {
            request.setAttribute("password", "Password non valida!");
            request.getRequestDispatcher("WEB-INF/jsp/Registrazione.jsp").forward(request, response);
            return;
        }

        String passwordConferma = request.getParameter("passwordConferma");
        if (!password.equals(passwordConferma)) {
            request.setAttribute("confermaPassword", "Le password non corrispondono!");
            request.getRequestDispatcher("WEB-INF/jsp/Registrazione.jsp").forward(request, response);
            return;
        }

        String nome = request.getParameter("nome");
        if (!(nome != null && nome.trim().length() > 0 && nome.matches("([a-zA-Z]{0,30})"))) {
            request.setAttribute("nome", "Nome non valido!");
            request.getRequestDispatcher("WEB-INF/jsp/Registrazione.jsp").forward(request, response);
            return;
        }

        String cognome = request.getParameter("cognome");
        if (!(cognome != null && cognome.trim().length() > 0 && cognome.matches("([ a-zA-Z]{0,30})"))) {
            request.setAttribute("cognome", "Cognome non valido!");
            request.getRequestDispatcher("WEB-INF/jsp/Registrazione.jsp").forward(request, response);
            return;
        }

        String email = request.getParameter("email");
        Utente u1 = utenteDAO.doRetrieveByEmail(email);
        if (!(email != null && email.matches("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w+)"))) {
            request.setAttribute("email", "Email non valida!");
            request.getRequestDispatcher("WEB-INF/jsp/Registrazione.jsp").forward(request, response);
            return;
        } else if (u1 != null) {
            request.setAttribute("email", "Email già usata!");
            request.getRequestDispatcher("WEB-INF/jsp/Registrazione.jsp").forward(request, response);
            return;
        }

        Utente utente = new Utente();
        utente.setUsername(username);
        utente.setNome(nome);
        utente.setCognome(cognome);
        utente.setPassword(password);
        utente.setEmail(email);
        utenteDAO.doSave(utente);
        request.getSession().setAttribute("utente",utente);
        String messaggio = "Registrazione effettuata con successo! Benvenuto in GoldenOnlineStore!";

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/Messaggio.jsp");
        request.getSession().setAttribute("messaggio", messaggio);
        requestDispatcher.forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("utente") != null) {
            throw new MyServletException("Utente loggato");
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/Registrazione.jsp");
        requestDispatcher.forward(request, response);
    }
}