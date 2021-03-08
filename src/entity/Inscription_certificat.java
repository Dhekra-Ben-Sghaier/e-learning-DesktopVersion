package entity;

public class Inscription_certificat {

    public Inscription_certificat(int id, String nomUtilisateur, String nom, String description) {
        this.id = id;
        this.nomUtilisateur = nomUtilisateur;
        this.nom = nom;
        this.description = description;
    }
    private int id;    
    private String nomUtilisateur;
    private String nom;
    private String description;
    private String domaine;

    public Inscription_certificat() {
    }
    
    public Inscription_certificat(String nomUtilisateur, String nom, String description, String domaine) {
        this.nomUtilisateur = nomUtilisateur;
        this.nom = nom;
        this.description = description;
        this.domaine = domaine;
        
    }
    
    public Inscription_certificat(int id, String nomUtilisateur, String nom, String description, String domaine) {
        this.id=id;
        this.nomUtilisateur = nomUtilisateur;
        this.nom = nom;
        this.description = description;
        this.domaine = domaine;
        
    }    
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }    

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }    
    

    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }  

    public void setDescription(String description) {
        this.description = description;
    }
    
     @Override
    public String toString() {
        return "Inscription_certificat{" + "id=" + id + ", nomUtilisateur=" + nomUtilisateur + ", nom=" + nom + ", description=" + description + ", domaine=" + domaine + '}';
    }
    
    
       
}