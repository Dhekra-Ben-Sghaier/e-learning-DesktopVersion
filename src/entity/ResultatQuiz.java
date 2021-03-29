package entity;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.runtime.PropertyDescriptor.SET;
import static sun.plugin2.message.JavaScriptMemberOpMessage.SET;

public class ResultatQuiz {
    
    private String url ="jdbc:mysql://127.0.0.1/esprit";
    private String login ="root";
    private String pwd ="";
    
    private Integer id;
    private Quizz quiz;
    private Utilisateur utilisateur;
    private Integer bonnesReponses;
    private Timestamp timestamp;
    
    {

        timestamp = new Timestamp(new Date().getTime());    
    }

    public ResultatQuiz() {
    }

    public ResultatQuiz(Quizz quiz, Utilisateur utilisateur, Integer bonnesReponses) {
        this.quiz = quiz;
        this.utilisateur = utilisateur;
        this.bonnesReponses = bonnesReponses;
    }
    
    public ResultatQuiz(Integer id, Quizz quiz, Utilisateur utilisateur, Integer bonnesReponses) {
        this.id = id;
        this.quiz = quiz;
        this.utilisateur = utilisateur;
        this.bonnesReponses = bonnesReponses;
    }

    public Integer getId() {
        return id;
    }

    public Quizz getQuiz() {
        return quiz;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public Integer getBonnesReponses() {
        return bonnesReponses;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQuiz(Quizz quiz) {
        this.quiz = quiz;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setBonnesReponses(Integer bonnesReponses) {
        this.bonnesReponses = bonnesReponses;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    
    public void save(Map<Question, String> utilisateurReponses ){

        
//        String req ="INSERT INTO quiz_resultats (quizID, utilisateurID, bonnes_reponses, date_time) VALUES"
//                + " ( ?, ?, ?, CURRENT_TIMESTAMP)";
//        
//        Connection cnx;
//        try {
//            cnx = DriverManager.getConnection(url, login, pwd);
//            PreparedStatement ps = cnx.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
//            ps.setInt(1,this.getUtilisateur().getID());
//            ps.setInt(2,this.getQuiz().getQuizID());
//            ps.setInt(3,this.getBonnesReponses());        
//            
//            int result = ps.executeUpdate();
//            if(result>0){
//                ResultSet keys = ps.getGeneratedKeys();
//                if(keys.next()){
//                    this.setId(keys.getInt(1));
//                    //enregistrement des details
//                    System.out.println(this);
////                    saveDetailsQuizResultat(utilisateurReponses);
//                }
//            }
//            
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(ResultatQuiz.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    private void saveDetailsQuizResultat(Map <Question, String> utilisateurReponses){
    
    
    }
    
    
    
    
    
   
    
    

    
    
    
}
