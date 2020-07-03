/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author toshiba
 */
public class Article {
    
    private int ref ,qte;
  private float prix;
  private String nom ,des,img;

    public Article(int ref, String nom, String des, float prix, int qte,String img) 
    {
        this.ref = ref;
        this.nom=nom;
        this.des = des;
        this.prix = prix;
        this.qte = qte;
        this.img=img;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getRef() {
        return ref;
    }

    public int getQte() {
        return qte;
    }

    public float getPrix() {
        return prix;
    }

    public String getNom() {
        return nom;
    }

    public String getDes() {
        return des;
    }

    public String getImg() {
        return img;
    }
    
}
