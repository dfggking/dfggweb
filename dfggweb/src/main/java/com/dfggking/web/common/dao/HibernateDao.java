package com.dfggking.web.common.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.dfggking.util.LoggingHelper;
import com.dfggking.util.bean.BeanException;

/**
 * 
 * <p></p>
 * <pre></pre>
 * @author jinyf
 * @date 2017年2月21日 上午10:54:00 
 * @since 1.0
 */
public class HibernateDao extends HibernateDaoSupport {

	
	
	
	private final static Logger log = LogManager.getLogger(HibernateDao.class);
	/**
	 * 向指定的Query中添加参数值。
	 * 
	 * @param query
	 *            Query。
	 * @param args
	 *            参数值的数组。
	 */
	public static void setParameters(Query query, Object[] args) {
		for (int i = 0; i < args.length; i++) {
			query.setParameter(i, args[i]);
		}
	}

	public <T> T load(Class<T> clazz, Serializable id) {
		return (T) currentSession().load(clazz, id);
	}

	public <T> T load(String clazz, Serializable id) {
		return (T) currentSession().load(clazz, id);
	}

	public <T> T get(Class<T> clazz, Serializable id) {
		return (T) currentSession().get(clazz, id);
	}

	public <T> T get(String clazz, Serializable id) {
		return (T) currentSession().get(clazz, id);
	}

	public Serializable save(Object arg0) {
		return currentSession().save(arg0);
	}

	public Serializable save(String arg0, Object arg1) {
		return currentSession().save(arg0, arg1);
	}

	public void saveOrUpdate(Object arg0) {
		currentSession().saveOrUpdate(arg0);
	}

	public void saveOrUpdate(String arg0, Object arg1) {
		currentSession().saveOrUpdate(arg0, arg1);
	}

	public void update(Object arg0) {
		currentSession().update(arg0);
	}

	public void update(String arg0, Object arg1) {
		currentSession().update(arg0, arg1);
	}

	public void delete(Object arg0) {
		currentSession().delete(arg0);
	}

	public void delete(String arg0, Object arg1) {
		currentSession().delete(arg0, arg1);
	}

	/**
	 * 提交HQL。
	 * 
	 * @param hql
	 *            HQL语句。
	 * @param args
	 *            参数值。
	 * @return 返回更改数据条数。
	 */
	public int executeUpdate(String hql, Object[] args) {
		Query query = currentSession().createQuery(hql);
		setParameters(query, args);
		return query.executeUpdate();
	}

	/**
	 * 自动分页查询。
	 * 
	 * @param queryHql
	 *            HQL语句。
	 * @param pageInfo
	 *            分页信息。
	 * @return 返回分页结果。
	 */
	public <T> List<T> autoPageQuery(String queryHql, PageInfo pageInfo) {
		return autoPageQuery(queryHql, queryHql, pageInfo);
	}

	/**
	 * 自动分页查询。
	 * 
	 * @param queryHql
	 *            HQL语句。
	 * @param countHql
	 *            求数量的HQL语句。
	 * @param pageInfo
	 *            分页信息。
	 * @return 返回分页结果。
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> autoPageQuery(String queryHql, String countHql, PageInfo pageInfo) {
		if (pageInfo == null) {
			return currentSession().createQuery(queryHql).list();
		}
		int rowcount = countQuery(countHql);
		pageInfo.setRowCount(rowcount);
		pageInfo.handle();
		if (log.isDebugEnabled()) {
			try {
				log.debug(LoggingHelper.beanDetails(pageInfo));
			} catch (BeanException e) {
				log.debug(e);
			}
		}
		if (pageInfo.getPageCount() == 0) {
			return new ArrayList<T>();
		}
		return currentSession().createQuery(queryHql)
				.setFirstResult((pageInfo.getPage() * pageInfo.getLimit() - pageInfo.getLimit()))
				.setMaxResults(pageInfo.getLimit()).list();
	}

	/**
	 * 自动分页查询。
	 * 
	 * @param queryHql
	 *            HQL语句。
	 * @param queryArgs
	 *            HQL参数值。
	 * @param pageInfo
	 *            分页信息。
	 * @return 返回分页结果。
	 */
	public <T> List<T> autoPageQuery(String queryHql, Object[] queryArgs, PageInfo pageInfo) {
		return autoPageQuery(queryHql, queryArgs, queryHql, queryArgs, pageInfo);
	}

