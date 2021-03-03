/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author benha
 */
public class Personne {
     private SimpleIntegerProperty id;
    private SimpleStringProperty nom;
   private SimpleStringProperty cin;

    private SimpleStringProperty prenom;
    private SimpleStringProperty email;
    private SimpleStringProperty mdp;
     private SimpleStringProperty login;
      private SimpleStringProperty role;

    public Personne(String cin ,String nom ,String prenom, String email, String mdp, String login) {
      
        this.cin = new SimpleStringProperty(cin);
         this.nom = new SimpleStringProperty( nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.email = new SimpleStringProperty(email);
        this.mdp = new SimpleStringProperty(mdp);
        this.login = new SimpleStringProperty(login);

    } 
     public Personne(String cin ,String nom ,String prenom, String email, String mdp, String login , String role) {
      
        this.cin = new SimpleStringProperty(cin);
         this.nom = new SimpleStringProperty( nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.email = new SimpleStringProperty(email);
        this.mdp = new SimpleStringProperty(mdp);
        this.login = new SimpleStringProperty(login);
        this.role = new SimpleStringProperty(role);


    } 
    public Personne(int id, String nom, String prenom) {
        this.id = new SimpleIntegerProperty(id);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
    }

    public Personne() {
    }
    public Personne(int id,String nom, String prenom, String email, String mdp, String login) {
        this.id=new SimpleIntegerProperty(id);
        this.nom = new SimpleStringProperty( nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.email = new SimpleStringProperty(email);
        this.mdp = new SimpleStringProperty(mdp);
        this.login = new SimpleStringProperty(login);
    }



    public Personne(String nom, String prenom, String email, String mdp, String login) {
         this.nom = new SimpleStringProperty( nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.email = new SimpleStringProperty(email);
        this.mdp = new SimpleStringProperty(mdp);
        this.login = new SimpleStringProperty(login);
    }

    public Personne(String nom, String prenom) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
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
        this.nom = new SimpleStringProperty(nom);
    }
    public String getCin() {
        return cin.get();
    }

    public void setCin(String cin) {
        this.cin = new SimpleStringProperty(cin);
    }
     public String getPrenom() {
        return prenom.get();
    }

     public void setPrenom(String prenom) {
        this.prenom = new SimpleStringProperty(prenom);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
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
    
     public String getRole() {
        return role.get();
    }

    public void setRole(String role) {
        this.role = new SimpleStringProperty(role);
    }
     public SimpleStringProperty getNomProperty(){
        return nom;
    }
    public SimpleStringProperty getPrenomProperty(){
        return prenom;
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
    public SimpleStringProperty getRoleProperty(){
        return role;
    }
     public SimpleStringProperty getCinProperty(){
        return cin;
    }
    public SimpleIntegerProperty getIdProperty(){
        return id;
    }

    @Override
    public String toString() {
        return "Personne{" + "id=" + id.get() + ", nom=" + nom.get() + ", prenom=" + prenom.get() + ", email=" + email.get() + ", mdp=" + mdp.get() + '}';
    }
    
     @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personne other = (Personne) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
