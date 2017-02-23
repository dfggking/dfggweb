package com.dfggking.cache;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

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

	private DictionaryUtil() {}

	public static DictionaryUtil getInstance() {
		return dictionaryUtil;
	}



	/**
	 * 初始化系统字典
	 * 
	 * @param refresh
	 * @param jdbc
	 * @return
	 */
	public boolean initDictionaryList(boolean refresh) {
		if (refresh || dictionaryList.isEmpty()) {
			String sql = "select dic_id,dic_name,dic_code,dic_value,parent_id,dic_memo,dic_sort from xfz_dictionary";
			
			
//			try {
//				dictionaryList = jdbc.query(sql, DICTIONARYMAPPER);
//				log.info("=============系统字典初始化成功=====================");
//				return true;
//			} catch (DataAccessException e) {
//				log.error("initDictionaryList error!", e);
//			}
		}
		return false;
	}





}
