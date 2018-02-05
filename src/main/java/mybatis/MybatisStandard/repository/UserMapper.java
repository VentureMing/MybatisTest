package mybatis.MybatisStandard.repository;

import mybatis.MybatisStandard.model.User;

public interface UserMapper {
    public User findUserById(int id);
    public void insertUser(User user);
}
