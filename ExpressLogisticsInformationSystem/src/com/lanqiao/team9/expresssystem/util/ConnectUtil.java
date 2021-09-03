package com.lanqiao.team9.expresssystem.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectUtil {

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //System.out.println("加载驱动成功！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@119.23.77.46:1521:orcl", "hr", "hr");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭连接
     * @param conn 连接对象
     */
    public static void closeConnection(Connection conn) {
        try {
            if(null != conn) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
	System.out.println(getConnection());;
}

}
