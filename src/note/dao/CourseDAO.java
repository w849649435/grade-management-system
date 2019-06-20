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
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import note.vo.Course;


public class CourseDAO {

    public boolean insert(
            String courseid,String coursename) {
        String sql = "INSERT INTO course(courseid,coursename) VALUES(?,?)";
        //得到连接对象
        Connection conn = DBConnection.getConnection();
        //定义预编译语句对象，此对象可执行动态sql命令。
        PreparedStatement pstmt = null;
        boolean insertSuccessFlag = false;
        try {
            pstmt = conn.prepareStatement(sql);
           // pstmt.setInt(1, ID);
            pstmt.setString(1,courseid);
            pstmt.setString(2,coursename);
           
            
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

    // 修改操作
    public boolean update(String courseid,String coursename) {
        String sql = "UPDATE course SET coursename=? WHERE courseid=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        boolean updateSuccessFlag = false;
        try {
            pstmt = conn.prepareStatement(sql);
          
            pstmt.setString(1,coursename);
            pstmt.setString(2,courseid);
            int x = pstmt.executeUpdate();
            if (x > 0) {
                updateSuccessFlag = true;
            }
        } catch (SQLException e) {
            System.out.println("更新操作中出现错误！！！");
            System.out.println(e);
        } finally {
            DBConnection.close(conn, pstmt, null);
        }
        return updateSuccessFlag;
    }
    // 删除操作

    public boolean delete(String courseid) {
        String sql = "DELETE FROM course WHERE courseid=?";
        PreparedStatement pstmt = null;
        Connection conn = DBConnection.getConnection();
        boolean deleteSuccessFlag = false;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,courseid);
            int i = pstmt.executeUpdate();
            if (i ==1) {
                deleteSuccessFlag = true;
            }
        } catch (SQLException e) {
            System.out.println("删除操作中出现错误！！！");
            System.out.println(e);
        } finally {
            DBConnection.close(conn, pstmt, null);
        }
        return deleteSuccessFlag;
    }
    // 按ID查询

    public Course queryById(String courseid) {
        Course course = null;
        String sql = "SELECT * FROM course WHERE courseid=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, courseid);
            rs = pstmt.executeQuery();
            //此处为什么不用while,用while可不可以
            if (rs.next()) {
                course = new Course();
                course.setId(rs.getString(1));
                course.setCoursename(rs.getString(2));
               
              
            }

        } catch (SQLException e) {
            System.out.println("操作中出现错误！！！");
        } finally {
            DBConnection.close(conn, pstmt, rs);
        }
        return course;
    }

    public String[] getSingleFiledData() {
        String sql = "SELECT * FROM course";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String[] data = null;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            rs.last();
            int rowCount = rs.getRow();
            data = new String[rowCount];
            rs.first();
            for (int i = 0; i < rowCount; i++) {
                data[i] = rs.getString(1);
                rs.next();
            }
        } catch (SQLException e) {
            System.out.println("操作中出现错误！！！");
            System.out.println(e.getMessage());
        } finally {
            DBConnection.close(conn, pstmt, rs);
        }
        return data;
    }

    public void saveTableData(JTable table) {
        String sql = "UPDATE course SET coursename=? WHERE courseid=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        //boolean updateSuccessFlag = false;
        DefaultTableModel mdl = (DefaultTableModel) table.getModel();
        int rowCount = mdl.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, (String) mdl.getValueAt(i, 1));
                pstmt.setString(2, (String) mdl.getValueAt(i, 0));
               
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } 
        }
                DBConnection.close(conn, pstmt, null);
            
    }

    public String[][] getAllData() {
        String sql = "SELECT * FROM course order by courseid";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String[][] data = null;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            rs.last();
            int rowCount = rs.getRow();
            data = new String[rowCount][2];
            rs.first();
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < 2; j++) {
                    data[i][j] = rs.getString(j + 1);
                }
                rs.next();
            }
        } catch (SQLException e) {
            System.out.println("操作中出现错误！！！");
            System.out.println(e.getMessage());
        } finally {

            DBConnection.close(conn, pstmt, rs);
        }


        return data;
    }
    public Object[][] getAllData2() {
        String sql = "SELECT * FROM course order by courseid";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Object[][] data = null;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            rs.last();
            int rowCount = rs.getRow();
            data = new Object[rowCount][2];
            rs.first();
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < 2; j++) {
                    data[i][j] = rs.getObject(j + 1);
                }
                rs.next();
            }
        } catch (SQLException e) {
            System.out.println("操作中出现错误！！！");
            System.out.println(e.getMessage());
        } finally {

            DBConnection.close(conn, pstmt, rs);
        }


        return data;
    }
    public String[][] findByLike(String content) {
        String sql = "SELECT * FROM course where" + " courseid like ?" + " or coursename like ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String[][] data = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + content + "%");
            pstmt.setString(2, "%" + content + "%");
          
           
       

            rs = pstmt.executeQuery();
            rs.last();
            int rowCount = rs.getRow();
            data = new String[rowCount][2];
            rs.first();
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < 2; j++) {
                    data[i][j] = rs.getString(j + 1);
                }
                rs.next();
            }
        } catch (SQLException e) {
            System.out.println("操作中出现错误！！！");
            System.out.println(e.getMessage());
        } finally {
            DBConnection.close(conn, pstmt, rs);
        }

        return data;
    }
     public ArrayList<Course> queryAll() {
       ArrayList<Course> all = new ArrayList<Course>();
        Course course = null;
        String sql = "SELECT  * FROM course ";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            //此处为什么不用while,用while可不可以
            while (rs.next()) {
                course = new Course();
                course.setId(rs.getString(1));
                course.setCoursename(rs.getString(2));
                all.add(course);
            }

        } catch (SQLException e) {
            System.out.println("操作中出现错误！！！");
            System.out.println(e.getMessage());
        } finally {
            DBConnection.close(conn, pstmt, rs);
        }
        return all;
    }

    public String[][] findByCombo(String courseid, String coursename) {
        String sql = "SELECT * FROM course where" + " courseid like ?" + " and coursename like ?";

        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String[][] data = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + courseid + "%");
            pstmt.setString(2, "%" + coursename + "%");
            rs = pstmt.executeQuery();
            rs.last();
            int rowCount = rs.getRow();
            data = new String[rowCount][2];
            rs.first();
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < 2; j++) {
                    data[i][j] = rs.getString(j + 1);
                }
                rs.next();
            }
        } catch (SQLException e) {
            System.out.println("操作中出现错误！！！");
            System.out.println(e.getMessage());
        } finally {
            DBConnection.close(conn, pstmt, rs);
        }
        return data;
    }
    public ArrayList<Course> findAll2() {
        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        ArrayList<Course> course=new ArrayList<Course>(); 
        int count;
        try {
            conn = DBConnection.getConnection();
            pstat = conn.prepareStatement("select * from course");
            rs = pstat.executeQuery();
            while(rs.next()) {
                Course bj=new  Course(rs.getString(1),rs.getString(2));
                course.add(bj);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return course;
    }

	
	
}

