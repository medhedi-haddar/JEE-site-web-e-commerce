/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import singleton.ConnectionDb;

/**
 *
 * @author toshiba
 */
public class ArticleDAO {

    Connection con = ConnectionDb.getInstance();

    public void ajouter(Article a) throws SQLException {
        try {
            String req = "INSERT INTO  article ( ref_ar,nom_ar, desc_ar, prix, qte, img) "
                + "VALUES ("+a.getRef()+",'" + a.getNom() + "', '" + a.getDes() + "', " + a.getPrix() + ", " + a.getQte() + ", '"+ a.getImg() + "')";
            Statement st=con.createStatement();
            st.executeUpdate(req);
        }
        catch(SQLException e){
            System.out.println("\n"+e.getMessage());
        }
               
        
    }
    public void update(Article a) throws SQLException {
        try {
            Statement st=con.createStatement();
            st.executeUpdate("update article set nom_ar='"+a.getNom()+"',desc_ar='"+a.getDes()+"',prix="+a.getPrix()+",qte="+a.getQte()+",img='"+a.getImg()+"' where ref_ar="+a.getRef()); 
            
//            String req = "update article set nom='"+a.getNom()+"',desc_ar="+a.getDes()+",prix="+a.getPrix()+",qte="+a.getQte()+",img="+a.getImg()+" where ref_ar="+a.getRef();
            
//            st.executeUpdate(req);
        }
        catch(SQLException e){
            System.out.println("\n"+e.getMessage());
        }
               
        
    }

    public Vector<Article> listerArticles() 
    {
        try 
        {

            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM article");

            Vector<Article> v = new Vector<>();

            while (rs.next()) 
            {

            v.add(new Article(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getFloat(4), rs.getInt(5),  rs.getString(6)));
            }
            
            return v;
        } catch (Exception e) 
        {
            return null;
        }
    }
    
    public Vector<Article> listerArticlesByRef(int ref) 
    {
        try 
        {

            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM article WHERE ref_ar="+ref);

            Vector<Article> v = new Vector<>();

            while (rs.next()) 
            {

            v.add(new Article(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getFloat(4), rs.getInt(5),  rs.getString(6)));
            }
            
            return v;
        } catch (Exception e) 
        {
            return null;
        }
    }
    
    public void delete(Article a){
        try {
            Statement st=con.createStatement();
            st.executeUpdate("delete from article where ref_ar="+a.getRef());
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
