/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Personne;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import static java.lang.Math.random;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import sun.misc.IOUtils;
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
     public String recRole (String user) {
        String req="select role from personnes where nomUtilisateur ='"+user+"'";
        String res="null";
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
               res=rs.getString("role");
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
         public boolean insert(FileInputStream o ,int id)  {
 Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/esprit","root","");
              String req=("UPDATE personnes SET image= ? WHERE id_user="+id);
        PreparedStatement ps;
        ps=conn.prepareStatement(req);
         ps.setBinaryStream(1, o); 
    
         
         return true;
        } catch (SQLException ex) {
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       
     
        return false;
        
    }
          public void recImage (int id , ImageView im) throws SQLException {
        String req="select image from personnes where id_user ="+id;
       
        Connection conn;
        try {
             PreparedStatement ps;
        
            conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/esprit","root","");
            ps=conn.prepareStatement(req);
            rs=ps.executeQuery();
            
          if(rs.first()){
            Blob blob=rs.getBlob("image");
             System.out.println("blob"+blob.toString());
            InputStream inputstream =blob.getBinaryStream();
             System.out.println("input="+inputstream.toString());
            Image image=new Image(inputstream);
            System.out.println(image);
            im.setImage(image);
                    System.out.println("images="+image);
          }
       } catch (SQLException ex) {
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
          public Image getImageById(int id) throws SQLException, IOException  {
 String req="select image from personnes where id_user ='"+id+"'";
  Image img = null ;
     try {
           rs=st.executeQuery(req);
       
        if (rs.next()) {
            Blob foto = rs.getBlob("image");
            System.out.println(foto);
            InputStream is = foto.getBinaryStream();
            img = new Image(is) ; // false = no background loading
            is.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        rs.close();
        return img ;
    }

}
