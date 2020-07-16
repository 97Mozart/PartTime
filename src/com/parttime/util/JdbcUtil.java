package com.parttime.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JdbcUtil {

	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	private static final String classname = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/part_time?useSSL=false&serverTimezone=CTT";
	private static final String username = "root";
	private static final String password = "root";

	static {
		try {
			Class.forName(classname);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 数据库连接池操作
		// try {
		// // 创建Context对象，用于检索资源
		// Context context = new InitialContext();
		// //获取数据库连接池 固定字符串java:comp/env/ + 连接池名
		// DataSource ds =
		// (DataSource)context.lookup("java:comp/env/jdbc/scott");
		// conn = ds.getConnection();
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		return conn;

	}

	// 增删改
	public void updatePreparedStatement(String sql, List<Object> params) {
		getConn();
		try {
			pstm = conn.prepareStatement(sql);

			if (params != null) {
				for (int i = 0; i < params.size(); i++) {
					pstm.setObject(i + 1, params.get(i));
				}
			}

			pstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updatePreparedStatement(String sql, Object... params) throws Exception {
		getConn();
		pstm = conn.prepareStatement(sql);

		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				pstm.setObject(i + 1, params[i]);
			}
		}

		pstm.execute();
	}

	// 风险查询
	public ResultSet queryStatement(String sql) throws SQLException {
		getConn();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		// 执行更新 stmt.executeUpdate(sql);
		return rs;
	}

	// 查询
	public <T> List<T> queryPreparedStatement(String sql, Class<T> clazz, List<Object> params) {
		getConn();
		List<T> result = new ArrayList<T>();
		try {
			pstm = conn.prepareStatement(sql);

			if (params != null) {
				for (int i = 0; i < params.size(); i++) {
					pstm.setObject(i + 1, params.get(i));
				}
			}

			rs = pstm.executeQuery();

			ResultSetMetaData rsmd = rs.getMetaData();
			// 获取列的数量
			int count = rsmd.getColumnCount();
			// 存储所有列的名字
			List<String> column = new ArrayList<String>();
			for (int i = 0; i < count; i++) {
				column.add(rsmd.getColumnName(i + 1));
			}

			while (rs.next()) {
				// 创建对象
				T obj = clazz.newInstance();

				for (int i = 0; i < count; i++) {
					String name = column.get(i).toLowerCase();

					// 根据列明获取属性
					Field f = clazz.getDeclaredField(name);
					f.setAccessible(true);
					// 获取属性的类型
					String type = f.getType().getName();
					if ("int".equals(type) || "java.lang.Integer".equals(type)) {
						int val = rs.getInt(name);
						f.set(obj, val);
					} else if ("double".equals(type) || "java.lang.Double".equals(type)) {
						double val = rs.getDouble(name);
						f.set(obj, val);
					} else if ("float".equals(type) || "java.lang.Float".equals(type)) {
						float val = rs.getFloat(name);
						f.set(obj, val);
					} else if ("java.lang.String".equals(type)) {
						String val = rs.getString(name);
						f.set(obj, val);
					} else if ("java.util.Date".equals(type)) {
						Date val = rs.getDate(name);
						f.set(obj, val);
					} else if ("boolean".equals(type) || "java.lang.Boolean".equals(type)) {
						boolean val = rs.getBoolean(name);
						f.set(obj, val);
					}

				}

				result.add(obj);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public <T> List<T> queryPreparedStatement(String sql, Class<T> clazz, Object... params) throws Exception {
		getConn();
		List<T> result = new ArrayList<T>();
		pstm = conn.prepareStatement(sql);

		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				pstm.setObject(i + 1, params[i]);
			}
		}

		rs = pstm.executeQuery();

		ResultSetMetaData rsmd = rs.getMetaData();
		// 获取列的数量
		int count = rsmd.getColumnCount();
		// 存储所有列的名字
		List<String> column = new ArrayList<String>();
		for (int i = 0; i < count; i++) {
			column.add(rsmd.getColumnName(i + 1));
		}

		while (rs.next()) {
			// 创建对象
			T obj = clazz.newInstance();

			for (int i = 0; i < count; i++) {
				String name = column.get(i).toLowerCase();// 将获取到的列名都转成小写

				// 根据列明获取属性
				Field f = clazz.getDeclaredField(name);
				f.setAccessible(true);
				// 获取属性的类型
				String type = f.getType().getName();
				if ("int".equals(type) || "java.lang.Integer".equals(type)) {
					int val = rs.getInt(name);
					f.set(obj, val);
				} else if ("double".equals(type) || "java.lang.Double".equals(type)) {
					double val = rs.getDouble(name);
					f.set(obj, val);
				} else if ("float".equals(type) || "java.lang.Float".equals(type)) {
					float val = rs.getFloat(name);
					f.set(obj, val);
				} else if ("java.lang.String".equals(type)) {
					String val = rs.getString(name);
					f.set(obj, val);
				} else if ("java.util.Date".equals(type)) {
					Date val = rs.getDate(name);
					f.set(obj, val);
				} else if ("boolean".equals(type) || "java.lang.Boolean".equals(type)) {
					boolean val = rs.getBoolean(name);
					f.set(obj, val);
				}

			}

			result.add(obj);

		}

		return result;
	}

	public void close() {
		try {
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
