/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aquascape;

/**
 *
 * @author shahi
 */

import static java.lang.String.valueOf;
import java.sql.*;
import java.util.ArrayList;

public class DbConnect {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    
    public DbConnect(){
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            //Get a connection to the db
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Aquarium","root","");
            
            //Create a statement
            
            st = con.createStatement();
            
        }catch(Exception e){
            System.out.println("Error"+e);
            e.printStackTrace();
        }
    }
    
    
    int adminLogin(String user,char[] password){
        
        String s=valueOf(password);
        
        System.out.println("adminLogin");
        String query = "select * from admin where username='"+user+"'";
        
        System.out.println(query);
        
        try{
            rs=st.executeQuery(query);
            while(rs.next()){
                if(rs.getString(1).equals(user) && rs.getString(2).equals(s)){
                    System.out.println(rs.getString(1));
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString("status"));
                    return rs.getInt(3);
                }
               else
                 return 0;
            }
            
        }catch(Exception e){
            System.out.println("Login Error"+e);
        }
        return 2;
    }
    
    
    
    
    int userLogin(String user,char[] password){
        
        String s=valueOf(password);
        
        String query = "select * from user where username='"+user+"'";
        
        System.out.println(query);
        
        try{
            rs=st.executeQuery(query);
            while(rs.next()){
                if(rs.getString(1).equals(user) && rs.getString(2).equals(s)){
                    System.out.println(rs.getString(1));
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString("status"));
                    return rs.getInt(3);
                }
               else
                 return 0;
            }
            
        }catch(Exception e){
            System.out.println("Login Error"+e);
        }
        return 2;
    }
    
    
   
    boolean updateQuery(String s) throws SQLException{
        
        System.out.println(s);
        st.executeUpdate(s);
        
        return true;
    }
    
    
    ArrayList getFishResult(String s) throws SQLException{
        
        ArrayList result = new ArrayList();
        
        rs=st.executeQuery(s);  
        
        while(rs.next()){
            result.add(rs.getString(1));
            result.add(rs.getString(2));
            result.add(rs.getString(3));
            //result.add(rs.getString(1));  //use this for compatibility check
            
        }
        
        return result;
    }
    
    
        ArrayList getPlantResult(String s) throws SQLException{
        
        ArrayList result = new ArrayList();
        
        rs=st.executeQuery(s);  
        
        while(rs.next()){
            result.add(rs.getString(1));
            result.add(rs.getString(2));
            result.add(rs.getString(3));
            //result.add(rs.getString(1));  //use this for compatibility check
            
        }
        
        return result;
    }
    
    
    
    ArrayList getFilterResult(String s) throws SQLException{
        
        ArrayList result = new ArrayList();
        
        rs=st.executeQuery(s);  
        
        while(rs.next()){
            result.add(rs.getString(1));
            result.add(rs.getString(2));
            result.add(rs.getString(3));
            //result.add(rs.getString(1));  //use this for compatibility check
            
        }
        
        return result;
    }   
    
    
    
    String getCompResult(String s) throws SQLException{
        String result="";
        rs=st.executeQuery(s);
        while(rs.next()){
            result=rs.getString(1);
        }
        return result;
    }
    
    
    
    boolean userRegistration(String user,char[] password) throws SQLException{
        
        String s = valueOf(password);
        String query = "insert into user (username, password) values('" 
                    + user + "','" + s + "');";
        st.executeUpdate(query);
        return true;
    }
    
}