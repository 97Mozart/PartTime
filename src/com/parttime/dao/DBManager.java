package com.parttime.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 连接对象的管理
 *
 * @author Administrator
 */
public class DBManager {
    private static DataSource dataSource;

    static {
        Context initContext = null;
        Context envContext  = null;
        try {
            initContext = new InitialContext();
            envContext  = (Context)initContext.lookup("java:/comp/env");
            dataSource = (DataSource)envContext.lookup("jdbc/DBPool");

            if (dataSource == null) {
                System.err.println("'DBPool' is an unknown DataSource");
            }
        } catch (NamingException ne) {
            ne.printStackTrace();
        }
    }

    /**
     * 获得Connection对象
     *
     * @return conn
     */
    public static Connection getConn() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException ex) {
            System.out.println("查看一下连接池是否配置错误");
            ex.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭传入的ResultSet、Statement、Connection对象
     */
    public static void close(ResultSet rs, Statement ps, Connection conn) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (null != conn) {
            conn.close();
        }
    }

    /**
     * 关闭传入的Statement、Connection对象
     */
    public static void close(Statement ps, Connection conn) throws SQLException {
        if (ps != null) {
            ps.close();
        }
        if (null != conn) {
            conn.close();
        }
    }

    /**
     * 关闭传入的Connection对象
     */
    public static void close(Connection conn) throws SQLException {
        if (null != conn) {
            conn.close();
        }
    }
}