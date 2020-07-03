/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.Article;
import DAO.ArticleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hedi
 */
@WebServlet(name = "AjoutArticle_servlet", urlPatterns = {"/AjoutArticle_servlet"})
public class AjoutArticle_servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    HttpSession session = request.getSession();
    
        int ref=Integer.parseInt(request.getParameter("ref_art"));
        String nom = request.getParameter("nom_art");
        String des=request.getParameter("des_art");
        Float prix=Float.parseFloat(request.getParameter("prix_art"));
        int qte=Integer.parseInt(request.getParameter("qte_art"));
       String img =request.getParameter("image_art");
        
        Article a = new Article(ref, nom, des, prix, qte, img);
        ArticleDAO art = new ArticleDAO();         
         
            try {
                art.ajouter(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
   

        
      

        
        session.setAttribute("nom", nom);   
        
        RequestDispatcher reqdis=request.getRequestDispatcher("administrateur.jsp");      
        reqdis.forward(request, response);
        
    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
