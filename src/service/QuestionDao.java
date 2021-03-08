package service;

import entity.Question;
import entity.Quizz;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

public class QuestionDao implements Idao<Question>{
    
    private static QuestionDao instance;
    private Statement st;
    private ResultSet rs;
    
    private QuestionDao() {
        DataSource cs= DataSource.getInstance();
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
        String req = "insert into question (question, option1) values ('"+o.getQuestion()+"','"+o.getOption1()+"')"; 
//        String query = String.format(req, Question.MetaData.TABLE_NAME,
//                                            Question.MetaData.OPTION1,
//                                            Question.MetaData.OPTION2,
//                                            Question.MetaData.OPTION3,
//                                            Question.MetaData.OPTION4,
//                                            Question.MetaData.REPONSE,
//                                            Question.MetaData.QUIZ_ID,
//                                            Question.MetaData.QUIZ_ID,
//                                            Quizz.MetaData.TABLE_NAME,
//                                            Quizz.MetaData.QUIZ_ID
//                );
//        System.err.println(query);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Question displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Question os) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
