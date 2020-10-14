package swagger.training.swaggerDemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import swagger.training.swaggerDemo.Dao.UserDao;
import swagger.training.swaggerDemo.model.User;
import swagger.training.swaggerDemo.service.UserService;

/**
 * 用户操作实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean addUser(User user) {
        boolean flag=false;
        try{
            userDao.addUser(user);
            flag=true;
        }catch(Exception e){
            System.out.println("新增失败!");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateUser(User user) {
        boolean flag=false;
        try{
            userDao.updateUser(user);
            flag=true;
        }catch(Exception e){
            System.out.println("修改失败!");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean flag=false;
        try{
            userDao.deleteUser(id);
            flag=true;
        }catch(Exception e){
            System.out.println("删除失败!");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public User findUserByName(String userName) {
        return userDao.findByName(userName);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}