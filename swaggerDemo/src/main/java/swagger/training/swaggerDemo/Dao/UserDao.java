package swagger.training.swaggerDemo.Dao;

import org.apache.ibatis.annotations.*;
import swagger.training.swaggerDemo.model.User;

import java.util.List;


@Mapper
public interface UserDao {
    /**
     * 用户数据新增
     */
    @Insert("insert into message(id,name,number) values (#{id},#{name},#{number})")
    void addUser(User user);

    /**
     * 用户数据修改
     */
    @Update("update message set name=#{name},number=#{number} where id=#{id}")
    void
    updateUser(User user);

    /**
     * 用户数据删除
     */
    @Delete("delete from message where id=#{id}")
    void deleteUser(int id);

    /**
     * 根据用户名称查询用户信息
     *
     */
    @Select("SELECT id,name,number FROM message where name=#{userName}")
    User findByName(String userName);

    /**
     * 查询所有
     */
    @Select("SELECT id,name,number FROM message")
    List<User> findAll();

}

