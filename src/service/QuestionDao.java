package service;

import entity.Inscription_certificat;
import entity.Question;
import entity.Quizz;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static jdk.nashorn.internal.objects.NativeObject.keys;
import utils.ConnexionSingleton;

public class QuestionDao implements Idao<Question>{
    
    private static QuestionDao instance;
    private Statement st;
    private ResultSet rs;
    
    private QuestionDao() {
       ConnexionSingleton cs= ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static QuestionDao getInstance(){
        if(instance==null) 
            instance=new QuestionDao();
        return instance;
    }

    @Override
    public void insert(Question o) {
//        System.out.println("++++++++++++++++");
//        System.out.println(o.getQuiz());
        String req = "insert into questionn (question,option1,option2,option3,option4,reponse,idQuiz) values  ('"+o.getQuestion()+"','"+o.getOption1()+"', '"+o.getOption2()+"', '"+o.getOption3()+"','"+o.getOption4()+"','"+o.getReponse()+"','"+o.getQuiz()+"')"; 
        try {
            st.executeUpdate(req);   
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Question o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Question> displayAll() {
        String req="SELECT * FROM quizz JOIN questionn ON questionn.idQuiz = quizz.quizID";
        ObservableList<Question> list =FXCollections.observableArrayList();  
        ObservableList<Quizz> list1 =FXCollections.observableArrayList();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Question f =new Question();
                Quizz f1 =new Quizz();
                //table question
                f.setQuestionId(rs.getInt("id"));
                f.setQuestion(rs.getString("question"));
                f.setOption1(rs.getString("option1"));
                f.setOption2(rs.getString("option2"));
                f.setOption3(rs.getString("option3"));
                f.setOption4(rs.getString("option4"));
                f.setReponse(rs.getString("reponse"));
                f.setQuiz(rs.getInt("idQuiz"));
                //table quiz
                f1.setQuizID(rs.getInt("quizID"));
                f1.setNom(rs.getString("nom"));
                //ajout dans list et list1
                list.add(f);
                list1.add(f1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Inscription_certificatDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Question displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Question os) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Question> displayAllById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<Question> displaylist() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Question> displayAllByEmail(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
