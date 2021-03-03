 
package entity;

public class Quizz {

    
    
    private String nom;
    
    public Quizz() {
    }
    
    public Quizz(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Quizz{" + ", nom=" + nom + '}';
    }

    

    public void setNom(String nom) {
        this.nom = nom;
    }

    

    public String getNom() {
        return nom;
    }
    
}
