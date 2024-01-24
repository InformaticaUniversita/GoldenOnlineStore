package Servlet;

import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet( "/AggiuntaProdotto")
public class AggiuntaProdottoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/AggiuntaProdotto.jsp");
        requestDispatcher.forward(request, response);
    }

    private final ProdottoDAO prodottoDAO = new ProdottoDAO();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Prodotto prodotto;
        Amministratore amministratore = (Amministratore) request.getSession().getAttribute("amministratore");
        if (amministratore == null ) {
            throw new MyServletException("Utente non autorizzato");

        }
        String nome = request.getParameter("nome");
        if (!(nome.matches("([ a-zA-Z0-9.!@#$%^&*()_-]{3,32})"))) {
            request.setAttribute("notifica", "Nome non valida!");
            request.getRequestDispatcher("WEB-INF/jsp/AggiuntaProdotto.jsp").forward(request, response);
            return;
        }
        String descrizione = request.getParameter("descrizione");
        if (!(descrizione != null && descrizione.trim().length() > 0 && descrizione.trim().length()<=128 && descrizione.matches("[ a-zA-Z0-9.!@#$%^&*()_-]+$"))) {
            request.setAttribute("notifica", "Descrizione non valida!");
            request.getRequestDispatcher("WEB-INF/jsp/AggiuntaProdotto.jsp").forward(request, response);
            return;
        }
        String marca = request.getParameter("marca");
        if (!(marca != null && marca.trim().length() > 3 && marca.trim().length()<=32 && marca.matches("[ a-zA-Z0-9.!@#$%^&*()_-]+$"))) {
            request.setAttribute("notifica", "Marca non valida!");
            request.getRequestDispatcher("WEB-INF/jsp/AggiuntaProdotto.jsp").forward(request, response);
            return;
        }
        String prezzo = request.getParameter("prezzo");

        String categoria = request.getParameter("categoria");
        int idCategoria= Integer.parseInt(categoria);
        if (nome != null && descrizione != null && marca != null && prezzo != null && categoria != null) {
            prodotto = new Prodotto();
            prodotto.setNome(nome);
            prodotto.setDescrizione(descrizione);
            prodotto.setMarca(marca);
            prodotto.setPrezzo(Float.parseFloat(prezzo));
            prodotto.setCategoria(Integer.parseInt(categoria));
            prodottoDAO.doSave(prodotto, idCategoria);
            request.setAttribute("notifica", "prodotto aggiunto con successo");
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/AggiuntaProdotto.jsp");
        requestDispatcher.forward(request,response);
    }
}