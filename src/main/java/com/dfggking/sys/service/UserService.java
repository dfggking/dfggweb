package com.dfggking.sys.service;

import com.dfggking.entity.User;

/**
 * 用户Service接口
 * @author dfggking@hotmail.com
 * @date 2017-07-04
 * @since 1.0
 */
public interface UserService {

    /**
     * 电话是否已经注册
     * @author dfggking@hotmail.com
     * @date 2017-07-04
     * @return Boolean
     * @since 1.0
     */
    Boolean ifTelExist(String tel);
    
    /**
     * 用户存入注册
     * @author dfggking@hotmail.com
     * @date 2017-07-04
     * @return Boolean
     * @since 1.0
     */
    Boolean register(User user);
    
    /**
     * 获取User信息
     * @author dfggking@hotmail.com
     * @create 2017-10-22
     * @return User
     * @since 1.0
     */
    User getUserById(String userId);
    
    
}
