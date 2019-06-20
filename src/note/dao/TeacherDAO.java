package note.dao;
import note.dbc.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import note.vo.Course;

import note.vo.Teacher;
import note.vo.Teachercourse;

public class TeacherDAO {

    public boolean insert( String teacherid,String teachername,String teacherpassword) {
        String sql = "INSERT INTO teacher(teacherid,teachername,teacherpassword) VALUES(?,?,?)";
        //得到连接对象
        Connection conn = DBConnection.getConnection();
        //定义预编译语句对象，此对象可执行动态sql命令。
        PreparedStatement pstmt = null;
        boolean insertSuccessFlag = false;
        try {
            pstmt = conn.prepareStatement(sql);
           // pstmt.setInt(1, ID);
            pstmt.setString(1,teacherid);
            pstmt.setString(2,teachername);
            pstmt.setString(3,teacherpassword);
            
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
    public boolean update(String teacherid,String teachername,String teacherpassword) {
        String sql = "UPDATE teacher SET teachername=? ,teacherpassword=? WHERE teacherid=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        boolean updateSuccessFlag = false;
        try {
            pstmt = conn.prepareStatement(sql);
          
            pstmt.setString(1,teachername);
            pstmt.setString(2,teacherid);
            pstmt.setString(3,teacherpassword);
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

    public boolean delete(String teacherid) {
        String sql = "DELETE FROM teacher WHERE teacherid=?";
        PreparedStatement pstmt = null;
        Connection conn = DBConnection.getConnection();
        boolean deleteSuccessFlag = false;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,teacherid);
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

    public Teacher queryById(String teacherid) {
      Teacher teacher = null;
        String sql = "SELECT * FROM teacher WHERE teacherid=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, teacherid);
            rs = pstmt.executeQuery();
            //此处为什么不用while,用while可不可以
            if (rs.next()) {
                teacher = new Teacher();
                teacher.setTeacherid(rs.getString(1));
                teacher.setTeachername(rs.getString(2));
                teacher.setTeacherpassword(rs.getString(3));
              
            }

        } catch (SQLException e) {
            System.out.println("操作中出现错误！！！");
        } finally {
            DBConnection.close(conn, pstmt, rs);
        }
        return teacher;
    }

    public String[] getSingleFiledData() {
        String sql = "SELECT * FROM teacher";
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
        String sql = "UPDATE teacher SET teachername=? WHERE teacherid=?";
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
        String sql = "SELECT * FROM teacher order by teacherid";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String[][] data = null;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            rs.last();
            int rowCount = rs.getRow();
            data = new String[rowCount][3];
            rs.first();
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < 3; j++) {
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
        String sql = "SELECT * FROM teacher order by teacherid";
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
        String sql = "SELECT * FROM teacher where" + " teacherid like ?" + " or teachername like ?";
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
            data = new String[rowCount][3];
            rs.first();
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < 3; j++) {
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
     public ArrayList<Teacher> queryAll() {
       ArrayList<Teacher> all = new ArrayList<Teacher>();
       Teacher teacher = null;
        String sql = "SELECT  * FROM teacher ";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            //此处为什么不用while,用while可不可以
            while (rs.next()) {
                teacher = new Teacher();
                teacher.setTeacherid(rs.getString(1));
                teacher.setTeachername(rs.getString(2));
                teacher.setTeacherpassword(rs.getString(3));
                all.add(teacher);
            }

        } catch (SQLException e) {
            System.out.println("操作中出现错误！！！");
            System.out.println(e.getMessage());
        } finally {
            DBConnection.close(conn, pstmt, rs);
        }
        return all;
    }

    public String[][] findByCombo(String teacherid, String teachername) {
        String sql = "SELECT * FROM teacher where" + " teacherid= ?"+ "and  teachername= ?";

        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String[][] data = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,  teacherid );
            pstmt.setString(2,  teachername);
           
            rs = pstmt.executeQuery();
            rs.last();
            int rowCount = rs.getRow();
            data = new String[rowCount][3];
            rs.first();
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < 3; j++) {
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
    public ArrayList<Teacher> findAll2() {
        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        ArrayList<Teacher> teacher=new ArrayList<Teacher>(); 
        int count;
        try {
            conn = DBConnection.getConnection();
            pstat = conn.prepareStatement("select * from teacher");
            rs = pstat.executeQuery();
            while(rs.next()) {
                Teacher bj=new Teacher(rs.getString(1),rs.getString(2),rs.getString(3));
                teacher.add(bj);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return teacher;
    }
    public boolean MofifyPassword(String id,String password) {
        String sql = "UPDATE teacher SET teacherpassword=? WHERE teacherid=?";
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