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
 * @author asus
 */
public class Recformation {
    private SimpleIntegerProperty id_formation;
    private SimpleStringProperty adressemail;
    private SimpleStringProperty formation;
    private SimpleStringProperty  nom_formateur;
    private SimpleStringProperty description;

    public Recformation(int id_formation,String adressemail, String formation, String nom_formateur, String description) {
        this.id_formation = new SimpleIntegerProperty(id_formation);
        this.adressemail = new SimpleStringProperty(adressemail);
        this.formation = new SimpleStringProperty(formation);
        this.nom_formateur =  new SimpleStringProperty(nom_formateur);
        this.description = new SimpleStringProperty(description);
     
    }
     public Recformation(int id_formation, String formation, String nom_formateur, String description) {
        this.id_formation = new SimpleIntegerProperty(id_formation);
        
        this.formation = new SimpleStringProperty(formation);
        this.nom_formateur =  new SimpleStringProperty(nom_formateur);
        this.description = new SimpleStringProperty(description);
     
    }
    public Recformation(String adressemail,String formation, String nom_formateur, String description) {
        
       this.adressemail=new SimpleStringProperty(adressemail);
   
        this.formation =  new SimpleStringProperty(formation);
        this.nom_formateur = new SimpleStringProperty(nom_formateur);
        this.description =  new SimpleStringProperty(description);
    }

    
    
    

  

    public Recformation() {
    }
 
    public int getId_formation() {
        return id_formation.get();
    }

    public void setId_formation(int id_formation) {
        this.id_formation =new SimpleIntegerProperty(id_formation);
    }
    public String getAdressemail() {
        return adressemail.get();
    }
    public String getFormation() {
        return formation.get();
    }
    public SimpleIntegerProperty getId_formationProperty()
    {
        return id_formation;
    }
    public SimpleStringProperty getAdressemailProperty(){
        return adressemail;
    }
           
    public SimpleStringProperty getFormationProperty(){
        return formation;
    }
    public SimpleStringProperty getNomformateurProperty(){
        return nom_formateur;
    }
     public SimpleStringProperty getDescriptionProperty(){
        return description;
    }
       
   
    
    public void setAdressemail(String adressemail) {
        this.adressemail = new SimpleStringProperty(adressemail);
    }
    
    public void setFormation(String formation) {
        this.formation = new SimpleStringProperty(formation);
    }

   
    public String getNom_formateur() {
        return nom_formateur.get();
    }

    public void setNom_formateur(String nom_formateur) {
        this.nom_formateur = new SimpleStringProperty(nom_formateur);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description = new SimpleStringProperty(description);
    }
    
    @Override
     public String toString() {
        return "Recformation{" + ", formation=" + formation.get() + ", nom_formateur=" + nom_formateur.get() + ", description=" + description.get() +'}';
    }
    
}
