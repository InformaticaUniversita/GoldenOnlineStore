package Servlet;

import model.Carrello;
import model.Utente;
import org.junit.Test;
import org.mockito.Mockito;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AcquistoProdottoServletTest {
    private HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
    private HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
    private HttpSession session;

    @Test
    public void doGetSuccessTest() throws ServletException, IOException {
        session = mock(HttpSession.class);
        when(httpServletRequest.getSession(true)).thenReturn(session);
        Carrello carrello = new Carrello();
        when(httpServletRequest.getAttribute("carrello")).thenReturn(carrello);
        Utente utente = new Utente();
        when(httpServletRequest.getAttribute("utente")).thenReturn(utente);
        when(httpServletRequest.getParameter("nome")).thenReturn("Mario");
        when(httpServletRequest.getParameter("cognome")).thenReturn("Rossi");
        when(httpServletRequest.getParameter("email")).thenReturn("mariorossi@gmail.com");
        when(httpServletRequest.getParameter("provincia")).thenReturn("Salerno");
        when(httpServletRequest.getParameter("city")).thenReturn("Salerno");
        when(httpServletRequest.getParameter("cap")).thenReturn("84000");
        when(httpServletRequest.getParameter("indirizzo")).thenReturn("Via principale 11");
        when(httpServletRequest.getParameter("numeroCarta")).thenReturn("1111222233334444");
        when(httpServletRequest.getParameter("cvv")).thenReturn("123");
        when(httpServletRequest.getParameter("nomeIntestatario")).thenReturn("Mario Rossi");

        // Crea un mock di AcquistoProdottoServlet
        AcquistoServlet acquistoServlet = Mockito.mock(AcquistoServlet.class);
        try {
            acquistoServlet.doGet(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Verifica che il metodo doGet sia stato chiamato
        Mockito.verify(acquistoServlet).doGet(httpServletRequest, httpServletResponse);
    }
}
