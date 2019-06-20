/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package note.dbc;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {
        //�?��要注意使用的数据库名、表名�?用户名�?密码�?
        Connection conn = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/st2?characterEncoding=gbk";
        String username = "root";
        String password = "root";
        try {
            //登记驱动程序
            Class.forName(driver);
            //得到连接
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //返回连接
        return conn;
    }
    public static void close(Connection conn,PreparedStatement pstmt,ResultSet rs){
        try{
        if(rs!=null){rs.close();}
        if(pstmt!=null){pstmt.close();}
        if(conn!=null){conn.close();}

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

