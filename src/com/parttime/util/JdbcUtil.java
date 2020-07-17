package com.parttime.util;

import com.parttime.dao.DBManager;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 咚咚dongdong
 * Date: 2020/5/7
 * Time: 16:22
 */
public class JdbcUtil {

    private static Connection connection = null;
    private PreparedStatement prepared = null;
    private ResultSet resultSet = null;

    public void getConnection() {
        connection = DBManager.getConn();
        //System.out.println("数据库连接成功");
    }

    /**
     * 是否存在查询
     * 若存在返回 1
     * 不存在返回0
     */
    public Integer exitSearch(String sql,Object... params) throws SQLException {
        getConnection();
        prepared = connection.prepareStatement(sql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                prepared.setObject(i + 1, params[i]);
            }
        }
        resultSet = prepared.executeQuery();
        if(resultSet.next()){
            return 1;
        }
        DBManager.close(prepared, connection);
        return 0;
    }

    /**
     * 增/删/改
     *
     * @param sql    sql语句
     * @param params 用于填充 sql 语句中的 未知 变量
     * @return 返回 增/删/改 操作的结果
     */
    public boolean updatePreparedStatement(String sql, Object... params) throws SQLException {
        getConnection();
        prepared = connection.prepareStatement(sql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                prepared.setObject(i + 1, params[i]);
            }
        }
        prepared.execute();
        DBManager.close(prepared, connection);
        return true;
    }

    /**
     * @param sql          sql语句
     * @param reflectClass 实例化信息类
     * @param params       用于填充 sql 语句中的 ？ 变量
     * @param <T>          信息类泛型
     * @return 返回查询结果集合
     */
    public <T> List<T> queryPreparedStatement(String sql, Class<T> reflectClass, Object... params){
        List<T> selectResult = null;
        try {
            getConnection();
            selectResult = new ArrayList<>();
            prepared = connection.prepareStatement(sql);

            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    prepared.setObject(i + 1, params[i]);
                }
            }

            resultSet = prepared.executeQuery();

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            //获取列的数量
            int columnCount = resultSetMetaData.getColumnCount();
            //存储所有列的名字
            List<String> columnNames = new ArrayList<>();
            for (int i = 0; i < columnCount; i++) {
                columnNames.add(resultSetMetaData.getColumnName(i + 1));
            }

            while (resultSet.next()) {
                /*
                 * 创建实例化对象
                 * 原本是 clazz.newInstance()，不过在 jdk1.9取消使用
                 * 为了使实例化对象更加明确，
                 * 替换为 clazz.getDeclaredConstructor().newInstance()
                 * ** 看一下信息类中是否含有无参构造器 **
                 * ** 还有下方的从数据库中读取的字段名，全部转成了 小写字母，信息类中的属性不要夹杂 大写字母 **
                 */

                T reflectiveObject = reflectClass.getDeclaredConstructor().newInstance();

                for (int i = 0; i < columnCount; i++) {
                    //获取数据库中表的每一列的表头，并转换成小写字母
                    String columnName = columnNames.get(i).toLowerCase();

                    //根据列明获取属性
                    Field field = reflectClass.getDeclaredField(columnName);
                    //关闭指定类 Field 实例的反射访问检查，这行代码执行之后不论是私有的、受保护的以及包访问的作用域，你都可以在任何地方访问
                    field.setAccessible(true);

                    //获取属性的类型
                    String type = field.getType().getName();
                    switch (type) {
                        case "int":
                        case "java.lang.Integer": {
                            int value = resultSet.getInt(columnName);
                            field.set(reflectiveObject, value);
                            break;
                        }
                        case "double":
                        case "java.lang.Double": {
                            double value = resultSet.getDouble(columnName);
                            field.set(reflectiveObject, value);
                            break;
                        }
                        case "float":
                        case "java.lang.Float": {
                            float value = resultSet.getFloat(columnName);
                            field.set(reflectiveObject, value);
                            break;
                        }
                        case "java.lang.String": {
                            String value = resultSet.getString(columnName);
                            field.set(reflectiveObject, value);
                            break;
                        }
                        case "java.util.Date": {
                            Date value = resultSet.getDate(columnName);
                            field.set(reflectiveObject, value);
                            break;
                        }
                        case "boolean":
                        case "java.lang.Boolean": {
                            boolean value = resultSet.getBoolean(columnName);
                            field.set(reflectiveObject, value);
                            break;
                        }
                        default:
                            break;
                    }
                }
                selectResult.add(reflectiveObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DBManager.close(resultSet, prepared, connection);
            } catch (SQLException sqlE) {
                sqlE.printStackTrace();
            }
        }
        return selectResult;
    }

}