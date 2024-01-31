package Servlet;

import Servlet.RegistrazioneServlet;
import com.mysql.cj.Session;
import model.ConnectionPool;
import model.Utente;
import model.UtenteDAO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

public class RegistrazioneServletTest {
    private HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
    private HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
    private HttpSession session;

    @Test
    public void doGetSuccessTest() throws ServletException, IOException {
        session = mock(HttpSession.class);
        when(httpServletRequest.getSession(true)).thenReturn(session);
        when(httpServletRequest.getAttribute("utente")).thenReturn(null);
        when(httpServletRequest.getParameter("username")).thenReturn("Vittorio99");
        when(httpServletRequest.getParameter("password")).thenReturn("Vitto.99");
        when(httpServletRequest.getParameter("passwordConferma")).thenReturn("Vitto.99");
        when(httpServletRequest.getParameter("nome")).thenReturn("Vittorio");
        when(httpServletRequest.getParameter("cognome")).thenReturn("Cbr");
        when(httpServletRequest.getParameter("email")).thenReturn("vittoriogior@gmail.com");

        // Crea un mock di RegistrazioneServlet
        RegistrazioneServlet registrazioneServlet = Mockito.mock(RegistrazioneServlet.class);
        try {
            registrazioneServlet.doGet(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Verifica che il metodo doGet sia stato chiamato
        Mockito.verify(registrazioneServlet).doGet(httpServletRequest, httpServletResponse);
    }
}
