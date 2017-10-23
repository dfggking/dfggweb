package com.dfggking.sys.service.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dfggking.common.base.service.BaseService;
import com.dfggking.entity.User;
import com.dfggking.sys.service.UserService;
import com.dfggking.util.CommonsUtil;

/**
 * 用户Service实现
 * @author dfggking@hotmail.com
 * @date 2017-07-04
 * @version 1.0
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class, isolation = Isolation.READ_COMMITTED)
public class UserServiceImpl extends BaseService implements UserService {
    private final static Logger log = LogManager.getLogger(UserServiceImpl.class);

    /**
     * 电话是否已经注册
     * @author dfggking@hotmail.com
     * @date 2017-07-04
     * @version 1.0
     */
    @Override
    public Boolean ifTelExist(String tel) {
        String hql = "from User where tel=?";
        @SuppressWarnings("unchecked")
        List<User> userList = (List<User>) hibernateTemplate.find(hql, new Object[]{ tel });
        return !userList.isEmpty(); // 如果结果为空=>电话不存在=>return false;
    }
    
    /**
     * @author dfggking@hotmail.com
     * @date 2017-07-04
     * @version 1.0
     */
    @Override
    public Boolean register(User user) {
        user.setId(CommonsUtil.uuid());
        try{
            hibernateTemplate.save(user);
        }catch(DataAccessException e){
            log.error(e);
            return false;
        }
        return true;
    }
    
    /**
     * 
     */
    @Override
    public User getUserById(String userId) {
        User user = hibernateTemplate.get(User.class, userId);
        return user;
    }
    
}
