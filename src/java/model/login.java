/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.*;
public class login {

    Connection con;
    public login(String dsn) {
        try
        {
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        con=DriverManager.getConnection(dsn);

        }
        catch(Exception e){
            System.out.println(e.getStackTrace());
        }

    }


    public void create(int key,String username,String password){


        String sql="insert into login values(?,?,?)";

       try{
       PreparedStatement ps=con.prepareStatement(sql);
       ps.setInt(1,key);
       ps.setString(2,password);
       ps.setString(3,username);
       ps.executeUpdate();
       con.close();
        }
       catch(Exception e){
           System.out.println(e.getStackTrace());
       }

    }

     public int validate(String username,String password)
     {
         int user_id=0;
         
         String sql="select * from login where Username=? and Password=?";
         try{
       PreparedStatement ps=con.prepareStatement(sql);
       ps.setString(1,username);
       ps.setString(2,password);
      ResultSet rs= ps.executeQuery();
      
      if(rs.next()){
          user_id=rs.getInt("User_id");
          
      }
       con.close();

        }
       catch(Exception e){
           System.out.println(e.getStackTrace());
       }
         
         return user_id;
     }
    
     public String isPresent(String username){
         
         
         String sql="select * from login where Username=?";
         String ans="yes";
         try{
       PreparedStatement ps=con.prepareStatement(sql);
       ps.setString(1,username);
      ResultSet rs= ps.executeQuery();
      
      if(rs.next()){
         ans="no";
          
      }
       con.close();

        }
       catch(Exception e){
           System.out.println(e.getStackTrace());
       }
         
         
         return ans;
     }
    
    
}
