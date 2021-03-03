/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author benha
 */
public class Apprenant extends Personne {
    
    private SimpleStringProperty cd ; //centre d'interet

       public Apprenant() {
        
    }
    public Apprenant(String nom, String prenom ,String cd) {
        super(nom, prenom);
        this.cd = new SimpleStringProperty(cd);
    }

    public Apprenant(String cin ,String nom, String prenom, String email, String mdp, String login, String cd ,String role) {
        super(cin,nom, prenom, email, mdp, login, role);
   this.cd = new SimpleStringProperty(cd);    
    }
    


    public Apprenant(int id, String nom, String prenom, String email, String mdp, String login, String cd) {
        super(id, nom, prenom, email, mdp, login);
    }

    
    public Apprenant(int id, String nom, String prenom ,String cd) {
        super(id, nom, prenom);
        this.cd = new SimpleStringProperty(cd);
    }

    private Apprenant(int id, String nom, String prenom, String email, String mdp, String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCd() {
        return cd.get();
    }

    public void setCd(String cd) {
        this.cd = new SimpleStringProperty(cd);
    }
 public SimpleStringProperty getCdProperty(){
        return cd;
    }
    
}
