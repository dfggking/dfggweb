package com.dfggweb.web.service.impl;

import com.dfggweb.common.base.BaseService;
import com.dfggweb.entity.User;
import com.dfggweb.web.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * user service
 * @author dfggking@hotmail.com
 * @since 1.0
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {


    /**
     * 添加用户
     * @param user
     * @since 1.0
     */
    @Override
    public void addUser(User user) {
        hibernateTemplate.save(user);
    }

    /**
     * 删除用户
     *
     * @param user
     * @author dfggking@hotmail.com
     * @since 1.0
     */
    @Override
    public void delUser(User user) {
        hibernateTemplate.delete(user);
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @since 1.0
     */
    @Override
    public void updateUser(User user) {
        hibernateTemplate.update(user);
    }

    /**
     * 查找用户
     *
     * @param userId
     * @return User
     */
    @Override
    public User getUserById(int userId) {
        return hibernateTemplate.get(User.class, userId);
    }

    /**
     * 查找登录用户信息
     *
     * @param username
     * @param password
     * @return User
     */
    @Override
    public User getLoginUser(String username, String password) {
        String sql = "select u.id,u.login_name,u.email,u.status,u.create_time " +
                "from user u where login_name=? and password=?";
        List<User> userList = jdbcTemplate.queryForList(sql, new Object[]{username, password}, User.class);
        if(userList.isEmpty()){
            return null;
        }else{
            return userList.get(0);
        }
    }


}
