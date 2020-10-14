package swagger.training.swaggerDemo.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import swagger.training.swaggerDemo.model.User;
import swagger.training.swaggerDemo.service.UserService;

import java.util.List;

/**
 * 用户控制层
 */
@RestController
@RequestMapping(value = "/api")
public class UserRestController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "添加新的信息")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user) {
        System.out.println("开始新增...");
        return userService.addUser(user);
    }

    @ApiOperation(value = "更新信息")
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public boolean updateUser(@RequestBody User user) {
        System.out.println("开始更新...");
        return userService.updateUser(user);
    }

    @ApiOperation(value = "根据id删除信息")
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public boolean delete(@RequestParam(value = "userId", required = true) int userId) {
        System.out.println("开始删除...");
        return userService.deleteUser(userId);
    }

    @ApiOperation(value = "根据姓名查询信息")
    @RequestMapping(value = "/username", method = RequestMethod.GET)
    public User findByUserName(@RequestParam(value = "userName", required = true) String userName) {
        System.out.println("开始查询...");
        return userService.findUserByName(userName);
    }

    @ApiOperation(value = "查询全部信息")
    @RequestMapping(value = "/userAll", method = RequestMethod.GET)
    public List<User> findByUserAge() {
        System.out.println("开始查询所有数据...");
        return userService.findAll();
    }
}


