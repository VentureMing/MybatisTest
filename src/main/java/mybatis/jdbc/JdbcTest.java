package mybatis.jdbc;


import java.sql.*;

/**
 * @program: MybatisTest
 * @description: 原生JDBC连接数据库测试
 * @author: Ming
 * @create: 2018-01-30 11:17
 **/
public class JdbcTest {
    /**
     * 问题：
     * 1.频繁的进行数据库的连接与释放，浪费数据库资源，影响性能  解决：使用数据库连接池
     * 2.将sql语句编码到java语句中，不利于系统的维护           解决：将sql配置在xml文件中
     * 3.向PreparedStatement设置参数时，占位符和参数硬编码在java代码中  解决：将sql语句，参数，占位符 配置在xml、
     * 4.ResultSet 获取字段硬编码在java文件中                 解决：将查询结果集，自动映射成java对象，通过get()方法获取
     */

    public static void main(String[] args) {

        //数据库连接
        Connection connection = null;
        //预编译Statement,编译后存储在数据库端，下次相同sql语句不再进行编译，提高数据库性能
        PreparedStatement preparedStatement = null;
        //结果集
        ResultSet resultSet = null;

        try {
            //加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //通过驱动管理类,获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatistest?characterEncoding=utf-8", "root", "191714");
            //定义sql语句
            String sql = "select * from user where username= ? ";
            //获取预处理statement
            preparedStatement = connection.prepareStatement(sql);
            //设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为设置的参数
            preparedStatement.setString(1, "ming");
            //向数据库发出sql,执行查询，查询出结果集
            resultSet = preparedStatement.executeQuery();
            //遍历查询结果集
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + " " + resultSet.getString("username"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
