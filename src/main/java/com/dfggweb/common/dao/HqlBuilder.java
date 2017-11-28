package com.dfggweb.common.dao;

import java.util.ArrayList;

import com.dfggweb.util.StringHelper;


/**
 * HQL查询帮助类，主要配装HQL语句和参数值。
 * 
 * @author LiuBo
 * 
 */
public class HqlBuilder {

	/** HQL查询语句 */
	private StringBuilder queryHql = new StringBuilder();;

	/** HQL查询数量语句 */
	private StringBuilder countHql = new StringBuilder();;

	/** HQL查询参数值 */
	private ArrayList<Object> queryArgs = new ArrayList<Object>();

	/** HQL查询数量参数值 */
	private ArrayList<Object> countArgs = new ArrayList<Object>();

	/**
	 * 获取HQL查询数量参数值。
	 * 
	 * @return 返回HQL查询数量参数值。
	 */
	public Object[] getCountArgs() {
		return countArgs.toArray();
	}

	/**
	 * 获取HQL查询数量语句。
	 * 
	 * @return HQL查询数量语句。
	 */
	public String getCountHql() {
		return countHql.toString();
	}

	/**
	 * 获取查询参数值。
	 * 
	 * @return 返回查询参数值。
	 */
	public Object[] getQueryArgs() {
		return queryArgs.toArray();
	}

	/**
	 * 获取查询HQL语句。
	 * 
	 * @return 返回查询的HQL语句。
	 */
	public String getQueryHql() {
		return queryHql.toString();
	}

	/**
	 * 追加HQL语句，空或null将不会被追加。
	 * 
	 * @param hql
	 *            追加的HQL语句。
	 * @return 返回本实例。
	 */
	public HqlBuilder appendQueryHql(String hql) {
		if (StringHelper.isNullOrNothing(hql)) {
			return this;
		}
		queryHql.append(hql);
		return this;
	}

	/**
	 * 追加HQL语句和参数值，空或null将不会被追加。
	 * 
	 * @param hql
	 *            追加的HQL语句。
	 * @param arg0
	 *            追加的参数值。
	 * @return 返回本实例。
	 */
	public HqlBuilder appendQueryHql(String hql, Object arg0) {
		if (StringHelper.isNullOrNothing(hql)) {
			return this;
		}
		if (arg0 == null) {
			return this;
		}
		if (arg0 instanceof String) {
			if (StringHelper.isNullOrNothing((String) arg0)) {
				return this;
			}
		}
		queryHql.append(hql);
		queryArgs.add(arg0);
		return this;
	}

	/**
	 * 追加HQL语句，被追加的值两端将会被加上“%”。
	 * 
	 * @param hql
	 *            追加的HQL语句。
	 * @param arg0
	 *            追加的参数值。
	 * @return 返回本实例。
	 */
	public HqlBuilder appendQueryHqlLike(String hql, String arg0) {
		if (StringHelper.isNullOrNothing(arg0)) {
			return this;
		}
		return appendQueryHql(hql, "%" + arg0 + "%");
	}

	/**
	 * 追加HQL查询数量语句。
	 * 
	 * @param hql
	 *            HQL查询数量语句。
	 * @return 返回本实例。
	 */
	public HqlBuilder appendCountHql(String hql) {
		if (StringHelper.isNullOrNothing(hql)) {
			return this;
		}
		countHql.append(hql);
		return this;
	}

	/**
	 * 追加HQL查询数量语句和参数值。
	 * 
	 * @param hql
	 *            HQL查询数量语句。
	 * @param arg0
	 *            参数值。
	 * @return 返回本实例。
	 */
	public HqlBuilder appendCountHql(String hql, Object arg0) {
		if (StringHelper.isNullOrNothing(hql)) {
			return this;
		}
		if (arg0 == null) {
			return this;
		}
		if (arg0 instanceof String) {
			if (StringHelper.isNullOrNothing((String) arg0)) {
				return this;
			}
		}
		countHql.append(hql);
		countArgs.add(arg0);
		return this;
	}

	/**
	 * 追加HQL查询数量语句和参数值，被追加的值两端将会被加上“%”。
	 * 
	 * @param hql
	 *            HQL查询数量语句。
	 * @param arg0
	 *            参数值。
	 * @return 返回本实例。
	 */
	public HqlBuilder appendCountHqlLike(String hql, String arg0) {
		if (StringHelper.isNullOrNothing(arg0)) {
			return this;
		}
		return appendCountHql(hql, "%" + arg0 + "%");
	}

	/**
	 * 追加HQL查询语句和查询数量语句。
	 * 
	 * @param hql
	 *            HQL查询语句。
	 * @return 返回本实例。
	 */
	public HqlBuilder append(String hql) {
		if (StringHelper.isNullOrNothing(hql)) {
			return this;
		}
		queryHql.append(hql);
		countHql.append(hql);
		return this;
	}

	/**
	 * 追加HQL查询语句和查询数量语句，以及它们的参数值。
	 * 
	 * @param hql
	 *            HQL查询语句。
	 * @param arg0
	 *            参数值。
	 * @return 返回本实例。
	 */
	public HqlBuilder append(String hql, Object arg0) {
		if (StringHelper.isNullOrNothing(hql)) {
			return this;
		}
		if (arg0 == null) {
			return this;
		}
		if (arg0 instanceof String) {
			if (StringHelper.isNullOrNothing((String) arg0)) {
				return this;
			}
		}
		queryHql.append(hql);
		countHql.append(hql);
		queryArgs.add(arg0);
		countArgs.add(arg0);
		return this;
	}

	/**
	 * 追加HQL查询语句和查询数量语句，以及它们的参数值，被追加的值两端将会被加上“%”。
	 * 
	 * @param hql
	 *            HQL查询语句。
	 * @param arg0
	 *            参数值。
	 * @return 返回本实例。
	 */
	public HqlBuilder appendLike(String hql, String arg0) {
		if (StringHelper.isNullOrNothing(arg0)) {
			return this;
		}
		return append(hql, "%" + arg0 + "%");
	}

}
