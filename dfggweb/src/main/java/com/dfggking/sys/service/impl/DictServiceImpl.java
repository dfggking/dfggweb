package com.dfggking.sys.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dfggking.common.base.service.impl.BaseServiceImpl;
import com.dfggking.sys.domain.DicDO;
import com.dfggking.sys.service.IDictService;

/**
 * 
 * <p>字典Service</p>
 * <pre></pre>
 * @author jinyf
 * @date 2017年2月24日 下午2:08:45
 * @since 1.0
 */
@Service
@Scope(value = "singleton")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class, isolation = Isolation.READ_COMMITTED)
public class DictServiceImpl extends BaseServiceImpl implements IDictService {

	
	
	/**
	 * 
	 */
	@Override
	public List<DicDO> listDict() {
		String hql = "from DicDO";
		List<DicDO> list = (List<DicDO>) hdao.getHibernateTemplate().find(hql, null);
		return list;
	}

}
