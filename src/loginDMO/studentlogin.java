/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package loginDMO;

/**
 *
 * @author Administrator
 */

import note.dbc.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class studentlogin {
    public static boolean studentlgn(String studentid,String userpassword ){
           boolean f=false;
          
           Connection cn=null;
           PreparedStatement ps=null;
           ResultSet rs=null;
           try{
               cn=DBConnection.getConnection();
               ps=cn.prepareStatement("select * from student where studentid=? and studentpassword=?");
               ps.setString(1, studentid);
               ps.setString(2,userpassword);
               rs=ps.executeQuery();
               if(rs.next()){
                   f=true;
               }
               rs.close();
               ps.close();
               cn.close();
               
           }catch(SQLException e){
               JOptionPane.showMessageDialog(null, e.getMessage());
           }
           return f;
               
    }
}
