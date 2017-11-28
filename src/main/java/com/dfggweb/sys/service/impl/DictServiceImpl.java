package com.dfggweb.sys.service.impl;

import com.dfggweb.common.base.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dfggweb.sys.service.DictService;

/**
 * 
 * <p>字典Service</p>
 * <pre></pre>
 * @author jinyf
 * @date 2017年2月24日 下午2:08:45
 * @since 1.0
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class, isolation = Isolation.READ_COMMITTED)
public class DictServiceImpl extends BaseService implements DictService {

}
