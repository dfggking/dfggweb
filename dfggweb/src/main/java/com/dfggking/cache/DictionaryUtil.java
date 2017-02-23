package com.dfggking.cache;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;

import com.dfggking.web.common.base.BaseServiceImpl;
import com.dfggking.web.vo.DicVo;


/**
 * 
 * <p>字典工具类</p>
 * <pre></pre>
 * @author jinyf   
 * @date 2017年2月20日 下午1:15:21 
 * @since 1.0
 */
public class DictionaryUtil extends BaseServiceImpl {
	private final static Logger log = LogManager.getLogger(DictionaryUtil.class);
	private static final DictionaryUtil dictionaryUtil = new DictionaryUtil();

	/** 系统字典集合 */
	private static List<DicVo> dictionaryList = new ArrayList<DicVo>();

//	private DictionaryUtil() {}

	public static DictionaryUtil getInstance() {
		return dictionaryUtil;
	}



	/**
	 * 初始化系统字典
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public void initDictionaryList(boolean refresh) {
		if (refresh || dictionaryList.isEmpty()) {
			try {
				dictionaryList = (List<DicVo>) hdao.getHibernateTemplate().find("from Dic");
			} catch (DataAccessException e) {
				// TODO: handle exception
				log.error("initDictionaryList error!", e);
			}
		}
	}





}
