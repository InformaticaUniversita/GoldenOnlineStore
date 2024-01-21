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

@WebServlet("/AnnullaOrdine")
public class AnnullaOrdineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession();

        Utente utente = (Utente) session.getAttribute("utente");
        if(utente == null)
            throw new MyServletException("Nessun utente loggato");

        int id = Integer.parseInt(request.getParameter("id"));
        OrdineDAO ordineDAO = new OrdineDAO();
        ordineDAO.doDelete(id);
        List<Ordine> ordini = ordineDAO.doRetrieveByUsername(utente.getUsername());
        request.setAttribute("ordini", ordini);

        RequestDispatcher requestDispatcher=request.getRequestDispatcher("WEB-INF/jsp/Ordini.jsp");
        requestDispatcher.forward(request,response);
    }
}