package com.lanqiao.team9.expresssystem.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class BaseDaoAdapter<E> implements IBaseDao<E>{

	@Override
	public boolean add(E obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(E obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E selectById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E selectByObj(E obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> listByObj(E obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> listByMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}


}
