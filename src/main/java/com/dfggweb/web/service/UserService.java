package com.dfggweb.web.service;

import com.dfggweb.entity.User;

/**
 * User Service
 * @author dfggking@hotmail.com
 * @since 1.0
 */
public interface UserService {
    
    
    /**
     * 添加用户
     * @author dfggking@hotmail.com
     * @param user
     * @since 1.0
     */
    void addUser(User user);

    /**
     * 删除用户
     * @author dfggking@hotmail.com
     * @param user
     * @since 1.0
     */
    void delUser(User user);

    /**
     * 更新用户信息
     * @param user
     * @since 1.0
     */
    void updateUser(User user);

    /**
     * 查找用户
     * @param userId
     * @return User
     */
    User getUserById(int userId);

    /**
     * 查找登录用户信息
     * @param username
     * @param password
     * @return User
     */
    User getLoginUser(String username, String password);

}
