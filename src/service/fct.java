/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Pub;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConnexionSingleton;
/**
 *
 * @author hp
 */
public class fct {
     private static fct instance;
    private Statement st;
    private ResultSet rs;
    public fct(){
        ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(fct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
  public  int calculer_prix(int aff) 
         { int prix;
             prix= 200 * aff;

return prix;
 }
  public int recId (Pub p,int prix){
    
      String req = "select id from publicité where  nom ='"+p.getNom()+"'AND prenom ='"+p.getPrenom()+"'AND email ='"+p.getEmail()+"'AND domaine ='"+p.getDomaine()+"'AND Affichage ='"+p.getAffichage()+"'AND lien ='"+p.getLien()+"' AND Prix ="+prix;
      int res=0;
        try {
           rs=st.executeQuery(req);
            
            while(rs.next()){
               res=rs.getInt("id");
                return res ;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(fct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res; 
  }
  public String recLien (int id) {
        String req="select lien from publicité where id ="+id;
        String res="null";
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
               res=rs.getString("lien");
              return res ;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(fct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res; 
    }
}
