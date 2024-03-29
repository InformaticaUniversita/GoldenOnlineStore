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

@WebServlet("/Carrello")
public class CarrelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    ProdottoDAO prodottoDAO=new ProdottoDAO();
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession();
        Carrello carrello = (Carrello) session.getAttribute(("carrello"));
        if(carrello==null){
            carrello= new Carrello();
            session.setAttribute("carrello", carrello);
        }

        String prodIdStr = request.getParameter("prodId");
        if(prodIdStr != null){
            int prodId = Integer.parseInt(prodIdStr);
            String addNumStr = request.getParameter("addNum");
            if (addNumStr!=null){
                int addNum=Integer.parseInt(addNumStr);

                Carrello.IstanzaProdotto prodQuantità = carrello.get(prodId);
                if(prodQuantità!=null) {
                    prodQuantità.setQuantità(prodQuantità.getQuantità()+ addNum);
                }else{
                    carrello.put(prodottoDAO.doRetrieveById(prodId),addNum);
                }
            }else{
                String setNumStr = request.getParameter("setNum");
                if (setNumStr!=null){
                    int setNum=Integer.parseInt(setNumStr);
                    if(setNum <= 0){
                        carrello.remove(prodId);
                    }else {
                        Carrello.IstanzaProdotto prodQuant= carrello.get(prodId);
                        if(prodQuant != null){
                            prodQuant.setQuantità(setNum);
                        }else{
                            carrello.put(prodottoDAO.doRetrieveById(prodId),setNum);
                        }
                    }
                }
            }
        }
        String operazione = request.getParameter("operazione");
            if(operazione != null){
                if(operazione.equals("modificaQuantita")){
                    int nuovaQuantità = Integer.parseInt(request.getParameter("nuovaQuantita"));
                    int prodId = Integer.parseInt(prodIdStr);
                    Carrello.IstanzaProdotto prodQuantità = carrello.get(prodId);
                    prodQuantità.setQuantità(nuovaQuantità);
            } else if(operazione.equals("svuotaCarrello")){
                    carrello.svuotaCarrello();
                }
        }

        RequestDispatcher requestDispatcher=request.getRequestDispatcher("WEB-INF/jsp/Carrello.jsp");
        requestDispatcher.forward(request,response);
    }
}
