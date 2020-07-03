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
public class Client {
    
   private int id,tel;
   private String nom,prenom,email,adresse,psudo,pwd;	

    public Client(int id, int tel, String nom, String prenom, String email, String adresse, String psudo, String pwd) {
        this.id = id;
        this.tel = tel;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.psudo = psudo;
        this.pwd = pwd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setPsudo(String psudo) {
        this.psudo = psudo;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public int getTel() {
        return tel;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getPsudo() {
        return psudo;
    }

    public String getPwd() {
        return pwd;
    }

    
}
