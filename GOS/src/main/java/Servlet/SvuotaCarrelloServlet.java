package Servlet;

import model.Carrello;
import model.ProdottoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/SvuotaCarrello")
public class SvuotaCarrelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession();
        Carrello carrello=(Carrello) session.getAttribute(("carrello"));
        if(carrello==null){
            carrello= new Carrello();
            session.setAttribute("carrello", carrello);
        }

        carrello.svuotaCarrello();

        RequestDispatcher requestDispatcher=request.getRequestDispatcher("WEB-INF/jsp/Carrello.jsp");
        requestDispatcher.forward(request,response);
    }
}
