/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package note.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import note.dbc.DBConnection;

import note.vo.Student;

/**
 *
 * @author Administrator
 */
public class StudentDAO {
    
    public boolean insert(
            String studentid,String studentname,String studentpassword,String studentclass){
        String sql = "INSERT INTO student(studentid,studentname,studentpassword,studentclass) VALUES(?,?,?,?)";
        //得到连接对象
        Connection conn = DBConnection.getConnection();
        //定义预编译语句对象，此对象可执行动态sql命令。
        PreparedStatement pstmt = null;
        boolean insertSuccessFlag = false;
        try {
            pstmt = conn.prepareStatement(sql);
           // pstmt.setInt(1, ID);
            pstmt.setString(1,studentid);
            pstmt.setString(2,studentname);
             pstmt.setString(3,studentpassword);
             pstmt.setString(4,studentclass);
            
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
    public boolean update(String studentid,String studentname,String studentpassword,String studentclass) {
        String sql = "UPDATE student SET studentname=?,studentpassword=?,studengclass=? WHERE studentid=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        boolean updateSuccessFlag = false;
        try {
            pstmt = conn.prepareStatement(sql);
           pstmt.setString(1,studentid);
            pstmt.setString(2,studentname);
            pstmt.setString(3,studentpassword);
              pstmt.setString(4,studentclass);
            
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

    public boolean delete(String studentid) {
        String sql = "DELETE FROM student WHERE studentid=?";
        PreparedStatement pstmt = null;
        Connection conn = DBConnection.getConnection();
        boolean deleteSuccessFlag = false;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,studentid);
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

    public Student queryById(String studentid) {
        Student  student = null;
        String sql = "SELECT * FROM student WHERE studentid=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentid);
            rs = pstmt.executeQuery();
            //此处为什么不用while,用while可不可以
            if (rs.next()) {
                student = new Student();
                student.setStudentid(rs.getString(1));
                student.setStudentname(rs.getString(2));
                student.setStudentpassword(rs.getString(3));
                student.setStudentclass(rs.getString(4));
                   
               
              
            }

        } catch (SQLException e) {
            System.out.println("操作中出现错误！！！");
        } finally {
            DBConnection.close(conn, pstmt, rs);
        }
        return student;
    }

    public String[] getSingleFiledData() {
        String sql = "SELECT * FROM student";
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
        String sql = "UPDATE student SET studentname=?,studengpassword=?,studentclass=? WHERE studentid=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        //boolean updateSuccessFlag = false;
        DefaultTableModel mdl = (DefaultTableModel) table.getModel();
        int rowCount = mdl.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, (String) mdl.getValueAt(i, 1));
                pstmt.setString(2, (String) mdl.getValueAt(i, 2));
                 pstmt.setString(3, (String) mdl.getValueAt(i, 3));
                pstmt.setString(4, (String) mdl.getValueAt(i, 0));
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } 
        }
                DBConnection.close(conn, pstmt, null);
            
    }

    public String[][] getAllData() {
        String sql = "SELECT * FROM student order by studentid";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String[][] data = null;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            rs.last();
            int rowCount = rs.getRow();
            data = new String[rowCount][4];
            rs.first();
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < 4; j++) {
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
    public String[][] getAllData2(String classid) {
        String sql = "SELECT studentid,studentname FROM student where studentclass=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String[][] data = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, classid);
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
        public String[] getAllData3(String classid) {
        String sql = "SELECT studentid  FROM student where studentclass=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String[] data = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, classid);
            rs = pstmt.executeQuery();
            rs.last();
            int rowCount = rs.getRow();
            data = new String[rowCount];
            rs.first();
            for (int i = 0; i < rowCount; i++) {
                
                    data[i] = rs.getString( 1);
                
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
        String sql = "SELECT * FROM student order by studentid";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Object[][] data = null;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            rs.last();
            int rowCount = rs.getRow();
            data = new Object[rowCount][4];
            rs.first();
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < 4; j++) {
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
        String sql = "SELECT * FROM student where" + " studentid like ?" + " or studentname like ?" + "or  studentpassword like ?"
                 + "or  studentclass like ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String[][] data = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + content + "%");
            pstmt.setString(2, "%" + content + "%");
            pstmt.setString(3, "%" + content + "%");
            pstmt.setString(4, "%" + content + "%");

            rs = pstmt.executeQuery();
            rs.last();
            int rowCount = rs.getRow();
            data = new String[rowCount][4];
            rs.first();
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < 4; j++) {
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
     public ArrayList<Student> queryAll() {
       ArrayList<Student> all = new ArrayList<Student>();
        Student student = null;
        String sql = "SELECT  * FROM student ";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            //此处为什么不用while,用while可不可以
            while (rs.next()) {
                student = new Student();
               student.setStudentid(rs.getString(1));
                student.setStudentname(rs.getString(2));
                student.setStudentpassword(rs.getString(3));
                student.setStudentclass(rs.getString(4));
                all.add(student);
            }

        } catch (SQLException e) {
            System.out.println("操作中出现错误！！！");
            System.out.println(e.getMessage());
        } finally {
            DBConnection.close(conn, pstmt, rs);
        }
        return all;
    }

    public String[][] findByCombo(String studentid, String studentname) {
        String sql = "SELECT * FROM student where" + " studentid like ?" + " and studentname like ?";

        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String[][] data = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + studentid + "%");
            pstmt.setString(2, "%" + studentname + "%");
            
            rs = pstmt.executeQuery();
            rs.last();
            int rowCount = rs.getRow();
            data = new String[rowCount][4];
            rs.first();
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < 4; j++) {
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
     public boolean MofifyPassword(String id,String password) {
        String sql = "UPDATE student SET studentpassword=? WHERE studentid=?";
        Connection conn = (Connection) DBConnection.getConnection();
        PreparedStatement pstmt = null;
        boolean updateSuccessFlag = false;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, password);
            pstmt.setString(2, id);
            int x = pstmt.executeUpdate();
            if (x > 0) {
                updateSuccessFlag = true;
            }
        } catch (SQLException e) {
            System.out.println("更新操作中出现错误！！！");
            System.out.println(e);
        } finally {
            DBConnection.close(conn, pstmt,null);
        }
        return updateSuccessFlag;
    }
}
