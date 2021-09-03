package com.lanqiao.team9.expresssystem.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IBaseService<E> {
	/**
	 * 增加一条记录
	 * @param obj
	 * @return 添加成功返回true，否则返回false
	 */
	boolean add(E obj);
	
	/**
	 * 删除一条记录
	 * @param id 记录id（主键或唯一键）
	 * @return 删除成功返回true，否则返回false
	 */
	boolean deleteById(Serializable id);
	
	/**
	 * 更新一条记录
	 * @param obj 待更新记录（对象）
	 * @return 修改成功返回true，否则返回false
	 */
	boolean update(E obj);
	
	/**
	 * 通过唯一列（主键/唯一键）获取一条记录
	 * @param id 主键/唯一键
	 * @return 获取的记录对象
	 */
	E selectById(Serializable id);
	
	/**
	 * 通过对象参数获取一条记录
	 * @param obj 封装有参数的对象
	 * @return 获取的记录对象
	 */
	E selectByObj(E obj);
	
	/**
	 * 通过对象参数获取记录
	 * @param obj 封装有参数的对象
	 * @return 获取的记录对象集合
	 */
	List<E> listByObj(E obj);
	
	/**
	 * 根据map封装的查询参数获取满足查询条件的记录
	 * @param map 查询参数(比如查询条件、分页参数)
	 * @return 记录集合
	 */
	List<E> listByMap(Map<String, Object> map);
	
}
