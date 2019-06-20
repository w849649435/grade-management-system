/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package note.dao;



import note.dbc.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import note.vo.Teachercourse;

/**
 *
 * @author Administrator
 */
public class TeachercourseDAO {
     public boolean insert(String courseid,String teacherid,String classid) {
        String sql = "INSERT INTO teachercourse(courseid,teacherid,classid) VALUES(?,?,?)";
        //得到连接对象
        Connection conn =  DBConnection.getConnection();
        //定义预编译语句对象，此对象可执行动态sql命令。
        PreparedStatement pstmt = null;
        boolean insertSuccessFlag = false;
        try {
            pstmt = conn.prepareStatement(sql);
           // pstmt.setInt(1, ID);
            pstmt.setString(1,courseid);
            pstmt.setString(2,teacherid);
           pstmt.setString(3,classid);
            
            //执行pstmt表示的插入命令
            pstmt.executeUpdate();
            insertSuccessFlag = true;
        } catch (SQLException e) {
            System.out.println("插入操作中出现错误！！！");
            System.out.println(e);
        } finally {
            DBConnection.close(conn, pstmt, null);
        }
        return insertSuccessFlag;
    }
     public ArrayList<Teachercourse>findAll2(String id) {
        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        ArrayList<Teachercourse> teachercourse=new ArrayList<Teachercourse>(); 
        int count;
        try {
            conn = DBConnection.getConnection();
             
            pstat = conn.prepareStatement("select teachercourse.courseid,coursename,classid from teachercourse,course   where teachercourse.courseid=course.courseid and teacherid= ?");
             pstat.setString(1,id);
            rs = pstat.executeQuery();
            while(rs.next()) {
                Teachercourse bj=new Teachercourse(rs.getString(1),rs.getString(2),rs.getString(3));
                teachercourse.add(bj);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return teachercourse;
    }
}
