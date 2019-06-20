/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package note.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import note.dbc.DBConnection;

/**
 *
 * @author Administrator
 */
public class AdminDAO {
    public boolean MofifyPassword(String id,String password) {
        String sql = "UPDATE admin1 SET adminpassword=? WHERE adminid=?";
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
