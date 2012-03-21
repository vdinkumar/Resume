/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.*;
public class profile {


    Connection con;

    public profile(String dsn) {

        try
        {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        con=DriverManager.getConnection(dsn);

        }
        catch(Exception e){
            System.out.println(e.getStackTrace());
        }

    }






    public int create(profilebean bean)
    {
         int key=0;
      String sql="insert into Profile(Name,DOB,Address,Mobile,Email,Specialization_id,Work_experience) values(?,?,?,?,?,?,?)";
       try{
       PreparedStatement ps=con.prepareStatement(sql);
       ps.setString(1,bean.getName());
       ps.setString(2,bean.getDOB());
       ps.setString(3,bean.getAddress());
       ps.setString(4,bean.getMobile());
       ps.setString(5,bean.getEmail());
       ps.setInt(6,bean.getSpecialization_id());
       ps.setInt(7,bean.getWork_experience());
        ps.executeUpdate();




        sql = "SELECT @@IDENTITY";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        rs.next();
        key=rs.getInt(1);
       con.close();
        }
       catch(Exception e){
           System.out.println(e.getStackTrace());
       }
       
       
        return key;

    }

    
    public profilebean getProfile(int user_id){
        
        String sql="select * from Profile where User_id=?";
        String name="dinesh";
        profilebean pb=new profilebean();
        try{
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,user_id);
        ResultSet rs=ps.executeQuery();
        rs.next();
        pb.setName(rs.getString("Name"));
        pb.setDOB(rs.getString("DOB"));
        pb.setAddress(rs.getString("Address"));
        pb.setMobile(rs.getString("Mobile"));
        pb.setEmail(rs.getString("Email"));
        pb.setSpecialization_id(rs.getInt("Specialization_id"));
        pb.setWork_experience(rs.getInt("Work_experience"));
        pb.setResume(rs.getString("Resume"));
        
        con.close();
        
        }
        catch(Exception e){
            System.out.println(e);
        }
        return pb;
        
    }
    
    
    public void updateResume(int user_id,String resume){
        
        
        String sql="update Profile set Resume=? where User_id=?";
       try{
       PreparedStatement ps=con.prepareStatement(sql);
       ps.setString(1,resume);
       ps.setInt(2,user_id);
       ps.executeUpdate();
         con.close();
        
    }
       catch(Exception e){
            System.out.println(e);
        }
       
    }
}
