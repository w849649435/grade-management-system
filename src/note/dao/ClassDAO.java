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
import note.vo.Class1;

/**
 *
 * @author Administrator
 */
public class ClassDAO {


    
     public boolean insert(
            String classid,String classname) {
        String sql = "INSERT INTO class1(classid,classname) VALUES(?,?)";
        //得到连接对象
        Connection conn = DBConnection.getConnection();
        //定义预编译语句对象，此对象可执行动态sql命令。
        PreparedStatement pstmt = null;
        boolean insertSuccessFlag = false;
        try {
            pstmt = conn.prepareStatement(sql);
           // pstmt.setInt(1, ID);
            pstmt.setString(1,classid);
            pstmt.setString(2,classname);
           
            
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
    public boolean update(String classid,String classname) {
        String sql = "UPDATE class1 SET classname=? WHERE classid=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        boolean updateSuccessFlag = false;
        try {
            pstmt = conn.prepareStatement(sql);
          
            pstmt.setString(1,classname);
            pstmt.setString(2,classid);
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

    public boolean delete(String classid) {
        String sql = "DELETE FROM class1 WHERE classid=?";
        PreparedStatement pstmt = null;
        Connection conn = DBConnection.getConnection();
        boolean deleteSuccessFlag = false;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,classid);
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

    public Class1 queryById(String classid) {
        Class1 class1 = null;
        String sql = "SELECT * FROM class1 WHERE classid=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, classid);
            rs = pstmt.executeQuery();
            //此处为什么不用while,用while可不可以
            if (rs.next()) {
               class1=new Class1();
                class1.setClassId(rs.getString(1));
                class1.setClassName(rs.getString(2));
               
              
            }

        } catch (SQLException e) {
            System.out.println("操作中出现错误！！！");
        } finally {
            DBConnection.close(conn, pstmt, rs);
        }
        return class1;
    }
    public String getclassname(String classid){
        String sql = "SELECT classname FROM class1 where classid=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String data = null;
        try {
            pstmt = conn.prepareStatement(sql);
              pstmt.setString(1, classid);
            rs = pstmt.executeQuery();
                data = rs.getString(1);
        } catch (SQLException e) {
            System.out.println("操作中出现错误！！！");
            System.out.println(e.getMessage());
        } finally {
            DBConnection.close(conn, pstmt, rs);
        }
        return data;
    }
    public String[] getSingleFiledData() {
        String sql = "SELECT * FROM class1";
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
        String sql = "UPDATE class1 SET classname=? WHERE classid=?";
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
        String sql = "SELECT * FROM class1 order by classid";
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
        String sql = "SELECT * FROM class1 order by classid";
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
        String sql = "SELECT * FROM class1 where" + " classid like ?" + " or classname like ?";
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
     public ArrayList<Class1> queryAll() {
       ArrayList<Class1> all = new ArrayList<Class1>();
        Class1 class1 = null;
        String sql = "SELECT  * FROM class1 ";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            //此处为什么不用while,用while可不可以
            while (rs.next()) {
                class1= new Class1();
             class1.setClassId(rs.getString(1));
                class1.setClassName(rs.getString(2));
                all.add(class1);
            }

        } catch (SQLException e) {
            System.out.println("操作中出现错误！！！");
            System.out.println(e.getMessage());
        } finally {
            DBConnection.close(conn, pstmt, rs);
        }
        return all;
    }

    public String[][] findByCombo(String classid, String classname) {
        String sql = "SELECT * FROM class1 where" + " classid like ?" + " and classname like ?";

        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String[][] data = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + classid + "%");
            pstmt.setString(2, "%" + classname + "%");
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
     public ArrayList<Class1> findAll2() {
        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        ArrayList<Class1> teacher=new ArrayList<Class1>(); 
        int count;
        try {
            conn = DBConnection.getConnection();
            pstat = conn.prepareStatement("select * from class1");
            rs = pstat.executeQuery();
            while(rs.next()) {
               Class1 bj=new Class1(rs.getString(1),rs.getString(2));
                teacher.add(bj);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return teacher;
    }
}

    
