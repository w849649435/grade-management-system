/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package note.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import note.dbc.DBConnection;

/**
 *
 * @author Administrator
 */
public class LogInfoDAO {
    public boolean addLog(String userid) {
        Date date=new Date();
        String date1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        String sql = "insert into loginfo values(null,?,?)";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        boolean insertSuccessFlag = false;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userid);
            pstmt.setString(2, date1);
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
    public String[][] getAllData() {
        String sql = "SELECT * FROM loginfo";
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
}
