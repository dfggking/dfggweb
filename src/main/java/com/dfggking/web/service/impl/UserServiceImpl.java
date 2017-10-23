package com.dfggking.web.service.impl;

import com.dfggking.common.base.service.BaseService;
import com.dfggking.entity.User;
import com.dfggking.web.service.UserService;

public class UserServiceImpl extends BaseService implements UserService {
    
    
    
    @Override
    public void addUser(User user) {
        hibernateTemplate.save(user);
    }
    
    
    
    
}
