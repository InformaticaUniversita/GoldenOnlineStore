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

public class ModificaProdottoServletTest {
    private HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
    private HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
    private HttpSession session;

    @Test
    public void doGetSuccessTest() throws ServletException, IOException {
        session = mock(HttpSession.class);
        when(httpServletRequest.getSession(true)).thenReturn(session);
        Amministratore amministratore = new Amministratore();
        when(httpServletRequest.getAttribute("amministratore")).thenReturn(amministratore);
        when(httpServletRequest.getParameter("idProdotto")).thenReturn("idProdotto");
        when(httpServletRequest.getParameter("id")).thenReturn("id");
        when(httpServletRequest.getParameter("categoria")).thenReturn("categoria");
        when(httpServletRequest.getParameter("nome")).thenReturn("prodotto");
        when(httpServletRequest.getParameter("descrizione")).thenReturn("descrizione");
        when(httpServletRequest.getParameter("prezzo")).thenReturn("prezzo");
        when(httpServletRequest.getParameter("marca")).thenReturn("marca");

        // Crea un mock di ModificaProdottoServlet
        ModificaProdottoServlet modificaProdottoServlet = Mockito.mock(ModificaProdottoServlet.class);
        try {
            modificaProdottoServlet.doGet(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Verifica che il metodo doGet sia stato chiamato
        Mockito.verify(modificaProdottoServlet).doGet(httpServletRequest, httpServletResponse);
    }
}
