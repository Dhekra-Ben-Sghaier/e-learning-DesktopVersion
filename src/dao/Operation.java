/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Personne;
import static java.lang.Math.random;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.ConnexionSingleton;

/**
 *
 * @author benha
 */
public class Operation {
    
    private static Operation instance;
    private Statement st;
    private ResultSet rs;
    
    public Operation() {
        ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(AppDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Operation getInstance(){
        if(instance==null) 
            instance=new Operation();
        return instance;
    }
    
    public String recEmail (String user) {
        String req="select email from personnes where nomUtilisateur ='"+user+"'";
        String res="null";
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
               res=rs.getString("email");
              return res ;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res; 
    }
     public String recCode (int id) {
        String req="select code from personnes where id_user ='"+id+"'";
        String res="null";
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
               res=rs.getString("code");
              return res ;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res; 
    }
    
     public int recId (String user) {
        String req="select id_user from personnes where nomUtilisateur ='"+user+"'";
      int res=0;
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
               res=rs.getInt("id_user");
              return res ;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res; 
    }
     public String envoyerCode(int id){
         Random r = new Random();
         return ""+r.nextInt(100)+id+r.nextInt(100);
         
       //return ;
     }
     public boolean update(String pwd,int id) {
         
        String qry = "UPDATE personnes SET password = '"+pwd+"' WHERE id_user = "+id;
         
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
      public boolean updateInfo(String nom,String prenom,String email,String user,int id) {
         
        String qry = "UPDATE personnes SET  nom = '"+nom+"', prenom = '"+prenom+"', email = '"+email+"', nomUtilisateur = '"+user+"' WHERE id_user = "+id;
         
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
      public boolean updateCode(String code,int id) {
         
        String qry = "UPDATE personnes SET code = '"+code+"' WHERE id_user = "+id;
         
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
        public Personne recInfos(String user) {
         
         String req="select * from personnes where nomUtilisateur ='"+user+"'";;
         
           Personne p=new Personne();
         try {
            rs=st.executeQuery(req);
            while(rs.next()){
               
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setEmail(rs.getString("email"));
                p.setLogin(user);
               

                
               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p ; 
    
        }
         public String isPassword(String user) {
         
         String req="select * from personnes where nomUtilisateur ='"+user+"'";;
          String res="";
         try {
            rs=st.executeQuery(req);
            while(rs.next()){
               res=rs.getString("password");
                
               return res;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
         }
}
