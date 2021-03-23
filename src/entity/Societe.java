/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author benha
 */
public class Societe {
    private SimpleIntegerProperty id;
    private SimpleStringProperty nom;
   private SimpleStringProperty email;
   private SimpleStringProperty adresse;
     private SimpleStringProperty mdp;
     private SimpleStringProperty login;
    public Societe() {
    }

    public Societe(int id, String nom, String email, String adresse ,String login,String mdp) {
        this.id = new SimpleIntegerProperty(id);
        this.nom = new SimpleStringProperty(nom);
        this.email = new SimpleStringProperty(email);
        this.adresse =new SimpleStringProperty( adresse);
        this.login =new SimpleStringProperty( login);
        this.mdp =new SimpleStringProperty( mdp);
    }
     public Societe(String nom, String email, String adresse ,String login,String mdp) {
    
        this.nom = new SimpleStringProperty(nom);
        this.email = new SimpleStringProperty(email);
        this.adresse =new SimpleStringProperty( adresse);
        this.login =new SimpleStringProperty( login);
        this.mdp =new SimpleStringProperty( mdp);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom = new SimpleStringProperty( nom);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email = new SimpleStringProperty( email);
    }

    public String getAdresse() {
        return adresse.get();
    }

    public void setAdresse(String adresse) {
        this.adresse = new SimpleStringProperty( adresse);
    }
   
     public String getMdp() {
        return mdp.get();
    }

    public void setMdp(String mdp) {
        this.mdp = new SimpleStringProperty(mdp);
    }
     public String getLogin() {
        return login.get();
    }

    public void setLogin(String login) {
        this.login = new SimpleStringProperty(login);
    }
     public SimpleStringProperty getNomProperty(){
        return nom;
    }
    public SimpleStringProperty getAdresseProperty(){
        return adresse;
    }
     public SimpleStringProperty getEmailProperty(){
        return email;
    }
    public SimpleStringProperty getMdpProperty(){
        return mdp;
    }
    public SimpleStringProperty getLoginProperty(){
        return login;
    }
   
    public SimpleIntegerProperty getIdProperty(){
        return id;
    }
}
