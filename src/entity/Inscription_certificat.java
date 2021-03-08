package entity;

public class Inscription_certificat {
    private int id;

    
    private String nomUtilisateur;
    private String nom;
    private String description;
    private String domaine;
    
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

    public Inscription_certificat() {
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

    public String getDescription() {
        return description;
    }
    

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getIdProperty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
}