	/**
	 * 自动分页查询。
	 * 
	 * @param queryHql
	 *            HQL语句。
	 * @param queryArgs
	 *            HQL参数值。
	 * @param countHql
	 *            求数量的HQL语句。
	 * @param countArgs
	 *            求数量的HQL参数值。
	 * @param pageInfo
	 *            分页信息。
	 * @return 返回分页结果。
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> autoPageQuery(String queryHql, Object[] queryArgs, String countHql, Object[] countArgs,
			PageInfo pageInfo) {
		if (pageInfo == null) {
			Query query = currentSession().createQuery(queryHql);
			setParameters(query, queryArgs);
			return query.list();
		}
		int rowcount = countQuery(countHql, countArgs);
		pageInfo.setRowCount(rowcount);
		pageInfo.handle();
		if (log.isDebugEnabled()) {
			try {
				log.debug(LoggingHelper.beanDetails(pageInfo));
			} catch (BeanException e) {
				log.debug(e);
			}
		}
		if (pageInfo.getPageCount() == 0) {
			return new ArrayList<T>();
		}
		Query query = currentSession().createQuery(queryHql);
		setParameters(query, queryArgs);
		return query.setFirstResult((pageInfo.getPage() * pageInfo.getLimit() - pageInfo.getLimit()))
				.setMaxResults(pageInfo.getLimit()).list();
	}

	/**
	 * 自动分页查询。
	 * 
	 * @param hqlBuilder
	 *            HQL查询帮助类。
	 * @param pageInfo
	 *            分页信息。
	 * @return 返回分页结果。
	 */
	public <T> List<T> autoPageQuery(HqlBuilder hqlBuilder, PageInfo pageInfo) {
		return autoPageQuery(hqlBuilder.getQueryHql(), hqlBuilder.getQueryArgs(), hqlBuilder.getCountHql(),
				hqlBuilder.getCountArgs(), pageInfo);
	}

	/**
	 * 数量查询。
	 * 
	 * @param countHql
	 *            查询数量的HQL语句。
	 * @return 返回数量。
	 */
	public int countQuery(String countHql) {
		Object obj = currentSession().createQuery(countHql).uniqueResult();
		if (obj instanceof Number) {
			return ((Number) obj).intValue();
		}
		return new BigDecimal(obj.toString()).intValue();
	}

	/**
	 * 数量查询。
	 * 
	 * @param countHql
	 *            查询数量的HQL语句。
	 * @param countArgs
	 *            查询数量的HQL参数值。
	 * @return 返回数量。
	 */
	public int countQuery(String countHql, Object[] countArgs) {
		Query query = currentSession().createQuery(countHql);
		setParameters(query, countArgs);
		Object obj = query.uniqueResult();
		if (obj instanceof Number) {
			return ((Number) obj).intValue();
		}
		return new BigDecimal(obj.toString()).intValue();
	}

	/**
	 * 数量查询。
	 * 
	 * @param hqlBuilder
	 *            HQL查询帮助类。
	 * @return 返回数量。
	 */
	public int countQuery(HqlBuilder hqlBuilder) {
		return countQuery(hqlBuilder.getCountHql(), hqlBuilder.getCountArgs());
	}
	public <X> X findUnique(final String hql, final Object... values) {
		return (X) createQuery(hql, values).uniqueResult();
	}
	public Query createQuery(final String queryString, final Object... values) {
		Query query = currentSession().createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query;
	}
	
}
