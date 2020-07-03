/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import singleton.ConnectionDb;


/**
 *
 * @author toshiba
 */
@WebServlet(name = "login", urlPatterns = {"/login_servlet"})
public class Login_servlet extends HttpServlet {

    String login;
    String pwd;
    ResultSet rs = null;

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
            throws ServletException, IOException 
    {

        //processRequest(request, response);
        try 
        {
            login = request.getParameter("login");
            pwd = request.getParameter("password");

            HttpSession session = request.getSession();

            session.setAttribute("login", login);
            session.setAttribute("password", pwd);

            Statement st = ConnectionDb.getInstance().createStatement();
            
            
            String req = "SELECT * from client where pseudo='" + login + "' and pwd_cl ='" + pwd + "'";
            ResultSet rs = st.executeQuery(req);
            
            if (rs.next()) 
            {
                
                session.setAttribute("nom", rs.getString("nom_cl"));
                session.setAttribute("prenom", rs.getString("prenom_cl"));
                
//                response.getWriter().print("C BON "+rs.getString("nom_cl"));
               response.sendRedirect("client.jsp");


            } else if ((login.equals("admin")) && (pwd.equals("admin"))) 
            {
                session.setAttribute("page", "");
                response.sendRedirect("administrateur.jsp");
            } else 
            {              
//                response.getWriter().print("C BON index");
                response.sendRedirect("index.jsp");
            }

        } catch (Exception e) 
        {
            e.printStackTrace();
            response.getWriter().print(e.getMessage());
        }

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
