package entity;

import java.util.Objects;
import static javafx.beans.binding.Bindings.multiply;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author wiemhjiri
 */
public class Pub {
    private SimpleStringProperty Affichage ;
    private SimpleIntegerProperty id;
    private SimpleStringProperty nom;
    private SimpleStringProperty prenom;
    private SimpleStringProperty email;
    private SimpleStringProperty domaine;
    private SimpleIntegerProperty Prix;
    private SimpleStringProperty lien;

    public Pub() {
    }

    
    public Pub (int id, String nom,String prenom,String email, String domaine,String Affichage, int Prix, String lien) {
        this.id = new SimpleIntegerProperty(id);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
         this.email = new SimpleStringProperty(email);
        this.domaine = new SimpleStringProperty(domaine);
        this.Affichage = new SimpleStringProperty(Affichage);
        this.Prix = new SimpleIntegerProperty(Prix);
        this.lien = new SimpleStringProperty();
    }

    public Pub (String nom,String prenom,String email, String domaine, String Affichage,String lien) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.email = new SimpleStringProperty(email);
        this.domaine = new SimpleStringProperty(domaine);
        this.Affichage = new SimpleStringProperty(Affichage);
        this.lien = new SimpleStringProperty(lien);
    }
 public Pub (int id,String nom,String prenom,String email, String domaine, String Affichage,String lien) {
             this.id = new SimpleIntegerProperty(id);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.email = new SimpleStringProperty(email);
        this.domaine = new SimpleStringProperty(domaine);
        this.Affichage = new SimpleStringProperty(Affichage);
        this.lien = new SimpleStringProperty(lien);
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
    public String getPrenom() {
        return prenom.get();
    }

    public void setPrenom(String prenom) {
        this.prenom = new SimpleStringProperty(prenom);
    }

    public String getDomaine() {
        return domaine.get();
    }
    public SimpleStringProperty getNomProperty(){
        return nom;
    }
    public SimpleStringProperty getPrenomProperty(){
        return prenom;
    }
    public SimpleStringProperty getDomaineProperty(){
        return domaine;
    }
        public SimpleIntegerProperty getIdProperty(){
        return id;
    }
    public void setDomaine(String domaine) {
        this.domaine = new SimpleStringProperty(domaine);
    }
    public String getAffichage() {
        return Affichage.get();
    }

    public void setAffichage(String Affichage) {
        this.Affichage = new SimpleStringProperty(Affichage);
    }
     public SimpleStringProperty getAffichageProperty(){
        return Affichage;
    }
 public String getEmail() {
        return email.get();
    }
 public SimpleStringProperty getEmailProperty(){
        return email;
    }
 public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
    }
 public int getPrix() {
        return Prix.get();
    }

    public void setPrix(int Prix) {
        this.Prix = new SimpleIntegerProperty(Prix);
    }
 public SimpleIntegerProperty getPrixProperty(){
        return Prix;
    }
 public String getLien() {
        return lien.get();
    }

    public void setLien(String prenom) {
        this.lien = new SimpleStringProperty(prenom);
    }
    public SimpleStringProperty getLienProperty(){
        return lien;
    }

 

    
    
 
    @Override
    public String toString() {
        return "Pub{" + "id=" + id.get() + ", nom=" + nom.get() + ",prenom=" + prenom.get() + ", email=" + email.get() + ", domaine=" + domaine.get() + ", Affichage=" + Affichage.get() + ", lien=" + lien.get() +'}';
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
        final Pub other = (Pub) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   
  
    
    
}