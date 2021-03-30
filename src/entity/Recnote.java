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
public class Recnote {
    private SimpleIntegerProperty id_reclamation;
    private SimpleStringProperty adressem;
    private SimpleStringProperty examen;
    private SimpleStringProperty  date;
    private SimpleStringProperty nom_formateur;
    private SimpleStringProperty description;

    public Recnote(int id_reclamation, String examen, String date, String nom_formateur, String description) {
        this.id_reclamation = new SimpleIntegerProperty(id_reclamation);
        
        this.examen = new SimpleStringProperty(examen);
        this.date =  new SimpleStringProperty(date);
        this.nom_formateur = new SimpleStringProperty( nom_formateur);
        this.description =  new SimpleStringProperty(description);
    }
    public Recnote(String adressem, String examen, String date, String nom_formateur, String description) {
       this.adressem = new SimpleStringProperty(adressem);
        this.examen = new SimpleStringProperty(examen);
        this.date =  new SimpleStringProperty(date);
        this.nom_formateur = new SimpleStringProperty( nom_formateur);
        this.description =  new SimpleStringProperty(description);
    }
    public Recnote( String examen, String date, String nom_formateur, String description) {
        this.examen = new SimpleStringProperty(examen);
        this.date =  new SimpleStringProperty(date);
        this.nom_formateur = new SimpleStringProperty( nom_formateur);
        this.description =  new SimpleStringProperty(description);}

    
    
    

  

    public Recnote() {
    }

    public int getId_reclamation() {
        return id_reclamation.get();
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation =new SimpleIntegerProperty(id_reclamation);
    }
    public String getAdressem() {
        return examen.get();
    }

    public String getExamen() {
        return examen.get();
    }
    public SimpleIntegerProperty getId_reclamationProperty()
    {
        return id_reclamation;
    }
    public SimpleStringProperty getAdressemProperty(){
        return examen;
    }
           
    public SimpleStringProperty getExamProperty(){
        return examen;
    }
    public SimpleStringProperty getFormProperty(){
        return nom_formateur;
    }
     public SimpleStringProperty getDescProperty(){
        return description;
    }
       public SimpleStringProperty getDateProperty(){
        return date;
    }
   
    
    public void setAdressem(String adressem) {
        this.adressem = new SimpleStringProperty(adressem);
    }

    public void setExamen(String examen) {
        this.examen = new SimpleStringProperty(examen);
    }

    public  String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date = new SimpleStringProperty(date);
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
        return "Recnote{" + "id_reclamation=" + id_reclamation.get() + ", examen=" + examen.get() + ", nom_formateur=" + nom_formateur.get() + ", description=" + description.get() +'}';
    }
    
    
    
    
}
