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

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import note.dbc.DBConnection;
import note.util.Util;
import note.vo.Student;
import note.vo.Studentmark;

/**
 *
 * @author Administrator
 */
public class StudentmarkDAO {
	public void exportExcel(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		// response.getWriter().write("你看着办");
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment;studentmark=" + "data.xls");
		try {
			ServletOutputStream out1 = response.getOutputStream();
			// out1.flush();
//			HSSFWorkbook wb = MemberService.getHSSFWorkbook();
//			wb.write(out1);
			out1.close();
		} catch (Exception e) {
			System.out.println("导出方法出现错误");
//			logger.warn("导出方法出现错误" + e.getMessage());
		}

	}
     public boolean insert(String studentid,
            String courseid,String score) {
        String sql = "insert into studentmark(studentid,courseid,score) values(?,?,?)";
        //得到连接对象
        Connection conn = DBConnection.getConnection();
        //定义预编译语句对象，此对象可执行动态sql命令。
        PreparedStatement pstmt = null;
        boolean insertSuccessFlag = false;
        try {
            pstmt = conn.prepareStatement(sql);
      
            pstmt.setString(1,studentid);
            pstmt.setString(2,courseid);
            pstmt.setString(3,score);
            
            
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
     public boolean delete(String studentmarkid) {
         String sql = "DELETE FROM studentmark WHERE studentmarkid=?";
         PreparedStatement pstmt = null;
         Connection conn = DBConnection.getConnection();
         boolean deleteSuccessFlag = false;
         try {
             pstmt = conn.prepareStatement(sql);
             pstmt.setString(1,studentmarkid);
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
     public boolean insertscore(String score) {
         String sql = "insert into studentmark(score) values(?)";
         //得到连接对象
         Connection conn = DBConnection.getConnection();
         //定义预编译语句对象，此对象可执行动态sql命令。
         PreparedStatement pstmt = null;
         boolean insertSuccessFlag = false;
         try {
             pstmt = conn.prepareStatement(sql);
       
             pstmt.setString(1,score);
            
             
             
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
     public ArrayList<Studentmark> queryAll() {
         ArrayList<Studentmark> all = new ArrayList<Studentmark>();
          Studentmark student = null;
          String sql = "SELECT  * FROM studentmark ";
          Connection conn = DBConnection.getConnection();
          PreparedStatement pstmt = null;
          ResultSet rs = null;
          try {
              pstmt = conn.prepareStatement(sql);
              rs = pstmt.executeQuery();
              //此处为什么不用while,用while可不可以
              while (rs.next()) {
                  student = new Studentmark();
                 student.setStudentmarkid(rs.getString(1));
                  student.setStudentid(rs.getString(2));
                  student.setCourseid(rs.getString(3));
                  student.setScore(rs.getString(4));
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

      public void saveTableData(JTable table) {
          String sql = "UPDATE studentmark SET score=? WHERE studentid=? and courseid=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        //boolean updateSuccessFlag = false;
        DefaultTableModel mdl = (DefaultTableModel) table.getModel();
        int rowCount = mdl.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, (String) mdl.getValueAt(i, 2));
                 pstmt.setString(2, (String) mdl.getValueAt(i, 0));
                 pstmt.setString(3,Util.courseid);
               
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } 
        }
                DBConnection.close(conn, pstmt, null);
            
    }
    public String[][] getAllData2(String id) {
        String sql = "SELECT studentmark.courseid,coursename,score FROM studentmark,course where studentmark.courseid=course.courseid and studentid=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String[][] data = null;
        try {
            pstmt = conn.prepareStatement(sql);
             pstmt.setString(1, Util.id);
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
     public String[][] findByLike(String courseid ,String studentid) {
        String sql = "SELECT studentmark.courseid,coursename,score FROM course,studentmark where studentmark.courseid=course.courseid and studentmark.courseid=? and studentid=?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String[][] data = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, courseid);
            pstmt.setString(2, studentid);
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
}
