package mybatis.mybatis.Repository;


import mybatis.mybatis.Model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @program: MybatisTest
 * @description:
 * @author: Ming
 * @create: 2018-02-05 10:59
 **/
public class MybatisFirst {
    @Test
    public void findUserById() {
        SqlSession sqlSession = null;
        try {
            //Mybatis全局配置文件
            String resource = "config/SqlMapConfig.xml";
            //得到配置文件流
            InputStream inputStream = null;
            inputStream = Resources.getResourceAsStream(resource);


            //创建会话工厂，传入mybatis的配置文件信息
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //通过工程得到SqlSession
            sqlSession = sqlSessionFactory.openSession();
            //通过SqlSession操作数据库
            //第一个参数：映射文件中statement的id,等于namespace+"."+statement的id
            //第二个参数：和所匹配的映射文件中的parameterType的参数类型相同
            //sqlSession.selectOne与映射文件中的resultType类型形同
            User user = sqlSession.selectOne("test.findUserById", 1);
            System.out.println("序号：" + user.getId() + "  " + "名字：" + user.getUsername());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            sqlSession.close();
        }

    }

    @Test
    public void insertUser() {
        SqlSession sqlSession = null;
        try {
            //Mybatis全局配置文件
            String resource = "config/SqlMapConfig.xml";
            //得到配置文件流
            InputStream inputStream = null;
            inputStream = Resources.getResourceAsStream(resource);


            //创建会话工厂，传入mybatis的配置文件信息
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //通过工程得到SqlSession
            sqlSession = sqlSessionFactory.openSession();
            //通过SqlSession操作数据库
            //第一个参数：映射文件中statement的id,等于namespace+"."+statement的id
            //第二个参数：和所匹配的映射文件中的parameterType的参数类型相同
            //sqlSession.selectOne与映射文件中的resultType类型形同
            User user = new User();
            user.setUsername("三毛");
            user.setBirthday(new Date());
            user.setSex("男");
            user.setAddress("北京");
            sqlSession.insert("test.insertUser", user);
            System.out.println("序号:" + user.getId());
            //提交事务
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            sqlSession.close();
        }
    }

}
