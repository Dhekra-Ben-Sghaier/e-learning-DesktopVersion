 
package entity;

public class Quizz {
    private int quizID;
    private String nom;
    
//    public static class MetaData{
//        public static final String TABLE_NAME = "quizs";
//        public static final String QUIZ_ID = "quiz_id";
//    }

    public Quizz(int quizID, String nom) {
        this.quizID = quizID;
        this.nom = nom;
    }
    
    public Quizz() {
    }
    
    public Quizz(String nom) {
        this.nom = nom;
    }

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
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
