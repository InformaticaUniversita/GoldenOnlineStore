package Servlet;

import Servlet.RegistrazioneServlet;
import com.mysql.cj.Session;
import model.Amministratore;
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

public class CancellazioneProfiloServletTest {
    private HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
    private HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
    private HttpSession session;

    @Test
    public void doGetSuccessTest() throws ServletException, IOException {
        session = mock(HttpSession.class);
        when(httpServletRequest.getSession(true)).thenReturn(session);
        Utente utente = new Utente();
        when(httpServletRequest.getAttribute("utente")).thenReturn(utente);
        when(httpServletRequest.getParameter("username")).thenReturn("username");

        // Crea un mock di CancellazioneProfiloServlet
        CancellazioneProfiloServlet cancellazioneProfiloServlet = Mockito.mock(CancellazioneProfiloServlet.class);
        try {
            cancellazioneProfiloServlet.doGet(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Verifica che il metodo doGet sia stato chiamato
        Mockito.verify(cancellazioneProfiloServlet).doGet(httpServletRequest, httpServletResponse);
    }
}
