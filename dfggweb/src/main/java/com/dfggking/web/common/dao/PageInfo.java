package com.dfggking.web.common.dao;

import com.dfggking.util.prop.Prop;
import com.dfggking.util.prop.PropDefault;
import com.dfggking.util.prop.PropKey;

/**
 * 用来计算分页信息的工具类，获取分页信息前先进行计算，即调用handle方法。
 * 
 * @author LiuBo
 * 
 */
public class PageInfo {

	/**
	 * 总页数。
	 */
	private int pageCount;

	/**
	 * 起始行。
	 */
	private int start;

	/**
	 * 总行数。
	 */
	private int rowCount;

	/**
	 * 当前页数。
	 */
	private int page;

	/**
	 * 每页行数。
	 */
	private int limit = 10;

	/**
	 * 获取每页大小。
	 * 
	 * @return 返回每页大小。
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * 设置每页大小。
	 * 
	 * @param limit
	 *            每页大小。
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**
	 * 获取当前页。
	 * 
	 * @return 返回当前页。
	 */
	public int getPage() {
		return page;
	}

	/**
	 * 设置当前页。
	 * 
	 * @param page
	 *            当前页。
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * 获取总页数。
	 * 
	 * @return 返回总页数。
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * 设置总页数。
	 * 
	 * @param pageCount
	 *            总页数。
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * 获取总行数。
	 * 
	 * @return 返回总行数。
	 */
	public int getRowCount() {
		return rowCount;
	}

	/**
	 * 设置总行数。
	 * 
	 * @param rowCount
	 *            总行数。
	 */
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	/**
	 * 起始行。
	 * 
	 * @return 返回起始行。
	 */
	public int getStart() {
		return start;
	}

	/**
	 * 设置起始行。
	 * 
	 * @param start
	 *            起始行。
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * 计算分页信息，计算规则需要符合，每页条数不得小于等于0；总页数不得小于等于0，总页数为总行数与每页条数的商如果有余数则加1，当前页数不得大于总页数
	 * ，当前页数不得小于1，起始条数为当前页数减1再乘以每页条数。分页的计算无法保证实时性，每次发生变化时建议重新计算。
	 */
	public void handle() {
		limit = (limit <= 0 ? Prop.getInteger(PropKey.PAGESIZE, PropDefault.PAGESIZE) : limit);
		rowCount = (rowCount < 0 ? 0 : rowCount);
		if (rowCount % limit == 0) {
			pageCount = rowCount / limit;
		} else {
			pageCount = rowCount / limit + 1;
		}
		if (page > pageCount)
			page = pageCount;
		page = (page < 1 ? 1 : page);
		start = (page - 1) * limit;
	}

}
