package com.dfggking.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dfggking.common.base.service.BaseService;
import com.dfggking.sys.service.DictService;

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
