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
import java.util.Enumeration;
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
@WebServlet(name = "ModifierArticle_servlet", urlPatterns = {"/ModifierArticle_servlet"})
public class ModifierArticle_servlet extends HttpServlet {

    public String img;
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
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ModifierArticle_servlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ModifierArticle_servlet at " + request.getContextPath() + "</h1>");
//            out.printf("<li> %s</li>" ,request.getParameter("ref_art"));
//            out.printf("<li> %s</li>" ,request.getParameter("nom_art"));
//            out.printf("<li> %s</li>" ,request.getParameter("des_art"));
//            out.printf("<li> %s</li>" ,request.getParameter("prix_art"));
//            out.printf("<li> %s</li>" ,request.getParameter("qte_art"));
// if(request.getParameter("image_art")==null){
//        img =request.getParameter("old_img");
//        }
//        else if(request.getParameter("image_art")!=null){
//            img =request.getParameter("image_art");
//        }
//            out.printf("<li> %s</li>" ,img);
// 
//            
//            
//                 Enumeration <String> parametres = request.getParameterNames();
//            while(parametres.hasMoreElements())
//            {
//                String param = parametres.nextElement();
//                out.printf("<li>%s : %s</li>" , param, request.getParameter(param));
//                if (param.equals("retour")){
//                out.printf(" arja3" );
//                }
//
//              }
//            out.println("</body>");
//            out.println("</html>");
//        }
         HttpSession session = request.getSession();
        
        int ref=Integer.parseInt(request.getParameter("ref_art"));
        String nom = request.getParameter("nom_art");
        String des=request.getParameter("des_art");
        Float prix=Float.parseFloat(request.getParameter("prix_art"));
        int qte=Integer.parseInt(request.getParameter("qte_art"));        
            
        if(request.getParameter("image_art")==null){
                img =request.getParameter("old_img");
        }    
        else if(request.getParameter("image_art")!=null){
                img =request.getParameter("image_art");
        }
        
        Article a = new Article(ref, nom ,des,prix, qte,img);
        ArticleDAO art = new ArticleDAO();

                            
        
            Enumeration<String> parametres = request.getParameterNames();
            while (parametres.hasMoreElements()) {
                String param = parametres.nextElement();

                if (param.equals("retour")) 
                {
                    
                    session.setAttribute("page", "liste");
                    response.sendRedirect("administrateur.jsp");   

                } 
                else if (param.equals("modifier")) {
                    try {art.update(a);

        } catch (Exception e) {
            e.printStackTrace();}
                    session.setAttribute("page", "liste");
                    response.sendRedirect("administrateur.jsp");                    
                }
            
            }
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
