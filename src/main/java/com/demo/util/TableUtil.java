package com.demo.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableUtil {
    public static List<String> selectAlltableName(String url,String username,String password, String databasename)
            throws ClassNotFoundException, SQLException {
        String URL = url;
        String USER = username;
        String PASSWORD = password;
        // 1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        // 2.获得数据库链接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        // 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Statement st = conn.createStatement();
        ResultSet rs = st
                .executeQuery("SELECT DISTINCT TABLE_NAME as tn FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA ='"
                        + databasename + "'");
        // 4.处理数据库的返回结果(使用ResultSet类)
        List<String> list = new ArrayList<String>();
        while (rs.next()) {
            list.add(rs.getString("tn"));
        }

        // 关闭资源
        rs.close();
        st.close();
        conn.close();
        return list;
    }

}
