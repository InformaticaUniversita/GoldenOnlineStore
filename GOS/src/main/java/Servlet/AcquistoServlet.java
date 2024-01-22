package Servlet;

import model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@WebServlet("/Pagamento")
public class AcquistoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Carrello carrello = (Carrello) session.getAttribute("carrello");
        if(carrello == null){
            throw new MyServletException("Nessun prodotto nel carrello");
        }
        Utente u;
        u =(Utente) session.getAttribute("utente");
        if(u == null){
            throw new MyServletException("Devi prima loggarti");
        }

        String nome = request.getParameter("nome");
        if (!(nome != null && nome.trim().length() > 0 && nome.matches("([a-zA-Z]{0,30})"))) {
            request.setAttribute("nome", "Nome non valido!");
            request.getRequestDispatcher("WEB-INF/jsp/AcquistoForm.jsp").forward(request, response);
            return;
        }
        String cognome = request.getParameter("cognome");
        if (!(cognome != null && cognome.trim().length() > 0 && cognome.matches("([a-zA-Z]{0,30})"))) {
            request.setAttribute("cognome", "Cognome non valido!");
            request.getRequestDispatcher("WEB-INF/jsp/AcquistoForm.jsp").forward(request, response);
            return;
        }
        String email = request.getParameter("email");
        if (!(email != null && email.matches("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w+)"))) {
            request.setAttribute("email", "Email non valida!");
            request.getRequestDispatcher("WEB-INF/jsp/AcquistoForm.jsp").forward(request, response);
            return;
        }
        String provincia = request.getParameter("provincia");
        if (!(provincia != null && provincia.trim().length() > 0 && provincia.matches("([a-zA-Z]{0,30})"))) {
            request.setAttribute("provincia", "Provincia non valido!");
            request.getRequestDispatcher("WEB-INF/jsp/AcquistoForm.jsp").forward(request, response);
            return;
        }
        String city = request.getParameter("city");
        if (!(city != null && city.trim().length() > 0 && city.matches("([a-zA-Z]{0,30})"))) {
            request.setAttribute("city", "Città non valida!");
            request.getRequestDispatcher("WEB-INF/jsp/AcquistoForm.jsp").forward(request, response);
            return;
        }
        String cap = request.getParameter("cap");
        if (!(cap != null && cap.trim().length() > 0 && cap.matches("([0-9]{0,5})"))) {
            request.setAttribute("cap", "CAP non valido!");
            request.getRequestDispatcher("WEB-INF/jsp/AcquistoForm.jsp").forward(request, response);
            return;
        }

        String indirizzo = request.getParameter("indirizzo");
        if (!(indirizzo != null && indirizzo.trim().length() > 0 && (indirizzo.matches("([0-9a-zA-Z]{0,30})") || indirizzo.contains(" ")))) {
            request.setAttribute("indirizzo", "Indirizzo non valido!");
            request.getRequestDispatcher("WEB-INF/jsp/AcquistoForm.jsp").forward(request, response);
            return;
        }
        String numeroCarta = request.getParameter("numeroCarta");
        if (!(numeroCarta != null && numeroCarta.trim().length() > 0 && numeroCarta.matches("([0-9]{0,16})"))) {
            request.setAttribute("numeroCarta", "Numero carta non valido!");
            request.getRequestDispatcher("WEB-INF/jsp/AcquistoForm.jsp").forward(request, response);
            return;
        }
        String cvv = request.getParameter("cvv");
        if (!(cvv != null && cvv.trim().length() > 0 && cvv.matches("([0-9]{0,3})"))) {
            request.setAttribute("cvv", "CVV non valido!");
            request.getRequestDispatcher("WEB-INF/jsp/AcquistoForm.jsp").forward(request, response);
            return;
        }
        String nomeIntestatario = request.getParameter("nomeIntestatario");
        if (!(nomeIntestatario != null && nomeIntestatario.trim().length() > 0 && (nomeIntestatario.matches("([0-9a-zA-Z]{0,30})") || nomeIntestatario.contains(" ")))) {
            request.setAttribute("nomeIntestatario", "Nome intestatario non valido!");
            request.getRequestDispatcher("WEB-INF/jsp/AcquistoForm.jsp").forward(request, response);
            return;
        }
        String dataScadenza = request.getParameter("dataScadenza");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        try {
            java.util.Date date =  formatter.parse(dataScadenza);
        } catch (ParseException e) {
            request.setAttribute("dataScadenza", "Data scadenza non valida!");
            request.getRequestDispatcher("WEB-INF/jsp/AcquistoForm.jsp").forward(request, response);
            return;
        }

        Ordine o = new Ordine();
        o.setCliente(u.getUsername());
        LocalDate currentDate = LocalDate.now();
        Date dataodierna = Date.valueOf(currentDate);
        o.setDataOrdine(dataodierna);
        LocalDate afterDate = currentDate.plusDays(7);
        Date dataSpedizione = Date.valueOf(afterDate);
        o.setDataSpedizione(dataSpedizione);
        o.setPrezzoTotale(carrello.getPrezzoTot());
        OrdineDAO ordineDAO = new OrdineDAO();
        int id = ordineDAO.doSave(o);
        Indirizzo indirizzo1 = new Indirizzo();
        indirizzo1.setCitta(city);
        indirizzo1.setCap(cap);
        indirizzo1.setVia(indirizzo);
        indirizzo1.setId(id);
        IndirizzoDAO indirizzoDAO = new IndirizzoDAO();
        indirizzoDAO.doSave(indirizzo1);
        LineaOrdine l = new LineaOrdine();
        List<Carrello.IstanzaProdotto> pq = carrello.getProdottiArray();
        LineaOrdineDAO lineaOrdineDAO = new LineaOrdineDAO();
        for(Carrello.IstanzaProdotto p:pq){
            System.out.println(id);
            l.setIdOrdine(id);
            l.setIdProdotto(p.getProdotto().getId());
            l.setQuantità(p.getQuantità());
            l.setPrezzoUnitario(p.getProdotto().getPrezzo());
            lineaOrdineDAO.doSave(l);
            carrello.remove(p.getProdotto().getId());
        }

        String messaggio = "Pagamento andato a buon fine!";

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/Messaggio.jsp");
        request.getSession().setAttribute("messaggio", messaggio);
        requestDispatcher.forward(request,response);
    }

}
